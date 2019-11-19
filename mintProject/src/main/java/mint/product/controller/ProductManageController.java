package mint.product.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mint.orderAndSales.bean.OrderAndSalesDTO;
import mint.product.bean.ProductDTO;
import mint.product.service.ProductManageService;
import mint.qnaBoard.bean.QnaBoardDTO;
import net.sf.json.JSONArray;

@Controller
public class ProductManageController {
	@Autowired
	private ProductManageService productManageService;
	
	//상품등록 페이지 이동
//	@RequestMapping(value = "/qnaboard/getQnaBoardList")
//	public ModelAndView ProductManageWriteForm(HttpSession session) {
//		
//		
//		
//		return null;
//	}
	
	//써머노트 
	@RequestMapping(value="/admin/imageUpload", method = RequestMethod.POST, produces = "application/text; charset=utf-8")
	@ResponseBody
	public String handleFileUpload(@RequestParam("uploadFile") MultipartFile multiPartFile){
		String filePath = "../mintProject/src/main/webapp/storage"; // 원하는 위치 (storage로 잡아주세요)
		String fileName = multiPartFile.getOriginalFilename();
		File file = new File (filePath, fileName);
		try {
			FileCopyUtils.copy(multiPartFile.getInputStream(), new FileOutputStream(file)); // spring저장소에서 storage로 복사
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	} 
	
	@RequestMapping(value = "/productManage/productWriteForm", method = RequestMethod.GET) 
	public ModelAndView productManageWrite() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/admin/service/productWrite.jsp");
		mav.setViewName("/admin/main/admin");
		return mav;
	}
	
	@RequestMapping(value="/productManage/productWrite", method = RequestMethod.POST)
	@ResponseBody
	public void productWrite(@ModelAttribute ProductDTO productDTO, @RequestParam MultipartFile product_img, @RequestParam MultipartFile thumbnail_img) {
		String filePath = "../mintProject/src/main/webapp/storage"; // 원하는 위치
		try {
			FileCopyUtils.copy(thumbnail_img.getInputStream(), new FileOutputStream(new File(filePath, thumbnail_img.getOriginalFilename()))); 
			FileCopyUtils.copy(product_img.getInputStream(), new FileOutputStream(new File(filePath, product_img.getOriginalFilename()))); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		productDTO.setThumbnail(thumbnail_img.getOriginalFilename());
		productDTO.setProductImage(product_img.getOriginalFilename());
		
		productManageService.productWrite(productDTO);
	}
	
	@RequestMapping(value = "/productList/getProductList", method = RequestMethod.GET) 
	public ModelAndView getProductList(@RequestParam Map<String,String> map ) {
		
		System.out.println(map);
		ModelAndView mav = new ModelAndView();
		
		//gubun이 1 또는 2일때
		if(map.get("gubun").equals("1")||map.get("gubun").equals("2")) {
			List<ProductDTO> list =  productManageService.getProductList(map);
			
			mav.addObject("display","/shop/product/productList.jsp");
			mav.addObject("list",list);
			mav.addObject("gubun",map.get("gubun"));
//			mav.addObject("selectGubun",map.get("selectGubun"));
			mav.setViewName("/shop/main/index");
			
			System.out.println("list : " + list);
			System.out.println("gubun : " + map.get("gubun"));
			
			//gubun이 3일 떄	
		}else {
			
			
		}
		return mav;
	}
	
	@RequestMapping(value="/shop/product/productView")
	public ModelAndView productView(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("display","/shop/product/productView.jsp");
		mav.setViewName("/shop/main/index");
		mav.addObject("memId", (String) session.getAttribute("memId"));
		return mav;
	}
	
	@RequestMapping(value="/admin/sales_getTotalSales", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getTotalSalesForChart() {
		List<Map<String, String>> list = productManageService.getSalesData();
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray;
	}
	
	@RequestMapping(value="/admin/sales_getProductSales", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getProductSalesForChart() {
		List<Map<String, String>> list = productManageService.getProductData();
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray;
	}
}

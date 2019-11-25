package mint.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mint.member.bean.MemberDTO;
import mint.order.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/shop/goods/order", method=RequestMethod.GET)
	public String orderList(@RequestParam String ctCount,
							@RequestParam String productCode,
							@RequestParam String totalPoint,
							Map<String, Object> resultMap,
							Model model,
							HttpSession session) {
		
		String id = (String)session.getAttribute("memId");
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//카트 수량 조절
		String[] ctCountWord = ctCount.split(",");
		String[] productCodetWord = productCode.split(",");
		for (int i = 0; i < ctCountWord.length; i++) {
			map.put("ctCount", ctCountWord[i]);
			map.put("productCode", productCodetWord[i]);
			map.put("id", id);
			orderService.updateCartCount(map);
			resultMap = orderService.getProductCartData(map);
			list.add(resultMap);
		}

		MemberDTO memberDTO = orderService.getUserData(map);
		
		// System.out.println("list :"+list);
		// System.out.println("memberDTO :"+memberDTO);
		
		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("list", list);
		model.addAttribute("memberDTO", memberDTO);
		model.addAttribute("display", "/shop/goods/order.jsp");
		return "/shop/main/index";
	}
	
	@RequestMapping(value="/shop/goods/redirectServer", method= RequestMethod.GET)
	@ResponseBody
	public void redirectSuccess(@RequestParam String imp_uid,
								Model model,
								HttpSession session) {
		
		String id = (String)session.getAttribute("memId");
		
		System.out.println(id);
		System.out.println(imp_uid);
		
		model.addAttribute("imp_uid", imp_uid);
		System.out.println("model : " +model);
	}
	
	// 마이페이지 - 주문내역 페이지
	@RequestMapping(value="/shop/mypage/myOrderList", method = RequestMethod.GET)
	public ModelAndView myOrderList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("display", "/shop/mypage/myOrderList.jsp");
		mav.setViewName("/shop/main/index");
		return mav;
	}
	
	// 마이페이지 - 주문내역
	@RequestMapping(value="/shop/mypage/getOrderInfo", method = RequestMethod.POST)
	public ModelAndView getOrderInfo(@RequestParam String dateOption, HttpSession session, Map<String, String> map, ModelAndView mav) {
		if(dateOption.contains("-")) {
			dateOption = dateOption.replace("/", "");
			map.put("from", dateOption.substring(0,6));
			map.put("to", dateOption.substring(9));
		}
		map.put("id", (String) session.getAttribute("memId"));
		List<Map<String, String>> list = orderService.getMyOrderInfo(map);
		mav.addObject("list",list);
		mav.setViewName("jsonView");
		return mav;
		
	}
	
	@RequestMapping(value="/shop/mypage/myOrderDetails", method = RequestMethod.GET)
	public ModelAndView getMyOrderDetails(@RequestParam String ordernumber, HttpSession session, Map<String, String> map) {
		ModelAndView mav = new ModelAndView();
		List<Map<String, String>> list = orderService.getMyOrderDetails(ordernumber);
		System.out.println("session id : "+(String) session.getAttribute("memId"));
		System.out.println(list.get(0).get("ID"));
		if(!((String) session.getAttribute("memId")).equals(list.get(0).get("ID"))) {
			String result = "주문자 아이디와 현재 로그인중인 아이디가 일치하지 않습니다.";
			mav.addObject("result", result);
		} else {
			mav.addObject("list",list);
		}
		mav.addObject("display","/shop/mypage/myOrderDetails.jsp");
		mav.setViewName("/shop/main/index");
		return mav;
	}
	
}

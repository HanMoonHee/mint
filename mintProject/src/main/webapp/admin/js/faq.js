const $table = $('.table-bordered');
let $frag = $(document.createDocumentFragment());

$(function(){
	
	// 게시판 리스트 가져오기 
	$.ajax({
		type:'post',
		url:'/mintProject/shop/service/faq/getBoardList',
		data: 'pg='+$('#pg').val(),
		dataType:'json',
		success: function(result){
			getAdminFAQList(result);
			$('.pagination').html(result.faqBoardPaging.pagingHTML);
		},
		error: function(error){
			console.error(error);
		}
	});
});


function getAdminFAQList(result){
	let faqs = result.list;
	// 구조분해할당, 템플릿 리터럴
	for(let i=0; i<faqs.length; i++){
		const {
			seq,
			category,
			subject,
			content,
			logtime,
			id
		} = faqs[i];
		
		let faqRow = `
	      	<tr>
				<td><input type="checkbox" name="" id=""></td>
				<td>${seq}</td>
				<td>${
						(() => {
							if(faqs[i].category === '0') return '회원 문의';
							else if(faqs[i].category === '1') return '주문/결제';
							else if(faqs[i].category === '2') return '취소/교환/반품';
							else if(faqs[i].category === '3') return '배송 문의';
							else if(faqs[i].category === '4') return '쿠폰/적립금';
							else if(faqs[i].category === '5') return '서비스 이용 및 기타';
						})()
					}</td>
				<td class="table--left" id="" onclick="faqFAQView(this)">${subject}</td>
				<td>${logtime}</td>
				<td>${id}</td>
			</tr>
			`;
		$frag.append($(faqRow));
	}
	$table.append($frag);

}
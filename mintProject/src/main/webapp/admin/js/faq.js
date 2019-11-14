

$(function(){
	
	// 검색 버튼에 포커스
	$('.searchTerm').focus();
	
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

// 카테고리 선택시 게시판 리스트 불러오기
$('#categorySelect').change(function(){
	// 기존 테이블 비우기
	$('.faqRow').remove();
	
	$.ajax({
		type:'post',
		url:'/mintProject/shop/service/faq/getCategoryList',
		data: $('#faqBoardForm').serialize(),
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

// 검색시  게시판 리스트 불러오기
$('.searchButton').click(function(){
	if(!$('.searchTerm').val()){
		alert('검색어를 입력해주세요');
	} else {
		// 기존 테이블 비우기
		$('.faqRow').remove();
		
		$.ajax({
			type:'post',
			url:'/mintProject/shop/service/faq/getSearchBoardList',
			data: $('#faqBoardForm').serialize(),
			dataType:'json',
			success: function(result){
				getAdminFAQList(result);
				$('.pagination').html(result.faqBoardPaging.pagingHTML);
			},
			error: function(error){
				console.error(error);
			}
		});
	}
	
});



function getAdminFAQList(result){
	const $table = $('.table-bordered');
	let faqs = result.list;
	let $frag = $(document.createDocumentFragment());
	
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
	      	<tr class = "faqRow">
				<td><input type="checkbox" name="" id="chk_${seq}"></td>
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
				<td class="table--left" onclick="faqAdminView(${seq})">${subject}</td>
				<td>${logtime}</td>
				<td>${id}</td>
			</tr>
			`;
		$frag.append($(faqRow));
	}
	$table.append($frag);
}

// 글쓰기 이동
$('#faqWriteFormBtn').click(function(){
	location.href='/mintProject/admin/service/faqWriteForm';
});

// 게시물 보기
function faqAdminView(seq){
	let pg = $('#pg').val();
	location.href='/mintProject/admin/service/faqView?seq='+seq+'&pg='+pg;
}



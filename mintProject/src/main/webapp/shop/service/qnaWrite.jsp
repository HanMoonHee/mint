<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<seciton class="service">
    <div class="snb">
        <h2 class="snb__title">������</h2>
        <ul class="snb__list">
            <li class="snb__item"><a href="/shop/service/notice">��������</a></li>
            <li class="snb__item"><a href="/shop/service/faq">�����ϴ� ����</a></li>
            <li class="snb__item current"><a href="/shop/service/qna">1:1 ����</a></li>
            <li class="snb__item"><a href="/shop/service/offer">��ǰ ����</a></li>
        </ul>
    </div>
    <div class="service__main">
        <h2 class="service__main-title">1:1����</h2>
        <form id="offerWriteForm" enctype="multipart/form-data">
            <div class="board-write">
                <div class="board-write__subject">
                    <div class="board-write__title">����</div>
                    <div class="board-write__subject-inputs">
                            <select name="" id="" class="board-write__subject-select">
                                <option value="">�������ּ���.</option>
                                <option value="">�������/�Ҹ�</option>
                                <option value="">��ǰ����</option>
                                <option value="">A/S����</option>
                                <option value="">ȯ�ҹ���</option>
                                <option value="">�ֹ���������</option>
                                <option value="">ȸ����������</option>
                                <option value="">��ҹ���</option>
                                <option value="">��ȯ����</option>
                                <option value="">��ǰ��������</option>
                                <option value="">��Ÿ</option>
                            </select>
                            <input type="text" class="board-write__subject-txt">
                    </div>
                </div>
                <div class="board-write__order-num">
                    <div class="board-write__title">�ֹ� ��ȣ</div>
                    <div class="board-write__order-inputs">
                        <input type="text" class="board-write__order-txt">
                        <input type="button" value="�ֹ���ȸ" class="board-write__order-btn">
                    </div>
                </div>
                <div class="board-write__content">
                    <div class="board-write__title">����</div>
                    <textarea name="content" id="content"></textarea>
                </div>
                <div class="board-write__upload">
                    <div class="board-write__title">�̹���</div>
                    <div class="board-write__file">
                        <input type="file" name="" id="">
                    </div>
                </div>
            </div>
            <div class="board-write__write-btn">���</div>
            
        </form>
    </div>
</seciton>
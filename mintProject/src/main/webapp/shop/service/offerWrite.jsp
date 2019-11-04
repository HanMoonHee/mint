<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<seciton class="service">
    <div class="snb">
        <h2 class="snb__title">������</h2>
        <ul class="snb__list">
            <li class="snb__item"><a href="/shop/service/notice">��������</a></li>
            <li class="snb__item"><a href="/shop/service/faq">�����ϴ� ����</a></li>
            <li class="snb__item"><a href="/shop/service/qna">1:1 ����</a></li>
            <li class="snb__item current"><a href="/shop/service/offer">��ǰ ����</a></li>
        </ul>
    </div>
    <div class="service__main">
        <h2 class="service__main-title">��ǰ ����</h2>
        <ul class="service__manual">
            <li>
                <p class="txt">�����ø����� �߰������� �ǸŵǸ� ���� ��ǰ�� �������ּ���.</p>
            </li>
            <li>
                <p class="txt">������ �ǰ��� �� ������ �ݿ��Ͽ� ���� ���� �����ø��� �ǰڽ��ϴ�.</p>
            </li>
            <li>
                <p class="txt">����)���� ��ǰ�� ���ɻ� �¶��� �ǸŰ� �Ұ��Ͽ���, �� �� �����Ͽ� �ۼ���Ź�帳�ϴ�.</p>
            </li>
            <li>
                <p class="txt">��� MD�� �������ֽ� �ǰ��� �ǽð����� ����͸��� �����̳�, ���� �亯 �ȳ��� ���� ������ ���غ�Ź�帳�ϴ�.</p>
            </li>
        </ul>
        <form id="offerWriteForm" enctype="multipart/form-data">
            <div class="board-write">
                <div class="board-write__subject">
                    <div class="board-write__title">����</div>
                    <div class="board-write__subject-inputs">
                            <select name="" id="" class="board-write__subject-select">
                                <option value="">����</option>
                                <option value="">�ż���ǰ</option>
                                <option value="">����/�ް�</option>
                                <option value="">���/����</option>
                                <option value="">Home Dining</option>
                                <option value="">Deli/Bakery</option>
                                <option value="">Daily+</option>
                                <option value="">��Ÿ</option>
                            </select>
                            <input type="text" class="board-write__subject-txt">
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
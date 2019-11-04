<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<seciton class="service">
    <div class="snb">
        <h2 class="snb__title">������</h2>
        <ul class="snb__list">
            <li class="snb__item"><a href="/shop/service/notice">��������</a></li>
            <li class="snb__item current"><a href="/shop/service/faq">�����ϴ� ����</a></li>
            <li class="snb__item"><a href="/shop/service/qna">1:1 ����</a></li>
            <li class="snb__item"><a href="/shop/service/offer">��ǰ ����</a></li>
        </ul>
    </div>
    <div class="service__main">
        <h2 class="service__main-title">�����ϴ� ����
            <span class="title_sub">���Ե鲲�� ���� �����Ͻô� ������ ��� ��ҽ��ϴ�.</span>
        </h2>
        <!-- ���� �� ���� ���� ������ ���� -->
        <select name="" id="" class="select-box">
            <option value="">����</option>
            <option value="">ȸ�� ����</option>
            <option value="">�ֹ�/����</option>
            <option value="">���/��ȯ/��ǰ</option>
            <option value="">��� ����</option>
            <option value="">����/������</option>
            <option value="">���� �̿� �� ��Ÿ</option>
        </select>
        <table class="tb tb-fqa">
            <tr>
                <th class="size-1">��ȣ</th>
                <th class="size-2">�ۼ���</th>
                <th class="size-9">����</th>
            </tr>
            <tr class="tb-content">
                <td>1</td>
                <td>�ȳ�</td>
                <td>���̵�� ��й�ȣ�� �������� �ʾƿ�. ��� ã�� �� �ֳ���?</td>
            </tr>

            <tr class="tb-view">
                <td colspan="1"><img src="https://www.kurly.com/shop/data/skin/designgj/img/common/faq_a.gif"></td>
                <td colspan="2">����</td>
            </tr>
        </table>
        
        <div class="paging">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#"><</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">></a></li>
            </ul>  
        </div>
        
        <div class="service__search">
            <div class="service__sel-box">
            </div>
            <div class="service__serch-box">
                <input type="text">
                <div class="service__seach-btn">
                    <i class="fas fa-search"></i>
                </div>
            </div>
        </div>
    </div>
</seciton>
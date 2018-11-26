<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="/jsp/common/head.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>订单管理页面</span>
    </div>
    <div class="search">
        <fm:form modelAttribute="Showbill" method="post"
                 action="${pageContext.request.contextPath }/FindBillPaging.action">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>商品名称：</span>
            <fm:input path="productName"></fm:input>
            <span>供应商：</span>
            <fm:select path="proName">
                <fm:options items="${Showbill.proNameList}"></fm:options>
            </fm:select>
            <span>是否付款：</span>
            <fm:select path="isPayment">
                <fm:options items="${Showbill.isPaymentList}"></fm:options>
            </fm:select>
            <input value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/addBillWindow.action">添加订单</a>
        </fm:form>
    </div>
    <!--账单表格 样式和供应商公用-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">订单编码</th>
            <th width="20%">商品名称</th>
            <th width="10%">供应商</th>
            <th width="10%">订单金额</th>
            <th width="10%">是否付款</th>
            <th width="10%">创建时间</th>
            <th width="30%">操作</th>
        </tr>
        <c:forEach var="bill" items="${billList }" varStatus="status">
            <tr>
                <td>
                    <span>${bill.billCode }</span>
                </td>
                <td>
                    <span>${bill.productName }</span>
                </td>
                <td>
                    <span>${bill.proName}</span>
                </td>
                <td>
                    <span>${bill.totalPrice}</span>
                </td>
                <td>
					<span>
						<c:if test="${bill.isPayment == 1}">未付款</c:if>
						<c:if test="${bill.isPayment == 2}">已付款</c:if>
					</span>
                </td>
                <td>
					<span>
					<fmt:formatDate value="${bill.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
                </td>
                <td>
                    <span><a class="viewBill" href="FindBillById.action?id=${bill.id }" billcc=${bill.billCode }><img
                            src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifyBill" href="editBillWindow.action?id=${bill.id }"
                             billcc=${bill.billCode }><img
                            src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteBill" billid=${bill.id } billcc=${bill.billCode }><img
                            src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>


    <input type="hidden" id="userAction" value="${pageContext.request.contextPath }/FindBillPaging.action"/>
    <input type="hidden" id="totalPageCount" value="${max}"/>
    <c:import url="rollpage.jsp">
        <c:param name="max" value="${max}"/>
        <c:param name="page" value="${page}"/>
        <c:param name="max" value="${max}"/>
    </c:import>

</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>
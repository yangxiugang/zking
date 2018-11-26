<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="/jsp/common/head.jsp" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>订单管理页面 >> 订单添加页面</span>
    </div>
    <div class="providerAdd">
        <fm:form modelAttribute="Editbill" id="billForm" name="billForm" method="post"
                 action="${pageContext.request.contextPath }/editBill.action">
            <input type="hidden" name="method" value="modifysave">
            <fm:hidden path="id"></fm:hidden>
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="">
                <label>订单编码：</label>
                <fm:input path="billCode"></fm:input>
                <fm:errors path="billCode"></fm:errors>
            </div>
            <div>
                <label >商品名称：</label>
                <fm:input path="productName"></fm:input>
                <fm:errors path="productName"></fm:errors>
               <font color="red"></font>
            </div>
            <div>
                <label >商品单位：</label>
                <fm:input path="productUnit"></fm:input>
                <fm:errors path="productUnit"></fm:errors> <font color="red"></font>
            </div>
            <div>
                <label  >商品数量：</label>
                <fm:input path="productCount"></fm:input>
                <fm:errors path="productCount"></fm:errors>  <font color="red"></font>
            </div>
            <div>
                <label  >总金额：</label>
                <fm:input path="totalPrice"></fm:input>
                <fm:errors path="totalPrice"></fm:errors> <font color="red"></font>
            </div>
            <div>
                <label  >供应商：</label>
                <fm:select path="providerId">
                    <fm:options items="${Editbill.proNameList}"></fm:options>
                </fm:select>
                <font color="red"></font>
            </div>
            <div>
                <label>是否付款：</label>
                <fm:select path="isPayment">
                    <fm:options items="${Editbill.isPaymentList}"></fm:options>
                </fm:select>
            </div>
            <div class="providerAddBtn">
                <input type="button" name="save" id="save" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </fm:form>
    </div>

</div>
</section>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billmodify.js"></script>
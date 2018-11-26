<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="/jsp/common/head.jsp" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 供应商修改页</span>
    </div>
    <div class="providerAdd">
        <fm:form modelAttribute="Editprovider" id="providerForm" name="providerForm" method="post"
                 action="${pageContext.request.contextPath }/editProvider.action">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <fm:hidden path="id"></fm:hidden>
            <div class="">
                <label>供应商编码：</label>
                <fm:input path="proCode"></fm:input>
                <fm:errors path="proCode"></fm:errors>
            </div>
            <div>
                <label>供应商名称：</label>
                <fm:input path="proName"></fm:input>
                <fm:errors path="proName"></fm:errors>

                <font color="red"></font>
            </div>

            <div>
                <label>联系人：</label>
                <fm:input path="proContact"></fm:input>
                <fm:errors path="proContact"></fm:errors> <font color="red"></font>
            </div>

            <div>
                <label>联系电话：</label>
                <fm:input path="proPhone"></fm:input>
                <fm:errors path="proPhone"></fm:errors><font color="red"></font>
            </div>

            <div>
                <label>联系地址：</label>
                <fm:input path="proAddress"></fm:input>
                <fm:errors path="proAddress"></fm:errors><font color="red"></font>
            </div>

            <div>
                <label>传真：</label>
                <fm:input path="proFax"></fm:input>
                <fm:errors path="proFax"></fm:errors></div>

            <div>
                <label>描述：</label>
                <fm:input path="proDesc"></fm:input>
                <fm:errors path="proDesc"></fm:errors></div>
            <div class="providerAddBtn">
                <input type="submit" name="save" id="save" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </fm:form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/providermodify.js"></script>
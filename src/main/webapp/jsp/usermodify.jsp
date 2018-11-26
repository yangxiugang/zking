<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="/jsp/common/head.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户修改页面</span>
    </div>
    <div class="providerAdd">
        <fm:form modelAttribute="Edituser" id="userForm" method="post" action="${pageContext.request.contextPath }/editUser.action">
            <fm:hidden path="id"></fm:hidden>
            <div>
                <label>用户名称：</label>
                <fm:input path="userName"></fm:input>
                <fm:errors path="userName"></fm:errors>
                <font color="red"></font>
            </div>
            <div>
                <label>用户性别：</label>
                   <fm:select path="gender">
                        <fm:options items="${Edituser.genderList}"></fm:options>
                    </fm:select><fm:errors path="gender"></fm:errors>

            </div>
            <div>
                <label>出生日期：</label>
                <fm:input path="birthday"></fm:input>
                <fm:errors path="birthday"></fm:errors>
                <font color="red"></font>
            </div>

            <div>
                <label>用户电话：</label>
                <fm:input path="phone"></fm:input>
                <fm:errors path="phone"></fm:errors>
                <font color="red"></font>
            </div>
            <div>
                <label>用户地址：</label>
                <fm:input path="address"></fm:input>
                <fm:errors path="address"></fm:errors>
            </div>
            <div>
                <label>用户角色：</label>
                <!-- 列出所有的角色分类 -->
                <fm:select path="userRole" multiple="false">
                    <fm:options items="${Edituser.userRoleList}"></fm:options>
                </fm:select>
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <input type="button" name="save" id="save" value="保存"/>
                <input type="button" id="back" name="back" value="返回"/>
            </div>
        </fm:form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/usermodify.js"></script>

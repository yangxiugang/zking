<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="/jsp/common/head.jsp" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户添加页面</span>
    </div>
    <div class="providerAdd">
        <fm:form modelAttribute="Adduser" method="post" action="${pageContext.request.contextPath }/addUser.action">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label>用户编码：</label>
                <fm:input path="userCode"></fm:input>
                <fm:errors path="userCode"></fm:errors>
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>


            <div>
                <label>用户名称：</label>
                <fm:input path="userName"></fm:input>
                <fm:errors path="userName"></fm:errors>
                <font color="red"></font>
            </div>


            <div>
                <label>用户密码：</label>
                <fm:password path="userPassword"></fm:password>
                <fm:errors path="userPassword"></fm:errors>
                <font color="red"></font>
            </div>
            <div>
                <label>确认密码：</label>
                <input  type="password">
                <font color="red"></font>
            </div>


            <div>
                <label>用户性别：</label>
                <fm:select path="gender">
                    <fm:options items="${Adduser.genderList}"></fm:options>
                </fm:select><fm:errors path="gender"></fm:errors>
                <fm:errors path="gender"></fm:errors>

            </div>


            <div>
                <label>出生日期：</label>

                <fm:input path="birthday"></fm:input>
                <fm:errors path="birthday"></fm:errors>
                    <%--  <input type="text" Class="Wdate" id="birthday" name="birthday"
                             readonly="readonly" onclick="WdatePicker();">--%>
                <font color="red"></font>
            </div>


            <div>
                <label>用户电话：</label>
                <fm:input path="phone"></fm:input>
                <fm:errors path="phone"></fm:errors>
                    <%-- <input type="text" name="phone" id="phone" value="">--%>
                <font color="red"></font>
            </div>


            <div>
                <label>用户地址：</label>
                <fm:input path="address"></fm:input>
                <fm:errors path="address"></fm:errors>
                    <%--  <input name="address" id="address" value="">--%>
            </div>


            <div>
                <label>用户角色：</label>
                <!-- 列出所有的角色分类 -->
                    <%--  <select name="userRole" id="userRole"></select>--%>
                <fm:select path="userRole" multiple="false">
                    <fm:options items="${Adduser.userRoleList}"></fm:options>
                </fm:select>
                <font color="red"></font>
            </div>


            <div class="providerAddBtn">
                <input type="submit" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>


        </fm:form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/useradd.js"></script>

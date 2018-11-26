<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/jsp/common/head.jsp"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>密码修改页面</span>
            </div>
            <div class="providerAdd">
                <fm:form modelAttribute="editPwduser" method="post" action="${pageContext.request.contextPath }/updatePwd.action">
                  <fm:hidden path="id"></fm:hidden>
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div class="info">${message}</div>
                    <div class="">
                        <label  >旧密码：</label>
                       <input type="password" name="oldpwd">
						<font color="red"></font>
                    </div>
                    <div>
                        <label >新密码：</label>
                        <fm:password path="userPassword"></fm:password>
                        <fm:errors path="userPassword"></fm:errors>
						<font color="red"></font>
                    </div>
                    <div>
                        <label  >确认新密码：</label>
                        <input type="password" name="rnewpassword" id="rnewpassword" value=""> 
						<font color="red"></font>
                    </div>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <input type="submit" name="save" id="save" value="保存" class="input-button">
                    </div>
                </fm:form>
            </div>
        </div>
    </section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/pwdmodify.js"></script>
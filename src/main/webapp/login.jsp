<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@  taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script type="text/javascript">
    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市订单管理系统</h1>
    </header>
    <section class="loginCont">
        <fm:form class="loginForm" action="logins.action"
              method="post" modelAttribute="user">
            <div class="info">${error }</div>
            <div class="inputbox">
                <label >用户名：</label>
               <%-- <input value="admin" type="text" class="input-text" id="userName" name="userName" placeholder="请输入用户名" required/>
--%>
                <fm:input path="userName" ></fm:input><fm:errors></fm:errors>
            </div>
            <div class="inputbox">
                <label >密码：</label>
          <%--      <input value="1234567" type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
          --%>
                <fm:password path="userPassword"></fm:password><fm:errors></fm:errors>
            </div>
            <div class="subBtn">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </div>
        </fm:form>
    </section>
</section>
</body>
</html>

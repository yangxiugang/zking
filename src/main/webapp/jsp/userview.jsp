<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/jsp/common/head.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${Showuser.userCode }</span></p>
            <p><strong>用户名称：</strong><span>${Showuser.userName }</span></p>
            <p><strong>用户性别：</strong>
            	<span>
            		<c:if test="${Showuser.gender == 1 }">男</c:if>
					<c:if test="${Showuser.gender == 2 }">女</c:if>
				</span>
			</p>
            <p><strong>出生日期：</strong><span>${Showuser.birthday }</span></p>
            <p><strong>用户电话：</strong><span>${Showuser.phone }</span></p>
            <p><strong>用户地址：</strong><span>${Showuser.address }</span></p>
            <p><strong>用户角色：</strong><span>${Showuser.userRole}</span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userview.js"></script>
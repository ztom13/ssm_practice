<%--
  Created by IntelliJ IDEA.
  User: ztom
  Date: 2018/10/24
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>登录</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <!-- 引入JS文件 -->
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" role="form" action="${ctx}/store/login" method="post">
    <div class="form-group">
        <label for="firstname" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" name="stuId" class="form-control" id="firstname"
                   placeholder="请输入学号">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" name="password" class="form-control" id="lastname"
                   placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-info">登录</button>
        </div>
    </div>
</form>
</body>
</html>
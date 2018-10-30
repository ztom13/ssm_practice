<%--
  Created by IntelliJ IDEA.
  User: ztom
  Date: 2018/10/24
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>所有图书一览表</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <!-- 引入JS文件 -->
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-bordered">
    <caption>
        所有图书一览表
    </caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>余量</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.name}</td>
            <td>${book.number}</td>
            <td>
                <a class="btn btn-info" href="${ctx}/books/appoint?bookId=${book.bookId}">预约</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

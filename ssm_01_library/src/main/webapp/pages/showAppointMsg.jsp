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
    <title>预约操作信息</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <!-- 引入JS文件 -->
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-bordered">
    <caption>
        预约操作信息
    </caption>
    <thead>
    <tr>
        <th>图书编号</th>
        <th>图书名称</th>
        <th>预约结果</th>
        <th>预约时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${appoint.bookId}</td>
        <td>${appoint.appointment.book.name}</td>
        <td>${appoint.stateInfo}</td>
        <td>${appoint.appointment.appointTime.toLocaleString()}</td>
        <td>
            <a class="btn btn-info" href="${ctx}/books/findBookList">继续预约</a>
            <a class="btn btn-danger"
               href= "javascript:;"
               onclick="x()">
                取消预约</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
<script>
    function x() {
        if(confirm('确定取消预约吗?')){
            location.href = '${ctx}/books/cancelAppoint?bookId=${appoint.bookId}&studentId=${appoint.appointment.studentId}';
        }
    }
</script>
</html>
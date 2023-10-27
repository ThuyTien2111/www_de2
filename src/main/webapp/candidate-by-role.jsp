<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 27/10/2023
  Time: 4:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách ứng viên dành cho bạn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Ứng viên dành cho bạn</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên ứng viên</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Candidate> candidates= (List<Candidate>) request.getAttribute("candidates");
            for (Candidate c:candidates) {
        %>
        <tr>
            <td><%=c.getName()%></td>
            <td><%=c.getEmail()%></td>
            <td><%=c.getPhone()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

<%@ page import="vn.edu.iuh.fit.dao.CandidateDao" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 27/10/2023
  Time: 3:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Báo cáo 2</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Danh sách ứng viên sử dụng gmail</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên ứng viên</th>
            <th>Email</th>
            <th>Số điện thoại</th>
        </tr>
        </thead>
        <tbody>
        <%
            CandidateDao candidateDao=new CandidateDao();
            List<Candidate> candidates=candidateDao.getCandidateUseGmail();
            for (Candidate c:candidates) {
        %>
        <tr>
            <td><%=c.getName()%></td>
            <td><%=c.getEmail()%></td>
            <td><%=c.getPhone()%></td>
            <td>
                <a href="candControl?action=view&canID=<%=c.getCanId()%>" class="btn btn-info">View</a>
            </td>
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

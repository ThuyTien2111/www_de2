<%@ page import="vn.edu.iuh.fit.dao.CandidateDao" %>
<%@ page import="vn.edu.iuh.fit.entity.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entity.Experience" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: my
  Date: 27/10/2023
  Time: 4:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Thông tin chi tiết ứng viên</title>
</head>
<body>
<div class="container">
    <h2>Thông tin chi tiết ứng viên</h2>
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
            long candID= (long) request.getAttribute("candID");
            CandidateDao candidateDao=new CandidateDao();
            Candidate candidate=candidateDao.getCandByID(candID);
        %>
        <tr>
            <td><%=candidate.getName()%></td>
            <td><%=candidate.getEmail()%></td>
            <td><%=candidate.getPhone()%></td>
        </tr>
        </tbody>
    </table>
    <p>------------------------------------------------------------------------------------------------------------------------</p>
    <h2>Kinh nghiệm của ứng viên</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Tên công ty</th>
            <th>Từ ngày</th>
            <th>Đến ngày</th>
            <th>Vai trò</th>
            <th>Mô tả công việc</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Experience> experiences= (List<Experience>)request.getAttribute("experiences");
            for (Experience e:experiences) {
                LocalDate from=e.getFromDate();
                LocalDate to=e.getToDate();
                String fromStr=from.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String toStr=to.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                String role="";
                if(e.getRole()==0){
                    role="ADMIN";
                }else if(e.getRole()==1){
                    role="STAFF";
                }else if(e.getRole()==2){
                    role="MANAGER";
                }if(e.getRole()==3){
                    role="EXECUTIVE";
                }
        %>
        <tr>
            <td><%=e.getCompany()%></td>
            <td><%=fromStr%></td>
            <td><%=toStr%></td>
            <td><%=role%></td>
            <td><%=e.getWorkDesc()%></td>
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

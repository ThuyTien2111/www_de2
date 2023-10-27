<%--
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
    <title>Báo cáo 1</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Chọn vai trò để tìm ứng viên tương thích</h2>
    <form method="post" action="candControl?action=findCanByRole">
        <div class="form-group">
            <label for="role">Chọn vai trò:</label>
            <select class="form-control" name="role" id="role">
                <option value="0">ADMIN</option>
                <option value="1">STAFF</option>
                <option value="2">MANAGER</option>
                <option value="3">EXECUTIVE</option>
            </select>
        </div>
        <button type="submit" class="btn btn-lg btn-block btn-success">View</button>
    </form>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

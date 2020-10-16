<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/8 0008
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  通过表单上传
  get方式上传的大小很小
  post没有限制

  --%>
      <form action="${pageContext.request.contextPath}/upload.do" method="post" enctype="multipart/form-data">
        上传用户 <input type="text"><br>
        <input type="file" name="file1"><br>
          <input type="file" name="file2"><br>
          <input type="submit">
          <input type="reset">
      </form>
  </body>
</html>

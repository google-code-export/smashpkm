<%-- 
    Document   : tes
    Created on : Dec 2, 2011, 3:18:38 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
        <h1>File Upload</h1>
        <form action="CommonsFileUploadServlet" enctype="multipart/form-data" method="POST">
            <input type="file" name="file1"><br>
            <input type="Submit" value="Upload File"><br>
        </form>
    </body>
</html>
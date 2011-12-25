<%-- 
    Document   : pengaturanPost
    Created on : Nov 8, 2011, 10:38:02 PM
    Author     : yosua
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posts</title>
    </head>
    <body>
        <h2>Posts</h2>

        <table>
            <tr>
                <td>
                    <form method='post' action='DispatcherBeasiswa?page=membuatPost'>
                        <input type='submit' value='Add New Post' >
                    </form>
                </td>
                <td>
                    <form method='post' action='DispatcherMahasiswa?page=home&&nrp=${mahasiswa.nrp}'>
                        <input type='submit' value='Menu Utama' >
                    </form>
                </td>
                <td>
                    <form  method='post' action='DispatcherMahasiswa?page=logout&&nrp=${mahasiswa.nrp}'>
                        <input type='submit' value='Logout' >
                    </form>

                </td>
            </tr>
        </table>
        <table>
            <c:forEach items="${list_beasiswa}" var="bsw">
                <tr>
                    <td>${bsw.namabeasiswa}</td>
                </tr>
                <tr>
                    <td>
                        <form method='post' action='DispatcherBeasiswa?page=editPost&&idbeasiswa=${bsw.idbeasiswa}'>
                            <input type='submit' value='Edit' >
                        </form>
                    </td>
                    <td>
                        <form method='post' action='DispatcherBeasiswa?page=deletePost&&idbeasiswa=${bsw.idbeasiswa}'>
                            <input type='submit' value='Delete' >
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <br><br>

    </body>
</html>

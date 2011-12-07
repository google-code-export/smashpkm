<%-- 
    Document   : beasiswaYangTersedia
    Created on : Nov 14, 2011, 8:36:27 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <br>
        <h1>login </h1>
        <table border=0>
            <tr>
                <td>
                    <form method='post' action='Dispatcher?page=logout'>
                        <input type='submit' value='Logout' >
                    </form>
                </td>
                <td>
                    <form method='post' action='Dispatcher?page=home'>
                        <input type='submit' value='Menu Utama' >
                    </form>
                </td>
            </tr>
        </table>
        <br>
        <form method='post' action="Dispatcher?page=daftarBeasiswa">
            <select name="pilih">
                 <c:forEach items="${list_beasiswa}" var="bsw">
                <option value=${bsw.namabeasiswa } > ${bsw.namabeasiswa} </option>
                </c:forEach>
            </select>
            <input type='submit' value='Daftar' >
        </form> 
    </body>
</html>


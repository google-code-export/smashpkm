<%-- 
    Document   : BeasiswaYangTersedia
    Created on : Dec 29, 2011, 1:06:23 PM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Beasiswa Yang Tersedia</h1>
        <table>
            <tr>
                <td
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

    <br/>
    <table border="1">
        <tr>
            <td>
                <font color="black"><b> No </b></font>
            </td>
            <td >
                <font color="black"><b> Nama Beasiswa </b></font>
            </td>
            <td >
                <font color="black"><b> Tanggal Mulai Kontrak </b></font>
            </td>
            <td>
                <font color="black"><b> Tanggal Habis Kontrak </b></font>
            </td>
            <td >
                <font color="black"><b> </b></font>
            </td>
        </tr>
        <%int i=1;%>
        <c:forEach items="${list_beasiswa}" var="bsw">
            <tr>
                <td>
                    <font color="black"> <%out.print(i);%>
                        <%i++;%></font>
                </td>
                <td align="center">
                    <font color="black">${bsw.namabeasiswa}</font>
                </td>
                <td align="center">
                    <font color="black">${bsw.tanggalmulai}</font>
                </td>
                <td align="center">
                    <font color="black">${bsw.tanggalhabis}</font>
                </td>
                <td align="center">
                     <form  method='post' action='DispatcherBeasiswa?page=detailBeasiswa&&idbeasiswa=${bsw.idbeasiswa}'>
                    <input type='submit' value='Selengkapnya' >
                </form>
                </td>
            </tr>
            <tr>
            </c:forEach>
    </table>
</body>
</html>

<%-- 
    Document   : statusBeasiswa
    Created on : Dec 28, 2011, 8:48:08 PM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Halaman Status Beasiswa</h1>
 <table border=0>
            <tr>

                <td>
                    <form method='post' action='DispatcherMahasiswa?page=home&&nrp=${mahasiswa.nrp}'>
                        <input type='submit' value='Menu Utama' />
                    </form>
                </td>
                <td>
                    <form method='post' action='DispatcherMahasiswa?page=logout&&nrp=${mahasiswa.nrp}'>
                        <input type='submit' value='Logout' />
                    </form>
                </td>
            </tr>
        </table>
        <table border="1">
            <thead>
                <tr>
                    <th>
                        No
                    </th>
                    <th>
                        Nama Beasiswa
                    </th>
                    <th>
                        Tanggal Mulai Berlaku
                    </th>
                     <th>
                        Tanggal Kadaluwarsa
                    </th>
                    <th>
                        Status Pengajuan
                    </th>
                </tr>
            </thead>
            <tbody>
                <%int i = 1;%>

                <c:forEach items="${list_pengajuan_by_nrp}" var="bsw">

                    <tr>
                        <td>
                            <%out.print(i);%>
                            <%i++;%>
                        </td>
                        <td>
                            ${bsw.idbeasiswa.namabeasiswa}
                        </td>
                        <td>
                            ${bsw.idbeasiswa.tanggalmulai}
                        </td>
                        <td>
                            ${bsw.idbeasiswa.tanggalkadaluarsa}
                        </td>
                        <td>
                            ${bsw.statuspengajuan}
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>

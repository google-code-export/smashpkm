<%-- 
    Document   : listDaftarBeasiswa
    Created on : Dec 23, 2011, 9:52:08 PM
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
        <h1>Hello World!</h1>
    </body><table border="1">
        <thead>
            <tr>
                <th>
                    No.
                    </th>
                <th>
                    Beasiswa
                </th>
                <th>
                    Tanggal pengajuan
                </th>               
            </tr>
        </thead>
        <tbody>
             <form method='post' action="DispatcherBeasiswa?page=daftarBeasiswa">
                 <c:forEach items="${list_beasiswa_nrp}" var="bsw">
        </form>
            <tr>
                <td>
                    <%int i=1;%>
                    <%out.print(i++); %>
                </td>
                <td>
                    bsw.idbeasiswa.namabeasiswa
                </td>
                <td>
                    bsw.tanggalpengajuan
                </td>
            </tr>
           </c:forEach>
        </tbody>
    </table>

</html>

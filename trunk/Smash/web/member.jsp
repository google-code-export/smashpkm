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
        <h2>Members</h2>
        <table>
            <tr>
                <td>
                    <form method='post' action='DispatcherMahasiswa?page=buatMember'>
                        <input type='submit' value='Add New Member' >
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
            <c:forEach items="${list_mahasiswa}" var="mhs">
                <tr>
                    <td>${mhs.nama}</td>
                </tr>
                <tr>
                    <td>
                        <form method='post' action='DispatcherMahasiswa?page=editMember&&nrp=${mhs.nrp}'>
                            <input type='submit' value='Edit' >
                        </form>
                    </td>
                    <td>
                        <form method='post' action='DispatcherMahasiswa?page=deleteMember&&nrp=${mhs.nrp}'>
                            <input type='submit' value='Delete' >
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <br><br>

    </body>
</html>

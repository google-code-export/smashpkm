<%-- 
    Document   : halamanUtamaAdmin
    Created on : Nov 8, 2011, 5:27:18 PM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Utama Admin</title>

    </head>
    <body>
        <h1>Halaman Utama Admin</h1>
        <fieldset>
            <table border="0.1">
                <tr><td>
                        <form method='post' action='Dispatcher?page=pengaturanPost'>
                            <input type='submit' value='Posts' >
                        </form>
                    </td> </tr>
                <tr><td>
                        <form method='post' action='Dispatcher?page=pengaturanMember'>
                            <input type='submit' value='Members' >
                        </form>
                    </td> </tr>
                <tr><td>
                        <form method='post' action='BeasiswaYangTersedia.jsp'>
                            <input type='submit' value='Rekapitulasi' >
                        </form>
                    </td> </tr>
                <tr><td>
                        <form  method='post' action='Dispatcher?page=logout'>
                            <input type='submit' value='Logout' >
                        </form>
                    </td> </tr>
            </table>
        </fieldset>
    </body>
</html>


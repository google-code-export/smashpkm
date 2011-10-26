<%-- 
    Document   : Login
    Created on : Oct 12, 2011, 8:54:34 PM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrasi</title>
        
    </head>
    <body>
       <h1>Registrasi</h1>
       <fieldset>     
            <table border="0.1">
                <tr><td>
            <form method='post' action='StatusMahasiswa.jsp'>
              <input type='submit' value='Status Mahasiswa' >
        </form>
                    </td> </tr>
                    <tr><td>
            <form method='post' action='Dispatcher?page=pengaturanAkun'>
              <input type='submit' value='Pengaturan Akun' >
        </form>
                    </td> </tr>
                    <tr><td>
            <form method='post' action='BeasiswaYangTersedia.jsp'>
              <input type='submit' value='Beasiswa yang Tersedia' >
        </form>
                    </td> </tr>
                <tr><td>
            <form method='post' action='Registrasi.jsp'>
              <input type='submit' value='Daftar Sekarang' >
        </form>
                    </td> </tr>
                <tr><td>
            <form method='post' action='DaftarBeasiswa.jsp'>
              <input type='submit' value='Daftar Beasiswa' >
        </form>
                    </td> </tr>
                 <tr><td>
            <form method='post' action='Logout.jsp'>
              <input type='submit' value='Logout' >
        </form>
                    </td> </tr>
            </table>
       </fieldset>
    </body>
</html>

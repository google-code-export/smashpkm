<%-- 
    Document   : index
    Created on : Oct 4, 2011, 12:23:25 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test</title>
    </head>
    <body>
        <h1>login</h1>
        <form method='post' action='SimpanRegistrasi'>
            <fieldset>
                <table border=2 tbcolor="white">
                    <tr>
                        <td>
            nrp:
                        </td>
                        <td>
            <input type=text name='nama' />
                        </td>
                    </tr>
                    <tr>

                    <td>
            password:
                    </td>
                    <td>
            <input type=text name='nrp'/>
            </td>
                </table>
            <input type='submit' value='Login'/>
            </fieldset>
        </form>
            <br>
            <form method='post' action='Registrasi.jsp'>
              <input type='submit' value='Daftar Sekarang' >

        </form>
    </body>
</html>

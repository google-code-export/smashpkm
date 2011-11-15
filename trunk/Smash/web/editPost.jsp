<%-- 
    Document   : editPost
    Created on : Nov 14, 2011, 8:05:32 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
                        <form method='post' action='Dispatcher?page=pengaturanPost'>
                            <input type='submit' value='Posts' >
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
        <form method='post' action='Dispatcher?page=membuatPost'>
            <fieldset>
                <table border=0>
                    <tr>
                        <td>
            nama beasiswa:
                        </td>
                        <td>
            <input type=text name='namabeasiswa' value=${beasiswa.namabeasiswa} />

                        </td>
                         <td>
            <input type=text name='zz' value=${publish} />

                        </td>
                    </tr>
                    <tr>
                </table>
            <input type='submit' value='add'/>
            </fieldset>
        </form>


    </body>
</html>

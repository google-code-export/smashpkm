<%-- 
    Document   : pengaturanPassword
    Created on : Nov 1, 2011, 1:08:25 PM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
  
        <table border="0">
    <tr>
        <td> <form method='post' action='Dispatcher?page=home'>
            <input type='submit' value='Menu Utama' >
            </form>
        </td>
            <td> <form method='post' action='Dispatcher?page=home'>
            <input type='submit' value='Profil' >
                </form>
            </td>
             <td>
           <form method='post' action='Dispatcher?page=pengaturanPassoword'>
            <input type='submit' value='Ganti Password' >
                </form>
            </td>
     <td>
           <form method='post' action='Dispatcher?page=pengaturanPassoword'>
            <input type='submit' value='Status Mahasiswa' >
                </form>
            </td>
     <td>
           <form method='post' action='Dispatcher?page=logout'>
            <input type='submit' value='Logout' >
                </form>
            </td></tr>
        </table>
        <p>${pesan}</p>
      
        <form method='post'  action='Dispatcher?page=setPengaturanPassword'>

            <fieldset>
                <table border=0>

                    <tr>
                        <td>
                            Password Lama:
                        </td>
                        <td>
                            <input type=text name='password_lama' />
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Passord Baru:
                        </td>
                        <td>
                            <input type=text name='password_baru' />
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Passord Baru Ulangi:
                        </td>
                        <td>
                            <input type=text name='password_baru_ulangi' />
                        </td>

                    </tr>

                   

                       

                </table>

                <input type='submit' value='update'/>

            </fieldset>
        </form>


    </body>
</html>
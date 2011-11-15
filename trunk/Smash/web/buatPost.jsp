<%-- 
    Document   : buatPost
    Created on : Nov 9, 2011, 12:12:14 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rev="made" href="mailto:contact@rainforestnet.com">
        <meta name="generator" content="NoteTab Light 4.9">
        <meta name="author" content="TengYong Ng">
        <meta name="description" content="">
        <meta name="keywords" content="">

        <script language="javascript" type="text/javascript" src="datetimepicker.js">

            //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
            //Script featured on JavaScript Kit (http://www.javascriptkit.com)
            //For this script, visit http://www.javascriptkit.com

        </script>

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
        <fieldset>

            <form method='post' action='Dispatcher?page=goBuatPost'>
                <table border="0">
                    <tr>                          
                        <td >
                            nama beasiswa:
                        </td>
                        <td >
                            <input type=text name='namabeasiswa' value="${beasiswa.namabeasiswa}"/>
                            &nbsp; &nbsp;

                        </td>
                        <td>
                            tanggal publish:
                        </td>
                        <td> 
                           <input id="demo1" type="text" name="tanggalpublish" size="25" value="${beasiswa.tanggalpublish}"><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            tanggal kadaluwarsa:
                        </td>
                        <td>
                            <input type="text" name="tanggalkadaluwarsa"/>
                        </td>
                    </tr>


                </table>
                <p>keterangan</p>
                <textarea rows="10" cols="30" name="keterangan">${beasiswa.keterangan}</textarea>
                <input type='submit' value='add'/>
            </form>

        </fieldset>
    </body>
</html>
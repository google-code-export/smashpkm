<%--
    Document   : pengaturanPost
    Created on : Dec 11, 2011, 10:38:02 PM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        

    </head>
    <body>

           <form method='post' action='Dispatcher?page=home&&nrp=${mahasiswa.nrp}'>
            <input type='submit' value='Pengaturan member' />
        </form>

        <form method='post' action='Dispatcher?page=goBuatMember' onsubmit="">

                            <br/><fieldset>
                                <table border=0>
                                    <dd/><font color="red"><%= request.getAttribute("pesan")%></font>
                                    <br/>
                                    <tr>
                                        <td>
                                            <dd/><h6>Nama Lengkap</h6>
                                        </td>
                                        <td>
                                            <h6>: <input type=text name='nama' /></h6>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <dd/><h6>Username (NIM)</h6>
                                        </td>
                                        <td>
                                            <h6>: <input type=text name='nrp'/></h6>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <dd/><h6>Password</h6>
                                        </td>

                                        <td>
                                            <h6>: <input type=password name='password'/></h6>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <dd/><h6>Ulangi password</h6>
                                        </td>

                                        <td>
                                            <h6>: <input type=password name='password_ulangi'/></h6>
                                        </td>
                                    </tr>
                                </table>
                                <br/>
                                <dd/><input type='submit' value='Daftar'/>
                            </fieldset>
                        </form>

    </body>
</html>>

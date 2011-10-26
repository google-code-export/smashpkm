<%-- 
    Document   : Pengaturan
    Created on : Oct 21, 2011, 12:15:27 PM
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
         <form method='post' name="myForm" onsubmit='return pencocokanPassword()' action='Dispatcher?page=goRegistrasi'>

            <fieldset>
                <table border=0>

            <tr>
            <td>
            Nama:
            </td>
            <td>
            <input type=text name='nama' />
            </td>
            </tr>

            <tr>
            <td>
            NRP     :
            </td>
            <td>
            <input type=text name='nrp'/>
            </td>
            </tr>

            <tr>
            <td>
            No HP     :
            </td>

            <td>
            <input type=text name='no_hp'/>
            </td>
            </tr>

            <tr>
            <td>
            Alamat Asal :
            </td>
            <td>
            <input type=text name='alamat_asal'/>
            <td>
            </tr>
            <tr>
            <td>
            Alamat Surabaya:
            </td>
            <td>
            <input type=text name='alamat_surabaya' />
            </td>
            </tr>

            <tr>
            <td>
            Nilai TOEFL     :
            </td>
            <td>
            <input type=text name='nilai_toefl'/>
            </td>
            </tr>

            <tr>
            <td>
            Semester     :
            </td>

            <td>
            <input type=text name='semester'/>
            </td>
            </tr>

            <tr>
            <td>
            IPK :
            </td>
            <td>
            <input type=text name='ipk'/>
            <td>
            </tr>
            <tr>
            <td>
            Nama Ayah:
            </td>
            <td>
            <input type=text name='nama_ayah' />
            </td>
            </tr>

            <tr>
            <td>
            Pekerjaan Ayah    :
            </td>
            <td>
            <input type=text name='pekerjaan_ayah'/>
            </td>
            </tr>

            <tr>
            <td>
            Penghasilan Ayah  :
            </td>

            <td>
            <input type=text name='penghasilan_ayah'/>
            </td>
            </tr>

            <tr>
            <td>
            Nama Ibu :
            </td>
            <td>
            <input type=text name='nama_ibu'/>
            <td>
            </tr>
            <tr>
            <td>
            Pekerjaan Ibu:
            </td>
            <td>
            <input type=text name='pekerjaan_ibu' />
            </td>
            </tr>

            <tr>
            <td>
            Penghasilan Ibu     :
            </td>
            <td>
            <input type=text name='penghasilan_ibu'/>
            </td>
            </tr>

            <tr>
            <td>
            Jumlah Saudara     :
            </td>

            <td>
            <input type=text name='jumlah_saudara'/>
            </td>
            </tr>


                </table>

            <input type='submit' value='update'/>

            </fieldset>
        </form>
    </body>
</html>

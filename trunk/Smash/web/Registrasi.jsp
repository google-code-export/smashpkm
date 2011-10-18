<%-- 
    Document   : Registrasi
    Created on : Oct 12, 2011, 7:11:23 PM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script type="text/javascript">

function pencocokanPassword() {
var spasi = " "; 
var password = document.myForm.password.value;
var passwordUlangi = document.myForm.password_ulangi.value;
var nama= document.myForm.nama.value;
var nrp= document.myForm.nrp.value;



if ((password == '') || (passwordUlangi == '')||(nama=='')||(nrp='')  ){
alert('Isikan seluruh form sesuai data anda');
return false;
}

if (document.myForm.password.value.indexOf(spasi) > -1) {
alert('Password tidak boleh mengandung spasi');
return false;

}
else {
if (password != passwordUlangi) {
alert ("Password harus sama");
return false;
}

   }
}</script> 
    </head>
    <body>
       <h1>Registrasi</h1>
        <form method='post' name="myForm" onsubmit='return pencocokanPassword()' action='SimpanRegistrasi'>
            <fieldset>
                <table border=2>
            <tr>
            <td>
            nama:
            </td>
            <td>
            <input type=text name='nama' />
            </td>
            </tr>

            <tr>
            <td>
            nrp     :
            </td>
            <td>
            <input type=text name='nrp'/>
            </td>
            </tr>

            <tr>
            <td>
            password     :
            </td>

            <td>
            <input type=password name='password'/>
            </td>
            </tr>

            <tr>
            <td>
            ulangi password     :
            </td>
            <td>
            <input type=password name='password_ulangi'/>
            <td>
            </tr>
                </table>

            <input type='submit' value='submit'/>

            </fieldset>
        </form>
    </body>
</html>

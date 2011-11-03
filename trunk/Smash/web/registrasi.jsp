<%-- 
    Document   : registrasi
    Created on : Oct 31, 2011, 9:50:50 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<script type='text/javascript'>

    function pencocokanPassword() {
        var spasi = " ";
        var password = document.myForm.password.value;
        var passwordUlangi = document.myForm.password_ulangi.value;
        var nama= document.myForm.nama.value;
        var nrp= document.myForm.nrp.value;



        if ((password == '') || (passwordUlangi == '')||(nama=='')||(nrp='')  ){
            document.getElementById('pesan').innerHTML = 'Isikan seluruh form sesuai data anda';

            //alert('Isikan seluruh form sesuai data anda');
            return false;


        }

        if (document.myForm.password.value.indexOf(spasi) > -1) {
            document.getElementById('pesan').innerHTML = 'password tidak boleh mengandung spasi';
           // alert('password tidak boleh mengandung spasi');


            return false;

        }
        if (document.myForm.nrp.value.indexOf(spasi) > -1) {
            document.getElementById('pesan').innerHTML = 'nrp tidak boleh mengandung spasi';
           // alert('nrp tidak boleh mengandung spasi');


            return false;

        }
        else {
            if (password != passwordUlangi) {
                document.getElementById('pesan').innerHTML = "Password harus sama";
               // alert ("Password harus sama");
                return false;
            }

        }
    }</script>
</head>
<body>
    <p><font size="3" id='pesan'> </font></p>
    <h1>Registrasi</h1>

    <form method='post' name="myForm" onsubmit='return pencocokanPassword()' action='Dispatcher?page=goRegistrasi'>

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
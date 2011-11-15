<%--
    Document   : registrasi
    Created on : 04 Nov 11, 19:04:53
    Author     : Danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>SMASH</title>
        <meta name="keywords" content="Chrome Web Design, CSS, HTML, free template, piecemaker" />
        <meta name="description" content="Chrome Web Design is a free website template integrated with PieceMaker 3D Flash Slider." />
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="scripts/swfobject/swfobject.js"></script>
        <script type="text/javascript">
            var flashvars = {};
            flashvars.cssSource = "css/piecemaker.css";
            flashvars.xmlSource = "piecemaker.xml";

            var params = {};
            params.play = "true";
            params.menu = "false";
            params.scale = "showall";
            params.wmode = "transparent";
            params.allowfullscreen = "true";
            params.allowscriptaccess = "always";
            params.allownetworking = "all";

            swfobject.embedSWF('piecemaker.swf', 'piecemaker', '960', '500', '10', null, flashvars,
            params, null);

        </script>

        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <script type="text/javascript" src="scripts/ddsmoothmenu.js">

            /***********************************************
             * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
             * This notice MUST stay intact for legal use
             * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
             ***********************************************/

        </script>

        <script type="text/javascript">

            ddsmoothmenu.init({
                mainmenuid: "templatemo_menu", //menu DIV id
                orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu', //class added to menu's outer DIV
                //customtheme: ["#1c5a80", "#18374a"],
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
            })
        </script>

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

        <div id="templatemo_wrapper">

            <div id="templatemo_header">

                <img src="images/logo.png"/>

                <div id="templatemo_menu" class="ddsmoothmenu">
                    <ul>
                        <li><a href="index.html" class="selected">Home</a></li>
                        <li><a href="about.html">About</a>
                            <ul>
                                <li><a href="http://www.templatemo.com/page/1">SMASH</a></li>
                                <li><a href="http://www.templatemo.com/page/2">Our Team</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">Contact</a></li>
                    </ul>
                    <br style="clear: left" />
                </div> <!-- end of templatemo_menu -->

            </div> <!-- end of header -->

            <div class="cleaner h20"></div>
            <h6 align="right">Follow us at
                <br/><img align="right" src="images/twitter.png"/>  <img align="right" src="images/facebook.png"/></h6>

            <div id="templatemo_fw">
                <div id="piecemaker"/>
                <p>Download Adobe Flash Player untuk menampilkan konten 3D Flash Slider</p>
            </div>

            <div id="templatemo_main">
                <div class="sb_box">
                    <h3>Registration Form</h3>
                </div>
                <div class="col_fw">
                    <div class="col_w460 float_l">
                        <div class="cleaner h20"></div>
                        <br/><br/>
                        <h2>SMASH</h2>
                        <h5>Smart Application Scholarhip</h5>
                        <div class="cleaner h20"></div>
                        <h6>Jika Anda mengalami kesulitan melakukan pendaftaran, silahkan hubungi BAAK ITS atau email ke baak@its.ac.id</h6>
                        <div class="cleaner h20"></div>
                    </div>
                    <div class="col_w460 float_r">
                        <script language=JavaScript>

                            hariIni=new Date();
                            diniHari=hariIni.getDay();
                            tanggalSekarang=hariIni.getDate();
                            bulanSekarang=hariIni.getMonth()+1;
                            tahunSekarang=hariIni.getFullYear();

                            //Membuat Nama Hari
                            function tulisanHari (UrutanHari) {
                                Hari=new Array(); Hari[0]="Minggu"; Hari[1]="Senin"; Hari[2]="Selasa";
                                Hari[3]="Rabu"; Hari[4]="Kamis"; Hari[5]="Jumat"; Hari[6]="Sabtu";
                                return Hari[UrutanHari];
                            }
                            NamaHari=tulisanHari(diniHari);

                            //Membuat Nama Bulan
                            function tulisanBulan (UrutanBulan) {
                                Bulan=new Array(); Bulan[1]="Januari"; Bulan[2]="Februari"; Bulan[3]="Maret";
                                Bulan[4]="April"; Bulan[5]="Mei"; Bulan[6]="Juni"; Bulan[7]="Juli";
                                Bulan[8]="Agustus"; Bulan[9]="September"; Bulan[10]="Oktober";
                                Bulan[11]="November"; Bulan[12]="Desember";
                                return Bulan[UrutanBulan];
                            }
                            NamaBulan=tulisanBulan(bulanSekarang);

                            //Model Kotak & Isian Tanggal
                            d = new Date(); h = d.getHours();
                            document.write(NamaHari+", "+tanggalSekarang+" "+NamaBulan+" "+tahunSekarang);

                        </script>

                        <form method='post' action='Dispatcher?page=goRegistrasi' onsubmit="">

                            <br/><fieldset>
                                <table border=0>
                                    <br/>
                                    <tr>
                                        <td>
                                            <dd/><h6>Nama</h6>
                                        </td>
                                        <td>
                                            <h6>: <input type=text name='nama' /></h6>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <dd/><h6>Username</h6>
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
                    </div>
                    <div class="cleaner"></div>
                </div>
            </div>
        </div>

        <div class="cleaner"></div>

        <div id="templatemo_footer_wrapper">
            <div id="templatemo_footer">
                Copyright Â© 2011 <a href="#">Smash Inc.</a> | Institut Teknologi Sepuluh Nopember
                <div class="cleaner"></div>
            </div>
        </div>

    </body>
</html>>
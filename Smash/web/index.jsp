<%--
    Document   : index
    Created on : 03 Nov 11, 11:09:45
    Author     : Danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel='icon' href="images/favicon.ico" />
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
                    <h3>Login Form</h3>
                </div>
                <div class="col_fw">
                    <div class="col_w460 float_l">
                        <div class="cleaner h20"></div>
                        <br/>
                        <h2>SMASH</h2>
                        <h5>Smart Application Scholarhip</h5>
                        <div class="cleaner h20"></div>
                        <h6>Jika Anda mengalami kesulitan login, silahkan hubungi BAAK ITS atau email ke baak@its.ac.id</h6>
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

                        <form method='post' action='DispatcherMahasiswa?page=login'>
                            <br/><fieldset>
                                <table border=0>
                                    <dd/><font color="red"><b><%= request.getAttribute("pesan")%></b></font>
                                    <br/>
                                    <tr>
                                        <td>
                                            <dd/><h5>Username (NIM)</h5>
                                        </td>
                                        <td>
                                            <h5>: <input type=text name='nrp' /></h5>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <dd/><h5>Password</h5>
                                        </td>
                                        <td>
                                            <h5>: <input type=password name='password'/></h5>
                                        </td>
                                    </tr>
                                </table>
                                <br/>
                                <table>
                                    <tr><td/>
                                        <td>
                                            <dd/>
                                            <form><input type='submit' value='Login'/>
                                            </form>
                                            atau
                                        </td>
                                        <td>
                                            <form method='post' action='DispatcherMahasiswa?page=registrasi'/>
                                            <input type='submit' value='Daftar Sekarang >>' />
                                        </td>
                                    </tr>
                                </table>
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
                Copyright © 2011 <a href="#">Smash Inc.</a> | Institut Teknologi Sepuluh Nopember
                <div class="cleaner"></div>
            </div>
        </div>

    </body>
</html>
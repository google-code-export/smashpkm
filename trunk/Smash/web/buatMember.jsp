<%--
    Document   : buatMember
    Created on : Dec 28, 2011, 10:38:02 PM
    Author     : Danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel='icon' href="images/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Pengaturan Member-SMASH</title>
        <meta name="keywords" content="Chrome Blog Theme, Web Design, CSS, HTML, free template" />
        <meta name="description" content="Chrome Blog Template is a free website template from templatemo.com" />
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

        <link rel="stylesheet" media="screen" href="buttonstyle.css">

    </head>
    <body>
        <div id="templatemo_wrapper">

            <div id="templatemo_header">

                <img src="images/logo.png"/>

                <div id="templatemo_menu" class="ddsmoothmenu">
                    <ul>
                        <li><a href="DispatcherMahasiswa?page=home&&nrp=${mahasiswa.nrp}">Home</a></li>
                        <li><a href="DispatcherMahasiswa?page=home&&nrp=${mahasiswa.nrp}">Menu Utama</a>
                            <ul>
                                <li><a href="DispatcherBeasiswa?page=pengaturanPost">Posts</a></li>
                                <li><a href="DispatcherMahasiswa?page=pengaturanMember">Members</a></li>
                                <li><a href="DispatcherPengajuan?page=listRekapitulasi">Rekapitulasi</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">Panduan</a></li>
                        <li><a href="contact.html">Kontak</a></li>
                    </ul>
                    <br style="clear: left" />
                </div> <!-- end of templatemo_menu -->

            </div> <!-- end of header -->
            <br/>
            <p align="right"><font color="black">Anda login sebagai ${mahasiswa.nama},</font><a style="color: red" href="DispatcherMahasiswa?page=logout&&nrp=${mahasiswa.nrp}">(logout)</a></p>

            <div id="templatemo_main">

                <div class="sb_box">
                    <h3>Menambah Member Baru</h3>
                </div>

                <div class="col_w280 float_l">
                    <img src="images/track_Member.png"/>
                </div>

                <div class="col_w630 float_r">
                    <div id="contact_form">

                        <font color="#E56717">
                            <b><%= request.getAttribute("pesan")%></b>
                        </font>

                        <form method='post' action='DispatcherMahasiswa?page=goBuatMember' onsubmit="">
                            <table border=0>
                                <br/>
                                <tr>
                                    <td>
                                        <h6>Nama Lengkap</h6>
                                    </td>
                                    <td>
                                        <h6>: <input type=text name='nama' /></h6>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h6>Username (NIM)</h6>
                                    </td>
                                    <td>
                                        <h6>: <input type=text name='nrp'/></h6>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h6>Password</h6>
                                    </td>

                                    <td>
                                        <h6>: <input type=password name='password'/></h6>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <h6>Ulangi password</h6>
                                    </td>

                                    <td>
                                        <h6>: <input type=password name='password_ulangi'/></h6>
                                    </td>
                                </tr>
                            </table>
                            <br/>
                            <table>
                                <tr>
                                    <td>
                                        <input type="submit" class="submit_btn float_l" name="submit" id="submit" value="Tambahkan Sebagai Member Baru"  />
                                    </td>
                                    <td>
                                        <a href="DispatcherMahasiswa?page=pengaturanMember"><input type="button" class="submit_btn float_r" value="Kembali"/></a>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="templatemo_footer_wrapper">
            <div id="templatemo_footer">
                Copyright © 2011 <a href="#">Smash Inc.</a> | Institut Teknologi Sepuluh Nopember
                <div class="cleaner"></div>
            </div>
        </div>

    </body>
</html>

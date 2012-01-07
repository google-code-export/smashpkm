<%--
    Document   : beasiswaYangTersedia
    Created on : 05 Nov 11, 16:07:12
    Author     : Danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel='icon' href="images/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Apply Beasiswa-SMASH</title>
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
                                <li><a href="DispatcherMahasiswa?page=pengaturanAkun">Pengaturan Akun</a></li>
                                <li><a href="DispatcherPengajuan?page=statusBeasiswa">Status Beasiswa</a></li>
                                <li><a href="DispatcherBeasiswa?page=beasiswaYangTersedia">List Beasiswa</a></li>
                                <li><a href="DispatcherPengajuan?page=listDaftarBeasiswa">Mendaftar Beasiswa</a></li>
                            </ul>
                        </li>
                        <li><a href="about.html">Panduan</a>
                            <ul>
                                <li><a href="http://www.templatemo.com/page/1">Mengelola Akun</a></li>
                                <li><a href="http://www.templatemo.com/page/2">Melihat Status</a></li>
                                <li><a href="http://www.templatemo.com/page/2">Melihat List Beasiswa</a></li>
                                <li><a href="http://www.templatemo.com/page/2">Mendaftar Beasiswa</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">Peraturan</a></li>
                        <li><a href="contact.html">Kontak</a></li>
                    </ul>
                    <br style="clear: left" />
                </div> <!-- end of templatemo_menu -->

            </div> <!-- end of header -->
            <br/>
            <p align="right"><font color="black">Anda login sebagai ${mahasiswa.nama},</font><a style="color: red" href="DispatcherMahasiswa?name=logout">(logout)</a></p>

            <div id="templatemo_main">

                <div class="sb_box">
                    <h3>Apply Beasiswa</h3>
                </div>
                <table border=0>
                    <tr>

                        <td>
                            <form method='post' action='DispatcherBeasiswa?page=listPilihBeasiswa'>
                                <input type='submit' value='Kembali' />
                            </form>
                        </td>
                        <td>
                            <form method='post' action='DispatcherMahasiswa?page=home&&nrp=${mahasiswa.nrp}'>
                                <input type='submit' value='Menu Utama' />
                            </form>
                        </td>
                        <td>
                            <form method='post' action='DispatcherMahasiswa?page=logout&&nrp=${mahasiswa.nrp}'>
                                <input type='submit' value='Logout' />
                            </form>
                        </td>
                    </tr>
                </table>
                <form  method="post"  enctype="multipart/form-data" action="DispatcherPengajuan?page=goDaftarBeasiswa&&nrp=${mahasiswa.nrp}&&idbeasiswa=${idbeasiswa}" >
                    <table width="374" height="112" border="0">
                        <tr>
                            <td width="171" height="32">Scan Transkrip IPK</td>
                            <td> <input type="file" name="scan_ipk" /></td>
                        </tr>
                        <tr>
                            <td height="32">Scan Slip gaji</td>
                            <td><input type="file" name="scan_gaji" /></td>
                        </tr>
                        <tr>
                            <td width="171" height="32">Scan Surat Tidak Mampu</td>
                            <td> <input type="file" name="scan_surat_tidak_mampu" /></td>
                        </tr>

                        <tr>
                            <td width="171" height="32">Scan KTM</td>
                            <td> <input type="file" name="scan_ktm" /></td>
                        </tr>
                        <tr>
                            <td height="32">Scan KTP</td>
                            <td><input type="file" name="scan_ktp" /></td>
                        </tr>
                        <tr>
                            <td width="171" height="32">Scan Kartu Keluarga</td>
                            <td> <input type="file" name="scan_kk" /></td>
                        </tr>
                        <tr>
                            <td height="32">Scan Curriculum Vitae</td>
                            <td><input type="file" name="scan_cv" /></td>
                        </tr>
                        <tr>
                            <td width="171" height="32">Scan Sertifikat Kegiatan</td>
                            <td> <input type="file" name="scan_sertifikat" /></td>
                        </tr>
                        <tr>
                            <td width="171" height="32">Scan Rekening Bank</td>
                            <td> <input type="file" name="scan_rekening" /></td>
                        </tr>
                        <tr>
                            <td height="40">&nbsp;</td>
                            <td><input type="submit" name="button" id="button" value="Submit" /></td>
                        </tr>
                    </table>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <h1>&nbsp;</h1>
                    <h1>&nbsp;</h1>
                </form>
            </div>
        </div>
        <div class="cleaner h10"></div>
        <div id="templatemo_footer_wrapper">
            <div id="templatemo_footer">
                Copyright © 2011 <a href="#">Smash Inc.</a> | Institut Teknologi Sepuluh Nopember
                <div class="cleaner"></div>
            </div>
        </div>
    </body>
</html>
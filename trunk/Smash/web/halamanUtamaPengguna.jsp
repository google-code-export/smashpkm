<%--
    Document   : halamanUtamaPengguna
    Created on : 04 Nov 11, 08:15:05
    Author     : Danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel='icon' href="images/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>${mahasiswa.nama}</title>
        <meta name="keywords" content="Chrome Web Design, CSS, HTML, free template, piecemaker" />
        <meta name="description" content="Chrome Web Design is a free website template integrated with PieceMaker 3D Flash Slider." />
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />

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
            <br/>
            <p align="right"><font color="black">Anda login sebagai ${mahasiswa.nama},</font><a style="color: red" href="DispatcherMahasiswa?name=logout&&nrp=${mahasiswa.nrp}">(logout)</a></p>

            <div id="templatemo_main">
                <div class="sb_box">
                </div>
                <div class="col_fw">
                    <div class="col_w460 float_l">
                        <h5> </h5>
                        <img src="images/utama.png"/>
                        <div class="cleaner h20"></div>
                    </div>
                    <div class="col_w460 float_r">
                        <h2>Menu Utama</h2>
                        <div class="col_w460">
                            <div class="fp_service_box fp_c1">
                                <table>
                                    <tr>
                                        <td>
                                            <img src="images/1_64x64.png" alt="Image 1" />
                                        </td>
                                        <td>
                                            <a href="DispatcherMahasiswa?page=pengaturanAkun&&nrp=${mahasiswa.nrp}"><h4>Pengaturan Akun</h4></a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col_w460">
                            <div class="fp_service_box fp_c2">
                                <table>
                                    <tr>
                                        <td>
                                            <img src="images/32_64x64.png" alt="Image 2" />
                                        </td>
                                        <td>
                                            <a href="DispatcherPengajuan?page=statusBeasiswa&&nrp=${mahasiswa.nrp}"> <h4>Status Beasiswa</h4></a>
                                            
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col_w460">
                            <div class="fp_service_box fp_c3">
                                <table>
                                    <tr>
                                        <td>
                                            <img src="images/list.png" alt="Image 3"/>
                                        </td>
                                        <td>
                                            <a href="DispatcherBeasiswa?page=beasiswaYangTersedia"> <h4>Beasiswa yang Tersedia</h4></a>
                                            
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="col_w460">
                            <div class="fp_service_box fp_c4">
                                <table>
                                    <tr>
                                        <td>
                                            <img src="images/50_64x64.png" alt="Image 4" />
                                        </td>
                                        <td>

                                            <a href="DispatcherPengajuan?page=listDaftarBeasiswa&&nrp=${mahasiswa.nrp}"<h4>Daftar Beasiswa</h4> </a>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="cleaner"></div>
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
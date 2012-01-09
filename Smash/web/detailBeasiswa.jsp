<%--
    Document   : editPost
    Created on : Nov 9, 2011, 18:24:14 AM
    Author     : danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel='icon' href="images/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Detail Beasiswa-SMASH</title>
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
        <link rel="stylesheet" media="screen" href="buttonstyle.css"/>

        <script language="javascript" type="text/javascript" src="datetimepicker.js">

            //Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
            //Script featured on JavaScript Kit (http://www.javascriptkit.com)
            //For this script, visit http://www.javascriptkit.com

        </script>

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
                    <h3>Detail ${beasiswa.namabeasiswa}</h3>
                </div>

                <div class="col_w630 float_l">

                    <div id="contact_form">
                        <br/>
                        <form method="post" name="contact" action="#">
                            <p>
                                <label for="author">
                                    <font color="black">Nama Beasiswa</font>
                                </label>
                                <br/>
                                <input type=text name='namabeasiswa' class="input_field" value="${beasiswa.namabeasiswa}" style="font-weight: bold ; text-transform: uppercase" disabled="disabled"/>
                            </p>
                            <div class="cleaner h10"></div>

                            <br/>

                            <p>
                                <label for="text">
                                    <font color="black">Keterangan</font>
                                </label>
                                <br/>
                                <textarea id="text" name="keterangan" rows="0" cols="0" value="${beasiswa.keterangan}" disabled="disabled">${beasiswa.keterangan}</textarea>
                            </p>
                        
                        <br/>
                        <table>
                            <tr>
                                <td>
                                    <a href="DispatcherBeasiswa?page=beasiswaYangTersedia"><input type="button" class="submit_btn float_r" value="Kembali"/></a>
                                </td>
                            </tr>
                        </table>

                        </form>
                        <div class="cleaner h10"></div>
                    </div>
                </div>

                <br/>
                <div class="col_w300 float_r">
                    <table align="right">
                        <tr>
                            <td>
                                <font color="black"><b>Tanggal Posting Beasiswa</b></font>
                            </td>
                            <td>
                                <font color="black"><b>: ${tanggalpublish}</b></font>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <font color="black"><b>Batas Pendaftaran Beasiswa</b></font>
                            </td>
                            <td>
                                <font color="black"><b>: ${tanggalkadaluwarsa}</b></font>
                            </td>
                        </tr>
                    </table>
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

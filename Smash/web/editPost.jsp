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
        <title>Edit Post-SMASH</title>
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
                    <h3>Edit Post</h3>
                </div>

                <div class="col_w300 float_l">
                    <img src="images/track_Post.png"/>
                </div>

                <div class="col_w630 float_r">
                    <div id="contact_form">
                        <font color="#E56717">
                            <b><%= request.getAttribute("pesan")%></b>
                        </font>

                        <input type="hidden" name="post" value="Send" />
                        <form method='post' action='DispatcherBeasiswa?page=goEditPost&&idbeasiswa=${beasiswa.idbeasiswa}'>
                            <table align="left">
                                <tr>
                                    <td>
                                        <font color="black">Tanggal Publish Post</font>
                                    </td>
                                    <td>
                                        : <input id="demo1" type="text" name="tanggalpublish" size="15" value="${tanggalpublish}"><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <font color="black">Tanggal Batas Pendaftaran</font>
                                    </td>
                                    <td>
                                        : <input id="demo2" type="text" name="tanggalkadaluwarsa" size="15" value="${tanggalkadaluwarsa}"><a href="javascript:NewCal('demo2','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <font color="black">Tanggal Mulai Kontrak</font>
                                    </td>
                                    <td>
                                        : <input id="demo3" type="text" name="tanggalmulai" size="15" value="${tanggalmulai}"><a href="javascript:NewCal('demo3','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <font color="black">Tanggal Batas Kontrak</font>
                                    </td>
                                    <td>
                                        : <input id="demo4" type="text" name="tanggalhabis" size="15" value="${tanggalhabis}"><a href="javascript:NewCal('demo4','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                    </td>
                                </tr>
                            </table>

                            <br/><br/><br/><br/><br/><br/><br/>
                            <p align="right">
                                <label for="author">
                                    <font color="black">Judul Post</font>
                                </label>
                            <input type=text name='namabeasiswa' class="input_field" value="${beasiswa.namabeasiswa}" style="font-weight: bold ; text-transform: uppercase"/>
                            </p>
                            <div class="cleaner h10"></div>

                            <p align="right">
                                <label for="text">
                                    <font color="black">Keterangan</font>
                                </label> <textarea id="text" name="keterangan" rows="0" cols="0" value="${beasiswa.keterangan}">${beasiswa.keterangan}</textarea>
                            </p>
                            <div class="cleaner h10"></div>
                            <table>
                                <tr>
                                    <td>
                                        <input type="submit" class="submit_btn float_l" name="submit" id="submit" value="Edit Post"  />
                                    </td>
                                    <td>
                                        <input type="reset" class="submit_btn float_r" name="reset" id="reset" value="Reset" />
                                    </td>
                                    <td>
                                        <a href="DispatcherBeasiswa?page=pengaturanPost"><input type="button" class="submit_btn float_r" value="Kembali"/></a>
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
<%--
    Document   : statusBeasiswa
    Created on : 05 Nov 11, 16:07:12
    Author     : Danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link rel='icon' href="images/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Status Beasiswa-SMASH</title>
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
                    <h3>Status Beasiswa</h3>
                </div>

                <table border="1">
                    <thead>
                        <tr>
                            <th>
                                <font color="black">
                                    No
                                </font>
                            </th>
                            <th>
                                <font color="black">
                                    Nama Beasiswa
                                </font>
                            </th>
                            <th>
                                <font color="black">
                                    Tanggal Mulai Berlaku
                                </font>
                            </th>
                            <th>
                                <font color="black">
                                    Tanggal Kadaluwarsa
                                </font>
                            </th>
                            <th>
                                <font color="black">
                                    Status Pengajuan
                                </font>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <%int i = 1;%>

                        <c:forEach items="${list_pengajuan_by_nrp}" var="bsw">

                            <tr>
                                <td>
                                    <font color="black">
                                        <%out.print(i);%>
                                        <%i++;%>
                                    </font>
                                </td>
                                <td>
                                    <font color="black">
                                        ${bsw.idbeasiswa.namabeasiswa}
                                    </font>
                                </td>
                                <td>
                                    <font color="black">
                                        ${bsw.idbeasiswa.tanggalmulai}
                                    </font>
                                </td>
                                <td>
                                    <font color="black">
                                        ${bsw.idbeasiswa.tanggalkadaluarsa}
                                    </font>
                                </td>
                                <td>
                                    <font color="black">
                                        ${bsw.statuspengajuan}
                                    </font>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <table>
                    <tr>
                        <td width="125px">
                        </td>
                        <td>
                            <font color="black" >
                                <b><i><%= request.getAttribute("pesan")%></i></b>
                            </font>
                        </td>
                    </tr>
                </table>


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

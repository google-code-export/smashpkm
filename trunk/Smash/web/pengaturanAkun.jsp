<%--
    Document   : registrasi
    Created on : 05 Nov 11, 16:07:12
    Author     : Danang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
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
        <link rel="stylesheet" media="screen" href="buttonstyle.css">
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
            <p align="right"><font color="black">Anda login sebagai ${mahasiswa.nama},</font><a style="color: red" href="Dispatcher?name=logout">(logout)</a></p>

            <div class="content">
                <table border="0">
                    <tr>
                        <td>
                            <a href="Dispatcher?page=pengaturanAkun" title="" class="btn medium green">Profil</a>
                        </td>
                        <td>
                            <a href="Dispatcher?page=home" title="" class="btn medium green">Menu Utama</a>
                        </td>
                        <td>
                            <a href="Dispatcher?page=pengaturanPassword" title="" class="btn medium green">Ganti Password</a>
                        </td>
                    </tr>
                </table>
            </div>

            <table border="0">
                <font color="red"><%= request.getAttribute("pesan")%></font>
                <font color="green"><%= request.getAttribute("pesan1")%></font>
                <br/>
                <tr>
                    <td> <form class="btn medium green" method='post' action='Dispatcher?page=home'>
                            <input type='submit' value='Menu Utama' >
                        </form>
                    </td>
                    <td> <form method='post' action='Dispatcher?page=home'>
                            <input type='submit' value='Profil' >
                        </form>
                    </td>
                    <td>
                        <form method='post' action='Dispatcher?page=pengaturanPassword'>
                            <input type='submit' value='Ganti Password' >
                        </form>
                    </td>
                    <td>
                        <form method='post' action='Dispatcher?page=statusMahasiswa'>
                            <input type='submit' value='Status Mahasiswa' >
                        </form>
                    </td>
                    <td>
                        <form method='post' action='Dispatcher?page=logout'>
                            <input type='submit' value='Logout' >
                        </form>
                    </td></tr>
            </table>
            <form method='post'  action='Dispatcher?page=setPengaturanAkun'>

                <fieldset>
                    <table border=0>

                        <tr>
                            <td>
                                <font color="black">Nama</font>
                            </td>
                            <td>
                                : <input type=text name='nama' value='${mahasiswa.nama}' />
                            </td>

                        </tr>

                        <tr>
                            <td>
                                <font color="black">NRP</font>
                            </td>
                            <td>
                                : <font color="black">${mahasiswa.nrp}</font>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">No HP</font>
                            </td>

                            <td>
                                : <input type=text name='no_hp' value='${mahasiswa.nohp}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Alamat Asal</font>
                            </td>
                            <td>
                                <font color="transparent">:  </font><textarea rows="2" cols="20" name='alamat_asal' value="${ mahasiswa.alamatasal}"></textarea>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <font color="black">Alamat Surabaya</font>
                            </td>
                            <td>
                                <font color="transparent">: </font><textarea rows="2" cols="20" name='alamat_surabaya' value='${mahasiswa.alamatsurabaya}'></textarea>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Nilai TOEFL</font>
                            </td>
                            <td>
                                : <input type=text name='nilai_toefl' value='${mahasiswa.nilaitoefl}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Semester</font>
                            </td>

                            <td>
                                : <input type=text name='semester' value='${mahasiswa.semester}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">IPK</font>
                            </td>
                            <td>
                                : <input type=text name='ipk' value='${mahasiswa.ipk}'/>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <font color="black">Nama Ayah</font>
                            </td>
                            <td>
                                : <input type=text name='nama_ayah' value='${mahasiswa.namaayah}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Pekerjaan Ayah</font>
                            </td>
                            <td>
                                : <input type=text name='pekerjaan_ayah'value='${mahasiswa.pekerjaanayah}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Penghasilan Ayah</font>
                            </td>

                            <td>
                                : <input type=text name='penghasilan_ayah' value='${mahasiswa.penghasilanayah}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Nama Ibu</font>
                            </td>
                            <td>
                                : <input type=text name='nama_ibu' value='${mahasiswa.namaibu}'/>
                            <td>
                        </tr>
                        <tr>
                            <td>
                                <font color="black">Pekerjaan Ibu</font>
                            </td>
                            <td>
                                : <input type=text name='pekerjaan_ibu' value='${mahasiswa.pekerjaanibu}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Penghasilan Ibu</font>
                            </td>
                            <td>
                                : <input type=text name='penghasilan_ibu' value='${mahasiswa.penghasilanibu}'/>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <font color="black">Jumlah Saudara</font>
                            </td>

                            <td>
                                : <input type=text name='jumlah_saudara' value='${mahasiswa.jumlahsaudara}'/>
                            </td>
                        </tr>

                    </table>

                    <input type='submit' value='update'/>

                </fieldset>
            </form>
        </div>

    </body>
</html>


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
        <link rel='icon' href="images/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Pengaturan Akun-SMASH</title>
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
                    <h3>Pengaturan Akun</h3>
                </div>

                <div class="content">
                    <table border="0">
                        <tr>
                            <td>
                                <a href="DispatcherMahasiswa?page=pengaturanPassword&&nrp=${mahasiswa.nrp}" title="" class="btn medium green">Ganti Password</a>
                            </td>
                        </tr>
                    </table>
                </div>

                <br/>

                <form method='post'  action='DispatcherMahasiswa?page=setPengaturanAkun&&nrp=${mahasiswa.nrp}'>
                    <fieldset>
                        <table>
                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="#E56717">
                                        <b><%= request.getAttribute("pesan")%></b>
                                    </font>
                                    <br/>
                                </td>
                            </tr>
                        </table>

                        <table>
                            <tr>
                                <td width="50px">
                                <td>
                                    <img src="images/profpic.png">
                                </td>
                            </tr>


                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black"><b>Data Pribadi</b></font>
                                </td>
                                <td width="350px">

                                </td>
                                <td>
                                    <font color="black"><b>Data Akademik</b></font>
                                </td>
                            </tr>


                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">NRP</font>
                                </td>
                                <td>
                                    : <font color="black">${mahasiswa.nrp}</font>
                                </td>

                                <td>
                                    <font color="black">Semester</font>
                                </td>

                                <td>
                                    : <input type=text name='semester' value='${mahasiswa.semester}'/>
                                </td>
                            </tr>


                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Nama</font>
                                </td>
                                <td>
                                    : <input type=text name='nama' value='${mahasiswa.nama}' />
                                </td>

                                <td>
                                    <font color="black">IPK</font>
                                </td>
                                <td>
                                    : <input type=text name='ipk' value='${mahasiswa.ipk}'/>
                                <td>
                            </tr>


                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">No HP</font>
                                </td>
                                <td>
                                    : <input type=text name='no_hp' value='${mahasiswa.nohp}'/>
                                </td>

                                <td>
                                    <font color="black">Nilai TOEFL</font>
                                </td>
                                <td>
                                    : <input type=text name='nilai_toefl' value='${mahasiswa.nilaitoefl}'/>
                                </td>
                            </tr>


                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Alamat Asal</font>
                                </td>
                                <td>
                                    <font color="transparent">:  </font><textarea rows="2" cols="20" name='alamat_asal' value="${ mahasiswa.alamatasal}">${ mahasiswa.alamatasal}</textarea>
                                <td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Alamat Surabaya</font>
                                </td>
                                <td>
                                    <font color="transparent">: </font><textarea rows="2" cols="20" name='alamat_surabaya' value='${mahasiswa.alamatsurabaya}'>${mahasiswa.alamatsurabaya}</textarea>
                                </td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black"><b>Data Keluarga</b></font>
                                </td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Nama Ayah</font>
                                </td>
                                <td>
                                    : <input type=text name='nama_ayah' value='${mahasiswa.namaayah}'/>
                                </td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Pekerjaan Ayah</font>
                                </td>
                                <td>
                                    : <input type=text name='pekerjaan_ayah'value='${mahasiswa.pekerjaanayah}'/>
                                </td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Penghasilan Ayah</font>
                                </td>

                                <td>
                                    : <input type=text name='penghasilan_ayah' value='${mahasiswa.penghasilanayah}'/>
                                </td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Nama Ibu</font>
                                </td>
                                <td>
                                    : <input type=text name='nama_ibu' value='${mahasiswa.namaibu}'/>
                                <td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Pekerjaan Ibu</font>
                                </td>
                                <td>
                                    : <input type=text name='pekerjaan_ibu' value='${mahasiswa.pekerjaanibu}'/>
                                </td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Penghasilan Ibu</font>
                                </td>
                                <td>
                                    : <input type=text name='penghasilan_ibu' value='${mahasiswa.penghasilanibu}'/>
                                </td>
                            </tr>

                            <tr>
                                <td width="50px">
                                <td>
                                    <font color="black">Jumlah Saudara</font>
                                </td>

                                <td>
                                    : <input type=text name='jumlah_saudara' value='${mahasiswa.jumlahsaudara}'/>
                                </td>
                            </tr>

                        </table>

                        <br/>

                        <table>
                            <tr>
                                <td width="50px">
                                <td>
                                    <input type='submit' value='Simpan'/>
                                </td>
                            </tr>
                        </table>

                    </fieldset>
                </form>
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


<%--
    Document   : buatPost
    Created on : Nov 9, 2011, 18:24:14 AM
    Author     : danang
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
            <br/>
            <div class="sb_box">
                <h3>Tambah Posting Baru</h3>
            </div>

            <div class="col_w280 float_l">
                <img src="images/track_Post.png"/>
            </div>

            <div class="col_w630 float_r">
                <div id="contact_form">

                    <input type="hidden" name="post" value="Send" />
                    <form method='post' action='DispatcherBeasiswa?page=goBuatPost'>
                        <table align="right">
                            <tr>
                                <td>
                                    <font color="black">Tanggal publish</font>
                                </td>
                                <td>
                                    : <input id="demo1" type="text" name="tanggalpublish" size="20" value="${beasiswa.tanggalpublish}"><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font color="black">Tanggal kadaluarsa</font>
                                </td>
                                <td>
                                    : <input id="demo2" type="text" name="tanggalkadaluwarsa" size="20" value="${beasiswa.tanggalpublish}"><a href="javascript:NewCal('demo2','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font color="black">Tanggal mulai</font>
                                </td>
                                <td>
                                    : <input id="demo3" type="text" name="tanggalmulai" size="20" value="${beasiswa.tanggalmulai}"><a href="javascript:NewCal('demo3','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font color="black">Tanggal mulai</font>
                                </td>
                                <td>
                                    : <input id="demo4" type="text" name="tanggalhabis" size="20" value="${beasiswa.tanggalhabis}"><a href="javascript:NewCal('demo4','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"/></a></input>
                                </td>
                            </tr>
                        </table>

                        <br/><br/><br/><br/><br/><br/>
                        <label for="author"><font color="black">Judul Post</font></label> <input type=text name='namabeasiswa' class="input_field"/>
                        <div class="cleaner h10"></div>

                        <label for="text"><font color="black">Keterangan</font></label> <textarea id="text" name="keterangan" rows="0" cols="0"></textarea>
                        <div class="cleaner h10"></div>

                        <input type='submit' value='add'/>
                    </form>
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

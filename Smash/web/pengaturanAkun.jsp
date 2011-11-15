<%-- 
    Document   : newjsp
    Created on : Oct 31, 2011, 9:50:09 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
   
        <table border="0">
    <tr>
        <td> <form method='post' action='Dispatcher?page=home'>
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
                            Nama:
                        </td>
                        <td>
                            <input type=text name='nama' value='${mahasiswa.nama}' />
                        </td>
                      
                    </tr>

                    <tr>
                        <td>
                            NRP     :
                        </td>
                        <td>
                            ${mahasiswa.nrp}
                        </td>
                    </tr>

                    <tr>
                        <td>
                            No HP     :
                        </td>

                        <td>
                            <input type=text name='no_hp' value='${mahasiswa.nohp}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Alamat Asal :
                        </td>
                        <td>
                            <input type=text name='alamat_asal' value='${mahasiswa.alamatasal}'/>
                        <td>
                    </tr>
                    <tr>
                        <td>
                            Alamat Surabaya:
                        </td>
                        <td>
                            <input type=text name='alamat_surabaya' value='${mahasiswa.alamatsurabaya}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Nilai TOEFL     :
                        </td>
                        <td>
                            <input type=text name='nilai_toefl' value='${mahasiswa.nilaitoefl}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Semester     :
                        </td>

                        <td>
                            <input type=text name='semester' value='${mahasiswa.semester}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            IPK :
                        </td>
                        <td>
                            <input type=text name='ipk' value='${mahasiswa.ipk}'/>
                        <td>
                    </tr>
                    <tr>
                        <td>
                            Nama Ayah:
                        </td>
                        <td>
                            <input type=text name='nama_ayah' value='${mahasiswa.namaayah}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Pekerjaan Ayah    :
                        </td>
                        <td>
                            <input type=text name='pekerjaan_ayah'value='${mahasiswa.pekerjaanayah}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Penghasilan Ayah  :
                        </td>

                        <td>
                            <input type=text name='penghasilan_ayah' value='${mahasiswa.penghasilanayah}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Nama Ibu :
                        </td>
                        <td>
                            <input type=text name='nama_ibu' value='${mahasiswa.namaibu}'/>
                        <td>
                    </tr>
                    <tr>
                        <td>
                            Pekerjaan Ibu:
                        </td>
                        <td>
                            <input type=text name='pekerjaan_ibu' value='${mahasiswa.pekerjaanibu}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Penghasilan Ibu     :
                        </td>
                        <td>
                            <input type=text name='penghasilan_ibu' value='${mahasiswa.penghasilanibu}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Jumlah Saudara     :
                        </td>

                        <td>
                            <input type=text name='jumlah_saudara' value='${mahasiswa.jumlahsaudara}'/>
                        </td>
                    </tr>



                </table>

                <input type='submit' value='update'/>

            </fieldset>
        </form>


    </body>
</html>


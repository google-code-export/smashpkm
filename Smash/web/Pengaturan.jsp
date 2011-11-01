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
                        <td>
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
                            <input type=text name='no_hp' value='${mahasiswa.noHp}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Alamat Asal :
                        </td>
                        <td>
                            <input type=text name='alamat_asal' value='${mahasiswa.alamatAsal}'/>
                        <td>
                    </tr>
                    <tr>
                        <td>
                            Alamat Surabaya:
                        </td>
                        <td>
                            <input type=text name='alamat_surabaya' value='${mahasiswa.alamatSurabaya}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Nilai TOEFL     :
                        </td>
                        <td>
                            <input type=text name='nilai_toefl' value='${mahasiswa.nilaiToefl}'/>
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
                            <input type=text name='nama_ayah' value='${mahasiswa.namaAyah}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Pekerjaan Ayah    :
                        </td>
                        <td>
                            <input type=text name='pekerjaan_ayah'value='${mahasiswa.pekerjaanAyah}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Penghasilan Ayah  :
                        </td>

                        <td>
                            <input type=text name='penghasilan_ayah' value='${mahasiswa.penghasilanAyah}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Nama Ibu :
                        </td>
                        <td>
                            <input type=text name='nama_ibu' value='${mahasiswa.namaIbu}'/>
                        <td>
                    </tr>
                    <tr>
                        <td>
                            Pekerjaan Ibu:
                        </td>
                        <td>
                            <input type=text name='pekerjaan_ibu' value='${mahasiswa.pekerjaanIbu}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Penghasilan Ibu     :
                        </td>
                        <td>
                            <input type=text name='penghasilan_ibu' value='${mahasiswa.penghasilanIbu}'/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Jumlah Saudara     :
                        </td>

                        <td>
                            <input type=text name='jumlah_saudara' value='${mahasiswa.jumlahSaudara}'/>
                        </td>
                    </tr>



                </table>

                <input type='submit' value='update'/>
                
            </fieldset>
        </form>

                        <form method='post' action='Dispatcher?page=home'>
                            <input type='submit' value='Kembali ke Menu Utama' >

    </body>
</html>


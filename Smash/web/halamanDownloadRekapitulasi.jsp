<%-- 
    Document   : halamanDownloadlRekapitulasi
    Created on : Dec 26, 2011, 10:33:03 PM
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
        <h1>Rekapitulasi</h1>
    </body>
    <table>
        <td>
            <form method='post' action='DispatcherPengajuan?page=listRekapitulasi'>
                <input type='submit' value='Kembali' >
            </form>
        </td>
        <td>
                    <form method='post' action='DispatcherMahasiswa?page=home&&nrp=${mahasiswa.nrp}'>
                        <input type='submit' value='Menu Utama' />
                    </form>
                </td>
        <td>
            <form  method='post' action='DispatcherMahasiswa?page=logout&&nrp=${mahasiswa.nrp}'>
                <input type='submit' value='Logout' >
            </form>
        <td>
    </table>
    <table border="0" >

        <tr>
            <th align="left">
                Nama Beasiswa :
            </th>
            <td>
                ${pengajuan.idbeasiswa.namabeasiswa}
            </td>
        </tr>
        <tr>
            <th align="left">
                Nama Beasiswa :
            </th>
            <td>
                ${pengajuan.idbeasiswa.namabeasiswa}
            </td>
        </tr>
        <tr>
            <th align="left">
                Nama Pemohon :
            </th>
            <td>
                ${pengajuan.nrp.nama}
            </td>
        </tr>
        <tr>
            <th align="left">
                NRP :
            </th>
            <td>
                ${pengajuan.nrp.nrp}
            </td>

        </tr>

         <tr>
            <th align="left">
                Status :
            </th>
            <td>
                ${pengajuan.nrp.statuspenerima}
            </td>
            <td>
            <form  method='post' action='DispatcherPengajuan?page=aturStatus&&nrp=${pengajuan.nrp.nrp}&&idpengajuan=${pengajuan.idpengajuan}'>
                <input type='submit' value='Ubah Status' >
            </form>
        <td>


        </tr>
        <tr>
            <th align="left">
                Semester :
            </th>
            <td>
                ${pengajuan.nrp.semester}
            </td>
        </tr>
        <tr>
            <th align="left">
                IPK :
            </th>
            <td>
                ${pengajuan.nrp.ipk}
            </td>
        </tr>
        <tr>
            <th align="left">
                Penghasilan Orang tua :
            </th>
            <td>
                ${pengajuan.nrp.penghasilanayah+pengajuan.nrp.penghasilanibu}
            </td>
        </tr>

    </table>
    <br/>
    <table border="0" >

        <tr>
            <th align="left">
                Scan Transkrip IPK :
            </th>
            <td align="right">
                <a href="gambar/${pengajuan.pathsipk}" target="_blank">Download Link</a>
            </td>
        </tr>
        <tr>
            <th align="left">
                Scan Slip Gaji :
            </th>
            <td align="right">
                <a href="gambar/${pengajuan.pathsgaji}" target="_blank">Download Link</a>
            </td>
        </tr>
        <tr>
            <th align="left">
                Scan Surat Keterangan Tidak Mampu :
            </th>
            <td>
<a href="gambar/${pengajuan.pathssurattidakmampu}" target="_blank">Download Link</a>
            </td>

        </tr>
        <tr>
            <th align="left">
                Scan KTM :
            </th>
            <td>
<a href="gambar/${pengajuan.pathsktm}" target="_blank">Download Link</a>
            </td>
        </tr>
        <tr>
            <th align="left">
                Scan KTP :
            </th>
            <td>
<a href="gambar/${pengajuan.pathsktp}" target="_blank">Download Link</a>
            </td>
        </tr>
        <tr>

            <th align="left">
                Scan Kartu Kerluarga :
            </th>
            <td>
<a href="gambar/${pengajuan.pathskk}" target="_blank">Download Link</a>
            </td>

        </tr>
        <tr>
            <th align="left">
                Curriculum Vitae :
            </th>
            <td>
<a href="gambar/${pengajuan.pathscv}" target="_blank">Download Link</a>
            </td>
        </tr>
        <tr>
            <th align="left">
                Scan Sertifikat Kegiatan Kemahasiswaan  :
            </th>
            <td>
<a href="gambar/${pengajuan.pathssertifikat}" target="_blank">Download Link</a>
            </td>
        </tr>
        <tr>

            <th align="left">
                Scan Rekening BNI/ BRI :
            </th>
            <td>
<a href="gambar/${pengajuan.pathsrekening}" target="_blank">Download Link</a>
            </td>

        </tr>

    </table>

</html>

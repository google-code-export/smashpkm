<%-- 
    Document   : halamanDaftarBeasiswa
    Created on : Nov 22, 2011, 8:52:32 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<h1>Daftar Beasiswa  </h1>
   <table border=0>
            <tr>
             
                <td>
                    <form method='post' action='DispatcherMahasiswa?page=home&&nrp=${mahasiswa.nrp}'>
                        <input type='submit' value='Menu Utama' />
                    </form>
                </td>
                <td>
                    <form method='post' action='DispatcherMahasiswa?page=logout&&nrp=${mahasiswa.nrp}'>
                        <input type='submit' value='Logout' />
                    </form>
                </td>
            </tr>
        </table>
<form  method="post"  enctype="multipart/form-data" action="DispatcherPengajuan?page=goDaftarBeasiswa&&nrp=${mahasiswa.nrp}&&idbeasiswa=${idbeasiswa}" >
  <table width="374" height="112" border="0">
    <tr>
      <td width="171" height="32">Scan Transkrip IPK</td>
      <td> <input type="file" name="scan_ipk" /></td>
    </tr>
    <tr>
      <td height="32">Scan Slip gaji</td>
      <td><input type="file" name="scan_gaji" /></td>
    </tr>
       <tr>
      <td width="171" height="32">Scan Surat Tidak Mampu</td>
      <td> <input type="file" name="scan_surat_tidak_mampu" /></td>
    </tr>
  
      <tr>
      <td width="171" height="32">Scan KTM</td>
      <td> <input type="file" name="scan_ktm" /></td>
    </tr>
    <tr>
      <td height="32">Scan KTP</td>
      <td><input type="file" name="scan_ktp" /></td>
    </tr>
       <tr>
      <td width="171" height="32">Scan Kartu Keluarga</td>
      <td> <input type="file" name="scan_kk" /></td>
    </tr>
    <tr>
      <td height="32">Scan Curriculum Vitae</td>
      <td><input type="file" name="scan_cv" /></td>
    </tr>
       <tr>
      <td width="171" height="32">Scan Sertifikat Kegiatan</td>
      <td> <input type="file" name="scan_sertifikat" /></td>
    </tr>
      <tr>
      <td width="171" height="32">Scan Rekening Bank</td>
      <td> <input type="file" name="scan_rekening" /></td>
    </tr>
    <tr>
      <td height="40">&nbsp;</td>
      <td><input type="submit" name="button" id="button" value="Submit" /></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <h1>&nbsp;</h1>
  <h1>&nbsp;</h1>
</form>
</body>
</html>
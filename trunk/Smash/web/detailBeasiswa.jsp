<%-- 
    Document   : detailBeasiswa
    Created on : Dec 29, 2011, 5:22:23 PM
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
        <h1>Detail Beasiswa ${beasiswa.namabeasiswa}</h1>
         <table>
        <td>
            <form method='post' action='DispatcherBeasiswa?page=beasiswaYangTersedia'>
                <input type='submit' value='Kembali' >
            </form>
        </td>
        <td>
            <form  method='post' action='DispatcherMahasiswa?page=logout&&nrp=${mahasiswa.nrp}'>
                <input type='submit' value='Logout' >
            </form>
        <td>
    </table>

        <table width="374" height="112" border="0">
    <tr>
      <th>Nama beasiswa :</th>
<td>${beasiswa.namabeasiswa}</td>
    </tr>
    <tr>
      <th>Tanggal Mulai Masa Berlaku :</th>
      <td>${beasiswa.tanggalmulai}</td>
    </tr>
       <tr>
      <th>Tanggal Habis Habis Masa Berlaku :</th>
      <td>${beasiswa.tanggalmulai}</td>
    </tr>

      <tr>
          <td>Detail</td>
    </tr>
    <tr>
      <td width="200" height="200">${beasiswa.keterangan}</td>

    </tr>
  </table>
    </body>
</html>

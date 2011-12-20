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
<h1>Daftar Beasiswa</h1>
<form  method="post"  enctype="multipart/form-data" action="Dispatcher?page=goDaftarBeasiswa" >
  <table width="374" height="112" border="0">
    <tr>
      <td width="171" height="32">Scan Transkrip IPK</td>
      <td> <input type="file" name="scanTranskripIpk" /></td>
    </tr>
    <tr>
      <td height="32">Scan Slip gaji</td>
      <td><input type="file" name="file1" /></td>
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
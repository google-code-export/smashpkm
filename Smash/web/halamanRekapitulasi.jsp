<%--
    Document   : halamanDaftarBeasiswa
    Created on : Nov 22, 2011, 8:52:32 AM
    Author     : yosua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Halaman Rekapitulasi</h1>
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
        <form method='post' action="DispatcherPengajuan?page=goListRekapitulasi">
            <select name="pilih">
                <c:forEach items="${list_beasiswa}" var="bsw">
                    <option value=${bsw.idbeasiswa} > ${bsw.namabeasiswa} </option>
                </c:forEach>
            </select>
            <select name="pilih_sort">
                    <option value="gaji" > Berdasarkan Gaji </option>
                    <option value="ipk" > Berdasarkan IPK </option>
            </select>
            <input type='submit' value='Pilih' >
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>
                        No
                    </th>
                    <th>
                        Nama
                    </th>
                    <th>
                        NRP
                    </th>
                     <th>
                        IPK
                    </th>
                    <th>
                        Penghasilan Orang tua
                    </th>
                    <th>
                        Status
                    </th>
                    <th>
                        Beasiswa
                    </th>
                    <th>
                        Tgl Habis Berlaku
                    </th>

                </tr>
            </thead>
            <tbody>
                <%int i = 1;%>

                <c:forEach items="${list_all_pengajuan}" var="bsw">

                    <tr>
                        <td>
                            <%out.print(i);%>
                            <%i++;%>
                        </td>
                        <td>
                            ${bsw.nrp.nama}
                        </td>
                        <td>
                            ${bsw.nrp.nrp}
                        </td>
                        <td>
                            ${bsw.nrp.ipk}
                        </td>
                        <td>
                            ${bsw.nrp.penghasilanayah+bsw.nrp.penghasilanibu}
                        </td>
                         <td>
                            ${bsw.nrp.statuspenerima}
                        </td>
                        <td>
                            ${bsw.idbeasiswa.namabeasiswa}
                        </td>
                        <td>
                            ${bsw.idbeasiswa.tanggalhabis}
                        </td>
                        
                        <td>
                            <form method='post' action='DispatcherPengajuan?page=aturRekapitulasi&&idpengajuan=${bsw.idpengajuan}'>
                        <input type='submit' value='Rekap' >
                    </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>

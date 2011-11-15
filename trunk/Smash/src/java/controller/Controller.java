/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Beasiswa;
import model.Mahasiswa;

/**
 *
 * @author yosua
 */
public class Controller {

    HttpServletRequest request;

    public Controller(HttpServletRequest request) {
        this.request = request;
    }

    public void setRegistrasi(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
        String nama = request.getParameter("nama");
        String password = request.getParameter("password");
        String passwordUlangi = request.getParameter("password_ulangi");
        HttpSession session = request.getSession();


        if (nama.equals("") || nrp.equals("") || password.equals("")) {
            session.setAttribute("pesan", "isikan seluruh data");
            mahasiswa.setLoginstat(false);

            if (nrp.equals("") || nama.equals("") || password.equals("") || passwordUlangi.equals("")) {
                session.setAttribute("pesan", "Isikan seluruh form sesuai data anda");
                mahasiswa.setLoginstat(false);
            } else {
                if (password.equals(passwordUlangi)) {
                    MahasiswaJpaController registrasi = new MahasiswaJpaController();
                    mahasiswa.setNrp(nrp);
                    mahasiswa.setNama(nama);
                    mahasiswa.setPassword(password);

                    try {
                        registrasi.create(mahasiswa);
                        session.setAttribute("nrp", nrp);
                        session.setAttribute("mahasiswa", mahasiswa);
                        session.setAttribute("password", password);
                        session.setAttribute("pesan", "");
                        mahasiswa.setLoginstat(true);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {
                    session.setAttribute("pesan", "password harus sama");
                    mahasiswa.setLoginstat(false);
                }
            }
        }
        if (nama.equals("") || nrp.equals("") || password.equals("")) {
            session.setAttribute("pesan", "isikan seluruh data");
            mahasiswa.setLoginstat(false);
        } else {
            MahasiswaJpaController registrasi = new MahasiswaJpaController();
            mahasiswa.setNrp(nrp);
            mahasiswa.setNama(nama);
            mahasiswa.setPassword(password);
            try {
                registrasi.create(mahasiswa);
                session.setAttribute("nrp", nrp);
                session.setAttribute("mahasiswa", mahasiswa);
                session.setAttribute("password", password);
                session.setAttribute("pesan", "");
                mahasiswa.setLoginstat(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Mahasiswa getLogin() {
        String nrp = request.getParameter("nrp");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        MahasiswaJpaController login = new MahasiswaJpaController();
        Mahasiswa mahasiswa = new Mahasiswa();
        login.findMahasiswaByNrp(nrp);
        if (login.findMahasiswaByNrp(nrp) != null) {
            mahasiswa = login.findMahasiswaByNrp(nrp);

            if (mahasiswa.getPassword().equals(password)) {
                mahasiswa.setLoginstat(true);
                session.setAttribute("nrp", nrp);
                session.setAttribute("mahasiswa", mahasiswa);
                session.setAttribute("password", password);
                session.setAttribute("pesan", "");
                try {
                    login.edit(mahasiswa);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                mahasiswa.setLoginstat(false);
            }

        } else {
            mahasiswa.setLoginstat(false);
        }
        return mahasiswa;
    }

    public void setLogout(Mahasiswa mahasiswa) {
        MahasiswaJpaController logout = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = logout.findMahasiswaByNrp((String) session.getAttribute("nrp"));
        mahasiswa.setLoginstat(false);

        try {
            logout.edit(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Mahasiswa getMahasiswa() {
        Mahasiswa mahasiswa = new Mahasiswa();
        MahasiswaJpaController aturAkun = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturAkun.findMahasiswaByNrp((String) session.getAttribute("nrp"));
        return mahasiswa;
    }

    public void setAturAkun(Mahasiswa mahasiswa) {
        String nama = request.getParameter("nama");
        String noHp = request.getParameter("no_hp");
        String alamatAsal = request.getParameter("alamat_asal");
        String alamatSurabaya = request.getParameter("alamat_surabaya");
        String nilaiToefl1 = request.getParameter("nilai_toefl");
        String semester1 = request.getParameter("semester");
        String ipk1 = request.getParameter("ipk");
        String namaAyah = request.getParameter("nama_ayah");
        String penghasilanAyah1 = request.getParameter("penghasilan_ayah");
        String pekerjaanAyah = request.getParameter("pekerjaan_ayah");
        String namaIbu = request.getParameter("nama_ibu");
        String penghasilanIbu1 = request.getParameter("penghasilan_ibu");
        String pekerjaanIbu = request.getParameter("pekerjaan_ibu");
        String jumlahSaudara1 = request.getParameter("jumlah_saudara");

        int nilaiToefl = Integer.parseInt(nilaiToefl1);
        int semester = Integer.parseInt(semester1);
        int ipk = Integer.parseInt(ipk1);
        int penghasilanAyah = Integer.parseInt(penghasilanAyah1);
        int penghasilanIbu = Integer.parseInt(penghasilanIbu1);
        int jumlahSaudara = Integer.parseInt(jumlahSaudara1);

        MahasiswaJpaController aturAkun = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturAkun.findMahasiswaByNrp((String) session.getAttribute("nrp"));

        mahasiswa.setNama(nama);
        mahasiswa.setAlamatasal(alamatAsal);
        mahasiswa.setAlamatsurabaya(alamatSurabaya);
        mahasiswa.setNilaitoefl(nilaiToefl);
        mahasiswa.setSemester(semester);
        mahasiswa.setIpk(ipk);
        mahasiswa.setNamaayah(namaAyah);
        mahasiswa.setNamaibu(namaIbu);
        mahasiswa.setPekerjaanayah(pekerjaanAyah);
        mahasiswa.setPekerjaanibu(pekerjaanIbu);
        mahasiswa.setPenghasilanayah(penghasilanAyah);
        mahasiswa.setPenghasilanibu(penghasilanIbu);
        mahasiswa.setJumlahsaudara(jumlahSaudara);
        mahasiswa.setIsadmin(false);
        session.setAttribute("mahasiswa", mahasiswa);
        try {
            aturAkun.edit(mahasiswa);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAturPassword(Mahasiswa mahasiswa) {
        String passwordLama = request.getParameter("password_lama");
        String passwordBaru = request.getParameter("password_baru");
        MahasiswaJpaController aturPassword = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturPassword.findMahasiswaByNrp((String) session.getAttribute("nrp"));

        if (aturPassword.findMahasiswaByNrp((String) session.getAttribute("nrp")) != null) {
            mahasiswa = aturPassword.findMahasiswaByNrp((String) session.getAttribute("nrp"));
            if (mahasiswa.getPassword().equals(passwordLama)) {
                mahasiswa.setPassword(passwordBaru);

                try {
                    aturPassword.edit(mahasiswa);
                    session.setAttribute("pesan", "Password Berhasil Diubah");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void setBuatBeasiswa(Beasiswa beasiswa) throws ParseException {
        String namaBeasiswa = request.getParameter("namabeasiswa");
        String keterangan = request.getParameter("keterangan");
        String tanggalPublish = request.getParameter("tanggalpublish");

        HttpSession session = request.getSession();
        BeasiswaJpaController beasiswaBaru = new BeasiswaJpaController();
        beasiswa.setNamabeasiswa(namaBeasiswa);
        beasiswa.setKeterangan(keterangan);
        DateFormat formatter ; 
        Date date;
        formatter = new SimpleDateFormat("MM-dd-yyyy");
        date = (Date)formatter.parse(tanggalPublish);
        beasiswa.setTanggalpublish(date);
        request.setAttribute("beasiswa",beasiswa);
        try {
            beasiswaBaru.create(beasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setListBeasiswa() {
        BeasiswaJpaController listBeasiswa = new BeasiswaJpaController();
        List<Beasiswa> list = new ArrayList<Beasiswa>();
        list = listBeasiswa.getAllBeasiswa();
        request.setAttribute("list_beasiswa", list);
    }

    public void setEditPost(Beasiswa beasiswa) {
        HttpSession session = request.getSession();
        BeasiswaJpaController editPost = new BeasiswaJpaController();
        beasiswa = editPost.findBeasiswaById((String) session.getAttribute("idbeasiswa"));
        try {
            editPost.edit(beasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPost(Beasiswa beasiswa) {
        String idBeasiswa = request.getParameter("idbeasiswa");
        HttpSession session = request.getSession();
        BeasiswaJpaController aturPost = new BeasiswaJpaController();
        beasiswa = aturPost.findBeasiswaById(idBeasiswa);
        request.setAttribute("beasiswa", beasiswa);
        request.setAttribute("idbeasiswa", idBeasiswa);

    }

    public void setDeletePost() {
        String idBeasiswa = request.getParameter("idbeasiswa");
        HttpSession session = request.getSession();
        Beasiswa beasiswa = new Beasiswa();
        BeasiswaJpaController deletePost = new BeasiswaJpaController();
        beasiswa = deletePost.findBeasiswaById(idBeasiswa);
        try {
            deletePost.destroy(beasiswa.getIdbeasiswa());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

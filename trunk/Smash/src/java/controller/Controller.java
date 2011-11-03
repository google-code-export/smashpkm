/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
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
            mahasiswa.setLoginStat(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Mahasiswa getLoginStat() {
        String nrp = request.getParameter("nrp");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        MahasiswaJpaController login = new MahasiswaJpaController();
        Mahasiswa mahasiswa = new Mahasiswa();
        login.findMahasiswaByNrp(nrp);
        if (login.findMahasiswaByNrp(nrp) != null) {
            mahasiswa = login.findMahasiswaByNrp(nrp);
            if (mahasiswa.getPassword().equals(password)) {
                mahasiswa.setLoginStat(true);
                session.setAttribute("nrp", nrp);
                session.setAttribute("mahasiswa", mahasiswa);
                session.setAttribute("password", password);
                session.setAttribute("pesan", "");
            } else {
                mahasiswa.setLoginStat(false);
            }
            try {
                login.edit(mahasiswa);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        } else {
            mahasiswa.setLoginStat(false);
        }
        return mahasiswa;
    }

    public void setLogout(Mahasiswa mahasiswa) {
        MahasiswaJpaController logout = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = logout.findMahasiswaByNrp((String) session.getAttribute("nrp"));
        mahasiswa.setLoginStat(false);

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

        long nilaiToefl = Integer.parseInt(nilaiToefl1);
        long semester = Integer.parseInt(semester1);
        long ipk = Integer.parseInt(ipk1);
        long penghasilanAyah = Integer.parseInt(penghasilanAyah1);
        long penghasilanIbu = Integer.parseInt(penghasilanIbu1);
        long jumlahSaudara = Integer.parseInt(jumlahSaudara1);

        MahasiswaJpaController aturAkun = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturAkun.findMahasiswaByNrp((String) session.getAttribute("nrp"));

        
        mahasiswa.setNama(nama);
        mahasiswa.setAlamatAsal(alamatAsal);
        mahasiswa.setAlamatSurabaya(alamatSurabaya);
        mahasiswa.setNilaiToefl(nilaiToefl);
        mahasiswa.setSemester(semester);
        mahasiswa.setIpk(ipk);
        mahasiswa.setNamaAyah(namaAyah);
        mahasiswa.setNamaIbu(namaIbu);
        mahasiswa.setPekerjaanAyah(pekerjaanAyah);
        mahasiswa.setPekerjaanIbu(pekerjaanIbu);
        mahasiswa.setPenghasilanAyah(penghasilanAyah);
        mahasiswa.setPenghasilanIbu(penghasilanIbu);
        mahasiswa.setJumlahSaudara(jumlahSaudara);
        mahasiswa.setIsAdmin(false);
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
                    session.setAttribute("pesan","Password Berhasil Diubah");
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        }
    }
}

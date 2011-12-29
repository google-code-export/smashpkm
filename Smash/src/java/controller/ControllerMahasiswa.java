/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Mahasiswa;
import model.Pengajuan;

/**
 *
 * @author yosua
 */
public class ControllerMahasiswa {

    HttpServletRequest request;

    public ControllerMahasiswa(HttpServletRequest request) {
        this.request = request;
    }

    public void setRegistrasi(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
        String nama = request.getParameter("nama");
        String password = request.getParameter("password");
        String passwordUlangi = request.getParameter("password_ulangi");
        HttpSession session = request.getSession();
        MahasiswaJpaController registrasi = new MahasiswaJpaController();
        registrasi.findMahasiswaByNrp(nrp);


        if (nrp.equals("") || nama.equals("") || password.equals("") || passwordUlangi.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");
            mahasiswa.setLoginstat(false);
        } else {

            if (password.equals(passwordUlangi)) {
                if (registrasi.findMahasiswaByNrp(nrp) == null) {
                    mahasiswa.setLoginstat(true);
                    mahasiswa.setNrp(nrp);
                    mahasiswa.setNama(nama);
                    mahasiswa.setPassword(password);
                    mahasiswa.setNohp("");
                    mahasiswa.setAlamatasal("");
                    mahasiswa.setAlamatsurabaya("");
                    mahasiswa.setNilaitoefl(0);
                    mahasiswa.setSemester(0);
                    mahasiswa.setIpk(0.0);
                    mahasiswa.setNamaayah("");
                    mahasiswa.setNamaibu("");
                    mahasiswa.setPekerjaanayah("");
                    mahasiswa.setPekerjaanibu("");
                    mahasiswa.setPenghasilanayah(0);
                    mahasiswa.setPenghasilanibu(0);
                    mahasiswa.setJumlahsaudara(0);
                    mahasiswa.setIsadmin(false);
                    mahasiswa.setStatuspenerima("Tidak Sedang Menerima Beasiswa");

                    try {
                        registrasi.create(mahasiswa);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {
                    request.setAttribute("pesan", "Username yang Anda masukkan telah terdaftar");
                    mahasiswa.setLoginstat(false);
                }
            } else {
                request.setAttribute("pesan", "Password yang Anda masukkan tidak sesuai");
                mahasiswa.setLoginstat(false);
            }
        }
    }

    public Mahasiswa getLogin() {
        String nrp = request.getParameter("nrp");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        MahasiswaJpaController login = new MahasiswaJpaController();
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setIsadmin(false);
        //login.findMahasiswaByNrp(nrp);
        if (login.findMahasiswaByNrp(nrp) != null) {
            mahasiswa = login.findMahasiswaByNrp(nrp);

            if (mahasiswa.getPassword().equals(password)) {
                mahasiswa.setLoginstat(true);
                session.setAttribute("nrp", mahasiswa.getNrp());
                session.setAttribute("nama", mahasiswa.getNama());
                session.setAttribute("password", mahasiswa.getPassword());
                session.setAttribute("mahasiswa", mahasiswa);
                try {
                    login.edit(mahasiswa);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                mahasiswa.setLoginstat(false);
                request.setAttribute("pesan", "Username dan password Anda tidak ditemukan");
            }

        } else {
            mahasiswa.setLoginstat(false);
            request.setAttribute("pesan", "Username dan password Anda tidak ditemukan");
        }
        return mahasiswa;
    }

    public void setLogout(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
        MahasiswaJpaController logout = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = logout.findMahasiswaByNrp(nrp);
        mahasiswa.setLoginstat(false);

        try {
            logout.edit(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Mahasiswa getMahasiswa() {
        String nrp = request.getParameter("nrp");
        Mahasiswa mahasiswa = new Mahasiswa();
        MahasiswaJpaController aturAkun = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturAkun.findMahasiswaByNrp(nrp);
        session.setAttribute("mahasiswa", mahasiswa);
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
        HttpSession session = request.getSession();
        MahasiswaJpaController aturMember = new MahasiswaJpaController();
        mahasiswa = aturMember.findMahasiswaByNrp(nrp);
        session.setAttribute("member", mahasiswa);

    }

    public void setListMahasiswa() {
        MahasiswaJpaController listMahasiswa = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        List<Mahasiswa> list = new ArrayList<Mahasiswa>();
        list = listMahasiswa.getAllMahasiswa();

        session.setAttribute("list_mahasiswa", list);
    }

    public void setDeleteMahasiswa() {
        String nrp = request.getParameter("nrp");
        HttpSession session = request.getSession();
        Mahasiswa mahasiswa = new Mahasiswa();
        MahasiswaJpaController deleteMahasiswa = new MahasiswaJpaController();
        mahasiswa = deleteMahasiswa.findMahasiswaByNrp(nrp);
        try {
            deleteMahasiswa.destroy(mahasiswa.getNrp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAturAkun(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
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

        if (nama.equals("") || noHp.equals("") || alamatAsal.equals("") || nilaiToefl1.equals("")
                || semester1.equals("") || ipk1.equals("") || namaAyah.equals("")
                || penghasilanAyah1.equals("") || pekerjaanAyah.equals("") || namaIbu.equals("")
                || penghasilanIbu1.equals("") || pekerjaanIbu.equals("") || jumlahSaudara1.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");

        } else {
            try {
                int nilaiToefl = Integer.parseInt(nilaiToefl1);
                int semester = Integer.parseInt(semester1);
                Double ipk = Double.parseDouble(ipk1);
                int penghasilanAyah = Integer.parseInt(penghasilanAyah1);
                int penghasilanIbu = Integer.parseInt(penghasilanIbu1);
                int jumlahSaudara = Integer.parseInt(jumlahSaudara1);

                MahasiswaJpaController aturAkun = new MahasiswaJpaController();
                HttpSession session = request.getSession();
                mahasiswa = aturAkun.findMahasiswaByNrp(nrp);

                mahasiswa.setNama(nama);
                mahasiswa.setNohp(noHp);
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
                    request.setAttribute("pesan1", "Data yang Anda masukkan telah tersimpan. Pastikan data yang Anda masukkan adalah benar");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException nfe) {
                request.setAttribute("pesan", "Isikan seluruh field dengan ketentuan format yang ada");
            }

        }

    }


    public void setAturAkunMember(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp_member");
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

        if (nama.equals("") || noHp.equals("") || alamatAsal.equals("") || nilaiToefl1.equals("")
                || semester1.equals("") || ipk1.equals("") || namaAyah.equals("")
                || penghasilanAyah1.equals("") || pekerjaanAyah.equals("") || namaIbu.equals("")
                || penghasilanIbu1.equals("") || pekerjaanIbu.equals("") || jumlahSaudara1.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");

        } else {
            int nilaiToefl = Integer.parseInt(nilaiToefl1);
            int semester = Integer.parseInt(semester1);
            Double ipk = Double.parseDouble(ipk1);
            int penghasilanAyah = Integer.parseInt(penghasilanAyah1);
            int penghasilanIbu = Integer.parseInt(penghasilanIbu1);
            int jumlahSaudara = Integer.parseInt(jumlahSaudara1);

            MahasiswaJpaController aturAkun = new MahasiswaJpaController();
            HttpSession session = request.getSession();
            mahasiswa = aturAkun.findMahasiswaByNrp(nrp);

            mahasiswa.setNama(nama);
            mahasiswa.setNohp(noHp);
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
            try {
                aturAkun.edit(mahasiswa);

            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("pesan1", "Data yang Anda masukkan telah tersimpan. Pastikan data yang Anda masukkan adalah benar");

        }

    }

    public void setAturPassword(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
        String passwordLama = request.getParameter("password_lama");
        String passwordBaru = request.getParameter("password_baru");
        String ulangiPassword = request.getParameter("password_baru_ulangi");
        MahasiswaJpaController aturPassword = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturPassword.findMahasiswaByNrp(nrp);

        if (passwordLama.equals("") || passwordBaru.equals("") || ulangiPassword.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");

        } else {

            if (passwordBaru.equals(ulangiPassword)) {
                if (mahasiswa.getPassword().equals(passwordLama)) {
                    mahasiswa.setPassword(passwordBaru);

                    try {
                        aturPassword.edit(mahasiswa);
                        request.setAttribute("pesan", "Password Anda telah diganti");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    request.setAttribute("pesan", "Password yang Anda masukkan tidak sesuai");

                }
            } else {
                request.setAttribute("pesan", "Password Baru yang Anda masukkan tidak sesuai dengan ulangi Password");
            }
        }
    }
//asdadasdasdasdasd
    public void setAturPasswordMember(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp_member");
        String passwordBaru = request.getParameter("password_baru");
        MahasiswaJpaController aturPassword = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturPassword.findMahasiswaByNrp(nrp);

        if (passwordBaru.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");
            mahasiswa.setLoginstat(false);
        } else {
            mahasiswa.setPassword(passwordBaru);
            try {
                aturPassword.edit(mahasiswa);
                request.setAttribute("pesan", "Password Anda telah diganti");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public void setMember(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp_member");
        HttpSession session = request.getSession();
        MahasiswaJpaController aturMember = new MahasiswaJpaController();
        mahasiswa = aturMember.findMahasiswaByNrp(nrp);
        session.setAttribute("member", mahasiswa);
    }

}

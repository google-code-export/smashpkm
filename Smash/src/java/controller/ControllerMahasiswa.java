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

public class ControllerMahasiswa {

    HttpServletRequest request;

    public ControllerMahasiswa(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Fungsi untuk menyimpan dan membuat maasiswa baru dengan menerima input dari jsp
     * kemudian melakukan validasi. apabila validasi berhasil makan objek baru akan
     * disimpan dalam db
     */
    public void setRegistrasi(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");//menangkap parameter dari jsp
        String nama = request.getParameter("nama");
        String password = request.getParameter("password");
        String passwordUlangi = request.getParameter("password_ulangi");
        HttpSession session = request.getSession();
        JpaMahasiswa registrasi = new JpaMahasiswa();

        /**
         * validasi terhadap input dalam jsp
         * apabila seluruh input tidak diisikan maka gagal dalam menyimpan objek baru yang
         * telah diinputkan sebelumnya
         */
        if (nrp.equals("") || nama.equals("") || password.equals("") || passwordUlangi.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");
            mahasiswa.setLoginstat(false);//set login stat false agar pengguna kembali ke halam registrasi
        } else {

            if (password.equals(passwordUlangi)) { // validasi kesesuaian password yang di-input
                if (registrasi.findMahasiswaByNrp(nrp) == null) {//memeriksa apakah nrp belum digunakan
                    mahasiswa.setLoginstat(true); //melakukan set terhadap objek baru
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
                        registrasi.create(mahasiswa);//eksekusi membuat objek baru dan menyimpan

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {//set pesan apabila nrp/username yang diinput telah digunakan
                    request.setAttribute("pesan", "Username yang Anda masukkan telah terdaftar");
                    mahasiswa.setLoginstat(false);
                }
            } else {//set pesan apabila password yang di-input tidak sama
                request.setAttribute("pesan", "Password yang Anda masukkan tidak sesuai");
                mahasiswa.setLoginstat(false);
            }
        }
    }

    /**
     * Fungsi untuk login mahasiswa
     */
    public Mahasiswa getLogin() {
        String nrp = request.getParameter("nrp");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        JpaMahasiswa login = new JpaMahasiswa();
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setIsadmin(false);//untuk inisialisasi. pengguna diasumsikan bukan admin
        if (login.findMahasiswaByNrp(nrp) != null) {//validasi keberadaan akun berdasarkan nrp
            mahasiswa = login.findMahasiswaByNrp(nrp);//membuat objek menjadi objek yang telah ditemukan dlm db

            if (mahasiswa.getPassword().equals(password)) {//validasi kesesuaian antara password
                mahasiswa.setLoginstat(true);
                session.setAttribute("mahasiswa", mahasiswa);
                try {
                    login.edit(mahasiswa);//eksekusi menyimpan perubahan khususnya loginstat
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                mahasiswa.setLoginstat(false);//pesan apabila password salah
                request.setAttribute("pesan", "Username dan password Anda tidak ditemukan");
            }

        } else {
            mahasiswa.setLoginstat(false);//pesan apabila akun tidak ditemukan
            request.setAttribute("pesan", "Username dan password Anda tidak ditemukan");
        }
        return mahasiswa;
    }

    /**
     * Fungsi untuk logout akun dengan merubah loginstat menjadi false dan melakukan
     * invalidate session
     */
    public void setLogout() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp"); //menangkap parameter nrp
        JpaMahasiswa logout = new JpaMahasiswa();
        HttpSession session = request.getSession();
        mahasiswa = logout.findMahasiswaByNrp(nrp); //mencari objek berdasarkan nrp
        mahasiswa.setLoginstat(false);//merubah lignstat menjadi false
        session.invalidate();//menghapus semua session

        try {
            logout.edit(mahasiswa);//menyimpan hasil perubahan objek
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fungsi mengambil objek dan menyimpan dalam session untuk kembali ke home/halaman utama
     */
    public Mahasiswa getMahasiswa() {
        String nrp = request.getParameter("nrp");//menangkap parameter nrp
        Mahasiswa mahasiswa = new Mahasiswa();
        JpaMahasiswa aturAkun = new JpaMahasiswa();
        HttpSession session = request.getSession();
        mahasiswa = aturAkun.findMahasiswaByNrp(nrp);//mencari objek berdasarkan nrp
        session.setAttribute("mahasiswa", mahasiswa);//menyimpan  objek kedalam session
        return mahasiswa;//mengembalikan objek
    }

    /**
     * Fungsi mengambil objek dan menyimpan dalam session untuk di tampilkan sebagai input awal
     * dalam melakukan edit akun
     */
    public void setMahasiswa() {
        String nrp = request.getParameter("nrp");//menangkap parameter nrp
        Mahasiswa mahasiswa = new Mahasiswa();
        HttpSession session = request.getSession();
        JpaMahasiswa aturMember = new JpaMahasiswa();
        mahasiswa = aturMember.findMahasiswaByNrp(nrp);//mencari objek berdasarkan nrp
        session.setAttribute("member", mahasiswa);//menyimpan  objek kedalam session

    }

    /**
     * Fungsi melakukan list terhadap mahasiswa yang ada kedalam list
     * kemudian memasukkan kedalam session list_mahasiswa
     */
    public void setListMahasiswa() {
        JpaMahasiswa listMahasiswa = new JpaMahasiswa();
        HttpSession session = request.getSession();
        List<Mahasiswa> list = new ArrayList<Mahasiswa>();
        list = listMahasiswa.getAllMahasiswa();//melakukan list dengan arraylist
        session.setAttribute("list_mahasiswa", list);//memasukkan list kedalam session
    }

    /**
     * Fungsi untuk menghapus objek dari db dengan input berupa nrp
     */
    public void setDeleteMahasiswa() {
        String nrp = request.getParameter("nrp");
        HttpSession session = request.getSession();
        Mahasiswa mahasiswa = new Mahasiswa();
        JpaMahasiswa deleteMahasiswa = new JpaMahasiswa();
        mahasiswa = deleteMahasiswa.findMahasiswaByNrp(nrp); //mencari objek berdasarkan input nrp
        try {
            deleteMahasiswa.destroy(mahasiswa.getNrp()); //eksekusi menghapus
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fungsi untuk eksekusi terhadap perubahan data akun
     */
    public void setAturAkun() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp");//menangkap parameter input
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

        /**
         * Validasi input untuk menghindari input kosong
         */
        if (nama.equals("") || noHp.equals("") || nilaiToefl1.equals("")
                || semester1.equals("") || ipk1.equals("") || namaAyah.equals("")
                || penghasilanAyah1.equals("") || pekerjaanAyah.equals("") || namaIbu.equals("")
                || penghasilanIbu1.equals("") || pekerjaanIbu.equals("") || jumlahSaudara1.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");

        } else {
            try {//merubah input string menjadi int
                int nilaiToefl = Integer.parseInt(nilaiToefl1);
                int semester = Integer.parseInt(semester1);
                Double ipk = Double.parseDouble(ipk1);//merubah input string menjadi double
                int penghasilanAyah = Integer.parseInt(penghasilanAyah1);
                int penghasilanIbu = Integer.parseInt(penghasilanIbu1);
                int jumlahSaudara = Integer.parseInt(jumlahSaudara1);

                JpaMahasiswa aturAkun = new JpaMahasiswa();
                HttpSession session = request.getSession();
                mahasiswa = aturAkun.findMahasiswaByNrp(nrp);

                mahasiswa.setNama(nama);//set input kedalam objek
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
                    aturAkun.edit(mahasiswa);//eksekusi edit objek
                    request.setAttribute("pesan", "Data yang Anda masukkan telah tersimpan. Pastikan data yang Anda masukkan adalah benar");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException nfe) {
                request.setAttribute("pesan", "Isikan seluruh field dengan ketentuan format yang ada");
            }

        }

    }

    /**
     * Fungsi untuk eksekusi terhadap perubahan password
     */
    public void setAturPassword() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp");//menangkap input
        String passwordLama = request.getParameter("password_lama");
        String passwordBaru = request.getParameter("password_baru");
        String ulangiPassword = request.getParameter("password_baru_ulangi");
        JpaMahasiswa aturPassword = new JpaMahasiswa();
        HttpSession session = request.getSession();
        mahasiswa = aturPassword.findMahasiswaByNrp(nrp);
        /**
         * Validasi input untuk menghindari input kosong
         */
        if (passwordLama.equals("") || passwordBaru.equals("") || ulangiPassword.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");

        } else {
            /**
             * Validasi input password baru harus sama dengan password lama
             * dan password baru harus sama dengan password baru ulangi
             */
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

    /**
     * Fungsi untuk eksekusi terhadap perubahan data akun member
     * digunakan oleh admin
     */
    public void setAturAkunMember() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp_member");//menangkap parameter nrp member
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

        /**
         * Validasi input untuk menghindari input kosong
         */
        if (nama.equals("") || noHp.equals("") || nilaiToefl1.equals("")
                || semester1.equals("") || ipk1.equals("") || namaAyah.equals("")
                || penghasilanAyah1.equals("") || pekerjaanAyah.equals("") || namaIbu.equals("")
                || penghasilanIbu1.equals("") || pekerjaanIbu.equals("") || jumlahSaudara1.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Mahasiswa terkait");

        } else {
            try {//merubah input string menjadi int
                int nilaiToefl = Integer.parseInt(nilaiToefl1);//merubah input string menjadi int
            int semester = Integer.parseInt(semester1);
            Double ipk = Double.parseDouble(ipk1);//merubah input string menjadi double
            int penghasilanAyah = Integer.parseInt(penghasilanAyah1);
            int penghasilanIbu = Integer.parseInt(penghasilanIbu1);
            int jumlahSaudara = Integer.parseInt(jumlahSaudara1);

            JpaMahasiswa aturAkun = new JpaMahasiswa();
            HttpSession session = request.getSession();
            mahasiswa = aturAkun.findMahasiswaByNrp(nrp);

            mahasiswa.setNama(nama);//set input kedalam objek
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
                    aturAkun.edit(mahasiswa);//eksekusi edit objek
                    request.setAttribute("pesan", "Data mahasiswa yang Anda masukkan telah tersimpan. Pastikan data mahasiswa yang Anda masukkan adalah benar");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException nfe) {
                request.setAttribute("pesan", "Isikan seluruh field dengan ketentuan format yang ada");
            }
            
        }

    }

    /**
     * Fungsi untuk eksekusi terhadap perubahan password pada member
     * digunakan oleh admin
     */
    public void setAturPasswordMember() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp_member");
        String passwordBaru = request.getParameter("password");
        JpaMahasiswa aturPassword = new JpaMahasiswa();
        HttpSession session = request.getSession();
        mahasiswa = aturPassword.findMahasiswaByNrp(nrp);

        if (passwordBaru.equals("")) {//validasi terhadap input kosong
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data diri Anda");
            mahasiswa.setLoginstat(false);
        } else {
            mahasiswa.setPassword(passwordBaru);
            try {
                aturPassword.edit(mahasiswa);//eksekusi edit password
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Fungsi untuk mencari objek member beradasarkan nrp member
     */
    public void setMember() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp_member");//menangkap input nrp member
        HttpSession session = request.getSession();
        JpaMahasiswa aturMember = new JpaMahasiswa();
        mahasiswa = aturMember.findMahasiswaByNrp(nrp);//mencari objek bersarkan nrp
        session.setAttribute("member", mahasiswa);//memasukkan objek kedalam session
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Mahasiswa;
import model.Pengajuan;

/**
 *
 * @author yosua
 */
public class ControllerPengajuan {

    HttpServletRequest request;

    public ControllerPengajuan(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Melakukan list pengajuan berdasarkan nrp dengan me-remove objek yang nilai status bernilai "Daftar"
     */
    public void setListStatusByNrp() {
        String nrp = request.getParameter("nrp");//menangkap input parameter nrp
        JpaPengajuan listPengajuan = new JpaPengajuan();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();//membuat arraylist
        list = listPengajuan.getAllPengajuanByNrp(nrp);
        Iterator itr = list.listIterator();
        while (itr.hasNext()) {//melakukan iterasi untuk me-remove objek bernilai status "daftar"
            Pengajuan pengajuan = (Pengajuan) itr.next();

            if (pengajuan.getStatuspengajuan().equals("Daftar")) {
                itr.remove();//me-remove objek
            }
        }
        session.setAttribute("list_pengajuan_by_nrp", list);//menyimpan hasil list kedalam session
    }

    /**
     * Melakukan list pengajuan berdasarkan nrp
     */
    public void setListPengajuanByNrp() {
        Pengajuan pengajuan = new Pengajuan();
        String nrp = request.getParameter("nrp");//menangkap input parameter nrp
        JpaPengajuan listPengajuan = new JpaPengajuan();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();//membuat arraylist
        list = listPengajuan.getAllPengajuanByNrp(nrp);
        session.setAttribute("list_pengajuan_by_nrp", list);//menyimpan hasil list kedalam session
    }

    /**
     * Melakukan list seluruh pengajuan yang ada dalam db
     */
    public void setListPengajuan() {
        Pengajuan pengajuan = new Pengajuan();
        JpaPengajuan listPengajuan = new JpaPengajuan();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();//membuat arraylist
        list = listPengajuan.getAllPengajuan();
        session.setAttribute("list_all_pengajuan", list);//menyimpan hasil list kedalam session
    }

    /**
     * Melakukan list pengajuan berdasarkan idbeasiswa
     */
    public void setListPengajuanByIdBeasiswa() {
        Pengajuan pengajuan = new Pengajuan();
        String idbeasiswa = request.getParameter("pilih");//menangkap input parameter pilih yang berisi idbeasiswa
        String sort = request.getParameter("pilih_sort");//menangkap input parameter sort berdasarkan gaji atau ipk
        JpaPengajuan listPengajuan = new JpaPengajuan();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        if (sort.equals("ipk")) {
            list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByIpk(idbeasiswa);//order descending berdasarkan ipk
        } else if (sort.equals("gaji")) {
            list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByGaji(idbeasiswa);//order ascending berdasarkan gaji
        } else {
            list = listPengajuan.getAllPengajuan();
        }

        session.setAttribute("list_all_pengajuan", list);//menyimpan list kedalam session
    }

    /**
     * Fungsi untuk melakukan pencarian objek berdasarkan
     * idpengajuan kemudian menyimpan dalam session pengajuan
     */
    public void setPengajuan() {
        String idPengajuan = request.getParameter("idpengajuan");//menangkap input parameter
        JpaPengajuan cariPengajuan = new JpaPengajuan();
        Pengajuan pengajuan = new Pengajuan();
        pengajuan = cariPengajuan.findPengajuanById(idPengajuan);//mencari objek berdasarkan idpengajuannya
        HttpSession session = request.getSession();
        session.setAttribute("pengajuan", pengajuan);//menyimpan kedalam session
    }

    /**
     * Fungsi automasi untuk status pengajuan yang telah diterima menjadi kadaluarsa
     * fungsi ini berjalan otomatis setiap admin ingin melakukan rekapitulasi
     */
    public void setStatusPenerima() {
        JpaPengajuan listPengajuan = new JpaPengajuan();
        JpaMahasiswa aturPengajuan = new JpaMahasiswa();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuan();//mengambil semua pengajuan
        Iterator itr = list.listIterator();//memasukkan pengajuan kedalam list
        Date tglSaatIni = null;
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        try {
            tglSaatIni = (Date) formatter.parse(dateNow);//mengatur tanggal saat ini
        } catch (ParseException ex) {
            Logger.getLogger(ControllerPengajuan.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (itr.hasNext()) {// melakukan iterasi
            Pengajuan pengajuan = (Pengajuan) itr.next();//menginisialisasi tiap objek saat iterasi
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNrp(pengajuan.getNrp().getNrp());
            mahasiswa = aturPengajuan.findMahasiswaByNrp(mahasiswa.getNrp());//mencari mahasiswa sesuai nrp

            /**
             * jika tanggal saat ini telah melewati tanggal habis dan jika status pengajuan berupa "terima"
             * maka objek pengajuan tersebut sebelumnya bernilai masih menerima beasiswa
             * kemudian objek pengajuan tersebut diubah menjadi "berakhir" dan statu mahasiswa
             * yang mendapat beasiswa terbut diubah menjadi "tidak sedang menerima beasiswa"
             */
            if (tglSaatIni.after(pengajuan.getIdbeasiswa().getTanggalhabis()) == true) {
                if (pengajuan.getStatuspengajuan().equals("Terima")) {
                    pengajuan.setStatuspengajuan("Berakhir");
                    mahasiswa.setStatuspenerima("Tidak Sedang Menerima Beasiswa");
                    try {
                        listPengajuan.edit(pengajuan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    itr.remove();
                }
            }
            /**
             * untuk pengajuan yang diterima namun berstatus habis namun tanggal habis belum berakhir
             * atau diperpanjang maka statusnya akan diubah kembali menjadi "Terima"
             * sedangkan untuk mahasiswa yang mengajukan statusnya diubah menjadi "Sedang Menerima Beasiswa"
             */
            if (tglSaatIni.before(pengajuan.getIdbeasiswa().getTanggalhabis()) == true) {
                if (pengajuan.getStatuspengajuan().equals("Berakhir")) {
                    pengajuan.setStatuspengajuan("Terima");
                    mahasiswa.setStatuspenerima("Sedang Menerima Beasiswa");
                    try {
                        listPengajuan.edit(pengajuan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                aturPengajuan.edit(mahasiswa);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * Fungsi yang digunakan dalam rekapitulasi untuk merubah status penerima beasiswa
     */
    public void setAturStatus() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp");//meanangkap input parameter nrp
        String idpengajuan = request.getParameter("idpengajuan");
        JpaMahasiswa aturStatus = new JpaMahasiswa();
        JpaPengajuan aturPengajuan = new JpaPengajuan();
        mahasiswa = aturStatus.findMahasiswaByNrp(nrp);
        Pengajuan pengajuan = new Pengajuan();
        pengajuan = aturPengajuan.findPengajuanById(idpengajuan);
        if (mahasiswa.getStatuspenerima().equals("Sedang Menerima Beasiswa")) {
            pengajuan.setStatuspengajuan("Daftar");
            mahasiswa.setStatuspenerima("Tidak Sedang Menerima Beasiswa");//mengatur status
            try {
                aturPengajuan.edit(pengajuan);//eksekusi perubahan status
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            mahasiswa.setStatuspenerima("Sedang Menerima Beasiswa");
            pengajuan.setStatuspengajuan("Terima");
            try {
                aturPengajuan.edit(pengajuan);//eksekusi perubahan status
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            aturStatus.edit(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

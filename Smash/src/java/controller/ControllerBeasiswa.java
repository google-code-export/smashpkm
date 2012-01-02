/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */
import model.JpaBeasiswa;
import java.text.DateFormat;
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
import model.Beasiswa;

/**
 *
 * @author yosua
 */
public class ControllerBeasiswa {

    HttpServletRequest request;

    public ControllerBeasiswa(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Membuat beasiswa baru dengan menangkap parameter dari jsp
     */
    public void setBuatBeasiswa() throws ParseException {
        Beasiswa beasiswa=new Beasiswa();
        String namaBeasiswa = request.getParameter("namabeasiswa");//menangkap parameter
        String keterangan = request.getParameter("keterangan");
        String tanggalPublish = request.getParameter("tanggalpublish");
        String tanggalKadaluwarsa = request.getParameter("tanggalkadaluwarsa");
        String tanggalMulai = request.getParameter("tanggalmulai");
        String tanggalHabis = request.getParameter("tanggalhabis");

        /**
         * validasi terhadap data yang tidak diisi dalam jsp
         */
        if (namaBeasiswa.equals("") || keterangan.equals("") || tanggalPublish.equals("")
                || tanggalKadaluwarsa.equals("") || tanggalMulai.equals("") || tanggalHabis.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data SK penawaran beasiswa");
        } else {

            /**
             * Melakukan set pada objek beasiswa
             * kemudian melakukan create beasiswa baru
             */
            HttpSession session = request.getSession();
            JpaBeasiswa beasiswaBaru = new JpaBeasiswa();
            beasiswa.setNamabeasiswa(namaBeasiswa);
            beasiswa.setKeterangan(keterangan);
            DateFormat formatter; //formater untuk konvert string menjadi Date
            Date datePublish;//inisialisasi Date
            Date dateKadaluwarsa;
            Date dateMulai;
            Date dateHabis;
            formatter = new SimpleDateFormat("dd-MM-yyyy");
            datePublish = (Date) formatter.parse(tanggalPublish); //merubah String menjadi Date
            dateKadaluwarsa = (Date) formatter.parse(tanggalKadaluwarsa);
            dateMulai = (Date) formatter.parse(tanggalMulai);
            dateHabis = (Date) formatter.parse(tanggalHabis);
            beasiswa.setTanggalpublish(datePublish);
            beasiswa.setTanggalkadaluarsa(dateKadaluwarsa);
            beasiswa.setTanggalmulai(dateMulai);
            beasiswa.setTanggalhabis(dateHabis);
            session.setAttribute("beasiswa", beasiswa); //set session untuk ditampilkan dalam jsp
            try {
                beasiswaBaru.create(beasiswa); // membuat beasiswa baru
                request.setAttribute("pesan", "Post '" + request.getParameter("namabeasiswa") + "' berhasil disimpan");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mengambil semua beasiswa yang ada kedalam list
     */
    public void setListBeasiswa() {
        JpaBeasiswa listBeasiswa = new JpaBeasiswa();
        HttpSession session = request.getSession();
        List<Beasiswa> list = new ArrayList<Beasiswa>();
        list = listBeasiswa.getAllBeasiswa();
        session.setAttribute("list_beasiswa", list);
    }

    /**
     * Mengambil semua beasiswa yang ada kedalam list dan me-remove beasiswa yang masa berlakunya
     * telah berakhir. dimana masa berlaku berakhir ditentukan dengan tanggal publish dan tanggal kadaluarsa
     * di bandingkan dengan tanggal saat ini. apabila tanggal saat ini berada di antara tanggal publish
     * dan tanggal kadaluarsa maka objek tersebut tetap didalam list, selain itu akan di-remove
     */
    public void setListBeasiswaBerlaku() {
        JpaBeasiswa listBeasiswa = new JpaBeasiswa();
        HttpSession session = request.getSession();
        List<Beasiswa> list = new ArrayList<Beasiswa>();
        list = listBeasiswa.getAllBeasiswa();
        Iterator itr = list.listIterator();
        Date tglSaatIni = null;
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateNow = formatter.format(currentDate.getTime());  //mengambil tanggal sekarang
        try {
            tglSaatIni = (Date) formatter.parse(dateNow);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerPengajuan.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (itr.hasNext()) { //melakukan iterasi
            Beasiswa beasiswa = (Beasiswa) itr.next();

            if (beasiswa.getTanggalpublish().before(tglSaatIni) == true) { //pencocokan dengan tanggal publish
                if (beasiswa.getTanggalkadaluarsa().after(tglSaatIni) == true) {//pencocokan dengan tanggal kadaluarsa
                } else {
                    itr.remove(); //remove objek false
                }
            } else {
                itr.remove(); //remove objek false
            }
        }
        session.setAttribute("list_beasiswa", list);
    }

    /**
     * Melakukan perubahan terhadap objek beasiswa yang telah ada
     */
    public void setEditPost() throws ParseException {
        Beasiswa beasiswa=new Beasiswa();
        String idBeasiswa = request.getParameter("idbeasiswa");
        HttpSession session = request.getSession();
        JpaBeasiswa aturPost = new JpaBeasiswa();
        beasiswa = aturPost.findBeasiswaById(idBeasiswa);
        String namaBeasiswa = request.getParameter("namabeasiswa"); //menangkap parameter dari jsp
        String keterangan = request.getParameter("keterangan");
        String tanggalPublish = request.getParameter("tanggalpublish");
        String tanggalKadaluwarsa = request.getParameter("tanggalkadaluwarsa");
        String tanggalMulai = request.getParameter("tanggalmulai");
        String tanggalHabis = request.getParameter("tanggalhabis");

        /**
         * validasi apabila input kosong
         */
        if (namaBeasiswa.equals("") || keterangan.equals("") || tanggalPublish.equals("")
                || tanggalKadaluwarsa.equals("") || tanggalMulai.equals("") || tanggalHabis.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data SK penawaran beasiswa");
        } else {


            /**
             * Melakukan set terhadap input baru kedalam objek beasiswa
             */
            beasiswa.setNamabeasiswa(namaBeasiswa);
            beasiswa.setKeterangan(keterangan);
            DateFormat formatter;
            Date datePublish;
            Date dateKadaluwarsa;
            Date dateMulai;
            Date dateHabis;
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(tanggalPublish);
            formatter = new SimpleDateFormat("dd-MM-yyyy");
            datePublish = (Date) formatter.parse(tanggalPublish);
            dateKadaluwarsa = (Date) formatter.parse(tanggalKadaluwarsa);
            dateMulai = (Date) formatter.parse(tanggalMulai);
            dateHabis = (Date) formatter.parse(tanggalHabis);
            beasiswa.setTanggalpublish(datePublish);
            beasiswa.setTanggalkadaluarsa(dateKadaluwarsa);
            beasiswa.setTanggalmulai(dateMulai);
            beasiswa.setTanggalhabis(dateHabis);

            try {
                aturPost.edit(beasiswa); //eksekusi edit
                request.setAttribute("pesan", "Post '" + request.getParameter("namabeasiswa") + "' berhasil diedit");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Melakukan set terhadap objek beasiswa untuk nantinya akan ditampilkan dalam edit post
     * sebagai input lama yang dapat dimodifikasi
     */
    public void setPost() {
        Beasiswa beasiswa=new Beasiswa();
        String idBeasiswa = request.getParameter("idbeasiswa"); //menangkap parameter idbeasiswa dari jsp
        HttpSession session = request.getSession();
        JpaBeasiswa aturPost = new JpaBeasiswa();
        beasiswa = aturPost.findBeasiswaById(idBeasiswa);//mencari beasiswa yang ingin disimpan dalam session
        session.setAttribute("beasiswa", beasiswa);//menyimpan  objek dalam session
        Date datePublish = beasiswa.getTanggalpublish();
        Date dateKadaluwarsa = beasiswa.getTanggalkadaluarsa();
        Date dateMulai = beasiswa.getTanggalmulai();
        Date dateHabis = beasiswa.getTanggalhabis();
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd-MM-yyyy");//formatter untuk merubah Date menjadi string
        String tanggalPublish = formatter.format(datePublish);
        String tanggalKadaluwarsa = formatter.format(dateKadaluwarsa);
        String tanggalMulai = formatter.format(dateMulai);
        String tanggalHabis = formatter.format(dateHabis);
        session.setAttribute("tanggalpublish", tanggalPublish);//memasukkan tanggal berupa string kedalam session
        session.setAttribute("tanggalkadaluwarsa", tanggalKadaluwarsa);
        session.setAttribute("tanggalmulai", tanggalMulai);
        session.setAttribute("tanggalhabis", tanggalHabis);
    }

    /**
     * Menghapus beasiswa dengan input berupa idbeasiswa
     */
    public void setDeletePost() {
        String idBeasiswa = request.getParameter("idbeasiswa");//menangkap parameter idbeasiswa
        HttpSession session = request.getSession();
        Beasiswa beasiswa = new Beasiswa();
        JpaBeasiswa deletePost = new JpaBeasiswa();
        beasiswa = deletePost.findBeasiswaById(idBeasiswa); //mencari beasiswa yang ingin dihapus
        try {
            deletePost.destroy(beasiswa.getIdbeasiswa()); //eksekusi hapus
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Melakukan set terhadap pengajuan kedalam session idbeasiswa
     */
    public void setBeasiswaPengajuan() {
        String idBeasiswa = request.getParameter("pilih");
        HttpSession session = request.getSession();
        session.setAttribute("idbeasiswa", idBeasiswa);
    }


  
}

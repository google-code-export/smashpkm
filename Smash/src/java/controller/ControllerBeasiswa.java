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

/**
 *
 * @author yosua
 */
public class ControllerBeasiswa {

    HttpServletRequest request;

    public ControllerBeasiswa(HttpServletRequest request) {
        this.request = request;
    }

    public void setBuatBeasiswa(Beasiswa beasiswa) throws ParseException {
        String namaBeasiswa = request.getParameter("namabeasiswa");
        String keterangan = request.getParameter("keterangan");
        String tanggalPublish = request.getParameter("tanggalpublish");
        String tanggalKadaluwarsa = request.getParameter("tanggalkadaluwarsa");
        String tanggalMulai = request.getParameter("tanggalmulai");
        String tanggalHabis = request.getParameter("tanggalhabis");

        if (namaBeasiswa.equals("") || keterangan.equals("") || tanggalPublish.equals("")
                || tanggalKadaluwarsa.equals("") || tanggalMulai.equals("") || tanggalHabis.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data SK penawaran beasiswa");
        } else {

            HttpSession session = request.getSession();
            BeasiswaJpaController beasiswaBaru = new BeasiswaJpaController();
            beasiswa.setNamabeasiswa(namaBeasiswa);
            beasiswa.setKeterangan(keterangan);
            DateFormat formatter;
            Date datePublish;
            Date dateKadaluwarsa;
            Date dateMulai;
            Date dateHabis;
            formatter = new SimpleDateFormat("dd-MM-yyyy");
            datePublish = (Date) formatter.parse(tanggalPublish);
            dateKadaluwarsa = (Date) formatter.parse(tanggalKadaluwarsa);
            dateMulai = (Date) formatter.parse(tanggalMulai);
            dateHabis = (Date) formatter.parse(tanggalHabis);
            beasiswa.setTanggalpublish(datePublish);
            beasiswa.setTanggalkadaluarsa(dateKadaluwarsa);
            beasiswa.setTanggalmulai(dateMulai);
            beasiswa.setTanggalhabis(dateHabis);
            session.setAttribute("beasiswa", beasiswa);
            try {
                beasiswaBaru.create(beasiswa);
                request.setAttribute("pesan", "Post '" + request.getParameter("namabeasiswa") + "' berhasil disimpan");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setListBeasiswa() {
        BeasiswaJpaController listBeasiswa = new BeasiswaJpaController();
        HttpSession session = request.getSession();
        List<Beasiswa> list = new ArrayList<Beasiswa>();
        list = listBeasiswa.getAllBeasiswa();
        session.setAttribute("list_beasiswa", list);
    }

    public void setEditPost(Beasiswa beasiswa) throws ParseException {
        String idBeasiswa = request.getParameter("idbeasiswa");
        HttpSession session = request.getSession();
        BeasiswaJpaController aturPost = new BeasiswaJpaController();
        beasiswa = aturPost.findBeasiswaById(idBeasiswa);
        String namaBeasiswa = request.getParameter("namabeasiswa");
        String keterangan = request.getParameter("keterangan");
        String tanggalPublish = request.getParameter("tanggalpublish");
        String tanggalKadaluwarsa = request.getParameter("tanggalkadaluwarsa");
        String tanggalMulai = request.getParameter("tanggalmulai");
        String tanggalHabis = request.getParameter("tanggalhabis");

        if (namaBeasiswa.equals("") || keterangan.equals("") || tanggalPublish.equals("")
                || tanggalKadaluwarsa.equals("") || tanggalMulai.equals("") || tanggalHabis.equals("")) {
            request.setAttribute("pesan", "Isikan seluruh field yang tersedia sesuai dengan data SK penawaran beasiswa");
        } else {

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
                aturPost.edit(beasiswa);
                request.setAttribute("pesan", "Post '" + request.getParameter("namabeasiswa") + "' berhasil diedit");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void setPost(Beasiswa beasiswa) {
        String idBeasiswa = request.getParameter("idbeasiswa");
        HttpSession session = request.getSession();
        BeasiswaJpaController aturPost = new BeasiswaJpaController();
        beasiswa = aturPost.findBeasiswaById(idBeasiswa);
        session.setAttribute("beasiswa", beasiswa);
        Date datePublish = beasiswa.getTanggalpublish();
        Date dateKadaluwarsa = beasiswa.getTanggalkadaluarsa();
        Date dateMulai = beasiswa.getTanggalmulai();
        Date dateHabis = beasiswa.getTanggalhabis();
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        String tanggalPublish = formatter.format(datePublish);
        String tanggalKadaluwarsa = formatter.format(dateKadaluwarsa);
        String tanggalMulai = formatter.format(dateMulai);
        String tanggalHabis = formatter.format(dateHabis);
        session.setAttribute("tanggalpublish", tanggalPublish);
        session.setAttribute("tanggalkadaluwarsa", tanggalKadaluwarsa);
        session.setAttribute("tanggalmulai", tanggalMulai);
        session.setAttribute("tanggalhabis", tanggalHabis);
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

    public void setBeasiswaPengajuan() {
        String idBeasiswa = request.getParameter("pilih");
        HttpSession session = request.getSession();
        session.setAttribute("idbeasiswa", idBeasiswa);
    }
}

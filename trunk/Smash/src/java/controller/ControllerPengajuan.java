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

    public void setListPengajuanByNrp(Pengajuan pengajuan) {
        String nrp = request.getParameter("nrp");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuanByNrp(nrp);
        session.setAttribute("list_pengajuan_by_nrp", list);
    }

    public void setListPengajuan(Pengajuan pengajuan) {
        String nrp = request.getParameter("nrp");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuan();
        session.setAttribute("list_all_pengajuan", list);
    }

    public void setListPengajuanByIdBeasiswa(Pengajuan pengajuan) {
        String idbeasiswa = request.getParameter("pilih");
        String sort = request.getParameter("pilih_sort");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        if (sort.equals("ipk")) {
            list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByIpk(idbeasiswa);
        } else if (sort.equals("gaji")) {
            list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByGaji(idbeasiswa);
        } else {
            list = listPengajuan.getAllPengajuan();
        }

        session.setAttribute("list_all_pengajuan", list);
    }

    public void setPengajuan() {
        String idPengajuan = request.getParameter("idpengajuan");
        PengajuanJpaController cariPengajuan = new PengajuanJpaController();
        Pengajuan pengajuan = new Pengajuan();
        pengajuan = cariPengajuan.findPengajuanById(idPengajuan);
        HttpSession session = request.getSession();
        session.setAttribute("pengajuan", pengajuan);
    }

    public void setStatusPenerima() throws ParseException {
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        MahasiswaJpaController aturStatus = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        Mahasiswa mahasiswa = new Mahasiswa();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuanByStatus();
        Iterator itr = list.listIterator();
        Date tglSaatIni = null;
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        tglSaatIni = (Date) formatter.parse(dateNow);


        while (itr.hasNext()) {
            Pengajuan pengajuan = (Pengajuan) itr.next();
            mahasiswa.setNrp(pengajuan.getNrp().getNrp());
            if (tglSaatIni.after(pengajuan.getIdbeasiswa().getTanggalkadaluarsa())) {
                mahasiswa = aturStatus.findMahasiswa(pengajuan.getNrp().getNrp());
                mahasiswa.setStatuspenerima("Tidak Sedang Menerima Beasiswa");
                try {
                    aturStatus.edit(mahasiswa);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setAturStatus() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp");
        String idpengajuan = request.getParameter("idpengajuan");
        MahasiswaJpaController aturStatus = new MahasiswaJpaController();
        PengajuanJpaController aturPengajuan = new PengajuanJpaController();
        mahasiswa = aturStatus.findMahasiswaByNrp(nrp);
        Pengajuan pengajuan = new Pengajuan();
        pengajuan = aturPengajuan.findPengajuanById(idpengajuan);
        if (mahasiswa.getStatuspenerima().equals("Sedang Menerima Beasiswa")) {
            mahasiswa.setStatuspenerima("Tidak Sedang Menerima Beasiswa");
        } else {
            mahasiswa.setStatuspenerima("Sedang Menerima Beasiswa");
            pengajuan.setStatusPengajuan(true);
        }

        try {
            aturStatus.edit(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

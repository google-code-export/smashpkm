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

    public void setListPengajuanByNrp(Pengajuan pengajuan){
        String nrp = request.getParameter("nrp");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuanByNrp(nrp);
        session.setAttribute("list_pengajuan_by_nrp", list);
    }

    public void setListPengajuanByIdBeasiswa(Pengajuan pengajuan){
        String idbeasiswa = request.getParameter("pilih");
        String sort = request.getParameter("pilih_sort");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        if(sort.equals("ipk")){
        list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByIpk(idbeasiswa);
        }
        else if(sort.equals("gaji")){
        list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByGaji(idbeasiswa);
        }
        
        session.setAttribute("list_pengajuan_by_idbeasiswa", list);
    }

    public void setPengajuan() {
        String idPengajuan = request.getParameter("idpengajuan");
        PengajuanJpaController cariPengajuan = new PengajuanJpaController();
        Pengajuan pengajuan=new Pengajuan();
        pengajuan=cariPengajuan.findPengajuanById(idPengajuan);
        HttpSession session = request.getSession();
        session.setAttribute("pengajuan", pengajuan);
    }

  
}

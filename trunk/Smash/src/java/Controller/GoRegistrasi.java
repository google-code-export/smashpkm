/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author yosua
 */

import Model.KoneksiDB;
import Model.ModelDB;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author yosua
 */
public class GoRegistrasi {

    HttpServletRequest request;
    public String pesan="";


    public GoRegistrasi(HttpServletRequest request){
    
    this.request=request;}


    public String Registrasi(){


    String nama=request.getParameter("nama");
    String nrp=request.getParameter("nrp");
    String password=request.getParameter("password");
    KoneksiDB kondb=new KoneksiDB();
    ModelDB reg=new ModelDB(kondb.getConnection());
    
    if(nrp.length()>=1){
    try{
    reg.insertReg(nama,nrp,password);

    return "HalamanUtamaPengguna.jsp";

    }
    catch(Exception ex){
        setPesan("maaf, NRP telah digunakan");
        return "Registrasi.jsp";


    }finally{
    kondb.CloseConnection();}

    }else{
    setPesan("");
    return "Registrasi.jsp";}}
    
    


    public void setPesan(String pesan){
     this.pesan=pesan;
     }

    public String getPesan(){

    return pesan;}

    





}










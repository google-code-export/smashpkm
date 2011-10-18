/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author yosua
 */

import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author yosua
 */
public class GoRegistrasi {

    HttpServletRequest request;
    public String halaman;

    public GoRegistrasi(HttpServletRequest request){
    
    this.request=request;}


    public String Registrasi(){


    String nama=request.getParameter("nama");
    String nrp=request.getParameter("nrp");
    String password=request.getParameter("password");
    KoneksiDB kondb=new KoneksiDB();
    Registrasi reg=new Registrasi(kondb.getConnection());
    
    halaman="index.jsp";

    try{
    reg.insertReg(nama,nrp,password);}
    catch(Exception ex){
        
         
         halaman="Registrasi.jsp";
    }
    finally{
    kondb.CloseConnection();}
    return halaman;
    }

    public String pesan(){
    String pesan;
    pesan="";
    if(halaman.equals("Registrasi.jsp")){
    pesan="Maaf,nrp telah digunakan";}
    return pesan;
    } }










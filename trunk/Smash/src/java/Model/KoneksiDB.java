/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author yosua
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author yosua
 */
public class KoneksiDB {
Connection conn=null;

public KoneksiDB(){
String URL="jdbc:mysql://localhost:3306/Smash";
String USER="root";
String PASS="";
try {
Class.forName("com.mysql.jdbc.Driver");
this.conn=DriverManager.getConnection(URL,USER,PASS);
}catch(Exception ex){}
}

public Connection getConnection()
{return this.conn;}

public void CloseConnection(){
if(this.conn!=null){
try{this.conn.close();}
catch(Exception ex){}}
}}
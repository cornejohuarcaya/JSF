/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.websocket.Session;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Oran Alca
 */
public class Connexion {

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }
    private Connection cnn;     
      
    public void Conectar() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        //setCnn(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdcornejo", "root", "pa4cktln"));
        setCnn(DriverManager.getConnection("jdbc:mysql://localhost/bdcornejo", "root", ""));
        }catch(Exception e){
            throw e;
        }
    }
    public void Cerrar(){
        try {
            if(cnn != null){
                if(cnn.isClosed()==false){
                    cnn.close();
                }
            }
        } catch (Exception e) {
        }
    }

}

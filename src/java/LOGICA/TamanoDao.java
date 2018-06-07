/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.Tamano;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class TamanoDao extends Connexion{
    
    public void register(Tamano produc) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("INSERT INTO `tamano`(`TAMANO`) VALUES (?)");
            st.setString(1, produc.getTamano());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Tamano> list() throws Exception{
        List<Tamano> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareCall("SELECT `IDTAMANO`, `TAMANO` FROM `tamano` ");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Tamano staff = new Tamano();
                
                staff.setIdtamano(rs.getInt("IDTAMANO"));
                staff.setTamano(rs.getString("TAMANO"));
                
                
                lista.add(staff);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
    
    public Tamano searchId(Tamano taman) throws Exception{
        Tamano tamano;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("SELECT `IDTAMANO`, `TAMANO` FROM `tamano` WHERE `IDTAMANO`=?");
            st.setInt(1, taman.getIdtamano());
            rs = st.executeQuery();            
            while(rs.next()){
                tamano = new Tamano();
                
                tamano.setIdtamano(rs.getInt("IDTAMANO"));
                tamano.setTamano(rs.getString("TAMANO"));
             
            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return taman;
    }
    
    public void modify(Tamano taman )throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("UPDATE `tamano` SET `TAMANO`=? WHERE `IDTAMANO`=?");
            
            st.setString(1, taman.getTamano());
            st.setInt(2, taman.getIdtamano());     
                      
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public void delete(Tamano taman) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("DELETE FROM `tamano` WHERE `IDTAMANO`=?");
            st.setInt(1, taman.getIdtamano());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    } 
}

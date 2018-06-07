/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class ProductoDao extends Connexion{
    public void register(Producto produc) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("INSERT INTO `producto`(`NOMBRE`, `DETALLE`) VALUES (?,?)");
            st.setString(1, produc.getNombre());
            st.setString(2, produc.getDetalle());
      
      
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Producto> list() throws Exception{
        List<Producto> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareCall("SELECT `IDPRODUCTO`, `NOMBRE`, `DETALLE` FROM `producto`");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Producto staff = new Producto();
                
                staff.setIdproducto(rs.getInt("IDPRODUCTO"));
                staff.setNombre(rs.getString("NOMBRE"));
                staff.setDetalle(rs.getString("DETALLE"));
                
                lista.add(staff);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
    
    public Producto searchId(Producto produc) throws Exception{
        Producto producto;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("SELECT `IDPRODUCTO`, `NOMBRE`, `DETALLE` FROM `producto` WHERE `IDPRODUCTO` =?");
            st.setInt(1, produc.getIdproducto());
            rs = st.executeQuery();            
            while(rs.next()){
                producto = new Producto();
                
                producto.setIdproducto(rs.getInt("IDPRODUCTO"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setDetalle(rs.getString("DETALLE"));
            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return produc;
    }
    
    public void modify(Producto produc) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("UPDATE `producto` SET `NOMBRE`=?,`DETALLE`=? WHERE `IDPRODUCTO` = ?");
            
            st.setString(1, produc.getNombre());
            st.setString(2, produc.getDetalle());
            st.setInt(3, produc.getIdproducto());
     
          
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public void delete(Producto produc) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("DELETE FROM `producto` WHERE `IDPRODUCTO` =?");
            st.setInt(1, produc.getIdproducto());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
}

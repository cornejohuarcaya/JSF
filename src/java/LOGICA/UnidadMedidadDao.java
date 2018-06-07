/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;


import DATOS.Unidadmedida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class UnidadMedidadDao extends Connexion {
    public void register(Unidadmedida unidadmed) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("INSERT INTO `unidadmedida`( `NOMBRE`, `UNIDAD`) VALUES (?,?)");
            st.setString(1, unidadmed.getNombre());
            st.setInt(2, unidadmed.getUnidad());
      
      
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Unidadmedida> list() throws Exception{
        List<Unidadmedida> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareCall("SELECT `IDUNIDAD`, `NOMBRE`, `UNIDAD` FROM `unidadmedida`");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Unidadmedida staff = new Unidadmedida();
                
                staff.setIdunidad(rs.getInt("IDUNIDAD"));
                staff.setNombre(rs.getString("NOMBRE"));
                staff.setUnidad(rs.getInt("UNIDAD"));
                
                lista.add(staff);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
    
    public Unidadmedida searchId(Unidadmedida unidadmed) throws Exception{
        Unidadmedida producto;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("SELECT `IDUNIDAD`, `NOMBRE`, `UNIDAD` FROM `unidadmedida` WHERE `IDUNIDAD` = ?");
            st.setInt(1, unidadmed.getIdunidad());
            rs = st.executeQuery();            
            while(rs.next()){
                producto = new Unidadmedida();
                
                producto.setIdunidad(rs.getInt("IDUNIDAD"));
                producto.setNombre(rs.getString("NOMBRE"));
                producto.setUnidad(rs.getInt("UNIDAD"));
            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return unidadmed;
    }
    
    public void modify(Unidadmedida unidadmed) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("UPDATE `unidadmedida` SET `NOMBRE`= ?,`UNIDAD`=? WHERE `IDUNIDAD`=?");
            
            st.setString(1, unidadmed.getNombre());
            st.setInt(2, unidadmed.getUnidad());
            st.setInt(3, unidadmed.getIdunidad());
     
          
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public void delete(Unidadmedida produc) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("DELETE FROM `unidadmedida` WHERE `IDUNIDAD` =?");
            st.setInt(1, produc.getIdunidad());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
}

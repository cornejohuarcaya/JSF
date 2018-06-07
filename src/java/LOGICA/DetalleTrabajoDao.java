/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.DetalleTrabajo;
import DATOS.Producto;
import DATOS.Trabajo;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;

/**
 *
 * @author Erick
 */
public class DetalleTrabajoDao extends Connexion{
public void register(DetalleTrabajo detalle) throws Exception{
        
        try {
            this.Conectar();
             CallableStatement proc = getCnn().prepareCall("CALL REGISTRARDETALLE(?,?,?,?,?,?) ");
            proc.setInt(1, detalle.getProducto().getIdproducto() );
            proc.setInt(2, detalle.getCantidad());
            proc.setDouble(3, detalle.getPrecio()) ;
            proc.setInt(4, detalle.getUnidad().getIdunidad() );
            proc.setInt(5, detalle.getTamano().getIdtamano());
            proc.setString(6, detalle.getDescripcion());
            proc.execute();            
            
      
        } catch (Exception e) {

        }
  
    }
}

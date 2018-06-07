/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Logeo;
import DATOS.Usuario;
import LOGICA.LogueoDao;
import LOGICA.UsuarioDao;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick
 */
@ManagedBean
@ApplicationScoped
public class LogueoBean {

    
    /**
     * @return the validado
     */
    public Usuario getValidado() {
        return validado;
    }

    /**
     * @param aValidado the validado to set
     */
    public static void setValidado(Usuario aValidado) {
        validado = aValidado;
    }
    
    private static Usuario staff = new Usuario();
    public static Usuario validado;
    public void reiniciar()
    {
        staff= new Usuario();
        
    }

    public Usuario getStaff() {
        return staff;
    }

    public void setStaff(Usuario position) {
        this.staff = position;
    }
public String loguear() throws Exception{
        LogueoDao pdao;
         validado = new  Usuario();
        try {
            pdao = new LogueoDao();
            validado = pdao.searchId(staff);
             System.out.print("idusuario staff =" + staff.getIdusuario() + "idusuario valido  =" + validado.getIdusuario());
            if(staff.getIdusuario()>0 || validado.getIdusuario()>0  ){ 
               
                return "ingresar";               
            }
            else
            {            
                
               return "regresar";
            }
        } catch (Exception e) {
            throw e;
        }finally
        {
            reiniciar();
        }
          
    }
    
}

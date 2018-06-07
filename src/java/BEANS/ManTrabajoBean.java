/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Trabajo;
import LOGICA.ProductoDao;
import LOGICA.TrabajoDao;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Erick
 */
@ManagedBean
@ApplicationScoped
public class ManTrabajoBean {

    /**
     * @return the lstTrabajo
     */
    public List<Trabajo> getLstTrabajo() {
        return lstTrabajo;
    }
    

    /**
     * @param lstTrabajo the lstTrabajo to set
     */
    public void setLstTrabajo(List<Trabajo> lstTrabajo) {
        this.lstTrabajo = lstTrabajo;
    }

  private List<Trabajo>  lstTrabajo;
  private String valosbuscar;

    /**
     * @return the valosbuscar
     */
    public String getValosbuscar() {
        return valosbuscar;
    }

    /**
     * @param valosbuscar the valosbuscar to set
     */
    public void setValosbuscar(String valosbuscar) {
        this.valosbuscar = valosbuscar;
    }
    
     public void list() throws Exception{
         TrabajoDao dao;
        try {
            if(isPostBack() == false){
                dao = new TrabajoDao();
                setLstTrabajo(dao.listresumen(valosbuscar));                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
}

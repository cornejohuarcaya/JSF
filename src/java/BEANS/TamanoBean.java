/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Tamano;
import LOGICA.TamanoDao;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Erick
 */
@ManagedBean
@ApplicationScoped
public class TamanoBean {

   public  Tamano getTamano() {
        return tamano;
    }

    public static void setTamano(Tamano tamano2) {
        tamano = tamano2;
    }

  
    public List<Tamano> getLstTamano() {
        return lstTamano;
    }

    /**
     * @param lstTamano the lstProducto to set
     */
    public void setLstTamano(List<Tamano> lstTamano) {
        this.lstTamano = lstTamano;
    }

    private static Tamano tamano = new Tamano();
    
    
    private List<Tamano>  lstTamano;


 
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void register() throws Exception{
        TamanoDao pdao;
        try {
            pdao = new TamanoDao();
            pdao.register(getTamano());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void update() throws Exception{
        TamanoDao pdao;
        try {
            pdao = new TamanoDao();
            pdao.modify(getTamano());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void delete(Tamano tam )throws Exception{
        TamanoDao pdao;
        try {
            pdao = new TamanoDao();
            pdao.delete(tam);
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }

    public void list() throws Exception{
        TamanoDao dao;
        try {
            if(isPostBack() == false){
                dao = new TamanoDao();
                setLstTamano(dao.list());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    
    public void listAjax() throws Exception{
        TamanoDao dao;
        try {
            if(isPostBack() == true){
                dao = new TamanoDao();
                setLstTamano(dao.list());                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void searchID(Tamano tam) throws Exception{
        TamanoDao pdao;
        Tamano temp;
        try {
            pdao = new TamanoDao();
            temp = pdao.searchId(tam);
            if(temp != null){
                this.tamano=(temp);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

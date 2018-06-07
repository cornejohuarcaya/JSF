/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Unidadmedida;
import LOGICA.UnidadMedidadDao;
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
public class UnidadMedidaBean {

    /**
     * @return the unidadmedida
     */
    public  Unidadmedida getUnidadmedida() {
        return unidadmedida;
    }

    /**
     * @param aUnidadmedida the unidadmedida to set
     */
    public  void setUnidadmedida(Unidadmedida aUnidadmedida) {
        unidadmedida = aUnidadmedida;
    }

    /**
     * @return the lstUnidadmed
     */
    public List<Unidadmedida> getLstUnidadmed() {
        return lstUnidadmed;
    }

    /**
     * @param lstUnidadmed the lstUnidadmed to set
     */
    public void setLstUnidadmed(List<Unidadmedida> lstUnidadmed) {
        this.lstUnidadmed = lstUnidadmed;
    }

  
   

  
  

    private static Unidadmedida unidadmedida = new Unidadmedida();
    
    
    private List<Unidadmedida>  lstUnidadmed;


 
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void register() throws Exception{
        UnidadMedidadDao pdao;
        try {
            pdao = new UnidadMedidadDao();
            pdao.register(getUnidadmedida());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void update() throws Exception{
        UnidadMedidadDao pdao;
        try {
            pdao = new UnidadMedidadDao();
            pdao.modify(getUnidadmedida());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void delete(Unidadmedida undmed) throws Exception{
        UnidadMedidadDao pdao;
        try {
            pdao = new UnidadMedidadDao();
            pdao.delete(undmed);
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }

    public void list() throws Exception{
        UnidadMedidadDao dao;
        try {
            if(isPostBack() == false){
                dao = new UnidadMedidadDao();
                setLstUnidadmed(dao.list());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    
    public void listAjax() throws Exception{
        UnidadMedidadDao dao;
        try {
            if(isPostBack() == true){
                dao = new UnidadMedidadDao();
                setLstUnidadmed(dao.list());                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void searchID(Unidadmedida umed) throws Exception{
        UnidadMedidadDao pdao;
        Unidadmedida temp;
        try {
            pdao = new UnidadMedidadDao();
            temp = pdao.searchId(umed);
            if(temp != null){
                this.setUnidadmedida(temp);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

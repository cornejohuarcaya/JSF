/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Producto;
import LOGICA.ProductoDao;
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
public class ProductoBean {

   public  Producto getProducto() {
        return producto;
    }

    public static void setProducto(Producto producto2) {
        producto = producto2;
    }

  
    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    /**
     * @param lstProducto the lstProducto to set
     */
    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    private static Producto producto = new Producto();
    
    
    private List<Producto>  lstProducto;


 
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void register() throws Exception{
        ProductoDao pdao;
        try {
            pdao = new ProductoDao();
            pdao.register(getProducto());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void update() throws Exception{
        ProductoDao pdao;
        try {
            pdao = new ProductoDao();
            pdao.modify(getProducto());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void delete(Producto prov) throws Exception{
        ProductoDao pdao;
        try {
            pdao = new ProductoDao();
            pdao.delete(prov);
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }

    public void list() throws Exception{
        ProductoDao dao;
        try {
            if(isPostBack() == false){
                dao = new ProductoDao();
                setLstProducto(dao.list());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    
    public void listAjax() throws Exception{
        ProductoDao dao;
        try {
            if(isPostBack() == true){
                dao = new ProductoDao();
                setLstProducto(dao.list());                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void searchID(Producto prov) throws Exception{
        ProductoDao pdao;
        Producto temp;
        try {
            pdao = new ProductoDao();
            temp = pdao.searchId(prov);
            if(temp != null){
                this.producto=(temp);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}

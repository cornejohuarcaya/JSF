/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Usuario;
import LOGICA.UsuarioDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Erick
 */
@ManagedBean
@ApplicationScoped
public class UsuBean{

    /**
     * @return the lstStaff
     */
    public List<Usuario> getLstStaff() {
        return lstStaff;
    }

    /**
     * @param lstStaff the lstStaff to set
     */
    public void setLstStaff(List<Usuario> lstStaff) {
        this.lstStaff = lstStaff;
    }

    private static Usuario staff = new Usuario();
    private List<Usuario>  lstStaff;


    public Usuario getStaff() {
        return staff;
    }

    public void setStaff(Usuario position) {
        this.staff = position;
    }
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void register() throws Exception{
        UsuarioDao pdao;
        try {
            pdao = new UsuarioDao();
            pdao.register(staff);
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void update() throws Exception{
        UsuarioDao pdao;
        try {
            pdao = new UsuarioDao();
            pdao.modify(staff);
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void delete(Usuario prov) throws Exception{
        UsuarioDao pdao;
        try {
            pdao = new UsuarioDao();
            pdao.delete(prov);
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }

    public void list() throws Exception{
        UsuarioDao dao;
        try {
            if(isPostBack() == false){
                dao = new UsuarioDao();
                setLstStaff(dao.list());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    
    public void listAjax() throws Exception{
        UsuarioDao dao;
        try {
            if(isPostBack() == true){
                dao = new UsuarioDao();
                setLstStaff(dao.list());                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void searchID(Usuario prov) throws Exception{
        UsuarioDao pdao;
        Usuario temp;
        try {
            pdao = new UsuarioDao();
            temp = pdao.searchId(prov);
            if(temp != null){
                this.staff = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

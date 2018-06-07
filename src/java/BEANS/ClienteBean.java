/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Cliente;
import LOGICA.ClienteDao;
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
public class ClienteBean {

    /**
     * @return the cliente
     */
    public  Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente2) {
        cliente = cliente2;
    }

  
    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    /**
     * @param lstStaff the lstCliente to set
     */
    public void setLstCliente(List<Cliente> lstStaff) {
        this.lstCliente = lstStaff;
    }

    private static Cliente cliente = new Cliente();
    
    
    private List<Cliente>  lstCliente;


 
    
    private boolean isPostBack(){
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }
    
    public void register() throws Exception{
        ClienteDao pdao;
        try {
            pdao = new ClienteDao();
            pdao.register(getCliente());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void update() throws Exception{
        ClienteDao pdao;
        try {
            pdao = new ClienteDao();
            pdao.modify(getCliente());
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }
    public void delete(Cliente prov) throws Exception{
        ClienteDao pdao;
        try {
            pdao = new ClienteDao();
            pdao.delete(prov);
            this.listAjax();
        } catch (Exception e) {
            throw e;
        }
    }

    public void list() throws Exception{
        ClienteDao dao;
        try {
            if(isPostBack() == false){
                dao = new ClienteDao();
                setLstCliente(dao.list());                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    
    public void listAjax() throws Exception{
        ClienteDao dao;
        try {
            if(isPostBack() == true){
                dao = new ClienteDao();
                setLstCliente(dao.list());                
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void searchID(Cliente prov) throws Exception{
        ClienteDao pdao;
        Cliente temp;
        try {
            pdao = new ClienteDao();
            temp = pdao.searchId(prov);
            if(temp != null){
                this.cliente=(temp);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import DATOS.Amortizacion;
import DATOS.Cliente;
import DATOS.DetalleTrabajo;
import DATOS.Producto;
import DATOS.Tamano;
import DATOS.Trabajo;
import DATOS.Unidadmedida;
import LOGICA.AmortizacionDao;
import LOGICA.ClienteDao;
import LOGICA.DetalleTrabajoDao;
import LOGICA.ProductoDao;
import LOGICA.TrabajoDao;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author Erick
 */
@ManagedBean
@ApplicationScoped
public class TrabajoBean {

    /**
     * @return the abono
     */
    public Amortizacion getAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(Amortizacion abono) {
        this.abono = abono;
    }

    public LogueoBean log = new LogueoBean();

    /**
     * @return the trabajo
     */
    public Trabajo getTrabajo() {
        return trabajo;
    }

    /**
     * @param trabajo the trabajo to set
     */
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    /**
     * @return the detalle
     */
    public DetalleTrabajo getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(DetalleTrabajo detalle) {
        this.detalle = detalle;
    }

    public List<DetalleTrabajo> getLstdetalle() {
        return lstdetalle;
    }

    public void setLstdetalle(List<DetalleTrabajo> lstdetalle) {
        this.lstdetalle = lstdetalle;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
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

    /**
     * @param lstProducto the lstProducto to set
     */
    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    private List<Producto> lstProducto;
    private List<Cliente> lstCliente;
    private DetalleTrabajo detalle = new DetalleTrabajo();
    private List<DetalleTrabajo> lstdetalle = new ArrayList();
    private Double total = new Double(0);
    private Trabajo trabajo = new Trabajo();
    private Amortizacion abono= new Amortizacion();
    private Cliente cli = new Cliente();

    public void registrar() throws Exception {
        TrabajoDao trabaDao;
        DetalleTrabajoDao dedao;
        AmortizacionDao amorti;
        int id = 0;
        try {
            trabaDao = new TrabajoDao();
            trabaDao.register(trabajo);
            dedao = new DetalleTrabajoDao();
             amorti= new AmortizacionDao();

            for (Iterator<DetalleTrabajo> iterator = lstdetalle.iterator(); iterator.hasNext();) {
                DetalleTrabajo next = iterator.next();
                dedao.register(next);
            }
            if (abono.getMonto()> 0) {
                amorti.register(abono);
            }
            FacesMessages.info("Successfully saved.");

            trabajo.setCliente(cli);
            lstdetalle = new ArrayList();
            calcular();
            trabajo.setTotal(0.0);
            trabajo.setSaldo(0.0);
            abono.setMonto(0.0);
        } catch (Exception e) {
            FacesMessages.error("Error al Guardar");
        }

    }

    public void calcular() {
        trabajo.setSaldo(trabajo.getTotal() - getAbono().getMonto());
    }

    public void selecClient(Cliente clie) {
        trabajo.setCliente(clie);
        trabajo.setUsuaio(log.getValidado());
        getAbono().setusuario(log.getValidado());

    }

    public void selectProduct(Producto prod) {
        getDetalle().setProducto(prod);
    }

    public void agregar_a_lista() {
//       if (detalle.getIdproducto()>0 && detalle.getIdtamano()>0 && detalle.getIdunidad()>0 && detalle.getCantidad()>0 
//               && detalle.getDescripcion().length()>2  && detalle.getPrecio()>0)
        {
            lstdetalle.add(getDetalle());
            total = new Double(0);
            total = Double.valueOf(0);
            for (Iterator<DetalleTrabajo> iterator = lstdetalle.iterator(); iterator.hasNext();) {
                DetalleTrabajo next = iterator.next();
                total += next.getPrecio() * next.getCantidad();
            }
            trabajo.setTotal(total);
            calcular();
        }
        setDetalle(new DetalleTrabajo());
    }

    public void eliminar(DetalleTrabajo det) {
        lstdetalle.remove(det);
        total = new Double(0);
        total = Double.valueOf(0);
        for (Iterator<DetalleTrabajo> iterator = lstdetalle.iterator(); iterator.hasNext();) {
            DetalleTrabajo next = iterator.next();
            total += next.getPrecio() * next.getCantidad();
        }
        trabajo.setTotal(total);
        calcular();
    }

    public void listprod() throws Exception {
        ProductoDao dao;
        try {
            if (isPostBack() == false) {
                dao = new ProductoDao();
                setLstProducto(dao.list());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lstcliente() throws Exception {
        ClienteDao dao;
        try {
            if (isPostBack() == false) {
                dao = new ClienteDao();
                setLstCliente(dao.list());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isPostBack() {
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }

    public void modificar(DetalleTrabajo det) {
        setDetalle(new DetalleTrabajo());
        setDetalle(det);
    }

}

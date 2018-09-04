/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 * @param <COSA>
 */
public abstract class MngrCliAbs<COSA> extends CliAbs implements MngrCliPro<COSA> {

    private List<Clasificado> clasificaciones;
    private Clasificado clasificarPorSelected;
    private String buscar = "";
    private List<COSA> lista;
    private COSA lineaSelected;
    private List<COSA> variasLineasSeleted;
    private COSA actual;

    private List<Clasificado> crearClasificaciones() throws Exception {
        return getMngr().crearClasificaciones();
    }

    protected abstract MngrPro<COSA> getMngr() throws Exception;

    @Override
    public List<Clasificado> getClasificaciones() throws Exception {
        if (clasificaciones == null) {
            clasificaciones = crearClasificaciones();
        }
        return clasificaciones;
    }

    @Override
    public void setClasificaciones(List<Clasificado> clasificaciones) {
        this.clasificaciones = clasificaciones;
    }

    @Override
    public Clasificado getClasificarPorSelected() throws Exception {
        if (clasificarPorSelected == null) {
            clasificarPorSelected = getClasificaciones().get(0);
        }
        return clasificarPorSelected;
    }

    @Override
    public void setClasificarPorSelected(Clasificado clasificar) {
        this.clasificarPorSelected = clasificar;
    }

    @Override
    public String getBuscar() {
        return buscar;
    }

    @Override
    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    @Override
    public void paginaPrimera() {
        try {
            setLista(getMngr().paginaPrimera());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paginaAnterior() {
        try {
            setLista(getMngr().paginaAnterior());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paginaSiguiente() {
        try {
            setLista(getMngr().paginaSiguiente());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paginaUltima() {
        try {
            setLista(getMngr().paginaUltima());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<COSA> getLista() throws Exception {
        return lista;
    }

    @Override
    public void setLista(List<COSA> lista) {
        this.lista = lista;
    }

    @Override
    public void relista() {
        try {
            getMngr().relista(getClasificarPorSelected(), getBuscar());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public COSA getLineaSelected() {
        return lineaSelected;
    }

    @Override
    public void setLineaSelected(COSA lineaSelected) {
        this.lineaSelected = lineaSelected;
    }

    @Override
    public List<COSA> getVariasLineasSelected() {
        return variasLineasSeleted;
    }

    @Override
    public void setVariasLineasSelected(List<COSA> lineaVariosSelected) {
        this.variasLineasSeleted = lineaVariosSelected;
    }

    @Override
    public boolean isLineaCogida() {
        boolean ret = false;
        if (getLineaSelected() != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean isVariasLineasCogidas() {
        boolean ret = false;
        if (getVariasLineasSelected() != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public void selecciona() {
        if (isLineaCogida()) {
            try {
                COSA cosa = getLineaSelected();
                //System.out.println("lineaSelected:" + cosa);
                cosa = getMngr().ponteEnEste(cosa);
                //System.out.println("ponteEnEste:" + cosa);
                setActual(cosa);
                //System.out.println(getActual());
            } catch (Exception ex) {
                Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public COSA getEntidad(Object id) throws Exception {
        return getMngr().getEntidad(id);
    }

    @Override
    public void primero() {
        try {
            setActual(getMngr().primero());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void anterior() {
        try {
            setActual(getMngr().anterior());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void siguiente() {
        try {
            setActual(getMngr().siguiente());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ultimo() {
        try {
            setActual(getMngr().ultimo());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void nuevo() {
        try {
            setActual(getMngr().nuevo());
        } catch (Exception ex) {
            Logger.getLogger(MngrCliAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isNuevo() throws Exception {
        return getMngr().isNuevo();
    }

    @Override
    public void setNuevo(boolean nuevo) throws Exception {
        getMngr().setNuevo(nuevo);
    }

    @Override
    public COSA getActual() {
        return actual;
    }

    @Override
    public void setActual(COSA actual) {
        this.actual = actual;
    }

    @Override
    public void guardar() throws Exception {

        getMngr().grabarAmbos(getActual());
        getMngr().confirmar();
        setActual(getMngr().ponteEnEste(getActual()));

    }

    @Override
    public void borrar() throws Exception {

        getMngr().borrarAmbos(getActual());
        getMngr().confirmar();
        ultimo();

    }

}

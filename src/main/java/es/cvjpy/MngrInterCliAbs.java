/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public abstract class MngrInterCliAbs<COSA, INTER> extends MngrCliAbs<COSA> implements Serializable {

    private InterCambioCliPro<INTER> intercambio;

    protected abstract List<INTER> getTodos() throws Exception;

    protected abstract InterCambioCliPro<INTER> crearIntercambio();

    public InterCambioCliPro<INTER> getIntercambio() {
        if (intercambio == null) {
            intercambio = crearIntercambio();
            try {
                intercambio.setTotal(getTodos());
            } catch (Exception ex) {
                Logger.getLogger(MngrInterCliAbs.class.getName()).log(Level.SEVERE, null, ex);
            }
            intercambio.inicial();
        }
        return intercambio;
    }

    public void setIntercambio(InterCambioCliPro<INTER> intercambio) {
        this.intercambio = intercambio;
    }
}

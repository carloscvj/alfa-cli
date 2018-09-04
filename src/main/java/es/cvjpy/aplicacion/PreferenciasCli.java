/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.aplicacion;

import es.cvjpy.CliAbs;
import es.cvjpy.CliPro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class PreferenciasCli extends CliAbs implements CliPro {

    private Preferencias configuracion;
    private PreferenciasPro configuracionPro;

    protected PreferenciasPro getProgramaServidor() {
        if (configuracionPro == null) {
            try {
                configuracionPro = (PreferenciasPro) getPrincipalPro().getProgramaServidor(PreferenciasPro.class);
            } catch (Exception ex) {
                Logger.getLogger(PreferenciasCli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configuracionPro;
    }

    public Preferencias getPreferencias() throws Exception {
        if (configuracion == null) {
            configuracion = getProgramaServidor().getPreferencias();
        }
        return configuracion;
    }

    public void guardarPreferencias() throws Exception {
        getProgramaServidor().guardarPreferencias(getPreferencias());
    }
}

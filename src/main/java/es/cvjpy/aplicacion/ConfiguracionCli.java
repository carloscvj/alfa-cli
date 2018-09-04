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
public class ConfiguracionCli extends CliAbs implements CliPro {

    private Configuracion configuracion;
    private ConfiguracionPro configuracionPro;

    protected ConfiguracionPro getProgramaServidor() {
        if (configuracionPro == null) {
            try {
                configuracionPro = (ConfiguracionPro) getPrincipalPro().getProgramaServidor(ConfiguracionPro.class);
            } catch (Exception ex) {
                Logger.getLogger(ConfiguracionCli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configuracionPro;
    }

    public Configuracion getConfiguracion() throws Exception {
        if (configuracion == null) {
            configuracion = getProgramaServidor().getConfiguracion();
        }
        return configuracion;
    }

    public void guardarConfiguracion() throws Exception {
        getProgramaServidor().guardarConfiguracion(getConfiguracion());
    }
}

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
public class SalirCli extends CliAbs implements CliPro {

    private SalirPro salirPro;

    protected SalirPro getProgramaServidor() throws Exception {
        if (salirPro == null) {
            salirPro = (SalirPro) getPrincipalPro().getProgramaServidor(SalirPro.class);
        }
        return salirPro;
    }

    public void salir() {
        try {
            getProgramaServidor().salir();
        } catch (Exception ex) {
            Logger.getLogger(SalirCli.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.salirPro = null;
    }
}

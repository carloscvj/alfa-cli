/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.cobol.utilidades;

import es.cvjpy.GenCliAbs;
import java.util.logging.Level;
import java.util.logging.Logger;
import es.cvjpy.GenCliPro;

/**
 *
 * @author carlos
 */
public class ReconstruirIdxGenCli extends GenCliAbs<String> implements GenCliPro<String> {

    private ReconstruirIdxGenPro srv;

    @Override
    protected ReconstruirIdxGenPro getProceso() throws Exception {
        if (srv == null) {
            srv = (ReconstruirIdxGenPro) getPrincipalPro().getProgramaServidor(ReconstruirIdxGenPro.class);
        }
        return srv;
    }

    public void guardarFiltros(FicheroCobolFiltro filtros) throws Exception {
        getProceso().guardarFiltros(filtros);
    }

    public void procesar() throws Exception {
        while (getProceso().hasNext()) {
            String next = getProceso().next();

            if (next.startsWith("ERROR:")) {
                try {
                    throw new Exception(next);
                } catch (Exception ex) {
                    Logger.getLogger(ReconstruirIdxGenCli.class.getName()).log(Level.SEVERE, next);
                }
            } else {
                Logger.getLogger(ReconstruirIdxGenCli.class.getName()).log(Level.INFO, next);
            }
        }
    }
}

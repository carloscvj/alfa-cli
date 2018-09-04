/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.cobol.utilidades;

import es.cvjpy.CliAbs;
import es.cvjpy.CliPro;

/**
 *
 * @author carlos
 */
public class ReconstruirIdxCli extends CliAbs implements CliPro {

    private ReconstruirIdxPro mngr;

    protected ReconstruirIdxPro getMngr() throws Exception {
        if (mngr == null) {
            mngr = (ReconstruirIdxPro) getPrincipalPro().getProgramaServidor(ReconstruirIdxPro.class);
        }
        return mngr;
    }
    private FicheroCobolFiltro maqMedFiltro;

    public FicheroCobolFiltro getFicheroCobolFiltro() throws Exception {
        if (maqMedFiltro == null) {
            maqMedFiltro = getMngr().crearFicheroCobolFiltro();
        }
        return maqMedFiltro;
    }

    public void guardarFicheroCobolFiltro() throws Exception {
        getMngr().guardarFicheroCobolFiltro(getFicheroCobolFiltro());
    }

    public void reiniciarSesionCobol() throws Exception {
       getMngr().reiniciarSesionCobol();
    }

}

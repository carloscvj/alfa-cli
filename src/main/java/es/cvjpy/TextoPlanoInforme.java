/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

/**
 *
 * @author carlos
 */
public class TextoPlanoInforme extends JasperGenInfAbs implements JasperGenInfPro {

    private TextoPlanoLinea lineaListado;
    private TextoPlanoPro informadorPro;

    @Override
    protected void procesarLinea(Object linea) {
        lineaListado = (TextoPlanoLinea) linea;
    }

    @Override
    protected InformeLinea getLinea() {
        return lineaListado;
    }

    @Override
    protected String getTotalNombreInforme() {
        return "/es/cvjpy/InformadorJasper.jasper";
    }

    @Override
    protected TextoPlanoPro getProceso() throws Exception {
        if (informadorPro == null) {
            informadorPro = (TextoPlanoPro) getPrincipalPro().getProgramaServidor(TextoPlanoPro.class);
        }
        return informadorPro;
    }

    public void setNonmbreFicheroCobol(String este) throws Exception {
        getProceso().setNombreFicheroCobol(este);
    }

}

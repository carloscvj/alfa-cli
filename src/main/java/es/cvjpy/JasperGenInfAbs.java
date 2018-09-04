/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSwapFile;

/**
 *
 * @author carlos
 */
public abstract class JasperGenInfAbs extends GenInfCliAbs implements JasperGenInfPro {

    private Map parametrosInforme;

    private InputStream abrejasper() throws Exception {
        InputStream fs;
        fs = this.getClass().getResourceAsStream(getTotalNombreInforme());
        return fs;
    }

    protected Object nextReal() throws Exception {
        Object next = null;
        while (getProceso().hasNext()) {
            next = getProceso().next();
            if (next == null) {
                break;
            }
            String snext = next.toString();
            if (snext.startsWith("INFO:")) {
                Logger.getLogger(JasperGenInfAbs.class.getName()).log(Level.INFO, snext.substring(5));
                next=null;
                continue;
            }
            if (snext.startsWith("DEBUG:")) {
                Logger.getLogger(JasperGenInfAbs.class.getName()).log(Level.INFO, snext.substring(6));
                next = null;
                continue;
            }
            if (snext.startsWith("ERROR:")) {
                try {
                    throw new Exception(snext);
                } catch (Exception ex) {
                    Logger.getLogger(JasperGenInfAbs.class.getName()).log(Level.SEVERE, null, ex);
                }
                next = null;
                continue;
            }
            break;
        }
        return next;
    }

    protected abstract void procesarLinea(Object linea);

    protected abstract InformeLinea getLinea();

    protected abstract String getTotalNombreInforme();

    protected Map getParametrosInforme() {
        if (parametrosInforme == null) {
            parametrosInforme = new HashMap();
        }
        return parametrosInforme;
    }

    @SuppressWarnings("LoggerStringConcat")
    @Override
    public JasperPrint generaInforme() throws Exception {
        InputStream fs = abrejasper();
        JasperReport ja;
        ja = (JasperReport) JRLoader.loadObject(fs);

        String palTmp = System.getProperty("user.home", "./") + "/tmp";
        new File(palTmp).mkdirs();
        JRSwapFileVirtualizer virtu = new JRSwapFileVirtualizer(500, new JRSwapFile(palTmp + "/", 500, 10));
        
        //Esto debes ponerlo tú si te hace falta.
        //getParametrosInforme().put("REPORT_RESOURCE_BUNDLE", ResourceBundle.getBundle("literales"));
        //Y solo si te hace falta. En tu propia clase que extiende a ésta.
        
        getParametrosInforme().put("REPORT_VIRTUALIZER", virtu);
        getParametrosInforme().put("TITULO", getCabeceras().getTitulo());
        getParametrosInforme().put("EMISION", getCabeceras().getFechaEmision());

        return JasperFillManager.fillReport(ja, getParametrosInforme(), this);
    }

    @Override
    public boolean next() throws JRException {
        boolean ret = false;
        try {
            Object next = nextReal();
            if (next != null) {
                procesarLinea(next);
                ret = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JasperGenInfAbs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        String nombre = jrf.getName();
        Object valor = getLinea().getCampos().get(nombre);
        return valor;
    }
}

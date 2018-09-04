/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author CarlosVJ
 */
public interface JasperGenInfPro extends GenInfCliPro, JRDataSource {

    JasperPrint generaInforme() throws Exception;

}

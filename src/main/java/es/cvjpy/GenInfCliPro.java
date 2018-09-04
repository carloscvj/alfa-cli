/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

/**
 *
 * @author CarlosVJ
 * @param <COSA>
 */
public interface GenInfCliPro<COSA> extends GenCliPro<COSA> {

    CabeceraListado getCabeceras() throws Exception;

    void setCabeceras(CabeceraListado cabeceras) throws Exception;
}

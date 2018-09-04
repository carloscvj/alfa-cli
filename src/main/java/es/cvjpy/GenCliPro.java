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
public interface GenCliPro<COSA> extends CliPro {

    void preparado() throws Exception;

    boolean isEjecutando() throws Exception;
}

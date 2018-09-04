/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

/**
 *
 * @author carlos
 */
public interface PrincipalCliPro {

    String getBase();

    void setBase(String base);

    String getUsuarioRemoto();

    void setUsuarioRemoto(String userName);

    PrincipalPro getServidor();
}

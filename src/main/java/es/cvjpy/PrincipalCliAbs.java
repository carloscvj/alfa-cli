/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

/**
 *
 * @author carlos
 */
public abstract class PrincipalCliAbs implements PrincipalCliPro {

    @Override
    public String getBase() {
        return getServidor().getBase();
    }

    @Override
    public void setBase(String base) {
        getServidor().setBase(base);
    }

    @Override
    public String getUsuarioRemoto() {
        return getServidor().getUsuarioRemoto();
    }

    @Override
    public void setUsuarioRemoto(String userName) {
        getServidor().setUsuarioRemoto(userName);
    }
}

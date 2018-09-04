/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

/**
 *
 * @author carlos
 * @param <COSA>
 */
public abstract class GenCliAbs<COSA> extends CliAbs implements GenCliPro<COSA> {

    protected abstract GenPro<COSA> getProceso() throws Exception;
    
    @Override
    public void preparado() throws Exception {
        getProceso().preparado();
    }

    @Override
    public boolean isEjecutando() throws Exception {
        return getProceso().isEjecutando();
    }

    
}

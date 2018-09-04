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
public abstract class GenInfCliAbs<COSA> extends GenCliAbs<COSA> implements GenInfCliPro<COSA> {

    private CabeceraListado cabeceras;

    @Override
    protected abstract GenInfPro<COSA> getProceso() throws Exception;

    @Override
    public CabeceraListado getCabeceras() throws Exception {
        return cabeceras;
    }

    @Override
    public void setCabeceras(CabeceraListado cabeceras) throws Exception {
        this.cabeceras = cabeceras;
    }

    @Override
    public void preparado() throws Exception {
        super.preparado();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

/**
 *
 * @author carlos
 */
public abstract class ActInfCliAbs extends CliAbs implements ActInfCliPro {

    private CabeceraListado cabeceraListado;

    protected abstract CabeceraListado crearCabeceraListado();

    @Override
    public CabeceraListado getCabeceraListado() {
        if (cabeceraListado == null) {
            cabeceraListado = crearCabeceraListado();
        }
        return cabeceraListado;
    }

    @Override
    public void setCabeceraListado(CabeceraListado cabeceraListado) {
        this.cabeceraListado = cabeceraListado;
    }

}

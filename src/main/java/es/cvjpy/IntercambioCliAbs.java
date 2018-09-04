/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosVJ
 */
public class IntercambioCliAbs<COSA> implements InterCambioCliPro<COSA>, Serializable {

    private List<COSA> total;
    private List<COSA> origen;
    private List<COSA> destino;
    private List<COSA> origenSelected;
    private List<COSA> destinoSelected;

    public IntercambioCliAbs() {
    }

    @Override
    public List<COSA> getOrigen() {
        return origen;
    }

    @Override
    public void setOrigen(List<COSA> origen) {
        this.origen = origen;
    }

    @Override
    public List<COSA> getDestino() {
        return destino;
    }

    @Override
    public void setDestino(List<COSA> destino) {
        this.destino = destino;
    }

    @Override
    public List<COSA> getOrigenSelected() {
        return origenSelected;
    }

    @Override
    public void setOrigenSelected(List<COSA> origenSelected) {
        this.origenSelected = origenSelected;
    }

    @Override
    public List<COSA> getDestinoSelected() {
        return destinoSelected;
    }

    @Override
    public void setDestinoSelected(List<COSA> destinoSelected) {
        this.destinoSelected = destinoSelected;
    }

    @Override
    public void toDestino() {
        List<COSA> midestino = new ArrayList(this.getDestino());
        midestino.addAll(this.getOrigenSelected());
        this.setDestino(midestino);
        List<COSA> miorigen = new ArrayList();
        for (COSA uno : this.getOrigen()) {
            if (!this.getOrigenSelected().contains(uno)) {
                miorigen.add(uno);
            }
        }
        this.setOrigen(miorigen);
    }

    @Override
    public void toOrigen() {
        List<COSA> miorigen = new ArrayList(this.getOrigen());
        miorigen.addAll(this.getDestinoSelected());
        this.setOrigen(miorigen);
        List<COSA> midestino = new ArrayList();
        for (COSA uno : this.getDestino()) {
            if (!this.getDestinoSelected().contains(uno)) {
                midestino.add(uno);
            }
        }
        this.setDestino(midestino);
    }

    @Override
    public boolean isOriginable() {
        boolean ret = true;
        if (getOrigenSelected() == null || getOrigenSelected().isEmpty()) {
            ret = false;
        }
        return ret;
    }

    @Override
    public boolean isDestinable() {
        boolean ret = true;
        if (getDestinoSelected() == null || getDestinoSelected().isEmpty()) {
            ret = false;
        }
        return ret;
    }

    @Override
    public void inicial() {
        List<COSA> miorigen = new ArrayList();
        for (COSA uno : getTotal()) {
            boolean tiene = false;
            for (COSA esta : getDestino()) {
                if (uno.equals(esta)) {
                    tiene = true;
                    break;
                }
            }
            if (!tiene) {
                miorigen.add(uno);
            }
        }
        this.setOrigen(miorigen);
    }

    @Override
    public void setTotal(List<COSA> total) {
        this.total = total;
    }

    public List<COSA> getTotal() {
        return total;
    }
}

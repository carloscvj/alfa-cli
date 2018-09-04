/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.util.List;

/**
 *
 * @author CarlosVJ
 */
public interface InterCambioCliPro<SER> {

    void setTotal(List<SER> total);

    List<SER> getOrigen();

    List<SER> getDestino();

    void setOrigen(List<SER> origen);

    void setDestino(List<SER> destino);

    List<SER> getOrigenSelected();

    List<SER> getDestinoSelected();

    void setOrigenSelected(List<SER> origenSelected);

    void setDestinoSelected(List<SER> destinoSelected);

    void toDestino();

    void toOrigen();

    boolean isOriginable();

    boolean isDestinable();

    void inicial();
}

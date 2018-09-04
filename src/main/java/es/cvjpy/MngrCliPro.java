/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.util.List;

/**
 *
 * @author CarlosVJ
 * @param <COSA>
 */
public interface MngrCliPro<COSA> extends CliPro {

    List<Clasificado> getClasificaciones() throws Exception;

    void setClasificaciones(List<Clasificado> clasificarLista);

    Clasificado getClasificarPorSelected() throws Exception;

    void setClasificarPorSelected(Clasificado clasificar);

    String getBuscar();

    void setBuscar(String buscar);

    void paginaPrimera();

    void paginaAnterior();

    void paginaSiguiente();

    void paginaUltima();

    List<COSA> getLista() throws Exception;

    void setLista(List<COSA> lista);

    void relista();

    COSA getLineaSelected();

    void setLineaSelected(COSA lineaSelected);

    List<COSA> getVariasLineasSelected();

    void setVariasLineasSelected(List<COSA> lineaVariosSelected);

    boolean isLineaCogida();

    boolean isVariasLineasCogidas();

    void selecciona();

    ;
    COSA getEntidad(Object id) throws Exception;

    ;
    void primero();

    void anterior();

    void siguiente();

    void ultimo();

    void nuevo();

    boolean isNuevo() throws Exception;

    void setNuevo(boolean nuevo) throws Exception;

    COSA getActual();

    void setActual(COSA actual);

    void guardar() throws Exception;

    void borrar() throws Exception;

    void keyCambiada();
}

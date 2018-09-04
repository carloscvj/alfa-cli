/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

/**
 *
 * @author carlos
 */
public abstract class CliAbs implements CliPro {

    private PrincipalPro principalSrv;

    @Override
    public PrincipalPro getPrincipalPro() {
        return principalSrv;
    }

    @Override
    public void setPrincipalPro(PrincipalPro principalSrv) {
        this.principalSrv = principalSrv;
    }

}

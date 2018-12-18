/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturador.comportamental;

import facturador.creacional.ComprobanteElectronico;

/**
 *
 * @author Israel
 */
public class AutorizadorSRI {

    private Esquema autorizacion;
    
    public AutorizadorSRI(Esquema esquema_de_autorizacion){
    
        this.autorizacion = esquema_de_autorizacion;
    }
    
    
    public void autorizar(ComprobanteElectronico comprobante){

    
        autorizacion.autorizar(comprobante);
    }
}

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
    private final Esquema esquema;
    public AutorizadorSRI(Esquema esquema){
        this.esquema=esquema;
    
    
    }
    
    
    public void Autorizar(ComprobanteElectronico comprobante){
        esquema.autorizar(comprobante);
   
    }
    
}

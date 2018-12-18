/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturador.estructural;

import facturador.creacional.ComprobanteElectronico;
import java.util.List;

/**
 *
 * @author Israel
 */
public class FooterDecorator extends DetalleDecorator{
    ComprobanteElectronico comprobante;
    public FooterDecorator() {
        
    }

    public FooterDecorator(ComprobanteElectronico comprobante) {
        this.comprobante = comprobante;
    }
   
    
}

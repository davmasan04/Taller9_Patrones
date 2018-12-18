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
public class DetalleDecorator {
     ComprobanteElectronico comprobante;
    public DetalleDecorator() {
        
    }

    public DetalleDecorator(ComprobanteElectronico comprobante) {
        this.comprobante = comprobante;
    }
    
    public List<String> getDetallesEmisor(){
   return comprobante.getDetallesEmisor();}
    
    public ComprobanteElectronico getComprobante(){
        return comprobante;
    
    }
    
    
    
    
}

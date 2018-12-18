/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturador.comportamental;

import facturador.creacional.ComprobanteElectronico;
import java.util.Objects;

/**
 *
 * @author Israel
 */
public class EsquemaOnline implements Esquema {

   

    @Override
    public void autorizar(ComprobanteElectronico comprobante) {
        long codigo=comprobante.getCodigo();
        String cod= Objects.toString(codigo,null);
         comprobante.setNumeroAutorizacion(cod); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador;

import facturador.comportamental.AutorizadorSRI;
import facturador.comportamental.EsquemaOffline;
import facturador.comportamental.EsquemaOnline;
import facturador.creacional.ComprobanteElectronico;
import facturador.creacional.ComprobantesFactory;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USER
 */
public class INTEGRADOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ComprobantesFactory factory = new ComprobantesFactory();
        ComprobanteElectronico comprobante = factory.getComprobante("FACTURA");
        comprobante.setClaveAcceso("0951479823");
        comprobante.setCodigo(90000);
        ArrayList<String> detalles = new ArrayList<>();
        detalles.add("0991225869");
        detalles.add("efrenpar@espol.edu.ec");
        comprobante.setDetallesEmisor(detalles);
        LocalDate date = LocalDate.of(2018, Month.DECEMBER, 17);
        comprobante.setFecha(date);
        comprobante.setNombreCliente("Efren");
        AutorizadorSRI sri = new AutorizadorSRI(new EsquemaOffline());
        sri.autorizar(comprobante);
        System.out.println(comprobante.toString());
    }
    
}

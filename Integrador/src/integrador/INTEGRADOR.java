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
import facturador.creacional.Factura;
import facturador.creacional.GuiaRemision;
import facturador.creacional.NotaCredito;
import facturador.estructural.DetalleDecorator;
import facturador.estructural.LogoDecorator;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

import facturador.comportamental.*;
import facturador.creacional.*;
import facturador.estructural.FooterDecorator;
import java.time.*;
import java.util.*;


/**
 *
 * @author USER
 */
public class INTEGRADOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //FACTURA
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
        
        Factura factura = (Factura)comprobante;
        factura.setTotal(20.00);
        ArrayList<String> productos = new ArrayList<>();
        productos.add("carro");
        productos.add("mesa");
        factura.setProductos(productos);
        System.out.println(factura.toString());
        
        AutorizadorSRI online = new AutorizadorSRI(new EsquemaOnline());
        AutorizadorSRI offline = new AutorizadorSRI(new EsquemaOffline());
        offline.autorizar(comprobante);
        
        
        //GUIA DE REMISION
        ComprobanteElectronico comprobanteRemision= factory.getComprobante("NOTADECREDITO");
         comprobanteRemision.setClaveAcceso("0951479823");
         comprobanteRemision.setNumeroAutorizacion("2001002");
         comprobanteRemision.setCodigo(10000);
         comprobanteRemision.setFecha(LocalDate.of(2018, Month.DECEMBER, 17));
         comprobanteRemision.setDetallesEmisor(detalles);
           GuiaRemision guia=(GuiaRemision) comprobanteRemision;
        
         online.autorizar(guia);
        
        
        //NOTADECREDITO
         ComprobanteElectronico comprobanteNota = factory.getComprobante("NOTACREDITO");
         comprobanteNota.setClaveAcceso("0951479823");
         comprobanteNota.setNumeroAutorizacion("2001002");
         comprobanteNota.setCodigo(10000);
         comprobanteNota.setFecha(LocalDate.of(2018, Month.DECEMBER, 17));
         comprobanteNota.setDetallesEmisor(detalles);
         NotaCredito nota=(NotaCredito) comprobanteNota;
         nota.setDetalleModificacion("nuevos detalles");
         offline.autorizar(nota);
         
         
         System.out.println("Decorando");
         comprobanteNota= new LogoDecorator(comprobanteNota);
         System.out.println(comprobanteNota);
         comprobanteRemision= new FooterDecorator(comprobanteRemision);
         System.out.println(comprobanteRemision);
         
         
    }
    
}

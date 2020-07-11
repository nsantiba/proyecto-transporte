/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_pago;

import actores.*;
import extras.Solicitar;

/**
 *
 * @author Eddy Santibañez J
 * Esta clase definie la cuenta bancaria 
 */
public class CuentaBancaria {
    Charger charger; 
    double saldo; 
    String banco; 



    public CuentaBancaria( String banco){
        this.banco= banco;
        saldo=0; 
    }
    
    public void generarOrdendePago(double valor){
        saldo= saldo+valor; 
    }

    
    

   
 
}


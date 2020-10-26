/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorias;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author clases
 */
public class Animal {
    int edad;
    String nacimiento;

    public Animal(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        nacimiento = dtf.format(LocalDateTime.now()); 
    }
    
    public Animal(String nacimiento){  
        this.nacimiento = nacimiento; 
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
   
   
    
    
}

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

    private int edad;
    private String nombre;
    private String nacimiento;

    public Animal() {
        initial();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        nacimiento = dtf.format(LocalDateTime.now());
    }

    public Animal(String nacimiento) {
        initial();
        this.nacimiento = nacimiento;
    }
    
    public Animal(String nacimiento, String fechaVacunacion) {
        initial();
        this.nacimiento = nacimiento;
    }
    
    private void initial(){
        edad = 10;
        nombre = "NN";
    }

    int getEdad() {
        return edad;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    @Override
    public String toString(){
        return nombre +" con edad: "+edad+" y nacimiento: "+nacimiento ;
    }
    
    public String toString(int a, int b, int c, int d){
        return a+b+c+d+"+";
    }
    
}



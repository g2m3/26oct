
package presentaciones;

public class Ejecutar {
 
    public static void main(String[] args) {
        System.out.println("pryev");
        
        Gato pandora = new Gato();
        pandora.dormir();
        
        Tiburon tobby = new Tiburon();
        tobby.dormir();
        System.out.println("Todo tu grupo animal hace sonidos?: " + tobby.sonidoAnimalTodos());
        Murcielago batman = new Murcielago();
        batman.dormir();
        batman.volar();
    } 
}

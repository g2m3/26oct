package presentaciones;

public class Automovil extends Vehiculo {

    public Automovil(int pasajeros, double velocidad) {
        super(pasajeros, velocidad);
    }

    @Override
    public void pintar(int posicion) {
        espacios(posicion + 4);
        System.out.println("_____");
        espacios(posicion + 1);
        System.out.println("__/__|__\\\\___");
        espacios(posicion);
        System.out.println("|_ _____ __|");
        espacios(posicion);
        System.out.println(" O O");
    }
}

package presentaciones;

public class Carga extends Vehiculo {
    protected int capacidad;
    protected Object carga;

    public Carga(int pasa, double vel, int peso) {
        super(pasa, vel);
        capacidad = peso;
    }

    @Override
    public void pintar(int posicion) {
        
    }

    public boolean llevar(int p) {
        int k = 1;
        for (int i = 0; i < this.capacidad; i++) {
            k *= 10;
        }
        if (p < k) {
            this.carga = p;
            return true;
        } else {
            return false;
        }
    }

    public boolean llevar(String p) {
        //
        //
        
        
        //
        
        //
        
        return false;
    }
}

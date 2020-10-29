package presentaciones;

public abstract class Oviparo implements Animal{

    @Override
    public boolean sonidoAnimalTodos() {
        return false;
    }
    
    public void ponerHuevos() {        
        System.out.println("implementación larguísima ponerHuevos!!");
    }
    
    
}
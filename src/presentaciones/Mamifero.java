package presentaciones;

public abstract class Mamifero implements Animal{
    @Override
    public boolean sonidoAnimalTodos() {
        return true;
    }
    
    public void amamantar() {
        System.out.println("implementación larguísima amamantar!!");
    }    
}

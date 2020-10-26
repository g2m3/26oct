package monitorias;
import java.util.Scanner;

public class Monitoria {  
    public static void main(String[] args) {
        
        Animal canela = new Animal("2020/10/23");
        Animal rufus = new Animal();
        System.out.println("Nacimiento de Rufus: " + rufus.getNacimiento());
        System.out.println("Nacimiento de Canela: " + canela.getNacimiento());
    }    
    
    public static void probar(){
        char[][] triki = new char[3][3];       
        
        for(int i=0;i<triki.length;i++)
            for(int j=0;j<triki[i].length;j++)
                triki[i][j]='a';
        
    }
    
    static void show(String[] x){
        for(int i = 0; i<x.length; i++)
            System.out.println("Valor en la posición: "+i+"-> " + x[i]);
    }
}

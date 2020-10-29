package monitorias;

public class Monitoria {  
       
    
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
    
    
    public static int diferencia(String a, String b) {
        int cuenta = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public static String relacion(String a, String b, int p, int f) {
        int d = diferencia(a, b);
        if (d <= p)
            return "Padre-Hijo";
        if (d <= f)
            return "Familia";
        return "Ninguna";
        
    }
}

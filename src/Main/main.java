package Main;

import Corredor.corredor;
import java.util.concurrent.Semaphore;

public class main {
       
    public static void main(String []args){
        int permissoes = 1;
        
        Semaphore semaforo = new Semaphore(permissoes);
        
        for(int i=1; i<=4;i++){
            corredor c = new corredor(i, semaforo);
            c.start();
        }  
    }
}
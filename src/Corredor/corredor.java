package Corredor;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class corredor extends Thread{
   
    int pessoaid;
    int corredor = 200;
    private Semaphore semaforo;
    
    public corredor(int i, Semaphore semaforo){
        this.pessoaid = i;
        this.semaforo = semaforo;
    }
    
    @Override
    public void run(){
        caminhar();  
    }  
    
    private void caminhar(){
        int andar = (int) ((Math.random()+1)*4);
        
        while(andar<corredor){
           try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
               // TODO Auto-generated catch block
	    }
           andar+=andar;
        }
        System.out.println("A pessoa "+pessoaid+" andou "+andar+" metros e irá abrir a porta!");
        AbrirPorta();
    } 
    private void AbrirPorta(){
        try {
            semaforo.acquire();
            System.out.println("A pessoa "+pessoaid+" abriu a porta!");
        } catch (InterruptedException ex) {
            Logger.getLogger(corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        semaforo.release();
        }
        }
    }


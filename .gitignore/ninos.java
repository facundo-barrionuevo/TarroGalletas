

package tarrogalletas;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class ninos extends Thread{
private Semaphore HayGalletas;
private Semaphore NOHayGalletas;
private AtomicInteger galletas;
int numeronino;

public ninos(Semaphore HayGalletas, Semaphore NOHayGalletas, AtomicInteger galletas, int num){
this.HayGalletas=HayGalletas;
this.NOHayGalletas=NOHayGalletas;
this.galletas=galletas;
this.numeronino =  num;
}

public void run(){
    int random;
    try{
    while(true){
    HayGalletas.acquire(); //comprobacion de galletas de a 1, evitar falsa lectura.
    if(galletas.get()==0){//Si no hay galletas...
        NOHayGalletas.release(); //Desbloquea a la madre para que rellene
        HayGalletas.acquire();//Espera a que la madre rellene para continuar
        System.out.println(galletas + " asuidaibhia");
    }
        
        galletas.getAndDecrement();//una galleta menos
        System.out.println("niño numero: " + this.numeronino + " deja: " + galletas);
        random = (int)(Math.random()*(500-300))+0;
        HayGalletas.release();//Dejo que otro niño intente tomar una galleta (signal
        this.sleep(random);
        this.yield();
    }
    }catch(InterruptedException e){
            
    }
}
}

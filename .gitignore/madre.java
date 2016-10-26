package tarrogalletas;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class madre extends Thread{
private Semaphore HayGalletas;
private Semaphore NOHayGalletas;
private AtomicInteger galletas;
int n;

public madre(Semaphore HayGalletas,Semaphore NOHayGalletas, AtomicInteger galletas,int n){
    this.NOHayGalletas=NOHayGalletas;
    this.HayGalletas=HayGalletas;
    this.galletas=galletas;
    this.n=n;
}

public void run() {
    try{
    while(true){//La madre siempre estara esperando para reponer el tarro
    NOHayGalletas.acquire(); //Aquı se bloquea por que el semaforo "NoHayGalletas" (0)
    galletas.set(n);//Relleno el tarro de galletas
    HayGalletas.release();//Aviso que hay galletas poniendo en 1 el semaforo "HayGalleta
    }
    }catch(InterruptedException e){
            
    }
}
}
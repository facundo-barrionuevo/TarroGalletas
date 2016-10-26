package tarrogalletas;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class TarroGalletas {
public TarroGalletas(){
    
}

public static void main (String[] args) {
    AtomicInteger galletas= new AtomicInteger(10);
    Semaphore NoHayGalletas = new Semaphore(0);
    Semaphore HayGalletas = new Semaphore(1);
    ninos n1 = new ninos(HayGalletas, NoHayGalletas, galletas, 1);
    ninos n2 = new ninos(HayGalletas, NoHayGalletas, galletas, 2);
    ninos n3 = new ninos(HayGalletas, NoHayGalletas, galletas, 3);
    madre m= new madre(HayGalletas, NoHayGalletas, galletas, 10);

    n1.start();n2.start();n3.start();m.start();
}

}
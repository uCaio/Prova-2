public class RecursoCompartilhado {
    private int leitores = 0; 
    private boolean escrevendo = false;  
    private final Object lock = new Object();  

    public void iniciarLeitura(int idLeitor) {
        synchronized (lock) {
            try {
                while (escrevendo) {
                    System.out.println("Leitor " + idLeitor + " aguardando para ler...");
                    lock.wait(); 
                }
                leitores++;  
                System.out.println("Leitor " + idLeitor + " está lendo.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public void terminarLeitura(int idLeitor) {
        synchronized (lock) {
            leitores--; 
            System.out.println("Leitor " + idLeitor + " terminou de ler.");
            if (leitores == 0) {
                lock.notifyAll();  
            }
        }
    }
    public void iniciarEscrita(int idEscritor) {
        synchronized (lock) {
            try {
                while (leitores > 0 || escrevendo) {
                    System.out.println("Escritor " + idEscritor + " aguardando para escrever...");
                    lock.wait(); 
                }
                escrevendo = true;  
                System.out.println("Escritor " + idEscritor + " está escrevendo.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public void terminarEscrita(int idEscritor) {
        synchronized (lock) {
            escrevendo = false;  
            System.out.println("Escritor " + idEscritor + " terminou de escrever.");
            lock.notifyAll(); 
        }
    }
}

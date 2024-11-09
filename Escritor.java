public class Escritor extends Thread {
    private final RecursoCompartilhado recurso;
    private final int idEscritor;

    public Escritor(RecursoCompartilhado recurso, int idEscritor) {
        this.recurso = recurso;
        this.idEscritor = idEscritor;
    }

    @Override
    public void run() {
        try {
            recurso.iniciarEscrita(idEscritor);
            Thread.sleep(1000);
            recurso.terminarEscrita(idEscritor);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

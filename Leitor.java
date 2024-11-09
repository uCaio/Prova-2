public class Leitor extends Thread {
    private final RecursoCompartilhado recurso;
    private final int idLeitor;

    public Leitor(RecursoCompartilhado recurso, int idLeitor) {
        this.recurso = recurso;
        this.idLeitor = idLeitor;
    }

    @Override
    public void run() {
        try {
            recurso.iniciarLeitura(idLeitor);
            Thread.sleep(1000);
            recurso.terminarLeitura(idLeitor);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

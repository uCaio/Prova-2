public class Main {
    public static void main(String[] args) {
        RecursoCompartilhado recurso = new RecursoCompartilhado();

        Thread leitor1 = new Leitor(recurso, 1);
        Thread leitor2 = new Leitor(recurso, 2);

        Thread escritor1 = new Escritor(recurso, 1);
        Thread escritor2 = new Escritor(recurso, 2);

        leitor1.start();
        leitor2.start();
       
        escritor1.start();
        escritor2.start();
    }
}

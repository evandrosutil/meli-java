package pratica;

public class PraticaExcecoes {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int razao;

        try {
            razao = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Não pode ser divido por zero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}

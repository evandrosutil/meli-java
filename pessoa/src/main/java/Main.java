public class Main {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();
        Pessoa adroaldo = new Pessoa("Adroaldo Furtado", 32, "ADRLD0320");
        Pessoa emilia = new Pessoa("Emilia da Silva", 33, "EMLSL0330", 59.4, 1.65);

        int imc = emilia.calcularIMC();
        boolean maioridade = emilia.ehMaiorIdade();
        String weightLvl;

        if (imc == -1) {
            weightLvl = "Abaixo do peso";
        } else if (imc == 0) {
            weightLvl = "Peso saudável";
        } else weightLvl = "Sobrepeso";

        String ageLvl = (maioridade) ? "É maior de idade": "É menor de idade";

        System.out.println(emilia.toString());
        System.out.println("Análise de idade: ".concat(ageLvl));
        System.out.println("Análise IMC: ".concat(weightLvl));
    }
}

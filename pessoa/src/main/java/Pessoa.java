import java.lang.Math;

public class Pessoa {
    private String name;
    private Integer age;
    private String ID;
    private Double weight;
    private Double height;

    public Pessoa() {}

    public Pessoa(String name, Integer age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public Pessoa(String name, Integer age, String ID, Double weight, Double height) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.weight = weight;
        this.height = height;
    }

    public int calcularIMC() {
        double imc = weight / Math.pow(height, 2);
        if (imc < 20)
            return -1;
        else if (imc > 25)
            return 1;
        return 0;
    }

    public Boolean ehMaiorIdade() {
        return age >= 18;
    }

    @Override
    public String toString() {
        String msg = String.format("(%s) %s, %d anos", ID, name, age);
        if (weight != null)
            msg = msg.concat(String.format(", %.2f quilos", weight));
        if (height != null)
            msg = msg.concat(String.format(" e %.2f metros de altura", height));
        msg = msg.concat(".");
        return msg;
    }
}

package product;

import java.math.BigDecimal;

public class NonPerishable extends Product {
    private String tipo;

    public NonPerishable(String name, BigDecimal price, String tipo) {
        super(name, price);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString().concat(" - tipo: ").concat(tipo);
    }
}

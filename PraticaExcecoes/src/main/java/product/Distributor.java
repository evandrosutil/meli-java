package product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Distributor {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Perishable("Maça", BigDecimal.valueOf(4.23), 2));
        products.add(new Perishable("Leite", BigDecimal.valueOf(3.15), 3));
        products.add(new Perishable("Coentro", BigDecimal.valueOf(2.75), 1));
        products.add(new NonPerishable("Pipoca", BigDecimal.valueOf(5.00), "despensa"));
        products.add(new NonPerishable("Farinha de trigo", BigDecimal.valueOf(4.50), "despensa"));
        products.add(new NonPerishable("Lentilha", BigDecimal.valueOf(6.45), "grãos"));

        BigDecimal totalPrice = new BigDecimal("0");
        for (Product product:
             products) {
            totalPrice = totalPrice.add(product.calcTotalPrice(5));
        }

        System.out.printf("Preço total da compra foi de R$ %.2f", totalPrice);
    }
}

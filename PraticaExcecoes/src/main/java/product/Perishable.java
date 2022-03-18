package product;

import java.math.BigDecimal;

public class Perishable extends Product{
    private Integer daysToExpire;

    public Perishable(String name, BigDecimal price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public Integer getExpirationDate() {
        return daysToExpire;
    }

    public void setExpirationDate(Integer daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public BigDecimal calcTotalPrice(int quantity) {
        BigDecimal price = new BigDecimal(getPrice().toString());
        BigDecimal divisor;
        if (daysToExpire.equals(1)) {
            divisor = new BigDecimal("4");
        } else if (daysToExpire.equals(2)) {
            divisor = new BigDecimal("3");
        } else if (daysToExpire.equals(3)) {
            divisor = new BigDecimal("2");
        } else divisor = new BigDecimal("1");

        return price.divide(divisor);

    }
    @Override
    public String toString() {
        String days = (daysToExpire.equals(1)) ? "dia": "dias";
        return super.toString().concat(String.format(" - %d %s para o vencimento", daysToExpire, days));
    }
}

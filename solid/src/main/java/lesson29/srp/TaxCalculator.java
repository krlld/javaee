package lesson29.srp;

import java.math.BigDecimal;

public class TaxCalculator {

    private static final BigDecimal TAX = new BigDecimal("0.2");

    public BigDecimal calculateTax(Product product) {
        BigDecimal price = product.getPrice();
        return price.add(price.multiply(TAX));
    }
}

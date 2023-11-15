package srp;

import lesson29.srp.Product;
import lesson29.srp.TaxCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @BeforeEach
    public void refreshTaxCalculator() {
        taxCalculator = new TaxCalculator();
    }

    @Test
    public void calculateTaxTest() {
        Product product = Product.builder()
                .id(1L)
                .name("Table")
                .price(new BigDecimal("1000"))
                .build();
        Assertions.assertEquals(new BigDecimal("1200.0"), taxCalculator.calculateTax(product));
    }
}

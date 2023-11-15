package ocp;

import lesson29.ocp.Json;
import lesson29.ocp.Printer;
import lesson29.ocp.Xml;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrinterTest {

    private Printer printer;

    @BeforeEach
    public void refreshPrinter() {
        printer = new Printer();
    }

    @Test
    public void getTextTest_returnJson() {
        Json json = new Json();
        Assertions.assertEquals("It's json file", printer.getText(json));
    }

    @Test
    public void getTextTest_returnXml() {
        Xml xml = new Xml();
        Assertions.assertEquals("It's xml file", printer.getText(xml));
    }
}

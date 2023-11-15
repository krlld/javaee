package lesson29.lsp;

public class Converter {

    public String ConvertToString(Object object) {
        return object == null ? "" : object.toString();
    }
}

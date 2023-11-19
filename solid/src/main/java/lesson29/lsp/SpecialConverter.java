package lesson29.lsp;

public class SpecialConverter extends Converter {

    // Mistake
    @Override
    public String ConvertToString(Object object) {
        return object.toString();
    }
}

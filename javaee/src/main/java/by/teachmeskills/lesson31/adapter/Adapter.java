package by.teachmeskills.lesson31.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Adapter implements XmlClient {

    private final JsonService jsonService;

    @Override
    public void method(Xml xml) {
        Json json = convertToJson(xml);
        jsonService.serviceMethod(json);
    }

    protected Json convertToJson(Xml xml) {
        // some logic
        return new Json();
    }
}

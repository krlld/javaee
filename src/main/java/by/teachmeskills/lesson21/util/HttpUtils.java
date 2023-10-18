package by.teachmeskills.lesson21.util;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpUtils {
    public static Map<String, String> parseUriQueryParams(String queryParam) {
        String[] params = queryParam.split("&");
        return Arrays.stream(params)
                .map(param -> param.split("="))
                .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
    }
}

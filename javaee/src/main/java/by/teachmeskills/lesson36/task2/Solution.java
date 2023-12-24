package by.teachmeskills.lesson36.task2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//  Задача 2:
//  На вход поступает массив непустых строк, создайте и верните Map<String,
//  String> следующим образом: для каждой строки добавьте ее первый символ в
//  качестве ключа с последним символом в качестве значения. Пример:
//  pairs(["code", "bug"]) → {"b": "g", "c": "e"}
//  pairs(["man", "moon", "main"]) → {"m": "n"}
//  pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pair(new String[]{"code", "bug"}));
        System.out.println(solution.pair(new String[]{"man", "moon", "main"}));
        System.out.println(solution.pair(new String[]{"man", "moon", "good", "night"}));
    }

    public Map<String, String> pair(String[] strings) {
        return Arrays.stream(strings)
                .collect(Collectors.toMap(s -> String.valueOf(s.charAt(0)),
                        s -> String.valueOf(s.charAt(s.length() - 1)),
                        (oldValue, newValue) -> newValue));
    }
}

package by.teachmeskills.lesson36.task1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//  Задача 1:
//  На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
//  строка является ключом, и ее значение равно true, если эта строка встречается в массиве
//  2 или более раз. Пример:
//  wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
//  wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
//  wordMultiple(["c", "c", "c", "c"]) → {"c": true}
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(solution.wordMultiple(new String[]{"c", "b", "a"}));
        System.out.println(solution.wordMultiple(new String[]{"c", "c", "c", "c"}));
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
        return Arrays.stream(strings)
                .collect(Collectors.toMap(s -> s, s -> false, (oldValue, newValue) -> true));
    }
}

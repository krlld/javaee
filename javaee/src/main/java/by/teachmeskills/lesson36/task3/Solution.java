package by.teachmeskills.lesson36.task3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

//  Задача *:
//  Задана строка, которая может иметь внутри себя скобки. Скобкой считается
//  любой из следующих символов — «(«, «)», «[«, «]», «{«, «}». Проверить
//  сбалансированность расстановки скобок в этой строке. Набор скобок считается
//  сбалансированной парой, если открывающая скобка "(", "[" и "{" стоит слева от
//  соответствующей закрывающей скобки ")", "]" и "} ", соответственно. Строка,
//  содержащая пары скобок, не сбалансирована, если набор заключенных в нее
//  скобок не совпадает .
//  Например, если ввод «{[(])}», пара квадратных скобок «[]» заключает в себя
//  одну несбалансированную открывающую круглую скобку «(». Аналогично, пара
//  круглых скобок «() ", заключает в себя одну несбалансированную
//  закрывающую квадратную скобку "]". Таким образом, входная строка "{[(])}"
//  несбалансированная.
//  Пример
//  () - сбалансирована
//  [()] - сбалансирована
//  {[()]} - сбалансирована
//  ([{{[(())]}}]) - сбалансирована
//  {{[]()}}}} - не сбалансирована
//  {[(])} - не сбалансирована
public class Solution {

    private final Map<Character, Character> closedOpenBrackets = Map.of(')', '(', '}', '{', ']', '[');

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced("()"));
        System.out.println(solution.isBalanced("[()]"));
        System.out.println(solution.isBalanced("{[()]}"));
        System.out.println(solution.isBalanced("([{{[(())]}}])"));
        System.out.println(solution.isBalanced("{{[]()}}}}"));
        System.out.println(solution.isBalanced("{[(])}"));
    }

    public boolean isBalanced(String string) {
        Deque<Character> deque = new ArrayDeque<>();
        for (Character c : string.toCharArray()) {
            if (closedOpenBrackets.containsValue(c)) {
                deque.push(c);
                continue;
            }
            if (closedOpenBrackets.containsKey(c)) {
                if (deque.isEmpty() || !closedOpenBrackets.get(c).equals(deque.pop())) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}

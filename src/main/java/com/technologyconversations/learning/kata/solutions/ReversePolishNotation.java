package com.technologyconversations.learning.kata.solutions;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.*;

public class ReversePolishNotation {

    public static Double calc(String input) {
        Stack<Double> numbers = new Stack<>();
        Arrays.asList(input.split(" ")).stream().forEach(number -> {
            switch(number) {
                case "+":
                    calcSign(numbers, (num1, num2) -> { return num2 + num1; });
                    break;
                case "-":
                    calcSign(numbers, (num1, num2) -> { return num2 - num1; });
                    break;
                case "*":
                    calcSign(numbers, (num1, num2) -> { return num2 * num1; });
                    break;
                case "/":
                    calcSign(numbers, (num1, num2) -> { return num2 / num1; });
                    break;
                default:
                    numbers.push(Double.parseDouble(number));
            }
        });
        return numbers.pop();
    }

    public static Stack<Double> calcSign(Stack<Double> numbers, BiFunction<Double, Double, Double> operation) {
        numbers.push(operation.apply(numbers.pop(), numbers.pop()));
        return numbers;
    }

}

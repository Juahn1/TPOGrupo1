package org.adt.core.adt.TPOpuntos;

import java.util.Stack;

public class BalancedParentheses {
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(' && !isInsideSingleQuotes(expression, i)) {
                stack.push(currentChar);
            } else if (currentChar == ')' && !isInsideSingleQuotes(expression, i)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isInsideSingleQuotes(String expression, int index) {
        int countSingleQuotes = 0;
        for (int i = 0; i < index; i++) {
            if (expression.charAt(i) == '\'') {
                countSingleQuotes++;
            }
        }
        return countSingleQuotes % 2 != 0;
    }

    public static void main(String[] args) {
        String expression1 = "((2 + 3) * (5 - 4))'())))))))))'"; // Balanced parentheses
        String expression2 = "(((3 + 4) * 2)"; // Unbalanced parentheses
        String expression3 = "((2 + 3) * ')(5 - 4)')"; // Balanced parentheses (ignoring quotes)

        boolean isExpression1Balanced = areParenthesesBalanced(expression1);
        boolean isExpression2Balanced = areParenthesesBalanced(expression2);
        boolean isExpression3Balanced = areParenthesesBalanced(expression3);

        System.out.println("la expresion1 esta balanceada: " + isExpression1Balanced);
        System.out.println("la expresion2 esta balanceada: " + isExpression2Balanced);
        System.out.println("la expresion3 esta balanceada: " + isExpression3Balanced);
    }
    }


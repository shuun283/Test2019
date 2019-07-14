package shuTenho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Operation {

    private static double parsePostfix(List<String> postfix) {
        for (int i = 0; i < postfix.size(); i++) {
            String word = postfix.get(i);
            if (Operator.isSymbol(word)) {
                double n1 = Double.parseDouble(postfix.get(i - 1));
                double n2 = Double.parseDouble(postfix.get(i - 2));
                double result = 0;
                Operator symbol = Operator.value(word);
                switch (symbol) {
                case ADD:
                    result = n1 + n2;
                    break;
                case SUBTRACT:
                    result = n2 - n1;
                    break;
                case MULTIPLY:
                    result = n1 * n2;
                    break;
                case DIVIDE:
                    result = n2 / n1;
                    break;
                default:
                    break;
                }
                postfix.set(i, String.valueOf(result));
                postfix.remove(i - 1);
                postfix.remove(i - 2);
                break;
            }
        }
        if (postfix.size() == 1) {
            return Double.parseDouble(postfix.get(0));
        }
        return parsePostfix(postfix);
    }

    private static List<String> infix2Postfix(List<String> infix) {
        List<String> postfix = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (String word : infix) {
            if (Operator.isSymbol(word)) {
                if (stack.empty()) {
                    stack.push(word);
                } else {
                    Operator symbol1 = Operator.value(stack.peek());
                    Operator symbol2 = Operator.value(word);
                    if (symbol2 == Operator.CLOSE) {
                        while (!stack.empty()) {
                            String pop = stack.pop();
                            if (pop.charAt(0) == Operator.OPEN.getSymbol()) {
                                break;
                            } else {
                                postfix.add(pop);
                            }
                        }
                    } else if (symbol1.comparedTo(symbol2)) {
                        postfix.add(stack.pop());
                        stack.push(word);
                    } else {
                        stack.push(word);
                    }
                }
            } else {
                postfix.add(word);
            }
        }
        while (!stack.empty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }
    private static List<String> expr2Infix(String expr){
        Objects.requireNonNull(expr);
        Pattern pattern_expr = Pattern.compile("(\\(|\\)|\\+|\\-|\\*|/|\\d+(\\.\\d+)?)");
        Matcher matcher = pattern_expr.matcher(expr);
        List<String> exprs = new ArrayList<String>();
        while(matcher.find()) {
          exprs.add(matcher.group(1));
        }
        return exprs;
    }

    public static double eval(String expression) {
        return parsePostfix(infix2Postfix(expr2Infix(expression)));
    }

    /**
     * 运算符
     * 
     * @author Administrator
     *
     */
    static enum Operator {
        ADD('+', 0), SUBTRACT('-', 0), MULTIPLY('*', 1), DIVIDE('/', 1), OPEN('(', 2), CLOSE(')', 2);
        /**
         * 运算符号
         */
        char symbol;
        /**
         * 优先级
         */
        int priority;

        Operator(char symbol, int priority) {
            this.symbol = symbol;
            this.priority = priority;
        }

        public char getSymbol() {
            return symbol;
        }

        /**
         * 优先级比较
         * 
         * @param oper
         * @return
         */
        public boolean comparedTo(Operator oper) {
            if (this == OPEN || this == CLOSE) {
                return false;
            }
            return this.priority >= oper.priority;
        }

        /**
         * 判断是否是运算符号
         * 
         * @param symbol
         * @return
         */
        public static boolean isSymbol(String symbol) {
            Objects.requireNonNull(symbol);
            if (symbol.length() > 1) {
                return false;
            }
            return isSymbol(symbol.charAt(0));
        }

        /**
         * 判断是否是运算符号
         * 
         * @param symbol
         * @return
         */
        public static boolean isSymbol(char symbol) {
            for (Operator oper : values()) {
                if (symbol == oper.symbol) {
                    return true;
                }
            }
            return false;
        }

        public static Operator value(String symbol) {
            if (symbol == null || symbol.length() > 1) {
                throw new IllegalArgumentException(symbol);
            }
            return value(symbol.charAt(0));
        }

        public static Operator value(char symbol) {
            for (Operator oper : values()) {
                if (symbol == oper.symbol) {
                    return oper;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        String expression = "500/0";
        System.out.println(eval(expression));
    }
}
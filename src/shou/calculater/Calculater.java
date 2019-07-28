package shou.calculater;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculater {

	// 式
	private String expression;

	// コンストラクタ
	private Map<String, Integer> map = new HashMap<>();
	public Calculater(String expression) {
	        map.put("+", 0);
	        map.put("-", 0);
	        map.put("*", 1);
	        map.put("/", 1);
	        map.put("(", -1);
	        map.put(")", -1);
	        map.put("#", -2); 
	        this.expression = expression;
	    }

	// 式の正確性を確認
	private void check() throws FormatException {
		// 括弧の正確性に確認
		Stack<Character> brackets = new Stack<>();
		char lastChar = ' ';
		char[] chars = expression.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
			case '(':				
				brackets.push(chars[i]);
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				lastChar = chars[i];
				break;
			case '0':
				if (lastChar == '/')
					throw new FormatException("０は割れません、もう一度やり直してください");
				break;
			case ')':
				if (brackets.empty() || brackets.pop() != '(')
					throw new FormatException("括弧は正しくなく、もう一度やり直してください");
				if (chars[i+1]=='(') {
					throw new FormatException("'('の前は演算子が足らなく、もう一度やり直してください");
				}
				break;
			default:
				lastChar = chars[i];
				break;
			}
		}
		if (!brackets.empty())
			throw new FormatException("括弧は正しくなく、もう一度やり直してください");

	}

	//
	private Stack<String> postfix() {
		Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        s1.push("#");
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    s1.push(chars[i] + "");
                    break;
                case ')':
                    do {
                        s2.push(s1.pop());
                    } while (!s1.peek().equals("("));
                    s1.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':                    
                    if (map.get(String.valueOf(chars[i])) > map.get(s1.peek())) {
                        s1.push(chars[i] + "");
                    } else {
                        do {
                            s2.push(s1.pop());
                        } while (!(map.get(chars[i] + "") > map.get(s1.peek())));
                        s1.push(chars[i] + "");
                    }
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    while (Character.isDigit(chars[i]) || chars[i] == '.') {
                        sb.append(chars[i]);
                        if (i < chars.length - 1 && (Character.isDigit(chars[i + 1]) || chars[i + 1] == '.')) {
                            i++;
                        } else {
                            break;
                        }
                    }
                    s2.push(sb.toString());
                    break;
            }
        }
        while (!s1.peek().equals("#")) {
            s2.push(s1.pop());
        }
        Stack<String> stack = new Stack<>();
        while (!s2.empty()) {
            stack.push(s2.pop());
        }      
        return stack;
	}

	// 加算するメソッド
	public double calculate() throws FormatException {
		check();
        double result;
        Stack<String> tmp = new Stack<>();
        Stack<String> stack = postfix();
        while (!stack.empty()) {
            String s = stack.pop();
            if (Character.isDigit(s.charAt(0))) {
                tmp.push(s);
            } else {
                double a = Double.valueOf(tmp.pop());
                double b = Double.valueOf(tmp.pop());
                switch (s) {
                    case "+":
                        tmp.push(String.valueOf(add(a, b)));
                        break;
                    case "-":
                        tmp.push(String.valueOf(delete(b, a)));
                        break;
                    case "*":
                        tmp.push(String.valueOf(multiply(a, b)));
                        break;
                    case "/":
                        tmp.push(String.valueOf(divide(b, a)));
                        break;
                }
            }
        }
        result = Double.valueOf(tmp.pop());
        return result;
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double delete(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    @SuppressWarnings("deprecation")
	private double divide(double a, double b) {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
	
	}



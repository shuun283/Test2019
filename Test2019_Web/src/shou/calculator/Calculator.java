package shou.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	
	/*文字列の式をTokenのListに変換する*/
	public List<Token> formatIntoTokens(String expression) {
		/*スペースを除く*/
		expression.replace(" ", "");
		
		List<Token> tokens = new ArrayList<Token>();
		char[] chars = expression.toCharArray();
		StringBuffer sb = new StringBuffer("");
		TokenFactory tf = new TokenFactory();
		
		for (int i = 0; i < chars.length; i++){
			//数字の場合
			if (Character.isDigit(chars[i])&&chars[i]=='.') {
				sb.append(chars[i]);				
			}else if (chars[i] == '-') {
				if (Character.isDigit(chars[i-1])) {
				//ただの減算符号だと認識できる
					tokens.add(tf.getToken(chars[i]));
				}
				//負数だと認識できる
				else {
					sb.append(chars[i]);
				}
			}else {
				//他の符号の場合、まず数字の採番終了
				tokens.add(tf.getToken(sb));
				sb = new StringBuffer("");
				//そしてその符号をtokensに入れる
				tokens.add(tf.getToken(chars[i]));
			}
		}
		return tokens;
		
	}		

	//
	public Stack<Token> postfix(List<Token> tokens) {
		Stack<Token> s1 = new Stack<>();
        Stack<Token> s2 = new Stack<>();
        for (Token t : tokens) {
            switch (t.getPriority()) {
                case -3://数字
                    s1.push(t);
                    break;
                case -2://右括弧
                    do {
                        s2.push(s1.pop());
                    } while (s1.peek().getPriority()!=-1);
                    s1.pop();
                    break;             
                case 1:                    
                        s1.push(t);
                        break;
                case 0:                    
                        do {
                            s2.push(s1.pop());
                        } while (s1.peek().getPriority()==1);
                        s1.push(t);                    
                    break;              
            }
        }
        while (!s1.peek().equals(null)) {
            s2.push(s1.pop());
        }
        Stack<Token> stack = new Stack<>();
        while (!s2.empty()) {
            stack.push(s2.pop());
        }      
        return stack;
	}

	// 加算するメソッド
	public double calculate(List<Token> list){
		return 0;
        
       
    }

    
	
	}



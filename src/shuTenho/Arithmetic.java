package shuTenho;

import java.util.Stack;

public class Arithmetic {

    private Stack<Character> oprStack = new Stack<Character>();

    private Stack<Integer> numStack = new Stack<Integer>();

    public static void main(String[] args) {
        Arithmetic a = new Arithmetic();
        System.out.println(a.calc("5+3*(20-30)/5#"));        System.out.println(a.calc("5+3*(20-30)/5#"));

    }

    public Integer calc(String src) {
        int from = 0, to = 0;

        clear();
        char[] cs = src.toCharArray();
        while (to < cs.length && from < cs.length) {
            boolean numORopr = isNum(cs[from]);
            do {
                to++;
            } while (to < cs.length && numORopr && isNum(cs[to]));
            if (numORopr) {
                addNum(Integer.parseInt(new String(cs, from, to - from)));
                System.out.println(new String(cs, from, to - from));
            } else {
                addOpr(cs[from]);
            }
            from = to;
        }
        return numStack.pop();
    }

    public void clear() {

        oprStack.clear();
        numStack.clear();
    }

    private boolean isNum(char b) {

        return  '0'<= b &&b  <= '9';
    }

    private void addOpr(Character c) {

        while (!oprStack.empty() && isNeedCalc(c)) {
            calcByStep();
        }
        if (c == ')') {
            oprStack.pop();
        } else if (c != '#') {
            oprStack.push(c);
        }
    }

    private boolean isNeedCalc(Character c) {

        Character last = oprStack.lastElement();
        if (c == '(' || last == '(')
            return false;
        if (c == '*' || c == '/')
            return last == '*' || last == '/';
        if (c == '#' || c == ')' || c == '+' || c == '-')
            return true;
        throw new IllegalArgumentException();
    }

    private void addNum(Integer i) {

        numStack.push(i);
    }

    private Character calcByStep() {

		int num2 = numStack.pop();
		int num1 = numStack.pop();
		char opr = oprStack.pop();
		switch (opr) {
		case '+':
			numStack.push(num1 + num2);
			break;
		case '-':
			numStack.push(num1 - num2);
			break;
		case '*':
			numStack.push(num1 * num2);
			break;
		case '/':
			numStack.push(num1 / num2);
			break;
		}
		return opr;
	}
}
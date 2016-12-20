import java.util.Stack;

/**
 * Created by 曹利航 on 2016/11/06 12:28.
 */
public class inToPostToValue {

    public static Stack<Integer> operandStack = new Stack<>();

    public static void main(String[] args) {

        String infix = "(1+2)*(9-3)";
        function(infix);
    }

    public static void function(String infix) {
        Stack<Character> operatorStack = new Stack<>();
        operatorStack.push('#');
        char ch;
        char y;
        String res = "";

        for (int i = 0; i < infix.length(); i++) {
            ch = infix.charAt(i);
            if ('0' <= ch && ch <= '9') {   //遇到数字，直接加进后缀表达式，并压栈
                res += ch;
                operandStack.push(ch - '0');
            } else if (ch == ')') {         //不断退栈输出，并计算操作数栈的栈顶两数字，知道遇到'('
                for (y = operatorStack.pop(); y != '('; y = operatorStack.pop()) {
                    res += y;
                    calculate(y);
                }
            } else {                        //比较优先级，当前<=栈顶便取出输出并计算操作数栈栈顶两数字，否则压栈
                for (y = operatorStack.pop(); isp(y) > icp(ch); y = operatorStack.pop()) {
                    res += y;
                    calculate(y);
                }
                operatorStack.push(y);
                operatorStack.push(ch);
            }
        }

        // 打印所有运算符，每打印一个计算一次操作数栈栈顶两数字
        while (!operatorStack.empty() && operatorStack.peek() != '#') {
            y = operatorStack.pop();
            res += y;
            calculate(y);
        }
        System.out.println(res);
        System.out.println(operandStack.pop());
    }

    // 按运算符计算操作数栈栈顶两个数字
    public static void calculate(char operator) {
        int opr2 = Integer.valueOf(operandStack.pop());
        int opr1 = Integer.valueOf(operandStack.pop());

        switch (operator) {
            case '+':
                operandStack.push(opr1 + opr2);
                break;
            case '-':
                operandStack.push(opr1 - opr2);
                break;
            case '*':
                operandStack.push(opr1 * opr2);
                break;
            case '/':
                operandStack.push(opr1 / opr2);
                break;
        }
    }

    public static int isp(char operator) {
        if (operator == '-' || operator == '+')
            return 2;
        else if (operator == '*' || operator == '/')
            return 4;
        else
            return 0;
    }

    public static int icp(char operator) {
        if (operator == '-' || operator == '+')
            return 1;
        else if (operator == '*' || operator == '/')
            return 3;
        else
            return 5;
    }


}

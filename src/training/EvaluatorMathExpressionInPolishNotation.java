package training;

public class EvaluatorMathExpressionInPolishNotation {

    public static Integer evalPostfixExpression(String postfixExpr){
        StackOnArrayList<Integer> intStack = new StackOnArrayList<>();
        Character chr;
        String operand = "";
        for (int i = 0; i < postfixExpr.length(); i++) {
            chr = postfixExpr.charAt(i);
            if (Character.isDigit(chr)) {
                //collect digits
                operand = operand + String.valueOf(Character.getNumericValue(chr));
            } else {
                //digit to stack
                if (operand.length() > 0) {
                    intStack.push(Integer.parseInt(operand));
                    operand = "";
                }
                //operation
                if (!Character.isWhitespace(chr)) {
                    intStack.push(evalOperation(chr, intStack.pop(), intStack.pop()));
                }
            }
        }

        Integer res = 0;
        if (!intStack.isEmpty()) {
            if (intStack.size() == 1) {
                res = intStack.pop();
            }
        }
        return res;
    }

    private static Integer evalOperation(Character operation, Integer b, Integer a){
        Integer res = 0;
        switch (operation){
            case '+': res = a + b; break;
            case '-': res = a - b; break;
            case '*': res = a * b; break;
            case '/': res = a / b; break;
            default:
                System.err.println("Operation Not found");
        }
        return res;
    }
}

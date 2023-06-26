package training;

import java.util.HashMap;

public class ConverterMathExpression {

    public static String infixToPostfix(String infixExpr){
        //validating expression
        BracketValidator bracketValidator = new BracketValidator('(',')');
        if (!bracketValidator.validate(infixExpr)) {
            System.err.println("Expression brackets Non correct");
            return "";
        }

        StackOnArrayList<String> stringStack = new StackOnArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> priority = getOperationPriority();
        Character chr;
        String operand = "";
        String stackValue;

        for (int i = 0; i < infixExpr.length(); i++) {
            chr = infixExpr.charAt(i);
            if (!Character.isWhitespace(chr)) {
                if (Character.isDigit(chr)) {
                    //collect numeric
                    operand = operand + String.valueOf(Character.getNumericValue(chr));
                } else {
                    //previously collected numerics to result
                    if (operand.length() > 0) {
                        stringBuilder.append(operand + " ");
                        operand = "";
                    }
                    // chr: non digit & non whitespace
                    if (chr.equals('(')) {
                        //open bracket to stack
                        stringStack.push(chr.toString());
                    } else {
                        // chr: ')'
                        if (chr.equals(')')) {
                            if (!stringStack.isEmpty()) {
                                stackValue = stringStack.pop();
                                while (!stackValue.equals("(")) {
                                    stringBuilder.append(stackValue + " ");
                                    if (!stringStack.isEmpty()) { stackValue = stringStack.pop(); } else { stackValue = ""; break; }
                                }
                            } else {
                                System.err.println("the opening bracket was Not found");
                            }
                        } else {
                            //chr: operation
                            if (!stringStack.isEmpty()) {
                                stackValue = stringStack.pop();
                                int chrPriority = priority.get(chr);
                                while (chrPriority <= priority.get(stackValue.charAt(0))) {
                                    if (stackValue.equals("(")) break;
                                    stringBuilder.append(stackValue + " ");
                                    if (!stringStack.isEmpty()) {
                                        stackValue = stringStack.pop();
                                    } else {
                                        stackValue = "";
                                        break;
                                    }
                                }
                            } else {
                                stackValue = "";
                            }
                            if (!stackValue.isEmpty()) { stringStack.push(stackValue); }
                            stringStack.push(chr.toString());
                        }
                    }
                }
            }
        }

        if (operand.length() > 0){ stringBuilder.append(operand + " "); }

        while (!stringStack.isEmpty()){
            stringBuilder.append(stringStack.pop() + " ");
        }

        return stringBuilder.toString().trim();
    }

    static HashMap<Character, Integer> getOperationPriority(){
        HashMap<Character, Integer> priority = new HashMap<>();
                                    priority.put('+', 1);
                                    priority.put('-', 1);
                                    priority.put('*', 2);
                                    priority.put('/', 2);
                                    priority.put(')', 3);
                                    priority.put('(', 3);
        return priority;
    }
}

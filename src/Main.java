import training.BracketValidator;
import training.StackOnArrayList;

public class Main {
    public static void main(String[] args) {
        //How to use
        //stack
        StackOnArrayList<String> stringStack = new StackOnArrayList<>();
        System.out.println("size:" + stringStack.size());
        for (int i = 1; i <= 17; i++) {
            stringStack.push("Test" + i);
        }
        System.out.println(stringStack);
        System.out.println("size:" + stringStack.size());

        System.out.println("pop:'" + stringStack.pop() + "'");
        System.out.println(stringStack);
        System.out.println("size:" + stringStack.size());

        //bracket
        checkExpression('(',')',"((A)+B)*(C/(A-D))");
        checkExpression('(',')',"((A)+B)*)C/(A-D))");
        checkExpression('{','}',"{{A}+B}*{C/{A-D}}");
        checkExpression('{','}',"{{A}+B}*}C/{A-D}}");
    }

    static void checkExpression(char brOpen, char brClose, String check){
        BracketValidator bracketValidator = new BracketValidator(brOpen,brClose);
        System.out.println("String to validate: '" + check + "'");
        System.out.println("Result: " + bracketValidator.validate(check));

    }
}
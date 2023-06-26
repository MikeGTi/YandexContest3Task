import training.BracketValidator;
import training.ParserTextTable;
import training.StackOnArrayList;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import static training.ConverterMathExpression.infixToPostfix;
import static training.EvaluatorMathExpressionInPolishNotation.evalPostfixExpression;

public class Main {
    public static void main(String[] args) {
        //How to use
        //text table parser
        String str = "Имя|Возраст|Должность|Зарплата\n" +
                     "Кирилл|26|Middle java dev|150000 руб\n" +
                     "Виталий|28|Senior java automation QA|2000$\n" +
                     "Александр|31|junior functional tester|50000 руб\n" +
                     "Дементий|35|dev-ops|1500$\n";

        List<Map<String,String>> list = new ParserTextTable(str,"\n","\\|").parse();

        System.out.println("Сотрудники (моложе 30 лет)");
        list.stream()
                .filter(hm -> Integer.parseInt(hm.get("Возраст")) < 30)
                .map(hm -> hm.get("Имя"))
                .forEach(System.out::println);

        System.out.println("Сотрудники (получающие зарплату в рублях)");
        list.stream()
                .filter(hm -> hm.get("Зарплата").contains("руб"))
                .map(hm -> hm.get("Имя"))
                .forEach(System.out::println);

        System.out.println("Сотрудники (статистика, кат.'Возраст')");
        IntSummaryStatistics statistics = list.stream()
                                            .filter(hm -> Integer.parseInt(hm.get("Возраст")) > 0)
                                            .mapToInt((x) -> Integer.parseInt(x.get("Возраст")))
                                            .summaryStatistics();
        System.out.println("          количество " + statistics.getCount());
        System.out.println("     средний возраст " + statistics.getAverage());
        System.out.println(" минимальный возраст " + statistics.getMin());
        System.out.println("максимальный возраст " + statistics.getMax() + "\n");


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

        //bracket validation
        checkExpression('(',')',"((A)+B)*(C/(A-D))");
        checkExpression('(',')',"((A)+B)*)C/(A-D))");
        checkExpression('{','}',"{{A}+B}*{C/{A-D}}");
        checkExpression('{','}',"{{A}+B}*}C/{A-D}}");

        //convert infix To Postfix expression
        System.out.println("Postfix notation: " + infixToPostfix("6+3*(1+4*5)*2"));

        //evaluate postfix math expression
        System.out.println("Evaluation result: " + evalPostfixExpression(infixToPostfix("6+3*(1+4*5)*2")));
    }

    static void checkExpression(char brOpen, char brClose, String check){
        BracketValidator bracketValidator = new BracketValidator(brOpen,brClose);
        System.out.print("String to validate: '" + check + "'");
        System.out.println(", Result: " + bracketValidator.validate(check) + "\n");

    }
}
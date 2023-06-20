package training;

public class BracketValidator {

    private static Character bracketOpen;
    private static Character bracketClose;

    public BracketValidator(Character bracketOpen, Character bracketClose) {
        this.bracketOpen = bracketOpen;
        this.bracketClose = bracketClose;
    }

    public boolean validate(String expr){
        StackOnArrayList<Character> charStack = new StackOnArrayList();
        //String brackets = expr.replaceAll("[^\\\\{\\\\}\\\\" + bracketOpen + "\\\\" + bracketClose + "\\\\[\\\\]]","");
        for (int i = 0; i < expr.length(); i++){
            Character chr = expr.charAt(i);
            if (chr.equals(bracketOpen) || chr.equals(bracketClose)) {
                if (charStack.isEmpty()) {
                    if (chr.equals(bracketClose)) {
                        return false;
                    } else {
                        charStack.push(chr);
                    }
                } else {
                    if (chr.equals(bracketClose)) {
                        if (chr.equals(charStack.pop())) {
                            return false;
                        }
                    } else {
                        charStack.push(chr);
                    }
                }
            }
        }
        return charStack.isEmpty();
    }

}


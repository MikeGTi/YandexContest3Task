import java.util.*;

public class YaContest2023_taskA_KuzmaKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int keyboardButtonCounter = scanner.nextInt();
        int[] alphabetSymbolsIdentifiers = getInputIntArray(scanner, keyboardButtonCounter);
        int[] alphabetSymbolsIdentifiersRow = getInputIntArray(scanner, keyboardButtonCounter);
        int K = scanner.nextInt();
        int[] referatSymbolsIdentifiers = getInputIntArray(scanner, K);

        Map<Integer, Integer> mapper = new HashMap<>();
        int i;
        for (i = 0; i < keyboardButtonCounter; i++) {
            mapper.put(alphabetSymbolsIdentifiers[i], alphabetSymbolsIdentifiersRow[i]);
        }

        int counter = 0;
        for (i = 0; i < referatSymbolsIdentifiers.length - 1; i++) {
            if (!Objects.equals(mapper.get(referatSymbolsIdentifiers[i]), mapper.get(referatSymbolsIdentifiers[i + 1]))) {
                counter++;
            }
        }

        System.out.println(counter);

    }

    private static int[] getInputIntArray(Scanner scanner, int endInt){
        int[] res = new int[endInt];
        for (int i = 0; i < endInt; i++) {
            res[i] = scanner.nextInt();
        }
        return res;
    }


}

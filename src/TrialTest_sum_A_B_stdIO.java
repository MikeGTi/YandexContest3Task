import java.util.Scanner;

public class TrialTest_sum_A_B_stdIO {
        public static void main(String[] args) {
            //System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));

            Scanner scanner = new Scanner(System.in);
            int sum= 0;
            if (scanner.hasNextInt()) {
                do {
                    sum += scanner.nextInt();
                } while (scanner.hasNextInt());
            }
            System.out.println(sum);
        }
}

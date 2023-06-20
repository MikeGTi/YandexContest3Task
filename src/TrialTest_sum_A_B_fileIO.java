import java.io.*;
import java.util.Scanner;


public class TrialTest_sum_A_B_fileIO {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File("out\\input.txt"))) {
            Integer sum= 0;
            while (scanner.hasNextInt()) {
                sum+= scanner.nextInt();
            }
            try (FileWriter writer = new FileWriter("out\\output.txt", false)){
                writer.write(sum.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
import java.util.*;

public class YaContest2023_taskC_KuzmaTrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        List<Integer> prices = Arrays.stream(getInputIntArray(scanner, days)).boxed().toList();

        int startCash = 1;
        int maxDealCount = 8;
        int dealCount = 0;

        Map<Integer, Integer> mapper = new HashMap<>();
        for (int i = 1; i <= prices.size(); i++) {
            mapper.put(i, prices.get(i - 1));
        }

        /*double curCash = 0;
        double curBuy = 0;

        while (!(maxDealCount == dealCount)){

            for (int i = 0; i < prices.size(); i++) {
                if (prices.get(i) <= startCash) {
                    dealCount++;
                    curBuy = (double) startCash / prices.get(i);
                    curCash = (double) startCash % prices.get(i);
                }

            }
        }*/






        System.out.println(dealCount/2);
        //System.out.println(a2 + 1 + " " + b2 + 1);


    }

    private static int[] getInputIntArray(Scanner scanner, int endInt){
        int[] res = new int[endInt];
        for (int i = 0; i < endInt; i++) {
            res[i] = scanner.nextInt();
        }
        return res;
    }
}

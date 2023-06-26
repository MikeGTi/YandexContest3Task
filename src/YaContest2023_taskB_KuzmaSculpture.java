import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class YaContest2023_taskB_KuzmaSculpture {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String[] inpLine = bufferedReader.readLine().split(" ");
                if (!(inpLine.length == 3)) {
                    System.out.println(0);
                    return;
                }

                int sculptureCount = Integer.parseInt(inpLine[0]);

                int sculptureIdealWeight = Integer.parseInt(inpLine[1]);

                int timeToNewYear = Integer.parseInt(inpLine[2]);

                inpLine = bufferedReader.readLine().split(" ");
                if (inpLine.length == 0) {
                    System.out.println(0);
                    return;
                }

                List<Integer> sculpturesWeight = Arrays.stream(inpLine).map(Integer::valueOf).collect(Collectors.toList());

                Map<Integer, Integer> mapper = IntStream
                                                    .rangeClosed(1, sculptureCount)
                                                    .boxed()
                                                    .collect(Collectors.toMap(i -> i, i -> Math.abs(sculpturesWeight.get(i - 1) - sculptureIdealWeight), (a, b) -> b));

                LinkedList<Map.Entry<Integer, Integer>> mapperList = new LinkedList<>(mapper.entrySet());
                mapper.clear();

                mapperList.sort(Map.Entry.comparingByValue());

                List<Integer> ids = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : mapperList) {
                    timeToNewYear -= entry.getValue();
                    if (timeToNewYear < 0) {
                        break;
                    }
                    ids.add(entry.getKey());
                }
                mapperList.clear();

                if (!ids.isEmpty()) {
                    System.out.println(ids.size());
                    System.out.println(ids.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                } else {
                    System.out.println(0);
                }
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(0);
        }
    }
}

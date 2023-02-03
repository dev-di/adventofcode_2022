package advent.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static final String exampleFile = "src/main/resources/day01/example_input.txt";
    static final String file = "src/main/resources/day01/input.txt";

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("The sum of 3 greatest calory inventories is " + main.getGreatestSum(1, file)); // 202346
        System.out.println("The sum of 3 greatest calory inventories is " + main.getGreatestSum(3, file)); // 202346
    }

    private Stream<Integer> getInventoryStream(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useDelimiter(System.lineSeparator() +System.lineSeparator());

            LinkedList<Integer> elfInventory = new LinkedList<>();
            while (scanner.hasNext()) {
                String nextElfInventory = scanner.next();
                Integer sum = nextElfInventory.lines().mapToInt(Integer::parseInt).sum();
                elfInventory.add(sum);
            }
            scanner.close();
            return elfInventory.stream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Could not find file " +fileName);
        }

        return null;
    }

    public Integer getGreatestSum(int n, String file) {
        Stream<Integer> inventoryStream = getInventoryStream(file);
        List<Integer> list = inventoryStream.toList().stream().sorted(Collections.reverseOrder()).toList();
        List<Integer> sublist = list.subList(0, n);
        return  sublist.stream().mapToInt(v -> v).sum();
    }
}
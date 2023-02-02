package advent.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static final String exampleFile = "src/main/resources/day1/example_input.txt";
    static final String file = "src/main/resources/day1/input.txt";

    public static void main(String[] args) throws URISyntaxException, IOException {
        Main main = new Main();
        Integer maxInventory = main.getMaxInventory(file);
        System.out.println("The biggest calory inventory is " + maxInventory);
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

    public Integer getMaxInventory(String file) {
        Stream<Integer> inventoryStream = getInventoryStream(file);
        OptionalInt max = inventoryStream.mapToInt(v -> v).max();
        if(max.isPresent()) {
            return max.getAsInt();
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
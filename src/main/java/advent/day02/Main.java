package advent.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    static final String exampleFile = "src/main/resources/day02/example_input.txt";
    static final String file = "src/main/resources/day02/input.txt";

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Sum1: " + main.getStrategySum(file, new Strategy1()));
        System.out.println("Sum2: " + main.getStrategySum(file, new Strategy2()));
    }

    public Integer getStrategySum(String fileName, Strategy strategy) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.mapToInt(s -> strategy.getPoints(s)).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
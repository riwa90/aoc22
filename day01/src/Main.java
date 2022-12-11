import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main {

  public static void main(String[] args) throws IOException {
    String part = System.getenv("part");
    part = Objects.nonNull(part) ? part : "part2";
    if(part.equals("part1")) {
      part1();
    } else {
      part2();
    }
  }

  private static void part1() throws IOException{
    var path = Path.of("input.txt");
    var input = Files.newBufferedReader(path);
    int maxCals = 0;
    int currentCals = 0;
    while(input.ready()) {
      String currentValue = input.readLine();
      if(currentValue.isBlank()) {
        maxCals = currentCals > maxCals ? currentCals : maxCals;
        currentCals = 0;
      } else {
        currentCals += Integer.parseInt(currentValue);
      }
    }
    System.out.println(maxCals);
  }

  private static void part2() throws IOException {
    var path = Path.of("input.txt");
    var input = Files.newBufferedReader(path);
    int[] maxArray = {0, 0, 0};
    int currentCals = 0;
    while(input.ready()) {
      String currentValue = input.readLine();
      if(currentValue.isBlank()) {
        if(currentCals > maxArray[2]) {
          maxArray[0] = maxArray[1];
          maxArray[1] = maxArray[2];
          maxArray[2] = currentCals;
        } else if(currentCals > maxArray[1]) {
          maxArray[0] = maxArray[1];
          maxArray[1] = currentCals;
        } else if (currentCals > maxArray[0]) {
          maxArray[0] = currentCals;
        }
        currentCals = 0;
      } else {
        currentCals += Integer.parseInt(currentValue);
      }
    }
    System.out.println(maxArray[0] + maxArray[1] + maxArray[2]);
  }
}
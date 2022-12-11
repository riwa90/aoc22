import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Main {
  private static Map<String, Integer> pointMap1 = Map.of("A X", 4,
                                "B X", 1,
                                "C X", 7,
                                "A Y", 8,
                                "B Y", 5,
                                "C Y", 2,
                                "A Z", 3,
                                "B Z", 9,
                                "C Z", 6);

  private static Map<String, Integer> pointMap2 = Map.of("A X", 3,
                                       "B X", 1,
                                       "C X", 2,
                                       "A Y", 4,
                                       "B Y", 5,
                                       "C Y", 6,
                                       "A Z", 8,
                                       "B Z", 9,
                                       "C Z", 7);

  public static void main(String[] args) throws IOException {
    String part  = System.getenv("part");
    part = part != null ? part : "part2";
    Map<String, Integer> pointMap;
    if(part.equals("part1")) {
      pointMap = pointMap1;
    } else {
      pointMap = pointMap2;
    }
    var input = Files.newBufferedReader(Path.of("input.txt"));
    String inputLine;
    int points = 0;
    while(input.ready()) {
      inputLine = input.readLine();
      points += pointMap.get(inputLine);
    }
    System.out.println(points);
  }
}

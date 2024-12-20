package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HistorianHysteria {

    static List<Integer> firstTeam = new ArrayList<>();
    static List<Integer> secondTeam = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        int difference = 0;
        getValuesFromFile();

        Collections.sort(firstTeam);
        Collections.sort(secondTeam);

        for (int i = 0; i < firstTeam.size(); i++) {
            difference += Math.abs(firstTeam.get(i) - secondTeam.get(i));
        }

        System.out.println(difference);
    }

    public static void getValuesFromFile() {
        try {
            Scanner scanner = new Scanner(new File("src/main/java/Day1/numbers.txt"));
            boolean firstTeamsTurn = true;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // Trim removes extra spaces or trailing newlines
                if (!line.isEmpty()) { // Ignore empty lines
                    String[] parts = line.split("\\s+"); // Split by any amount of whitespace
                    firstTeam.add(Integer.parseInt(parts[0]));
                    secondTeam.add(Integer.parseInt(parts[1]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}

package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class HistorianHysteria2 {

    static List<Integer> firstTeam = new ArrayList<>();
    static List<Integer> secondTeam = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        int similarityScore = 0;
        getValuesFromFile();

        for (int i = 0; i < firstTeam.size(); i++) {
            int differenceScoreForThisNumber = 0;
            for (int j = 0; j < secondTeam.size(); j++) {
                if (Objects.equals(firstTeam.get(i), secondTeam.get(j))){
                    differenceScoreForThisNumber += secondTeam.get(j);
                }
            }
            similarityScore += differenceScoreForThisNumber;
        }

        System.out.println(similarityScore);
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

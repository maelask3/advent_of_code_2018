package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day2 {

    public static void main(String[] args){
        Part1();
        Part2();
    }

    public static void Part1() {
        int twos=0, threes=0;
        Map<Character,Integer> letters;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while ((line = br.readLine()) != null) {
                letters = new HashMap<>();
                char[] lett = line.toCharArray();

                for(Character s : lett) {

                    if(letters.containsKey(s)){
                        letters.put(s,letters.get(s)+1);
                    } else {
                        letters.put(s,1);
                    }
                }

                twos += (Collections.frequency(letters.values(),2)>=1) ? 1 : 0;
                threes += (Collections.frequency(letters.values(),3)>=1) ? 1 : 0;
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Result is: " + twos + " * " + threes + " = " + (twos*threes));
        }
    }

    public static void Part2() {
        String line;
        List<String> strings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            strings = br.lines().collect(Collectors.toList());

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        for (String previous : strings) {
            for (String s : strings) {
                if (!s.equals(previous)) {
                    int differences = 0;
                    StringBuffer common = new StringBuffer();

                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == previous.charAt(i)) {
                            common.append(s.charAt(i));
                        } else {
                            differences++;
                        }

                    }

                    if (differences <= 1) {
                        System.out.println("common letters: " + common.toString() + ", difference: " + differences);
                        return;
                    }
                }
            }
        }

    }
}

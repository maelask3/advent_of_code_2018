
package Day1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Day1 {

    public static void main(String[] args){
        String line = "";
        Set<Integer> seen = new HashSet<>();
        boolean dupe=false;
        int ax=0;

        if(args.length!=1) {
            System.err.println("This program takes exactly 1 argument.\nUsage: Day1 <filename>");
        } else {
            while(!dupe){
                try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                    while ((line = br.readLine()) != null && !dupe) {

                        ax += Integer.parseInt(line);

                        if(seen.contains(ax)){
                            System.out.println(ax + " has already been seen");
                            dupe=true;
                        }

                        seen.add(ax);
                    }
                } catch (IOException | NumberFormatException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Result is: " + ax);
                }
            }
        }
    }
}
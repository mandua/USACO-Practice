/*
ID: aarushd1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> monthAndDays = new HashMap<Integer, Integer>() {{
            put(1, 31); put(2, 28); put(3, 31); put(4, 30); put(5, 31); put(6, 30); put(7, 31); put(8, 31); put(9, 30); put(10, 31); put(11, 30); put(12, 31);
        }};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int currentDay = 13;
        HashMap<String, Integer> output = new HashMap<String, Integer>() {{
            put("Saturday", 0); put("Sunday", 0); put("Monday", 0); put("Tuesday", 0); put("Wednesday", 0); put("Thursday", 0); put("Friday", 0);
        }};

        for (int i = 1900; i < 1900+n; i++) {
            for (int j = 1; j < 13; j++) {
                output.put(days[currentDay%(days.length)], output.get(days[currentDay%(days.length)])+1);
                if (j == 2) {
                    if (i%100 == 0) {
                        if (i%400 == 0) {
                            monthAndDays.put(j, 29);
                        } else {
                            monthAndDays.put(j, 28);
                        }
                    } else if (i%4 == 0 && i%100 != 0) {
                        monthAndDays.put(j, 29);
                    } else {
                        monthAndDays.put(j, 28);
                    }
                }
                currentDay += monthAndDays.get(j);
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        String outputString = String.valueOf(output.get(days[days.length-1]));
        for (int i = 0; i < days.length-1; i++) {
            outputString += " " + String.valueOf(output.get(days[i]));
        }
        pw.print(outputString);
        pw.println();
        pw.close();
    }
}
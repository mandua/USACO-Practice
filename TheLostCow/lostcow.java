// BASE_PATH: USACOpractice/TheLostCow/

import java.io.*;
import java.util.*;

class lostcow {
    final static String BASE_PATH = "";
    static boolean bessieFound = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + "lostcow.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int X = Integer.parseInt(st.nextToken());
        final int Y = Integer.parseInt(st.nextToken());

        int distance = 1;
        boolean forward = true;
        int totalDistance = 0;
        while (!bessieFound) {
            int fjPosition = X;
            if (forward) {
                totalDistance += moveForward(X, Y, distance);
                fjPosition += distance;
                if (!bessieFound) {
                    totalDistance += (fjPosition - X);
                }
            } else {
                totalDistance += moveBackwards(X, Y, distance);
                fjPosition -= distance;
                if (!bessieFound) {
                    totalDistance += (X - fjPosition);
                }
            }
            distance *= 2;
            if (forward) {
                forward = false;
            } else {
                forward = true;
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(BASE_PATH + "lostcow.out")));
        pw.print(totalDistance);
        pw.println();
        pw.close();
    }

    public static int moveForward(int fj, int b, int d) {
        int currentPosition = fj;
        for (int i = 0; i < d; i++) {
            currentPosition++;
            if (isBessieThere(currentPosition, b)) {
                bessieFound = true;
                break;
            }
        }
        return currentPosition-fj;
    }

    public static int moveBackwards(int fj, int b, int d) {
        int currentPosition = fj;
        for (int i = 0; i < d; i++) {
            currentPosition--;
            if (isBessieThere(currentPosition, b)) {
                bessieFound = true;
                break;
            }
        }
        return fj-currentPosition;
    }

    public static boolean isBessieThere(int fj, int b) {
        return fj == b;
    }
}
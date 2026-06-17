// BASE_PATH: USACO/SpeedingTicket/

import java.io.*;
import java.util.*;

class speeding {
    final static String BASE_PATH = "";
    static int[] road = new int[100];
    static int[] bessie = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + "speeding.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int currentMile = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < distance; j++) {
                road[j+currentMile] = speed;
            }
            currentMile += distance;
        }
        currentMile = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < distance; j++) {
                bessie[j+currentMile] = speed;
            }
            currentMile += distance;
        }

        int maxOver = 0;
        for (int i = 0; i < 100; i++) {
            if (bessie[i] > road[i]) {
                if (bessie[i]-road[i] > maxOver) {
                    maxOver = bessie[i]-road[i];
                }
            }
        }
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(BASE_PATH + "speeding.out")));
        pw.print(maxOver);
        pw.println();
        pw.close();
    }
}
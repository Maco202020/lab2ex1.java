package exercitiul1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        try {

            String nume_fis = "C:\\Users\\macov\\Desktop\\java_laboratoare\\lab2ex1\\judete.txt";
            BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
            ArrayList<String> judeteList = new ArrayList<>();
            String line;
            while ((line = flux_in.readLine()) != null) {
                judeteList.add(line);
            }
            flux_in.close();
            String[] judete = judeteList.toArray(new String[0]);
            Arrays.sort(judete);

            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Introduceți un județ: ");
            String judetCautat = inputScanner.nextLine();
            inputScanner.close();

            int pozitie = Arrays.binarySearch(judete, judetCautat);

            if (pozitie >= 0) {
                System.out.println("Județul " + judetCautat + " se află pe poziția " + pozitie + " în vectorul ordonat.");
            } else {
                System.out.println("Județul " + judetCautat + " nu a fost găsit în vectorul ordonat.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

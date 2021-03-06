package ru.kpfu.itis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] elems;
        int i = 0;
        String absolutePath = "D:\\semester-project-disjoint-set\\src\\ru\\kpfu\\itis\\add\\testdata15";
        try (Scanner scanner = new Scanner(new FileReader(absolutePath))) {
            elems = new int[scanner.nextInt()];
            while (scanner.hasNextInt()) {
                elems[i++] = scanner.nextInt();
            }
            long sumTimeTestUnion1 = 0;
            long sumTimeTestUnion2 = 0;
            long sumTimeTestFind = 0;

            double num = 100.0;
            for (int j = 0; j < num; j++) {
                sumTimeTestUnion1 +=  testUnion1(elems);
                sumTimeTestUnion2 += testUnion2(elems);
                sumTimeTestFind += testFind(elems);
            }
            System.out.println("Average time for testUnion1(): " + sumTimeTestUnion1/num + " millis");
            System.out.println("Average time for testUnion2(): " + sumTimeTestUnion2/num + " millis");
            System.out.println("Average time for testFind(): " + sumTimeTestFind/num + " millis");

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (NullPointerException ex){
            System.err.println(ex.getMessage());
        }

    }
    private static long testUnion1(int[] elems){
        long start = System.currentTimeMillis();
        DisjointSet ds = new DisjointSet(elems);
        int randomIndex = generateRandomIndex(elems.length, 0);

        for (int i = 0; i < elems.length; i++) {
            if(elems[randomIndex] != elems[i]){
                ds.Union(elems[randomIndex], elems[i]);
            }
        }

        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;
    }

    private static long testUnion2(int[] elems){

        long start = System.currentTimeMillis();

        DisjointSet ds = new DisjointSet(elems);
        int randomIndex1 = generateRandomIndex(elems.length - 1 , 0);
        int randomIndex2 = generateRandomIndex(elems.length, randomIndex1 + 1);
        for (int i = 0; i < randomIndex1; i++) {
            ds.Union(elems[randomIndex1], elems[i]);
        }
        for (int i = randomIndex1 + 1; i < elems.length; i++) {
            ds.Union(elems[randomIndex2], elems[i]);
        }
        ds.Union(elems[randomIndex1], elems[randomIndex2]);
        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;
    }

    private static int generateRandomIndex(int upBound, int bottomBound){
        return bottomBound + (int) Math.random()*upBound;
    }

    private static long testFind(int[] elems){
        long start = System.currentTimeMillis();

        int randomIndex = generateRandomIndex(elems.length - 1 , 0);
        DisjointSet ds = new DisjointSet(elems);
        ds.Find(elems[randomIndex]);

        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;
    }

}

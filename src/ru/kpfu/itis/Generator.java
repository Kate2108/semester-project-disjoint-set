package ru.kpfu.itis;

import java.io.*;
import java.util.HashSet;
import java.util.Random;

public class Generator {
    public static void makeTest(String path, int numberOfElements) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(numberOfElements + "\n");
            Random random = new Random();
            HashSet<Integer> hashSet = new HashSet<>(numberOfElements, 1);
            for (int i = 0; i < numberOfElements; i++) {
                int elem = random.nextInt();
                while (hashSet.contains(elem)) {
                    elem = random.nextInt();
                }
                hashSet.add(elem);
                file.write(elem + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

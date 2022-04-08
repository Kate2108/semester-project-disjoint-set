package ru.kpfu.itis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] elems;
        int i = 0;
        // входные тестовые данные считываются при помощи Scanner с файла из папки add
        // которые сгенерированы классом Generator
        // чтобы протестировать структуру на различных данных, необходимо указать полный путь до папки add
        // и название файла с тестовыми данными (их должно быть 5)
        // ВАЖНО: после основной работы надо обработать исключение, возникающее, если на входе одинаковые элементы
        // наверное это будет NullPointer
        try(Scanner scanner = new Scanner( new FileReader("D:\\DisjointSet\\src\\ru\\kpfu\\itis\\add\\testdata1"))){
            elems = new int[scanner.nextInt()];
            while (scanner.hasNextInt()){
                elems[i++] = scanner.nextInt();
            }
            DisjointSet ds = new DisjointSet(elems);
            // здесь будут тесты по времени, пока наглядное изменение данных
            // просмотрите, что выводит программа!
        ds.printSets(elems, ds);
        ds.Union(6, 8);
        ds.printSets(elems, ds);
        ds.Union(9, 10);
        ds.printSets(elems, ds);
        ds.Union(9, 8);
        ds.printSets(elems, ds);

        }
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }

    }
}

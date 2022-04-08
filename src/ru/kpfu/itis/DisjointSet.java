package ru.kpfu.itis;
import java.util.HashMap;
import java.util.Map;

class DisjointSet {
    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> size = new HashMap<>();

    public DisjointSet(int[] elements){
        for (int i: elements) {
            parent.put(i, i); // помещаем ключи и значения i
            size.put(i, 0); // размер множеств, изначально к каждому ключу размер 0
        }

    }
    // ищет, в каком множестве элемент возвращает root (далее:родителя) всего множества
    public int Find(int k){
        if (parent.get(k) != k){
            parent.put(k, Find(parent.get(k)));
        }
        return parent.get(k);
    }
    // функция объединения элементов в множества
    // для оптимальности: если нужно соединить два множества, то меняется родитель
    // у элементов МЕНЬШЕГО множества
    public void Union(int a, int b) {
        int x = Find(a);
        int y = Find(b);

        if (x == y){
            return;
        }
        if (size.get(x) > size.get(y)){
            parent.put(y, x);
        }
        else if (size.get(x) < size.get(y)){
            parent.put(x, y);
        }
        else {
            parent.put(x, y);
            size.put(y, size.get(y) + 1);
        }
    }

    // тестовая функция (будет удалена) нужна для наглядности
    // принтует родителей элементов (у элементов одного множества один родитель)
    public void printSets(int[] universe, DisjointSet ds)
    {
        for (int i: universe) {
            System.out.print(ds.Find(i) + " ");
        }
        System.out.println();
    }
}

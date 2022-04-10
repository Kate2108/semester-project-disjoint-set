package ru.kpfu.itis;

import java.util.HashMap;
import java.util.Map;

class DisjointSet {
    private Map<Object, Object> parent = new HashMap<>();
    private Map<Object, Integer> size = new HashMap<>();

    public DisjointSet(int[] elements) {
        for (Object i : elements) {
            parent.put(i, i);
            size.put(i, 0);
        }

    }
    public Object Find(Object k) {
        if (!parent.get(k).equals(k)) {
            parent.put(k, Find(parent.get(k)));
        }
        return parent.get(k);
    }

    public void Union(Object a, Object b) {
        Object x = Find(a);
        Object y = Find(b);

        if (x.equals(y)) {
            return;
        }
        if (size.get(x) > size.get(y)) {
            parent.put(y, x);
        }
        else if (size.get(x) < size.get(y)) {
            parent.put(x, y);
        }
        else {
            parent.put(x, y);
            size.put(y, size.get(y) + 1);
        }
    }
}

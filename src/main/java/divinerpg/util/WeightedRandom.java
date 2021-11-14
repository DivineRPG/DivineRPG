package divinerpg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WeightedRandom<T> {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private HashMap<Integer, T> idMap = new HashMap<Integer, T>();
    private int currentId = 0;

    public void addItem(T item, int weight) {
        if(weight <= 0) {
            throw new IllegalArgumentException("Weights must be positive");
        }

        idMap.put(currentId, item);
        for(int k = 0; k < weight; k++) {
            list.add(currentId);
        }
        currentId++;
    }

    public T selectRandomItem(Random random) {
        return idMap.get(list.get(random.nextInt(list.size())));
    }
}
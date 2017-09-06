package night;

import java.util.Iterator;
import java.util.LinkedList;

public class LightList {

    private LinkedList<Light> ligths;

    private LightList() {
        ligths = new LinkedList<Light>();
    }

    private final static LightList instance = new LightList();

    public static final LightList getInstance() {
        return instance;
    }

    public static void add(Light light) {
        instance.ligths.add(light);
    }

    public static void clear() {
        instance.ligths.clear();
    }

    public static Iterator<Light> iterator() {
        return instance.ligths.iterator();
    }

}

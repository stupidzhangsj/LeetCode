package collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 集合测试
 *
 * @author :zhangshengjun
 * @create 2019-10-31 8:44
 **/
public class ArrayListDemo {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> initial = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14)) ;

        ArrayList<Integer> initial2 =  new ArrayList<>();
        System.out.format("Size: %2d, Capacity: %2d%n",initial2.size(), getCapacity(initial2));
        initial2.add(2);
        System.out.format("Size: %2d, Capacity: %2d%n",initial2.size(), getCapacity(initial2));
        initial2.add(2);
        initial2.add(2);
        initial2.add(2);
        initial2.add(2);
        initial2.add(2);
        initial2.add(2);
        initial2.add(2);
        initial2.add(2);
        initial2.add(2);
        System.out.format("Size: %2d, Capacity: %2d%n",initial2.size(), getCapacity(initial2));
        initial2.addAll(initial);
        System.out.format("Size: %2d, Capacity: %2d%n",initial2.size(), getCapacity(initial2));
        initial2.add(17);
        System.out.format("Size: %2d, Capacity: %2d%n",initial2.size(), getCapacity(initial2));

        new HashMap<>();

    }


    static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
}

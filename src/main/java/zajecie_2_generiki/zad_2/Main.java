package zajecie_2_generiki.zad_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(2);

        System.out.println(findMinimumm6(integers));
    }

    public static Integer findMinimumm(List<Integer> list) {
        Integer currentMin = list.get(0);
        for (Integer integer : list) {
            if (integer < currentMin) {
                currentMin = integer;
            }
        }
        return currentMin;
    }

    public static Integer findMinimum2(List<Integer> list) {
        ArrayList<Integer> listCopy = new ArrayList<>(list);
        Collections.sort(listCopy);
        return listCopy.get(0);
    }

    public static Integer findMinimum3(List<Integer> list) {
        return list.stream().min(Comparator.naturalOrder()).get();
    }

    public static Integer findMinimum4(List<Integer> list) {
        return Collections.min(list);                            // najlepsze rozwiazanie
    }

    public static Integer findMinimum5(List<Integer> list) {
        return list.stream().sorted().findFirst().get();        // bez kopijowanie listy
    }


    public static <T extends Number & Comparable<T>> T findMinimumm6(List<T> list) {
        T currentMin = list.get(0);
        for (T value : list) {
            if (value.compareTo(currentMin) < 0) {
                currentMin = value;
            }
        }
        return currentMin;
    }
}

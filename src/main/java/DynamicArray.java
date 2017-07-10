import java.util.*;

/**
 * Created by Dmitry Butilov
 * on 08.07.17.
 */

public class DynamicArray<T extends Number> {

    private List<Number> mArray;

    /**
     * Создание массива n элементов
     *
     * @param aCount  : размер массива
     * @param aRandom : генератор случайных чисел
     * @param aBound  : диапазон сгенерированных чисел [0..aBound]
     */
    public DynamicArray(int aCount, Random aRandom, Integer aBound, Class<T> aClazz) {
        mArray = new ArrayList<>();
        if (aClazz.isAssignableFrom(Integer.class)) {
            for (int i = 0; i < aCount; ++i) {
                mArray.add(aRandom.nextInt(aBound));
            }
        } else if (aClazz.isAssignableFrom(Double.class)) {
            for (int i = 0; i < aCount; ++i) {
                mArray.add(aRandom.nextDouble());
            }
        } else if (aClazz.isAssignableFrom(Float.class)) {
            for (int i = 0; i < aCount; ++i) {
                mArray.add(aRandom.nextFloat());
            }
        } else if (aClazz.isAssignableFrom(Long.class)) {
            for (int i = 0; i < aCount; ++i) {
                mArray.add(aRandom.nextLong());
            }
        } else {
            throw new IllegalArgumentException("Unsupported class: " + aClazz.getName());
        }
    }

    public void print() {
        for (Number elem : mArray) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public Iterator<T> iterator() {
        return (Iterator<T>) mArray.iterator();
    }

    public int size() {
        return mArray.size();
    }

    /**
     * Сортировка пузырьком
     */
    public void sort() {
        boolean fl = true;
        for (int j = 0; j < mArray.size() && fl; ++j) {
            fl = false;
            ListIterator<Number> it1 = mArray.listIterator();
            ListIterator<Number> it2 = mArray.listIterator(1);
            while (it2.hasNext()) {
                Comparable buf1 = (Comparable) it1.next();
                Comparable buf2 = (Comparable) it2.next();
                if (buf1.compareTo(buf2) > 0) {
                    fl = true;
                    it1.set((Number) buf2);
                    it2.set((Number) buf1);
                }
            }
        }
    }

//    public void sort()
//    {
//        boolean fl = true;
//        for (int j = 0; j < mArray.size() && fl ; ++j)
//        {
//            fl = false;
//            ListIterator<Integer> it = mArray.listIterator(0);
//            Integer buf2 = it.next();
//            while (it.hasNext())
//            {
//                Integer buf1 = buf2;
//                buf2 = it.next();
//                if (buf1 > buf2)
//                {
//                    fl = true;
//                    it.set(buf1);
//                    it.previous();
//                    it.previous();
//                    it.set(buf2);
//                    it.next();
//                }
//            }
//        }
//    }
}
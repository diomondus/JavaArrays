import java.util.*;

/**
 * Created by Dmitry Butilov
 * on 08.07.17.
 */

public class DynamicArray<T extends Number> extends ArrayList<T> {

    protected Comparator<T> mComparator;

    /**
     * Создание массива n элементов
     *
     * @param aCount  : размер массива
     * @param aRandom : генератор случайных чисел
     * @param aBound  : диапазон сгенерированных чисел [0..aBound]
     */
    public DynamicArray(int aCount, Random aRandom, Integer aBound, Class<T> aClazz) {
        if (aCount > 0) {
            if (aClazz.isAssignableFrom(Integer.class)) {
                mComparator = Comparator.comparingInt(o -> (Integer) o);
                for (int i = 0; i < aCount; ++i) {
                    add(aClazz.cast(aRandom.nextInt(aBound)));
                }
            } else if (aClazz.isAssignableFrom(Double.class)) {
                mComparator = Comparator.comparingDouble(o -> (Double) o);
                for (int i = 0; i < aCount; ++i) {
                    add(aClazz.cast(aRandom.nextDouble()));
                }
            } else if (aClazz.isAssignableFrom(Float.class)) {
                mComparator = (o1, o2) -> Float.compare((Float) o1, (Float) o2);
                for (int i = 0; i < aCount; ++i) {
                    add(aClazz.cast(aRandom.nextFloat()));
                }
            } else if (aClazz.isAssignableFrom(Long.class)) {
                mComparator = Comparator.comparingLong(o -> (Long) o);
                for (int i = 0; i < aCount; ++i) {
                    add(aClazz.cast(aRandom.nextLong()));
                }
            } else {
                throw new IllegalArgumentException("Unsupported class: " + aClazz.getName());
            }
        }
    }

    public DynamicArray(int aCount, Class<T> aClazz)
    {
        if (aCount > 0) {
            for (int i = 0; i < aCount; ++i) {
                add(aClazz.cast(0));
            }
        }
    }
    public void print() {
        for (Number elem : this) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    /**
     * Сортировка пузырьком
     */
    public void bubbleSort() {
        boolean fl = true;
        for (int j = 0; j < size() && fl; ++j) {
            fl = false;
            ListIterator<T> it1 = listIterator();
            ListIterator<T> it2 = listIterator(1);
            while (it2.hasNext()) {
                T buf1 = it1.next();
                T buf2 = it2.next();
                if (mComparator.compare(buf1, buf2) > 0) {
                    fl = true;
                    it1.set(buf2);
                    it2.set(buf1);
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
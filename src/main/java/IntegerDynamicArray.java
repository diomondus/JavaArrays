import java.util.*;

/**
 * Created by Dmitry Butilov
 * on 08.07.17.
 */

public class IntegerDynamicArray {

    private List<Integer> mArray;

    /**
     * Создание массива n элементов
     *
     * @param aCount  : размер массива
     * @param aRandom : генератор случайных чисел
     * @param aBound  : диапазон сгенерированных чисел [0..aBound]
     */
    public IntegerDynamicArray(int aCount, Random aRandom, Integer aBound) {
        mArray = new ArrayList<>();
        for (int i = 0; i < aCount; ++i) {
            mArray.add(aRandom.nextInt(aBound));
        }
    }

    public void print() {
        for (Integer elem : mArray) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public Iterator<Integer> iterator() {
        return mArray.iterator();
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
            ListIterator<Integer> it1 = mArray.listIterator();
            ListIterator<Integer> it2 = mArray.listIterator(1);
            while (it2.hasNext()) {
                Integer buf1 = it1.next();
                Integer buf2 = it2.next();
                if (buf1 > buf2) {
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
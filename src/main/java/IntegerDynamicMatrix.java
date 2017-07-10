import java.util.*;

/**
 * Created by Dmitry Butilov
 * on 08.07.17.
 */

public class IntegerDynamicMatrix<T extends Number> {
    private List<DynamicArray> mMatrix;
    private Class<T> clazz;

    /**
     * Создание матрицы m строк и n столбцов (m x n) с заполнением случайными числами
     *
     * @param aRows   = m
     * @param aCols   = n
     * @param aRandom : генератор случайных чисел
     * @param aBound  : диапазон сгенерированных чисел [0..aBound]
     */
    public IntegerDynamicMatrix(Integer aRows, Integer aCols, Random aRandom, int aBound, Class<T> clazz) {
        mMatrix = new ArrayList<>();
        for (int i = 0; i < aRows; ++i) {
            mMatrix.add(new DynamicArray(aCols, aRandom, aBound, clazz));
        }
    }

    public int getRowsCount() {
        return mMatrix.size();
    }

    public int getColsCount() {
        return mMatrix.iterator().next().size();
    }

    public void print() {
        for (DynamicArray array : mMatrix) {
            array.print();
        }
    }

    public void sort() {
        for (DynamicArray array : mMatrix) {
            array.sort();
        }
    }

    public T getMaximum() {
        Comparable max = (Comparable) mMatrix.iterator().next().iterator().next();
        for (DynamicArray array : mMatrix) {
            Iterator<T> it = array.iterator();
            while (it.hasNext()) {
                Comparable elem = (Comparable) it.next();
                if (elem.compareTo(max) > 0) {
                    max = elem;
                }
            }
        }
        return (T) max;
    }

    public Integer getMinimum() {
        Comparable min = (Comparable) mMatrix.iterator().next().iterator().next();
        for (DynamicArray array : mMatrix) {
            Iterator<T> it = array.iterator();
            while (it.hasNext()) {
                Comparable elem = (Comparable) it.next();
                if (elem.compareTo(min) < 0) {
                    min = elem;
                }
            }
        }
        return (Integer) min;
    }
}

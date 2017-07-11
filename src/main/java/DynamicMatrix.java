import java.util.*;

/**
 * Created by Dmitry Butilov
 * on 08.07.17.
 */

public class DynamicMatrix<T extends Number> extends ArrayList<DynamicArray<T>>{

    /**
     * Создание матрицы m строк и n столбцов (m x n) с заполнением случайными числами
     *
     * @param aRows   = m
     * @param aCols   = n
     * @param aRandom : генератор случайных чисел
     * @param aBound  : диапазон сгенерированных чисел [0..aBound]
     * @param clazz = преобразователь
     */
    public DynamicMatrix(Integer aRows, Integer aCols, Random aRandom, int aBound, Class<T> clazz) {
        if (aRows > 0 && aCols > 0) {
            for (int i = 0; i < aRows; ++i) {
                add(new DynamicArray<>(aCols, aRandom, aBound, clazz));
            }
        }
    }

    /**
     * Создание нулевой матрицы m строк и n столбцов
     * @param aRows = m
     * @param aCols = n
     * @param clazz = преобразователь
     */
    public DynamicMatrix(Integer aRows, Integer aCols, Class<T> clazz) {
        if (aRows > 0 && aCols > 0) {
            for (int i = 0; i < aRows; ++i) {
                add(new DynamicArray<>(aCols, clazz));
            }
        }
    }

    public int getRowsCount() {
        return size();
    }

    public int getColsCount() {
        return iterator().next().size();
    }

    public void print() {
        for (DynamicArray<T> array : this) {
            array.print();
        }
    }

    public void bubbleRowSort() {
        for (DynamicArray<T> array : this) {
            array.bubbleSort();
        }
    }

    public T getMaximum() {
        T max = iterator().next().iterator().next();
        for (DynamicArray<T> array : this) {
            for (T elem : array) {
                if (array.mComparator.compare(elem, max) > 0) {
                    max = elem;
                }
            }
        }
        return max;
    }

    public T getMinimum() {
        T min =  iterator().next().iterator().next();
        for (DynamicArray<T> array : this) {
            for (T elem : array) {
                if (array.mComparator.compare(elem, min) < 0) {
                    min = elem;
                }
            }
        }
        return min;
    }
}

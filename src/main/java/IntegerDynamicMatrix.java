import java.util.*;

/**
 * Created by Dmitry Butilov
 * on 08.07.17.
 */

public class IntegerDynamicMatrix {
    private List<IntegerDynamicArray> mMatrix;

    /**
     * Создание матрицы m строк и n столбцов (m x n) с заполнением случайными числами
     *
     * @param aRows   = m
     * @param aCols   = n
     * @param aRandom : генератор случайных чисел
     * @param aBound  : диапазон сгенерированных чисел [0..aBound]
     */
    public IntegerDynamicMatrix(Integer aRows, Integer aCols, Random aRandom, int aBound) {
        mMatrix = new ArrayList<>();
        for (int i = 0; i < aRows; ++i) {
            mMatrix.add(new IntegerDynamicArray(aCols, aRandom, aBound));
        }
    }

    public int getRowsCount() {
        return mMatrix.size();
    }

    public int getColsCount() {
        return mMatrix.iterator().next().size();
    }

    public void print() {
        for (IntegerDynamicArray array : mMatrix) {
            array.print();
        }
    }

    public void sort() {
        for (IntegerDynamicArray array : mMatrix) {
            array.sort();
        }
    }

    public Integer getMaximum() {
        Integer max = mMatrix.iterator().next().iterator().next();
        for (IntegerDynamicArray array : mMatrix) {
            Iterator<Integer> it = array.iterator();
            while (it.hasNext()) {
                Integer elem = it.next();
                if (elem > max) {
                    max = elem;
                }
            }
        }
        return max;
    }

    public Integer getMinimum() {
        Integer min = mMatrix.iterator().next().iterator().next();
        for (IntegerDynamicArray array : mMatrix) {
            Iterator<Integer> it = array.iterator();
            while (it.hasNext()) {
                Integer elem = it.next();
                if (elem < min) {
                    min = elem;
                }
            }
        }
        return min;
    }
}

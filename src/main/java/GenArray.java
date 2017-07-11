import java.util.Comparator;

/**
 * Created by Dmitry Butilov
 * on 11.07.17.
 */
public interface GenArray<T extends Number> {
    int a = 0;
    Class<T> clazz();

    Comparator<T> mComparator();

    void print();
}

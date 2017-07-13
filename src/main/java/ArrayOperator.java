import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Dmitry Butilov
 * on 13.07.17.
 */
public class ArrayOperator {

    static ArrayList<? extends Number> add(ArrayList<? extends Number> o1, ArrayList<? extends Number> o2) {
        if (o1 == null || o2 == null || o1.size() != o2.size()) {
            return null;
        } else {
            ArrayList result = new ArrayList();
            Iterator<? extends Number> it1 = o1.iterator();
            Iterator<? extends Number> it2 = o2.iterator();
            while (it1.hasNext()) {
                result.add((it1.next().doubleValue() + it2.next().doubleValue()));
            }
            return result;
        }
    }

    static ArrayList<? extends Number> sub(ArrayList<? extends Number> o1, ArrayList<? extends Number> o2) {
        if (o1 == null || o2 == null || o1.size() != o2.size()) {
            return null;
        } else {
            ArrayList result = new ArrayList();
            Iterator<? extends Number> it1 = o1.iterator();
            Iterator<? extends Number> it2 = o2.iterator();
            while (it1.hasNext()) {
                result.add((it1.next().doubleValue() + it2.next().doubleValue()));
            }
            return result;
        }
    }

    static ArrayList<? extends Number> mul(ArrayList<? extends Number> o1, ArrayList<? extends Number> o2) {
        if (o1 == null || o2 == null || o1.size() != o2.size()) {
            return null;
        } else {
            Double sum = 0.0d;
            ;
            Iterator<? extends Number> it1 = o1.iterator();
            Iterator<? extends Number> it2 = o2.iterator();
            while (it1.hasNext()) {
                sum += it1.next().doubleValue() * it2.next().doubleValue();
            }
            ArrayList result = new ArrayList();
            result.add(sum);
            return result;
        }
    }
}

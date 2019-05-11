/**
 * @author Bartłomiej Chmiel
 */
package SolutionPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

/**
 * Class for comparison of other solutions to the same problem. Returns time of execution of the process in seconds.
 *
 */
public class Performance{
    @SuppressWarnings("Duplicates")
    public static double[] difference0(Integer[][] A)
    {

        double[] timeResult = new double[3];
        long result;


        result =System.nanoTime();
        StringBuilder tempRow = new StringBuilder(A[0].length);
        StringBuilder tempRowNegated = new StringBuilder(A[0].length);
        Hashtable<Integer, Integer> locationList = new Hashtable<>();
        for (int i = 0; i < A.length; i++) {

            for (int k = 0; k < A[i].length; k++) {
                tempRow.append(A[i][k]);
                if (A[i][k] == 0)
                    tempRowNegated.append(1);
                else
                    tempRowNegated.append(0);
            }
            Number temp = new Number(tempRow.toString(), tempRowNegated.toString());

            locationList.computeIfAbsent(temp.hash,current -> new Integer(0));
            locationList.put(temp.hash, locationList.get(temp.hash) + 1);
            tempRow.delete(0, tempRow.length());
            tempRowNegated.delete(0, tempRowNegated.length());


        }
        ArrayList<Integer> l = new ArrayList<>(locationList.values());
        Collections.sort(l);
        Number.data.clear();
        Number.counter = 0;

        timeResult[0] = ((double)(System.nanoTime() - result)/ 1_000_000_000);

        return timeResult;
    }
}
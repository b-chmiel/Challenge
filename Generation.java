/**
 * @author Bartłomiej Chmiel
 */
package SolutionPackage;

import java.util.Random;

/**
 * Simple class used for testing purposes. Uses pseudo-random techniques. It generates matrix with provided
 * dimensions.
 */
public class Generation{
    @SuppressWarnings("Duplicates")
    /**
     * @return  randomly generated matrix with size N X M.
     * @throws java.lang.OutOfMemoryError     if size of matrix exceeds 10000 X 10000.
     */
    public static Integer[][] generateCase(int N, int M)
    {
        Random r = new Random();
        Integer[][] result = new Integer[N][M];
        for(int i=0; i<result.length; i++)
            for(int k=0; k<result[i].length; k++)
                result[i][k] =r.nextInt(2);

        return result;
    }
}


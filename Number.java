/**
 * @author Bartłomiej Chmiel
 */
package SolutionPackage;

import java.util.LinkedList;

/**
 * Class used for creation of new object called document. Generation of this object is crucial because
 * it easily provides unique hashCode for every similar rows. Used in solution class.
 *
 * @see Solution#solution(Integer[][])
 */
public class Number{
    /**
     * Used for storing hash code for number.
     * <p>
     *                    Generation:
     *                    <p>
     *                    check if it is contained
     *                    by {@link Number#data} if it is then hash is equal to index of this row in LinkedList {@link Number#data}.
     *                    If it is not contained then it checks if the flipped version of parameter is contained. If
     *                    it is not then {@link Number#binary} is added to {@link Number#data} and {@link Number#counter} is increased.
     *
     */
    public int hash;
    /**
     * Used for generating unique hash codes.
     * <p>
     * If current object (Flipped or not) is not contained by {@link Number#data}
     * then counter is incremented and assigned to {@link Number#hash}, otherwise counter do not change and is
     * assigned to {@link Number#hash}.
     */
    public static int counter=0;
    /**
     * Used for storing different patterns of rows.
     * <p>
     * There is an assumption that rows are similar if they are equal or
     * flipped version is equal to other unchanged row pattern. Used for purpose of deciding to increment {@link Number#counter}
     * or not.
     */
    public static LinkedList<String> data = new LinkedList<>();
    /**
     *  Used for storing string gained by StringBuilder in {@link Solution} class.
     */
    public String binary="";
    /**
     * Used for storing bitwise negated {@code binary} string.
     */
    public String binaryFlipped="";

    /**
     * Creates new object of number and then assigns to it {@link Number#hash}.
     * @param binary see {@link Number#binary}
     * @param binaryFlipped see {@link Number#binary}
     */
    Number(String binary, String binaryFlipped)
    {
        //assigning values
        this.binary = binary;
        this.binaryFlipped = binaryFlipped;

        //if data contains binary
        if(data.contains(binary))
            hash = data.indexOf(binary);

            //if data contains binaryFlipped
        else if(data.indexOf(binaryFlipped) != -1)
            hash = data.indexOf(binaryFlipped);

            //if data does not contain binary nor binaryFlipped
        else
        {
            hash = counter++;
            data.add(binary);
        }
    }

}

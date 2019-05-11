/**
 * @author Bartłomiej Chmiel
 */
package SolutionPackage;

import java.util.*;
/**
 * Class with solution.
 * <p>
 *
 *@version 1.2 final
 *   <p>
 *   Final solution is based on properties of HashTable.
 *   <p>
 *   In this solution it is treated as an array with option for adding elements with specified index.
 *   Index is just a {@link Number#hash} of the object. It also
 *   makes getting and putting to this Table very efficient.
 *   <p>
 *   If element is not present in this
 *   table then it is created a variable Integer initialised to 0, otherwise corresponding value is incremented.
 *  <p>
 *   At the end of the program in order to get highest value of HashTable it is converted to ArrayList and sorted.
 *
 *  <p>
 *      <strong>Variables used in final solution:</strong>
 *    <p>
 *   -<strong>tempRow</strong>   used for purpose of storing single temporary row of matrix in
 *                    string form(similar to binary)
 *  <p>
 *   -<strong>tempRowNegated</strong>    used for storing bitwise inverted tempRow
 *                            important for checking if it exists in a tree or not
 *  <p>
 *   -<strong>locationList</strong>     used for storing information how many groups(negated or normal considered together) of
 *                        rows are in certain document. Hashing function is used explicitly from {@code Number} class.
 *                        Hashing function gives the same hashes for binary or negated binary. Under specified index
 *                        value of how many similar groups is stored.
 *  <p>
 *   -<strong>locationListSorted</strong>    used at the end of execution of program. Takes highest value of locationList.
 *
 * <p>
 * <p>
 *      <strong>Older versions:</strong>
 *  <p>
 *      <p>
 *  <strong>v1.1</strong>
 *  <p>
 *  Whole idea strongly related to properties of binary search tree.
 *  <p>
 *  Properties used for purpose of this assigment are:
 *  {@code all elements are sorted} and {@code searching for element is very fast (there is no need for checking all elements)}.
 *  Using this very fast finding method in my solution there is very short time for checking if the element (row of matrix)
 *  is inside this tree or not.
 *  <p>
 *   If tree contains element then i take hash code of element and then on index indicated by
 *   this hash code; value (indicating how many similar[flipped or not] rows contain certain matrix) is increased{@code locationList}.
 *  <p>
 *   If tree does not contain element then this element we add to this tree and resets the counter to 1.
 *  <p>
 *   Whole problem with this solution was that despite very fast adding to a tree there was very complex problem how to
 *   calculate same elements (no function to search using object and returning unique index).
 *
 *  <p>
 * <strong>v1.0 stable</strong>
 *<p></p>
 * Idea based on basic comparison of rows in matrix.
 * <p>
 * Each row is compared with other ones by using
 * {@code isRowEqualOrReflected} comparing bits of this strings. This method was highly efficient for all
 * sets of data except case when input matrix was in size approximated to 50000 X 2 (many rows, only 2 columns).
 * Complexity was approximately N*M or N*M*log(N*M) or at worst case 1/2(N*(N-1))*M.
 *

 * @see Number
 */
public class Solution {
    @SuppressWarnings("Duplicates")

    public int solution(Integer[][] A) {
        if (A.length == 1) return 1;
        if (A[0].length == 1) return A.length;

        StringBuilder tempRow = new StringBuilder(A[0].length);
        StringBuilder tempRowNegated = new StringBuilder(A[0].length);
        Hashtable<Integer, Integer> locationList = new Hashtable<>();

        //for each row in the matrix
        for (int i = 0; i < A.length; i++) {

            //making from array of int's string
            for (int k = 0; k < A[i].length; k++) {
                tempRow.append(A[i][k]);
                if (A[i][k] == 0)
                    tempRowNegated.append(1);
                else
                    tempRowNegated.append(0);
            }
            //creation of object and creation of it's "unique" hashCode
            Number temp = new Number(tempRow.toString(), tempRowNegated.toString());

            //Thank you Lambda, very cool!
            locationList.computeIfAbsent(temp.hash,currentElement -> new Integer(0) );

            locationList.put(temp.hash, locationList.get(temp.hash) + 1);
            tempRow.delete(0, tempRow.length());
            tempRowNegated.delete(0, tempRowNegated.length());
        }

        ArrayList<Integer> locationListSorted = new ArrayList<>(locationList.values());
        Collections.sort(locationListSorted);
        Number.data.clear();
        Number.counter = 0;
        return locationListSorted.get(locationListSorted.size() - 1);
    }
}






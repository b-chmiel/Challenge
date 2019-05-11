/**
 * @author Bartłomiej Chmiel
 */
package SolutionPackage;

/**
 * Class for testing purposes.
 */
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[][][] testToAdd = {{{0, 1}, {1, 0}},
                {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}},
                {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}},
                {{1, 1, 1, 0, 1}, {0, 1, 0, 0, 1}, {0, 0, 0, 1, 0}},
                {{1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}},
                {{0, 0, 0, 0}, {0, 1, 0, 0}, {1, 0, 1, 1}},
                {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}}};

        for (int i = 0; i < testToAdd.length; i++)
            System.out.println(s.solution(testToAdd[i]));

        double sum = 0;
        int howMany = 5;
        Integer[][] performanceTest3;

        for (int i = 0; i < howMany; i++) {
            performanceTest3 = Generation.generateCase(2000, 2000);
            sum += Performance.difference0(performanceTest3)[0];
        }
        System.out.println("solution0: " + (sum / howMany));
    }
}
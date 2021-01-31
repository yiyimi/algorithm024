package algoTest;

import algo.Solution;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * Unit test for simple App.
 */
public class SolutionTest
{

    @Test
    public void removeDuplicatesTest() {
        int[] c = new int[]{1,2,3,4,5,6,7};
        Solution.rotate(c, 3);

        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};
        Solution.merge(a, a.length - b.length, b, b.length);
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution.removeDuplicates(nums);
    }

    @Test
    public void moveZeroesTest() {
        int[] a = new int[]{0,1,0,3,12};
        int[] res = new int[]{1,3,12,0,0};
        Solution.twoSum(new int[]{3,2,4}, 6);
        assertArrayEquals(res, Solution.moveZeroes(a));
    }

    @Test
    public void plusOneTest() {
        int[] a = new int[]{8, 9, 9};
        int[] res = new int[]{9, 0, 0};
        assertArrayEquals(res, Solution.plusOne(a));
    }

//    @Test
//    public void longestPalindromeTest() {
//        String param = "cbbd";
//        String res = "bb";
//        assertTrue(res.equals(Solution.longestPalindrome(param)));
//    }

//    @ParameterizedTest
//    @MethodSource("twoSumTestParamList")
//    public void twoSumTest(int[] res, int[] nums, int target) {
//        assertArrayEquals(res, Solution.twoSum(nums, target));
//    }
//
//    static List<Arguments> twoSumTestParamList() {
//        List<Arguments> list = new ArrayList<>();
//        int[] ss = new int[]{2, 4};
//        Arguments arguments = arguments(new int[]{0, 1}, new int[]{2, 7, 11, 15}, 9);
//        Arguments arguments = null;
//        arguments = arguments("test", "test");
//        list.add(arguments);
//        return list;
//    }

    @Test
    public void twoSumtTest() {
        int[] res = new int[]{0, 1};
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        assertArrayEquals(res, Solution.twoSum(nums, target));
    }

    @Test
    public void reverseTest() {
//        int[] nums = new int[]{1, 2, 0, 0};
//        int[] nums = new int[]{9,9,9,9,9,9,9,9,9,9};
//        int K = 34;
//        int[] res = new int[] {1,0,0,0,0,0,0,0,0,3,3};
//        assertEquals(res, Solution.addToArrayForm(nums, K));
//        assertEquals(4, Solution.rob(nums));
        //int val = -1234567;
        //assertEquals(-7654321, Solution.reverse(val));
//        String val = "MCMXCIV";
//        assertEquals(1994, Solution.romanToInt(val));
    }

}

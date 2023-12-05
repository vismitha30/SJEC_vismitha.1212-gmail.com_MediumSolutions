import java.util.ArrayList;
import java.util.List;

class Majority{
    public static List<Integer> majorityElement(int[] v) {
        int n = v.length;

        int cnt1 = 0, cnt2 = 0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && e2 != v[i]) {
                cnt1 = 1;
                e1 = v[i];
            } else if (cnt2 == 0 && e1 != v[i]) {
                cnt2 = 1;
                e2 = v[i];
            } else if (v[i] == e1) cnt1++;
            else if (v[i] == e2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>();

        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == e1) 
            cnt1++;
            if (v[i] == e2) 
            cnt2++;
        }

        int mini = (int) (n / 3) + 1;
        if (cnt1 >= mini) ls.add(e1);
        if (cnt2 >= mini) ls.add(e2);
        return ls;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        List<Integer> result1 = majorityElement(nums1);
        System.out.println("The answer is: " + result1);

        int[] nums2 = {1};
        List<Integer> result2 = majorityElement(nums2);
        System.out.println("The answer is: " + result2);

        int[] nums3 = {1, 2};
        List<Integer> result3 = majorityElement(nums3);
        System.out.println("The answer is: " + result3);
    }
}
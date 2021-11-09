package leetcode;

public class GetHint {
    /* 猜数字游戏
        猜数字游戏需要找到两种数字，要找到位置正确的数字和数字正确但是位置不正确的数字，找正确位置的数字就只需要遍历
    一遍就找到了，需要找正确但位置不正确的数字需要两个数组，将每个数字出现的次数记录下来，需要找到两个数字出现次数少的
    加起来，再减去位置正确的，就是数字正确但是位置不正确的数字。
     */
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        for (int i = 0;i < secret.length();i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }
        }
        int[] nums1 = {0,0,0,0,0,0,0,0,0,0};
        for (int i = 0;i < secret.length(); i++) {
            nums1[Integer.parseInt(String.valueOf(secret.charAt(i)))]++;
        }
        int[] nums2 = {0,0,0,0,0,0,0,0,0,0};
        for (int i = 0;i < guess.length(); i++) {
            nums2[Integer.parseInt(String.valueOf(guess.charAt(i)))]++;
        }
        for (int i = 0;i < 10;i++) {
            cow += Math.min(nums1[i], nums2[i]);
        }
        cow -= bull;
        return bull + "A" + cow + "B";
    }
}

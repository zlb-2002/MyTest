package leetcode;

public class GetHint {
    /* ��������Ϸ
        ��������Ϸ��Ҫ�ҵ��������֣�Ҫ�ҵ�λ����ȷ�����ֺ�������ȷ����λ�ò���ȷ�����֣�����ȷλ�õ����־�ֻ��Ҫ����
    һ����ҵ��ˣ���Ҫ����ȷ��λ�ò���ȷ��������Ҫ�������飬��ÿ�����ֳ��ֵĴ�����¼��������Ҫ�ҵ��������ֳ��ִ����ٵ�
    ���������ټ�ȥλ����ȷ�ģ�����������ȷ����λ�ò���ȷ�����֡�
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

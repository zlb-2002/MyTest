package leetcode;

public class Flower {
    /*�ֻ�����
    �ֻ�������һ��̰�����⣬̰�Ĳ������ҵ�����ط��ܲ����ֻ���Ȼ���������ֻ��ĵط�����ͳ�Ƴ������ж����n�Ĵ�С��ϵ���ɡ�
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            int x = flowerbed[0] == 1 ? n : --n;
        } else {
            for (int i = 0; i < flowerbed.length; i++) {
                if (i == 0) {
                    if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i != flowerbed.length-1) {
                    if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else {
                    if (flowerbed[i-1] == 0 && flowerbed[i] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }
        return n <= 0;
    }

}

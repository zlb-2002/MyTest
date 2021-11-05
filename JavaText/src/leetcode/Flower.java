package leetcode;

public class Flower {
    /*种花问题
    种花问题是一个贪心问题，贪心策略是找到这个地方能不能种花，然后将所有能种花的地方数量统计出来，判断其和n的大小关系即可。
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

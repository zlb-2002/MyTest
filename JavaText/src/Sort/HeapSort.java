package Sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4,9,8,5,6};
        heapSort(arr);
    }

    //堆排序
    public static void heapSort (int[] arr) {
        int i;
        for (i = arr.length/2; i >= 0;i--) {         //将数组调整为一个大顶堆
            HeapSort.adjustHeap(arr, i, arr.length);
        }

        for (i = arr.length-1; i > 0; i--) {
            arr[0] ^= arr[i];                       //将最大值与未排序的最后一个值进行排序
            arr[i] ^= arr[0];
            arr[0] ^= arr[i];
            adjustHeap(arr, 0, i);                //调整大顶堆
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length是在逐渐的减少
     */
    public static void adjustHeap (int[] arr, int i, int length) {
        int temp = arr[i];
        //k = i*2+1  k是i节点的左子节点
        for (int k = i*2+1;k < length;k = k*2+1) {
            if (k+1 < length && arr[k] < arr[k+1]) {        //说明左子节点的值小于右子节点的值
                k++;
            }
            if (arr[k] > temp) {        //如果子节点大于父节点
                arr[i] = arr[k];        //把较大的值赋给当前节点
                i = k;                  //i指向k，继续循环比较
            } else {
                break;
            }
        }
        //for循环结束后，我们已经将以i魏父结点的树的最大值放在了最顶部（局部）
        arr[i] = temp; //将temp的值放到调整后的位置
    }

}

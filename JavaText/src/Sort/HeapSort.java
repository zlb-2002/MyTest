package Sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4,9,8,5,6};
        heapSort(arr);
    }

    //������
    public static void heapSort (int[] arr) {
        int i;
        for (i = arr.length/2; i >= 0;i--) {         //���������Ϊһ���󶥶�
            HeapSort.adjustHeap(arr, i, arr.length);
        }

        for (i = arr.length-1; i > 0; i--) {
            arr[0] ^= arr[i];                       //�����ֵ��δ��������һ��ֵ��������
            arr[i] ^= arr[0];
            arr[0] ^= arr[i];
            adjustHeap(arr, 0, i);                //�����󶥶�
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     * @param arr ������������
     * @param i ��ʾ��Ҷ�ӽڵ��������е�����
     * @param length ��ʾ�Զ��ٸ�Ԫ�ؼ���������length�����𽥵ļ���
     */
    public static void adjustHeap (int[] arr, int i, int length) {
        int temp = arr[i];
        //k = i*2+1  k��i�ڵ�����ӽڵ�
        for (int k = i*2+1;k < length;k = k*2+1) {
            if (k+1 < length && arr[k] < arr[k+1]) {        //˵�����ӽڵ��ֵС�����ӽڵ��ֵ
                k++;
            }
            if (arr[k] > temp) {        //����ӽڵ���ڸ��ڵ�
                arr[i] = arr[k];        //�ѽϴ��ֵ������ǰ�ڵ�
                i = k;                  //iָ��k������ѭ���Ƚ�
            } else {
                break;
            }
        }
        //forѭ�������������Ѿ�����iκ�������������ֵ������������ֲ���
        arr[i] = temp; //��temp��ֵ�ŵ��������λ��
    }

}

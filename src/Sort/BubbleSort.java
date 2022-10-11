package Sort;

/**
 * @Author: Ronnie LEE
 * @Date: 2022/10/11 - 10 - 11 - 9:49
 * @Description: Sort
 * @version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 21, 4, 5, 34};
        bubble_sort(arr);
    }

    public static int[] bubble_sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {  // 比较的轮数（第一轮将最大的数放在最后），每一轮确定一个数位置
            for (int j = 0; j < arr.length - i - 1; j++) {  //  比较的次数
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            System.out.println("==========第" + (i + 1) + "轮 排序结果========== ");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + "\t");
            }
            System.out.println();

        }
        return arr;
    }
}





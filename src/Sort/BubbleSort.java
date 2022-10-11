package Sort;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * @Author: Ronnie LEE
 * @Date: 2022/10/11 - 10 - 11 - 9:49
 * @Description: Sort
 * @version: 1.0
 * //  对数器
 * //  易写，不出错（可能复杂度比较高）
 * //  生成随机数据
 *
 *
 * //   贪心策略 ---> 提出一种标准，就按照这个标准去操作 【无需证明（很复杂），只要和对数器比过之后，就一定是对的】
 *
 * 选课【a. 开始时间最早 b 持续时间最短 c 课程更早结束】
 *
 *  脑部策略 1， 2， 3
 *  写出一个暴力，但是肯定对的方法 （复杂度可能很高，过不了 OJ）
 *  用对数器跑策略 1，2，3
 *
 *
 *  生成随机字符串？？？
 *  先生成一个字符数组，每个 ASCII码( a-z 随机和 A -Z 也随机)，然后再转成 string
 */
public class BubbleSort {
    public static void main(String[] args) {

        int testTime = 500000;
        int size = 100;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);   //  用于打印原始样本
            bubble_sort(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)){
                succeed = false;
                printArray(arr3);   //  1 和 2 经过 排序后都被污染了
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


    public static void bubble_sort(int[] arr) {

        if ((arr == null) || (arr.length < 2)){
            return;
        }

        for (int e = arr.length - 1; e > 0; e--) {  // e 首先指向末尾
            for (int i = 0; i < e; i++) {  //  比较的次数
                if (arr[i] > arr[i + 1]){
                   swap(arr, i, i + 1);
                }
            }
        }
    }

    @Test
    public void m1(){
        System.out.println("m1方法被调用");
    }

    @Test
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    @Test
    //  随机数发生器
    public static int[] generateRandomArray(int size, int value) {
        //  Math.random --> double [0, 1]
        int[] arr = new int[(int)(Math.random() * (size + 1))]; //  [0, size]：长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (value + 1) - (int)(Math.random() * value)); // 有正数，也有负数
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}



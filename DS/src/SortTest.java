import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: SortTest
 * @Description: 排序
 * @Author: Ma Yuanyuan
 */
public class SortTest {
    public static void insertSort(int[] array){
        for(int bound = 1; bound < array.length; bound++){
            int tmp = array[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur--){
                if(array[cur] > tmp){
                    array[cur + 1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1){
            insertSortGap(array,gap);
            gap /= 2;
        }
        insertSortGap(array,1);
    }

    public static void insertSortGap(int[] array, int gap){
        for(int bound = 1;  bound < array.length; bound++){
            int tmp = array[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur -= gap){
                if(array[cur] > tmp){
                    array[cur + gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }
    public static void selectSort(int[] array){
        for(int bound = 0; bound < array.length; bound++){
            for(int cur = bound + 1; cur < array.length; cur++){
                if(array[bound] > array[cur]){
                    swap(array,bound,cur);
                    }
                }
            }
        }
        private static void swap(int[] array, int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
        }

    public static void heapSort(int[] array) {
        createHeap(array);
        System.out.println("建堆后，顺序为" + Arrays.toString(array));
        for(int i = 0; i < array.length - 1; i++){
            swap(array,0,array.length - 1 - i);
            System.out.println("交换后" + i + "顺序为" + Arrays.toString(array) );
            shiftDown(array, array.length - 1 -i, 0);
            System.out.println("向下调整后" + i + "顺序为" + Arrays.toString(array) );
        }
    }

    private static void createHeap(int[] array) {
        for(int i = (array.length - 1 - 1)/2; i >=0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while(child < heapLength){
            if(child + 1 < heapLength && array[child] < array[child + 1]){
                    child = child + 1;
            }
            if( array[child] > array[parent]){
                swap(array,child, parent);
            }else{
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int flag = 0;
            for(int j = 0;j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                    flag += 1;
                    System.out.println(flag);
                }
            }
            if(flag == 0){
                System.out.println(flag);
                break;
            }
        }
    }

//    public static void bubbleSort(int[] array){
//        for(int i = 0; i < array.length;i++){
//            for(int j = array.length - 1; j > i;j--){
//                if(array[j] < array[j-1]){
//                    swap(array,j-1,j);
//                }
//            }
//        }
//    }

    //递归实现快排
    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right){
            return;
        }
        //index是left和right的重合位置，知道这个位置就可以进行递归
        int index = partition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    //非递归版本的快排，借助栈
    public static void notQuickSort(int[] array){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);

        while(!stack.isEmpty()){
            int right = stack.pop();
            int left = stack.pop();

            if(left >= right){
                continue;
            }
            int index = partition(array,left,right);

            stack.push(left);
            stack.push(index - 1);

            stack.push(index + 1);
            stack.push(right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while(i < j){
            while(i < j && array[i] <= base){
                i++;
            }
            while(i < j && array[j] >= base){
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i, right);
        return i;
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array,int left, int right) {
        if(right - left <= 1){
            return;
        }
        int mid = (left + right)/2;
        mergeSortHelper(array,left,mid);
        mergeSortHelper(array,mid,right);

        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0;
        int cur1 = low;
        int cur2 = mid;

            while(cur1 < mid && cur2 < high){
                if(array[cur1] <= array[cur2]){
                    output[outputIndex] = array[cur1];
                    outputIndex++;
                    cur1++;
                }else{
                    output[outputIndex] = array[cur2];
                    outputIndex++;
                    cur2++;
                }
            }
            while (cur1 < mid) {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }
            while(cur2 < high){
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        for (int i = 0; i < high - low; i++) {
            array[low+i] = output[i];
        }
    }

    public static void mergeSortByLoop(int[] array){

        for(int gap = 1; gap < array.length; gap *= 2){
            for(int i = 0; i < array.length; i += gap*2){
                int left = i;
                int mid = i + gap;
                int right = i + 2*gap;
                if(mid > array.length){
                    mid = array.length;
                }
                if(array.length < right){
                    right = array.length;
                }
                merge(array,left,mid,right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arrar = {9,5,2,7,3,6,8};
        //int[] arrar = {1,2,3,4,5,6};
        //insertSort(arrar);
        //shellSort(arrar);
        //selectSort(arrar);
        //heapSort(arrar);
        //bubbleSort(arrar);
        //quickSort(arrar);
        //notQuickSort(arrar);
        //mergeSort(arrar);
        mergeSortByLoop(arrar);
        System.out.println(Arrays.toString(arrar));
    }

}

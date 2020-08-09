import java.util.Arrays;

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
            shiftDown(array, array.length, 0);
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

    public static void main(String[] args) {
        int[] arrar = {9,7,2,5,3,10};
        //insertSort(arrar);
        //shellSort(arrar);
        //selectSort(arrar);
        heapSort(arrar);
        System.out.println(Arrays.toString(arrar));
    }
}

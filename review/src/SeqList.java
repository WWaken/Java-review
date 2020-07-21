import java.util.Arrays;

/**
 * @ClassName: SeqList
 * @Description: 顺序表
 * @Author: Ma Yuanyuan
 */
public class SeqList {
    private int[] data =new int[10];
    private int size = 0;

    public void display(){
        System.out.println(Arrays.toString(data));
        System.out.println('[');
        for (int i = 0; i <size ; i++) {
            System.out.print(data[i]);
            if(i != size-1){
                System.out.println(',');
            }
        }
        System.out.println(']');
    }
    public void realloc(){
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < newData.length ; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
    public void add(int pos,int elem){
        if(pos < -1 || pos > data.length){
            return;
        }
        if(size > data.length){
            realloc();
        }
        if(pos == size){
            data[pos] = elem;
            size++;
        }else {
            for (int i = size; i > pos ; i++) {
                data[i] = data[i-1];
            }
            data[pos] = elem;
            size++;
        }
    }
}

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: FileOperatorTest
 * @Description: 文件操作的测试
 * @Author: Ma Yuanyuan
 */
public class FileOperatorTest {
    @Test
    public void fileRead_1() throws IOException {
        FileInputStream fis = new FileInputStream(new File("F:\\Java\\G.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        //字符流的按行读
        // String line;
//        while((line = br.readLine()) != null){
//            System.out.println(line);
//        }
        //字符流按照字符数组进行读取
        char[] chars = new char[1024];
        int len = 0;
        while((len = br.read(chars,4,30)) != -1){
            String str = new String(chars,0,len);
            System.out.println(str);
        }
    }
    @Test
    public void fileRead_2() throws IOException {
        FileInputStream fis = new FileInputStream(new File("F:\\Java\\G.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        //按字节读取
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes)) != -1){
            String str = new String(bytes);
            System.out.println(str);
        }
    }
    @Test
    public void fileWrite_1() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("F:\\Java\\G.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        //写数据到系统内存缓冲区
        bw.write("第一行\n");
        bw.write("dierhang");
        //缓冲区刷新，发送到目的设备
        bw.flush();
    }

    @Test
    public void copyFile() throws IOException {
        FileInputStream fis = new FileInputStream(new File("F:\\Java\\G.txt"));
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("F:\\Java\\G2.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes)) != -1){
          bos.write(bytes);
          bos.flush();
        }
    }
}

package fileTest;

import com.zyd.tools.files.FilesCopyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @projectName:MyTool
 * @see:PACKAGE_NAME
 * @author:张屹东
 * @createTime:2020/9/28 21:27
 */
public class FilesCopyUtilsTest {
    @Test
    public void Test() throws IOException {
        FilesCopyUtils fcu = new FilesCopyUtils("E:\\js\\2020-09-24", "E:\\js\\aa", ".zip|.rar");
        for (File i : fcu.traverseFolder()) {
            System.out.println(i.getName());
        }
    }

    @Test
    public void TestFile2() throws IOException {
        String oldFile = "E:\\js\\10.12\\15熊浩宇.zip";
        String newFile = "E:\\js\\10.12\\16唐智科.rar";
        //System.out.println(isSameFile(oldFile,newFile));
        System.out.printf("%.2f%n", isSameFile(oldFile, newFile));
    }


    /**
     * 判断两个文件的内容是否相同，文件名要用绝对路径
     *
     * @param fileName1 ：文件1的绝对路径
     * @param fileName2 ：文件2的绝对路径
     * @return 相同返回true，不相同返回false
     */
    public static double isSameFile(String fileName1, String fileName2) throws IOException {
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        try {
            fis1 = new FileInputStream(fileName1);
            fis2 = new FileInputStream(fileName2);

            int len1 = fis1.available();//返回总的字节数
            int len2 = fis2.available();
            int len = Math.min(len1, len2);
            //if (len1 == len2) {//长度相同，则比较具体内容
            //建立两个字节缓冲区
            byte[] data1 = new byte[len1];
            byte[] data2 = new byte[len2];

            //分别将两个文件的内容读入缓冲区
            int read1 = fis1.read(data1);
            int read2 = fis2.read(data2);
            float num = 0;
            System.out.println("len0: "+len);
            //依次比较文件中的每一个字节
            for (int i = 0; i < len; i++) {
                if (data1[i] == data2[i]) {
                    num++;
                }
            }
            System.out.println("num: "+num);
            System.out.println("len: "+len);
            return num/len;
            /*} else {
                //长度不一样，文件肯定不同
                return false;
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//关闭文件流，防止内存泄漏
            IOUtils.close(fis1);
            IOUtils.close(fis2);
        }
        return 0;
    }

    public static String getMD5Two(String path) {
        StringBuffer sb = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(FileUtils.readFileToByteArray(new File(path)));
            byte b[] = md.digest();
            int d;
            for (int i = 0; i < b.length; i++) {
                d = b[i];
                if (d < 0) {
                    d = b[i] & 0xff;
                    // 与上一行效果等同
                    // i += 256;
                }
                if (d < 16)
                    sb.append("0");
                sb.append(Integer.toHexString(d));
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

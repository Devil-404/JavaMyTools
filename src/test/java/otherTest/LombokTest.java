package otherTest;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @projectName:MyTool
 * @see:com.zyd.tool
 * @author:张屹东
 * @createTime:2020/8/20 12:43
 */
@Data
public class LombokTest {
    String a;
    String b;

    public static void main(String[] args) {
        LombokTest t = new LombokTest();
        t.setA("a");
        t.setB("b");
        System.out.println(t);
    }

    @org.junit.Test
    public void test20200926(){
        String fileName="asadas.zip";
        String reg = ".+(.zip|.ZIP|.Zip|.rar|.RAR|.Rra)$";
        Matcher matcher = Pattern.compile(reg).matcher(fileName);
        System.out.println(matcher.find());
    }
}

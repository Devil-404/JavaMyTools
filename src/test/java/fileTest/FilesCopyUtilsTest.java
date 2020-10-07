package fileTest;

import com.zyd.tools.files.FilesCopyUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
        FilesCopyUtils fcu = new FilesCopyUtils("E:\\js\\2020-09-24","E:\\js\\aa",".zip|.rar");
        for(File i:fcu.traverseFolder()){
            System.out.println(i.getName());
        }
    }
}

package client.utils;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author: Skider!!!
 * @create: 2023/8/22
 * @Description:
 * @FileName: FileUtil
 * @History:
 */
public class FileUtil {
    public static String getRunPath() {
        return System.getProperty("user.dir");
    }

    public static Font loadFont(String fontFileName, float fontSize)
    {
        try
        {
            File file = new File(getRunPath() + "\\resource\\font\\" + fontFileName + ".ttf");
            FileInputStream aixing = new FileInputStream(file);
            Font font1 = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font font2 = font1.deriveFont(fontSize);
            aixing.close();
            return font2;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new java.awt.Font("宋体", Font.PLAIN, 12);
        }
    }
}

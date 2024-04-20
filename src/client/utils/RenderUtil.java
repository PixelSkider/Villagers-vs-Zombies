package client.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author: Skider!!!
 * @create: 2023/8/22
 * @Description:
 * @FileName: RenderUtil
 * @History:
 */
public class RenderUtil {
    static Logger logger = LogManager.getLogger(RenderUtil.class);
    public static void drawString(Graphics g, String str, int x, int y){
        g.drawString(str,x,y);
    }

    public static void drawString(Graphics g, String str, int x, int y,Font font){
        g.setFont(font);
        g.drawString(str,x,y);
    }

    public static void drawString(Graphics g, String str, int x, int y, Color fontColor){
        g.setColor(fontColor);
        g.drawString(str,x,y);
    }

    public static void drawString(Graphics g, String str, int x, int y, Color fontColor,Font font){
        g.setFont(font);
        g.setColor(fontColor);
        g.drawString(str,x,y);
    }


    public static void drawImage(Graphics g, String name, int x, int y, int width, int height){
        File file = new File(FileUtil.getRunPath() + "\\resource\\img\\" + name + ".png");
        try {
            BufferedImage image = ImageIO.read(file);
            g.drawImage(image,x,y,width,height,null);

        }catch (IOException e){
            logger.error("read file error");
            e.printStackTrace();
        }
    }

    public static void drawHealthBottom(Graphics g, int x, int y, int health,int height,int width){
        g.setColor(Color.RED);
        g.draw3DRect(x - (120 -width) / 2,y + height + 10,120,10,false);
        g.fillRect(x - (120 -width) / 2,y + height + 10,health + 20,10);
    }

    public static void drawHealthTop(Graphics g, int x, int y, int health,int height,int width){
        g.setColor(Color.RED);
        g.draw3DRect(x - (120 -width) / 2,y - 15,120,10,false);
        g.fillRect(x - (120 -width) / 2,y - 15,health + 20,10);
    }
}

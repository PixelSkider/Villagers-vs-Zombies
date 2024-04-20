package client.entity;

import client.utils.FileUtil;
import client.utils.ScreenUtil;
import client.utils.RenderUtil;

import java.awt.*;

public class Zombie {
    int health = 100;
    int width = 96;
    int height = 96;
    int x = 0;
    int y = 50;
    Boolean moveRight = true;
    public static Boolean isDied = false;
    Font font = FileUtil.loadFont("main",20);

    public Zombie(){

    }

    public void render(Graphics g) {
        if (isDied){
            RenderUtil.drawImage(g,"zombie_die",x,y,width,height);
            RenderUtil.drawString(g,"You Win!",x,y + height + 15,Color.RED,font);
            return;
        }else {
            RenderUtil.drawImage(g,"zombie",x,y,width,height);
            RenderUtil.drawHealthTop(g,x,y,health,width);
        }

        if (moveRight) {
            x += 5;
            if (x >= ScreenUtil.screen_width - width -20) {
                x = ScreenUtil.screen_width - width -20;
                moveRight = false;
            }
        } else {
            x -= 5;
            if (x <= 0) {
                x = 0;
                moveRight = true;
            }
        }
    }

    public void press(boolean a){
        if (health == -20){
            isDied = true;
        }else if (a && health != -20){
            health = health - 5;
        }
    }

}

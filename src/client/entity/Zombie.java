package client.entity;

import client.main.Screen;
import client.utils.RenderUtil;

import java.awt.*;

public class Zombie {
    int health = 100;
    int width = 96;
    int height = 96;
    int x = 0;
    int y = 50;
    Boolean moveRight = true;


    public Zombie(){

    }

    public void render(Graphics g) {
        RenderUtil.drawImage(g,"zombie",x,y,width,height);
        RenderUtil.drawHealthTop(g,x,y,health,height,width);
        if (moveRight) {
            x += 5;
            if (x >= Screen.screen_width - width -20) {
                x = Screen.screen_width - width -20;
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

}

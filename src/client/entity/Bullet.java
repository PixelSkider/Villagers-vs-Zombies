package client.entity;

import client.utils.RenderUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Kalud
 * @website pixelskider.github.io/
 * @since 2024/04/20
 */
public class Bullet {
    public int x;
    public int y;
    int width = 70;
    int height = 70;

    public Bullet(int x,int y){
        this.x = x;
        this.y = y;

    }
    public void render(Graphics g){
        if (y < 0) return;
        RenderUtil.drawImage(g,"bullet",x,y,width,height);
    }

    public void move(){
        this.y -= 40;
    }


}

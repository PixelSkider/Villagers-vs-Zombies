package client.entity;

import client.utils.ScreenUtil;
import client.utils.FileUtil;
import client.utils.RenderUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

import static client.main.Main.logger;

public class Farmer {

    int health = 100;
    int width = 80;
    int height = 100;
    public int x = ScreenUtil.screen_width_half - 40;
    public int y = ScreenUtil.screen_height - height - 50;
    int steps = 3;
    public Boolean isDied = false;
    Zombie zombie = new Zombie();
    Dir dir = Dir.Stop;
    Font font = FileUtil.loadFont("main",20);

    public Farmer(){

    }

    public void render(Graphics g){
        if (isDied){
            RenderUtil.drawImage(g,"farmer_die",x,y,width,height);
            RenderUtil.drawString(g,"You Died",x,y + height + 15,Color.RED,font);
        }else {
            RenderUtil.drawImage(g,"farmer",x,y,width,height);
            RenderUtil.drawHealthBottom(g,x,y,health,height,width);
        }
    }

    public void move(KeyEvent e){
        if (isDied) return;
        switch (e.getKeyCode()){
            case KeyEvent.VK_D:
                if (x <= ScreenUtil.screen_width - width - 30){
                    dir = Dir.D;
                }
                break;
            case KeyEvent.VK_A:
                if (x >= 30){
                   dir = Dir.A;
                }
                break;
            case KeyEvent.VK_S:
                if (y <= ScreenUtil.screen_height - height - 35){
                    dir = Dir.S;
                }
                break;
            case KeyEvent.VK_W:
                if (y >= 30){
                    dir = Dir.W;
                }
                break;
        }

        if (e.getKeyCode() != KeyEvent.VK_W &&
                e.getKeyCode() != KeyEvent.VK_S &&
                e.getKeyCode() != KeyEvent.VK_A &&
                e.getKeyCode() != KeyEvent.VK_D) {
            dir = Dir.Stop;
        }

        switch (dir){
            case A:
                if (x != 10) {
                    x -= 5;
                }
                break;
            case D:
                if (x != ScreenUtil.screen_width - width - 20) {
                    x += 5;
                }
                break;
            case S:
                if (y <= ScreenUtil.screen_height - height - 35) {
                    y += 5;
                }
                break;
            case W:
                if (y >= 30) {
                    y -= 5;
                }
                break;
            case Stop:
                return;
        }
    }

    public void press(boolean a){
        if (health == 0){
            isDied = true;
        }else if (a && health !=  0 && !Zombie.isDied){
            health = health - 5;
        }
    }


}

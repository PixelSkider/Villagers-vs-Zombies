package client.main;

import client.entity.Bullet;
import client.entity.Farmer;
import client.entity.HitBox;
import client.entity.Zombie;
import client.utils.RenderUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends JFrame {
    ArrayList<Bullet> bullets = new ArrayList<>();
    int screen_width = 750,screen_height = 450;
    int screen_width_half = screen_width / 2,screen_height_half = screen_height / 2;
    int count = 0;
    long startTime = System.currentTimeMillis();
    BufferedImage bufferedImage;
    Graphics2D graphics2D;
    Graphics graphics;
    Farmer farmer;
    Zombie zombie;
    HitBox hitbox;
    public static Logger logger;

    public Main(){

        logger = LogManager.getLogger(Main.class);

        logger.info("Starting...");
        logger.info("Init...");
        bufferedImage = new BufferedImage(screen_width, screen_height, BufferedImage.TYPE_INT_ARGB);
        farmer = new Farmer();
        zombie = new Zombie();
        hitbox = new HitBox();
        graphics = bufferedImage.createGraphics();


        logger.info("Init JFrame...");
        this.setIconImage(RenderUtil.getIcon());
        this.setTitle("Villagers vs Zombies");
        this.setSize(750,450);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);


        logger.info("Init Event...");
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //draw
                graphics2D = bufferedImage.createGraphics();
                graphics2D.fillRect(0, 0, screen_width, screen_height);

                bullets.add(new Bullet(farmer.x + 5,farmer.y - 70));
                Iterator<Bullet> iterator = bullets.iterator();
                while (iterator.hasNext()) {
                    Bullet bullet = iterator.next();
                    if (bullet.y < 0) {
                        iterator.remove();
                    } else {
                        bullet.render(graphics2D);
                        bullet.move();
                        zombie.press(hitbox.press(bullet, zombie));
                    }
                }

                farmer.render(graphics2D);
                zombie.render(graphics2D);

                graphics2D.dispose();
                repaint();

                //if
                farmer.press(hitbox.press(farmer,zombie));


            }
        });
        timer.start();


        logger.info("Init Move...");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                farmer.move(e);
            }
        });
        logger.info("Init Done!");
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bufferedImage, 0, 0, this);
    }
}
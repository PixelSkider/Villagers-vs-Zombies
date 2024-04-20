package client.main;

import client.entity.Farmer;
import client.entity.HitBox;
import client.entity.Zombie;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Main extends JFrame {
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
    static Logger logger;

    public Main(){
        this.setSize(750,450);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);

        bufferedImage = new BufferedImage(screen_width, screen_height, BufferedImage.TYPE_INT_ARGB);
        logger = LogManager.getLogger(Main.class);
        farmer = new Farmer();
        zombie = new Zombie();
        hitbox = new HitBox();
        graphics = bufferedImage.createGraphics();

        logger.info("infotest");
        logger.error("errortest");
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //draw
                graphics2D = bufferedImage.createGraphics();
                graphics2D.fillRect(0, 0, screen_width, screen_height);
                farmer.render(graphics2D);
                zombie.render(graphics2D);
                graphics2D.dispose();
                repaint();

                //if
                farmer.press(hitbox.press(farmer,zombie));

            }
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                farmer.move(e);
            }
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bufferedImage, 0, 0, this);
    }
}
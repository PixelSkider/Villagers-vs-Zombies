package client.entity;

/**
 * @Author: Kalud
 * @description:
 * @date: 2024-02-12 16:43
 * @website: pixelskider.github.io
 */
public class HitBox {
    public boolean press(Farmer rect1, Zombie rect2){
        return rect1.x >= rect2.x
                && rect1.x <= rect2.x + rect2.width
                && rect1.y >= rect2.y
                && rect1.y <= rect2.y + rect2.height;
    }

    public boolean press(Zombie rect1, Bullet rect2){
        return rect1.x >= rect2.x
                && rect1.x <= rect2.x + rect2.width
                && rect1.y >= rect2.y
                && rect1.y <= rect2.y + rect2.height;
    }

    public boolean press(Bullet rect1, Zombie rect2){
        return rect1.x >= rect2.x
                && rect1.x <= rect2.x + rect2.width
                && rect1.y >= rect2.y
                && rect1.y <= rect2.y + rect2.height;
    }
}

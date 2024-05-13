package src.entity;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.Main.GamePanel;
import src.Main.keyHandler;

public class Player extends Entity {
    GamePanel gp;
    keyHandler keyH;

    public Player(GamePanel gp, keyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Walking_sprites/boy_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }
    
            apriteCounter++;
            if ((apriteCounter > 10)) {
                if(apriteNum == 1){
                    apriteNum = 2;
                }
               else if(apriteNum == 2){
                    apriteNum = 1;
                } 
                apriteCounter = 0;
            }
        }
     
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.titleSize, gp.titleSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
            if (apriteNum == 1) {
                image = up1;
            }
            if(apriteNum == 2){
                image = up2;
            }
                break;
            case "down":
            if(apriteNum == 1){
                image = down1;
            }
            if(apriteNum == 2){
                image = down2;
            }
                break;
            case "left":
            if(apriteNum == 1){
                image = left1;
            } 
            if(apriteNum == 2){
                image = left2;
            }
                break;
            case "right":
            if(apriteNum == 1){
                image = right1;
            } 
            if(apriteNum == 2){
                image = right2;
            }
                break;
        }
        g2.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);
    }
}

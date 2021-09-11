package gfx;

import core.Direction;
import game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

//Décide de l'animation d'une entité
public class AnimationManager {

    private SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private int updatesPerFrame;
    private int currentframeTime;
    private int frameIndex;
    private int directionIndex;

    public AnimationManager(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
        this.updatesPerFrame = 20;
        this.frameIndex = 0;
        this.directionIndex = 0;
        this.currentframeTime = 0;
        playAnimation("stand");
    }

    //Renvoit la variante de l'animation actuelle
    public Image getSprite(){
        return currentAnimationSheet.getSubimage(
                frameIndex * Game.SPRITE_SIZE,
                directionIndex * Game.SPRITE_SIZE,
                Game.SPRITE_SIZE,
                Game.SPRITE_SIZE
        );
    }

    //Choisit la variante de l'animation
    public void update(Direction direction){
        currentframeTime++;
        directionIndex = direction.getAnimationRow();

        if (currentframeTime >= updatesPerFrame){
            currentframeTime = 0;
            frameIndex++;

            if (frameIndex >= currentAnimationSheet.getWidth() / Game.SPRITE_SIZE){
                frameIndex = 0;
            }
        }
    }

    //Choisit l'action (marche, course, idle, ...)
    public void playAnimation(String name){
        this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
    }
}

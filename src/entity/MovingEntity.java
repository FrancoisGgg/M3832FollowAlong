package entity;

import controller.Controller;
import core.Direction;
import core.Motion;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.awt.*;

//gère les déplacements d'une entité qui bouge
public abstract class MovingEntity extends GameObject {

    private Controller controller;
    private Motion motion;
    private AnimationManager animationManager;
    private Direction direction;

    public MovingEntity(Controller controller, SpriteLibrary spriteLibrary){
        this.controller = controller;
        this.motion = new Motion(2);
        this.direction = Direction.S;
        this.animationManager = new AnimationManager(spriteLibrary.getUnit("matt"));
    }

    //Change la position d'une entity (en appliquant la vitesse) et change son animation
    @Override
    public void update() {
        motion.update(controller);
        position.apply(motion);
        manageDirection(); //change la direction
        decideAnimation(); //change l'animation (walk, idle, ...)
        animationManager.update(direction); //applique la direcion et change l'animation
    }

    protected void decideAnimation(){
        if (motion.isMoving()){
            animationManager.playAnimation("walk");
        }else{
            animationManager.playAnimation("stand");
        }

    }

    protected void manageDirection(){
        if (motion.isMoving()){
            this.direction = Direction.fromMotion(motion);
        }
    }

    //récupéré par game pour être rendered par le renderer
    @Override
    public Image getSprite() {
        return animationManager.getSprite();
    }
}

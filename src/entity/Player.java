package entity;

import controller.Controller;
import core.Position;
import gfx.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends MovingEntity {

    public Player(Controller controller, SpriteLibrary spriteLibrary) {
        super(controller, spriteLibrary);
    }

    //Déplacement de l'entité
    @Override
    public void update() {
        super.update();
    }

}

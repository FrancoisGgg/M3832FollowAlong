package core;

import controller.Controller;

//Gère les déplacements d'une entité
public class Motion {
    private Vector2D vector;
    private double speed;

    public Motion(double speed) {
        this.speed = speed;
        this.vector = new Vector2D(0,0);
    }

    //Calcule la vitesse a chaque frame
    public void update(Controller controller) {
        double deltaX = 0;
        double deltaY = 0;

        if (controller.isRequestingUp()) {
            deltaY--;
        }
        if (controller.isRequestingDown()) {
            deltaY++;
        }
        if (controller.isRequestingRight()) {
            deltaX++;
        }
        if (controller.isRequestingLeft()) {
            deltaX--;
        }

        vector = new Vector2D(deltaX,deltaY);
        vector.normalize();
        vector.multiply(speed);
    }

    public Vector2D getVector() {
        return vector;
    }

    public boolean isMoving() {
        return vector.length()>0;
    }
}

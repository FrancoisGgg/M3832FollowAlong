package core;


public class  Vector2D {

    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //multiplie le vecteur unitaire par une vitesse
    public void multiply(double speed) {
        x *= speed;
        y *= speed;
    }

    //normalise le vecteur (vitesse diag = vitesse orth)
    public void normalize(){
        double length = this.length();
        if (x != 0){
            x/=length;
        }
        if (y != 0){
            y/=length;
        }

    }

    public double length(){
        return Math.sqrt(x*x+y*y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

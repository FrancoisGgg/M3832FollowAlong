import game.Game;
import game.GameLoop;
import gfx.SpriteLibrary;

public class Launcher {

    public static void main(String[] args) {

        new Thread(new GameLoop(new Game(800,600))).start();

        //display.Display display = new display.Display(800,600);


    }

}

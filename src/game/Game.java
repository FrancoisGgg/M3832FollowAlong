package game;

import controller.PlayerController;
import display.Display;
import entity.GameObject;
import entity.Player;
import gfx.SpriteLibrary;
import input.Input;

import java.util.ArrayList;
import java.util.List;

//passé a gameloop de façon a effectuer update() a chaque tick
public class Game {

    public static int SPRITE_SIZE = 64;

    private Display display;
    private List<GameObject> gameObjects;
    private Input input;
    private SpriteLibrary spriteLibrary;

    public Game(int width, int height){
        this.input = new Input();
        this.display = new Display(width, height,input);
        this.gameObjects = new ArrayList<GameObject>();
        this.spriteLibrary = new SpriteLibrary();
        this.gameObjects.add(new Player(new PlayerController(input),spriteLibrary));
    }

    //gameObject.update() effectue les déplacements des entités
    public void update(){
        this.gameObjects.forEach((gameObject -> gameObject.update()));
    }

    //appelle le renderer
    public void render(){
        display.render(this);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}

package display;

import game.Game;
import input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    private Canvas canvas;
    private Renderer renderer;

    //initialise l'écran
    public Display(int w, int h, Input input){

        this.setResizable(false);
        this.setTitle("My 2D game.Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.renderer = new Renderer();

        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(w,h));
        this.canvas.setFocusable(false);
        this.add(canvas);
        this.pack();

        this.addKeyListener(input);

        this.canvas.createBufferStrategy(3);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    //dessine le "black screen" et appelle le rendrer sur toutes les entitées
    public void render(Game game){

        //Display affiche sa fenetre
        BufferStrategy bufferStrategy = this.canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(new Color(174, 145, 241));
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        //Renderer affiche les objets
        graphics.setColor(Color.BLUE);
        renderer.render(game,graphics);

        graphics.dispose();
        bufferStrategy.show();

    }



}

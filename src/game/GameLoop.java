package game;

public class GameLoop implements Runnable{

    private Game game;

    private boolean running;
    private final double updateRate = 1.0d/60.0d;

    private long nextStatTime = 0;
    private int ups,fps = 0;

    public GameLoop(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        running = true;

        long currentTime, lastUpdate = System.currentTimeMillis();
        double acc = 0;

        nextStatTime = System.currentTimeMillis() + 1000;

        while(running){
            currentTime = System.currentTimeMillis();
            double frameTime = (currentTime - lastUpdate) / 1000d;
            acc += frameTime;
            lastUpdate = currentTime;

            if (acc >= updateRate) {
                while (acc >= updateRate) {

                    update();
                    acc -= updateRate;

                }
                render();
            }
            printStats();
        }
    }

    private void printStats(){
        if (System.currentTimeMillis() >= nextStatTime){
            System.out.printf("FPS: %d\nUPS: %d\n",fps,ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update(){
        game.update();
        ups++;
    }

    private void render(){
        game.render();
        fps++;
    }
}

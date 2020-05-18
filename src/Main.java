import dev.federicocapece.jdaze.Engine;

import javax.swing.*;

public class Main extends JFrame {

    public Main(){
        //setting the JFrame
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setting the JDaze engine
        add(Engine.renderer);
        Engine.start();


        //creating the game scripts
        new CameraMove(300).setScales(.1f,10);
        Player player = new Player(0,0);
        new Enemy(player);

    }

    public static void main(String[] args) {
        new Main();
    }
}

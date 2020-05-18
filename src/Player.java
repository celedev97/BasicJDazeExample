import dev.federicocapece.jdaze.Engine;
import dev.federicocapece.jdaze.GameObject;
import dev.federicocapece.jdaze.Input;
import dev.federicocapece.jdaze.Vector;
import dev.federicocapece.jdaze.collider.CircleCollider;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player extends GameObject {

    private static final float SPEED = 20;

    public Player(int x, int y) {
        super(x,y);
        collider = new CircleCollider(this,5);
    }

    @Override
    protected void update() {
        //if the mouse is clicked i teleport the player to the mouse position.
        if(Input.isMouseDown(MouseEvent.BUTTON1)){
            position.set(Input.getMouseWorldPosition());
            return;
        }

        //if the mouse is not clicked i let him move with WASD

        //getting WASD movement vector, and multiplying it by speed and Engine.deltaTime (to make it frame-rate independent)
        Vector movement = Input.getWASDVector().multiplyUpdate(SPEED * Engine.deltaTime);

        //making speed faster if SHIFT is pressed
        if(Input.isKeyDown(KeyEvent.VK_SHIFT))
            movement.multiplyUpdate(3);

        //moving the gameObject using the calculated movement vector.
        move(movement);

    }

    @Override
    protected void draw(Graphics graphics, int x, int y, float scale) {
        graphics.setColor(Color.CYAN);
        float size = (int)collider.size() * scale;
        graphics.fillOval(x+(int)(size/2),y+(int)(size/2),(int) size, (int)size);
    }

}

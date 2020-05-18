import dev.federicocapece.jdaze.Engine;
import dev.federicocapece.jdaze.GameObject;
import dev.federicocapece.jdaze.collider.CircleCollider;
import dev.federicocapece.jdaze.collider.Collider;

import java.awt.*;

public class Enemy extends GameObject {

    private static final float SPEED = 20;
    private Player target;

    public Enemy(Player target) {
        super(-100,-100);
        this.target = target;
        collider = new CircleCollider(this,5);
    }

    @Override
    protected void update() {
        if(target != null){
            moveTowards(target.position, Engine.deltaTime* SPEED);
        }
    }

    @Override
    protected void onCollisionEnter(Collider collider) {
        System.out.println("HIT");
        //target.destroy();
        //target = null;
    }

    @Override
    protected void draw(Graphics graphics, int x, int y, float scale) {
        graphics.setColor(Color.RED);
        float size = (int)collider.size() * scale;
        graphics.fillOval(x+(int)(size/2),y+(int)(size/2),(int) size, (int)size);
    }

}
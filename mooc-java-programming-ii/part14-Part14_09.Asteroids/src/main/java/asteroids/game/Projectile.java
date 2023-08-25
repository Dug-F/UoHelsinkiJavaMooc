package asteroids;

import asteroids.Character;

import javafx.scene.shape.Polygon;

public class Projectile extends Character {

    public Projectile(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }
    
    @Override
    public void move() {
        this.getCharacter().setTranslateX(this.getCharacter().getTranslateX() + this.getMovement().getX());
        this.getCharacter().setTranslateY(this.getCharacter().getTranslateY() + this.getMovement().getY());

        if (this.getCharacter().getTranslateX() < 0 || this.getCharacter().getTranslateX() > AsteroidsApplication.WIDTH) {
            this.setAlive(false);
        }

        if (this.getCharacter().getTranslateY() < 0 || this.getCharacter().getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.setAlive(false);
        }
        
    }

}
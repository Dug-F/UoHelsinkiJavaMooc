package asteroids;

import asteroids.Ship;
import asteroids.Asteroid;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.shape.Polygon;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

public class AsteroidsApplication extends Application {
    public static int WIDTH = 300;
    public static int HEIGHT = 200;
    
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);
        
        AtomicInteger points = new AtomicInteger();
        
        pane.setPrefSize(WIDTH, HEIGHT);
        
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Character> projectiles = new ArrayList<>();
        List<Character> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
          Random rnd = new Random();
          asteroids.add(new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT)));
        };
        
        
        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
        
        
        asteroids.forEach(asteroid -> {
            asteroid.turnRight();
            asteroid.turnRight();
            asteroid.accelerate();
            asteroid.accelerate();
        });
        
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        Point2D movement = new Point2D(1, 0);
        
        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), true);
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), false);
        });
        
        new AnimationTimer() {
            
            @Override
            public void handle(long current) {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }         
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }  
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);
                    
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    
                    pane.getChildren().add(projectile.getCharacter());
                }
                
                if(Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
                
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
                
                projectiles.forEach(projectile -> projectile.move());
                
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid) && projectile.isAlive()) {
                            asteroid.setAlive(false);
                            projectile.setAlive(false);
                        }
                    });
                    
                    if(!projectile.isAlive()) {
                       text.setText("Points: " + points.addAndGet(1000));
                    }
                });
                
                removeCharacters(projectiles, pane);
                removeCharacters(asteroids, pane);

            }  
        }.start();

        
        
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }
    
    private void removeCharacters(List<Character> characters, Pane pane) {
        characters.stream()
                .filter(character -> !character.isAlive())
                .forEach(character -> pane.getChildren().remove(character.getCharacter()));
        characters.removeAll(characters.stream()
                                    .filter(character -> !character.isAlive())
                                    .collect(Collectors.toList()));
    }

}

package puissance4;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
// import javafx.stage.Window;
import jdk.incubator.vector.VectorOperators.Test;

public class App extends Application {
    
    private GameMenu gameMenu;
    private GameMenu gameMenu2;
    private Stage primaryStage = null;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Puissance 4");

        Pane root = new Pane();
        root.setPrefSize(800, 600);

        /* InputStream is = Files.newInputStream(Paths.get("./puissance4.png"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img); */

        gameMenu = new GameMenu();
        

        root.getChildren().addAll(gameMenu);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void test() {

        gameMenu2 = new GameMenu();
        Pane root2 = new Pane();
        root2.setPrefSize(800, 600);

        root2.getChildren().addAll(gameMenu2);

        Scene scene2 = new Scene(root2);

        primaryStage.setScene(scene2);
        primaryStage.show();

    }

    private class GameMenu extends Parent {
        
        public GameMenu(){
            VBox menu0 = new VBox(10);

            menu0.setTranslateX(270);
            menu0.setTranslateY(250);

            MenuButton btnPlay = new MenuButton("Play");
            // Action
            btnPlay.setOnMouseClicked(event -> {
                GameMenu2();
            });

            MenuButton btnQuit = new MenuButton("Quit");
            btnQuit.setOnMouseClicked(event -> {
                Platform.exit();
            });

            menu0.getChildren().addAll(btnPlay, btnQuit);
            getChildren().addAll(menu0);
        }

        public void GameMenu2(){
            VBox menu1 = new VBox(10);

            menu1.setTranslateX(270);
            menu1.setTranslateY(250);

            MenuButton btnPlay = new MenuButton("Local");
            // Action
            btnPlay.setOnMouseClicked(event -> {
                
            });

            MenuButton btnOnline = new MenuButton("Online");
            btnOnline.setOnMouseClicked(event -> {
                
            });

            MenuButton btnQuit = new MenuButton("Quit");
            btnQuit.setOnMouseClicked(event -> {
                Platform.exit();
            });

            menu1.getChildren().addAll(btnPlay, btnOnline, btnQuit);
            getChildren().addAll(menu1);
        }
    }

    private static class MenuButton extends StackPane {
        private Text text;

        public MenuButton(String name) {
            text = new Text(name);
            text.setFont(text.getFont().font(20));
            text.setFill(Color.WHITE);
            Rectangle bg = new Rectangle(250,30);
            bg.setOpacity(0.6);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));

            
            
            setAlignment(Pos.CENTER);
            setRotate(-0.5);
            getChildren().addAll(bg, text);
            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }

    }
    
}

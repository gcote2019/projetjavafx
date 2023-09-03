package ca.qc.bdeb.sim203.projetjavafx;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fenetre {

    public static Stage creer(Scene scene, int posX, int posY, String titre) {
        Stage stage = new Stage();
        stage.setTitle(titre);
        stage.setX(posX);
        stage.setY(posY);
        stage.setScene(scene);
        stage.show();
        return stage;
    }
}

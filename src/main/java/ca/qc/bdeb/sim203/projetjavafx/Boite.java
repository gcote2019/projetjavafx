package ca.qc.bdeb.sim203.projetjavafx;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

// un peu beaucoup inutile cette classe?
public class Boite {
    public static VBox creerVBox() {
        return new VBox();
    }

    public static HBox creerHBox() {
        return new HBox();
    }

    public static boolean ajouter(Pane pane, Node node) {
        if (node != null)
            return pane.getChildren().add(node);
        return false;
    }

}

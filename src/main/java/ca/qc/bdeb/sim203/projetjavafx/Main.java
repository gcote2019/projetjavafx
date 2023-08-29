package ca.qc.bdeb.sim203.projetjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;



public class Main extends Application {
    public static void main(String[] args) { launch(args); }
    private void exemple1(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 150);
        root.getChildren().add(new Text("Ceci n'est pas un titre"));
        root.getChildren().add(new Separator());
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button boutonGauche = new Button();
        boutonGauche.setText("Gauche");
        Button boutonCentre = new Button();
        boutonCentre.setText("Centre");
        Button boutonDroite = new Button();
        boutonDroite.setText("Droite");
        hBox.getChildren().add(boutonGauche);
        hBox.getChildren().add(boutonCentre);
        hBox.getChildren().add(boutonDroite);
        root.getChildren().add(hBox);
        root.getChildren().add(new Separator());
        CheckBox checkBox = new CheckBox();
        checkBox.setText("Voulez-vous cocher cette case?");
        checkBox.setSelected(true);
        root.getChildren().add(checkBox);
        root.setSpacing(10);
        stage.setTitle("Super titre!");
        stage.setScene(scene);
        stage.show();
    }

    private void exemple2(Stage stage) {
        VBox root = new VBox();

        Scene scene = new Scene(root, 400, 500);
        for (int i = 0; i < 30; i++) {
            root.getChildren().add(new Text("Ligne numéro " + (i+1)));
        }
        stage.setTitle("Beaucoup de texte");
        stage.setScene(scene);
        stage.show();
    }

    private void exemple3(Stage stage) {
        HBox root = new HBox();

        Scene scene = new Scene(root, 300, 400);
        root.setAlignment(Pos.CENTER);
        VBox[] vboxes = new VBox[2];
        for (int i = 0; i < vboxes.length; i++) {
            vboxes[i] = new VBox();
            root.getChildren().add(vboxes[i]);
            if (i == 0) {
                for (int j = 0; j < 15; j++) {
                    vboxes[i].getChildren().add(new Text("Ligne numéro " + (j + 1)));
                }
            } else {
                for (int j = 0; j < 15; j++) {
                    Button bouton = new Button();
                    bouton.setText("Bouton numéro " + (j + 1));
                    vboxes[i].getChildren().add(bouton);

                }
            }

        }
        stage.setTitle("Beaucoup de choses");
        stage.setScene(scene);
        stage.show();
    }

    private void exemple4(Stage stage) {
        VBox root = new VBox();

        Scene scene = new Scene(root, 400, 500);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setSpacing(10);
        for (int i = 0; i < 15; i++) {
            Text texte = new Text("Ligne numéro " + (i+1));
            if (i % 2 == 0) {
                Font police = Font.getDefault();
                Font nouvellePolice = Font.font(police.getFamily(), FontWeight.BOLD, FontPosture.ITALIC, police.getSize());
                texte.setFont(nouvellePolice);
                texte.setFill(Color.RED);
            }
            root.getChildren().add(texte);
        }
        stage.setTitle("Textes différents");
        stage.setScene(scene);
        stage.show();
    }

    private void exemple5(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 150);
        root.getChildren().add(new Text("Ceci n'est pas un titre"));
        root.getChildren().add(new Separator());
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        Button boutonGauche = new Button();
        boutonGauche.setText("Gauche");
        //-fx-border-width
        //-fx-border-color
        //-fx-background-color
        //-fx-font-size
        //-fx-text-fill
        boutonGauche.setStyle("-fx-background-color: #ff0000; ");
        Button boutonCentre = new Button();
        boutonCentre.setText("Centre");
        boutonCentre.setStyle("-fx-border-color : #0000ff;-fx-border-width : 10; -fx-text-fill : #ff00ff;");
        Button boutonDroite = new Button();
        boutonDroite.setText("Droite");
        hBox.getChildren().add(boutonGauche);
        hBox.getChildren().add(boutonCentre);
        hBox.getChildren().add(boutonDroite);
        root.getChildren().add(hBox);
        root.getChildren().add(new Separator());
        CheckBox checkBox = new CheckBox();
        checkBox.setText("Voulez-vous cocher cette case?");
        checkBox.setSelected(true);
        root.getChildren().add(checkBox);
        root.setSpacing(10);
        stage.setTitle("Super titre!");
        stage.setScene(scene);
        stage.show();
    }

    private void exemple6(Stage stage) {
        VBox root = new VBox();

        Scene scene = new Scene(root, 400, 500);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setSpacing(10);
        for (int i = 0; i < 15; i++) {
            Text texte = new Text("Ligne numéro " + (i+1));
            if (i % 2 == 0) {
                Font police = Font.getDefault();
                Font nouvellePolice = Font.font(police.getFamily(), FontWeight.BOLD, FontPosture.ITALIC, police.getSize());
                texte.setFont(nouvellePolice);
                texte.setFill(Color.RED);
            }
            root.getChildren().add(texte);
        }
        root.setStyle("-fx-border-color : #0000ff;");
        stage.setTitle("Textes différents");
        stage.setScene(scene);
        stage.show();
    }

    private void exemple7(Stage stage) {
        HBox root = new HBox();

        Scene scene = new Scene(root, 300, 400);
        root.setAlignment(Pos.CENTER);
        VBox[] vboxes = new VBox[2];
        for (int i = 0; i < vboxes.length; i++) {
            vboxes[i] = new VBox();
            vboxes[i].setStyle("-fx-border-color : #0000ff;");
            root.getChildren().add(vboxes[i]);
            if (i == 0) {
                for (int j = 0; j < 15; j++) {
                    if (j % 2 == 0) {
                        vboxes[i].getChildren().add(new Label("Ligne numéro " + (j + 1)));
                    } else {
                        vboxes[i].getChildren().add(new Text("Ligne numéro " + (j + 1)));
                    }
                }
            } else {
                for (int j = 0; j < 15; j++) {
                    Button bouton = new Button();
                    bouton.setText("Bouton numéro " + (j + 1));
                    vboxes[i].getChildren().add(bouton);

                }
            }

        }

        Image image = new Image("mario-droite.png");
        ImageView imageView = new ImageView(image);
        //root.getChildren().add(imageView);
        Button bouton = new Button("Mario");
        bouton.setGraphic(imageView);
        bouton.setContentDisplay(ContentDisplay.TOP);
        root.getChildren().add(bouton);

        bouton.setOnAction(new MonEventHandler());
        EventHandler<ActionEvent> evenement = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("On a cliqué sur Mario");
            }
        };
        bouton.setOnAction(evenement);
        bouton.setOnAction((event) -> {

            System.out.println("Mario!");
        });

        stage.setTitle("Beaucoup de choses");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
    @Override
    public void start(Stage stage) {
        exemple7(stage);
    }
}
package ca.qc.bdeb.sim203.projetjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Main extends Application {
    private final static String[] TEXTE_BOUTONS = {"Gauche", "Centre", "Droite"};
    private final static String[] NOM_DES_CLASSES = {"javafx.scene.text.Text", "javafx.scene.control.Button"};
    private final static String[] TEXTE_DANS_ELEMENT = {"Ligne", "Bouton"};
    private Class[] classes = new Class[NOM_DES_CLASSES.length];
    private final static TypeClasse[] TYPE_CLASSES = {TypeClasse.TEXT, TypeClasse.BUTTON};
    private boolean initClassesFait = false;


    // Pour pouvoir utiliser un scanner dans un projet gradle, voir la modification dans
    // build.gradle.kts pour standardInput
    private Scanner clavier = new Scanner(System.in);


    public static void main(String[] args) { launch(args); }

    private void initClasses() {
        for (int i = 0; i < NOM_DES_CLASSES.length; i++) {
            try {
                classes[i] = Class.forName(NOM_DES_CLASSES[i]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Node creerNode(TypeClasse type, String texte) {
        if (!initClassesFait) {
            initClasses();
            initClassesFait = true;
        }
        Node node = null;
        if (classes[type.indice] != null) {
            try {
                // on va chercher le constructeur qui prend une String comme argument
                node = (Node) classes[type.indice].getConstructor(String.class).newInstance(texte);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return node;
    }

    private void exemple1(Stage fenetrePrinciple, Integer position) {
        
        VBox root = Boite.creerVBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 150);
        Boite.ajouter(root, new Text("Ceci n'est pas un titre"));
        Boite.ajouter(root, new Separator());

        HBox hBox = Boite.creerHBox();
        hBox.setAlignment(Pos.CENTER);
        for (int i = 0; i < TEXTE_BOUTONS.length; i++) {
            Boite.ajouter(hBox, new Button(TEXTE_BOUTONS[i]));
        }
        Boite.ajouter(root, hBox);
        Boite.ajouter(root, new Separator());

        CheckBox checkBox = new CheckBox();
        checkBox.setText("Voulez-vous cocher cette case?");
        // il est sélectionné
        checkBox.setSelected(true);
        Boite.ajouter(root, checkBox);
        root.setSpacing(10);
        Fenetre.creer(scene, position*10, position*10,  "Super titre!");
    }

    private void exemple2(Stage fenetrePrinciple, Integer position) {
        
        VBox root = Boite.creerVBox();

        Scene scene = new Scene(root, 400, 500);
        for (int i = 0; i < 30; i++) {
            Boite.ajouter(root, new Text("Ligne numéro " + (i+1)));
        }
        Fenetre.creer(scene, position*10, position*10,  "Beaucoup de texte");

    }

    private void exemple3(Stage fenetrePrinciple, Integer position) {
        
        HBox root = Boite.creerHBox();

        Scene scene = new Scene(root, 300, 400);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        VBox[] vBoxes = new VBox[2];
        for (int i = 0; i < vBoxes.length; i++) {
            vBoxes[i] = new VBox();
            Boite.ajouter(root, vBoxes[i]);
            for (int j = 0; j < 15; j++) {
                Boite.ajouter(vBoxes[i], creerNode(TypeClasse.TEXT, "Ligne numéro " + (j + 1)));
            }
        }
        Fenetre.creer(scene, position*10, position*10,  "Beaucoup de choses");
    }

    private void exemple4(Stage fenetrePrinciple, Integer position) {
        
        VBox root = Boite.creerVBox();

        Scene scene = new Scene(root, 400, 500);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setSpacing(10);
        for (int i = 0; i < 15; i++) {
            Text texte = new Text("Ligne numéro " + (i+1));
            if (i % 2 == 0) {
                // comment faire en gras et en italique
                texte.setFont(creerPolice(true, true));
                // changer la couleur
                texte.setFill(Color.RED);
            }
            Boite.ajouter(root, texte);
        }
        Fenetre.creer(scene, position*10, position*10,  "Textes différents");
    }

    private void exemple5(Stage fenetrePrinciple, Integer position) {
        
        VBox root = Boite.creerVBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 150);
        Boite.ajouter(root, new Text("Ceci n'est pas un titre"));
        Boite.ajouter(root, new Separator());

        HBox hBox = Boite.creerHBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        //-fx-border-width
        //-fx-border-color
        //-fx-background-color
        //-fx-font-size
        //-fx-text-fill
        // #ff0000 --> RGB en hexadécimal
        String[] styles = {"-fx-background-color: #ff0000; ", "-fx-border-color : #0000ff;-fx-border-width : 10; -fx-text-fill : #ff00ff;", ""};
        for (int i = 0; i < TEXTE_BOUTONS.length; i++) {
            Button bouton = new Button(TEXTE_BOUTONS[i]);
            Boite.ajouter(hBox, bouton);
            if (!styles[i].isEmpty()) {
                bouton.setStyle(styles[i]);
            }
        }
        Boite.ajouter(root, hBox);
        Boite.ajouter(root, new Separator());

        CheckBox checkBox = new CheckBox();
        checkBox.setText("Voulez-vous cocher cette case?");
        checkBox.setSelected(true);

        Boite.ajouter(root, checkBox);
        root.setSpacing(10);
        Fenetre.creer(scene, position*10, position*10,  "Super titre!");
    }

    private Font creerPolice(boolean gras, boolean italique) {
        Font police = Font.getDefault();
        return Font.font(police.getFamily(),
                gras ? FontWeight.BOLD : FontWeight.NORMAL,
                italique ? FontPosture.ITALIC : FontPosture.REGULAR, police.getSize());

    }

    private void exemple6(Stage fenetrePrinciple, Integer position) {
        
        VBox root = Boite.creerVBox();

        Scene scene = new Scene(root, 400, 500);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setSpacing(10);
        for (int i = 0; i < 15; i++) {
            Text texte = new Text("Ligne numéro " + (i+1));
            if (i % 2 == 0) {
                texte.setFont(creerPolice(true, true));
                texte.setFill(Color.RED);
            }
            Boite.ajouter(root, texte);
        }
        root.setStyle("-fx-border-color : #0000ff;");
        Fenetre.creer(scene, position*10, position*10,  "Textes différents");
    }

    private void exemple7(Stage fenetrePrinciple, Integer position) {
        
        HBox root = Boite.creerHBox();

        Scene scene = new Scene(root, 300, 400);
        root.setAlignment(Pos.CENTER);
        VBox[] vBoxes = new VBox[2];
        // On va chercher la classe "Text" et "Button"
        for (int i = 0; i < vBoxes.length; i++) {
            vBoxes[i] = new VBox();
            vBoxes[i].setStyle("-fx-border-color : #0000ff;");
            Boite.ajouter(root, vBoxes[i]);

            for (int j = 0; j < 15; j++) {
                Boite.ajouter(vBoxes[i], creerNode(TYPE_CLASSES[i], TEXTE_DANS_ELEMENT[i] + " numéro " + (j + 1)));
            }
        }

        Image image = new Image("mario-droite.png");
        ImageView imageView = new ImageView(image);

        Button bouton = new Button("Mario");
        bouton.setGraphic(imageView);
        bouton.setContentDisplay(ContentDisplay.TOP);
        Boite.ajouter(root, bouton);


        // si on regarde setOnAction, on voit que la signature est
        // public final void setOnAction(EventHandler<ActionEvent> value)
        // et
        // public interface EventHandler<T extends Event> extends EventListener {
        //
        // 1-On peut se définir une classe qui implémente cette interface

        bouton.setOnAction(new MonEventHandler());

        //
        // 2-On peut se défnir une classe anonyme
        EventHandler<ActionEvent> evenement = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("On a cliqué sur Mario");
            }
        };
        bouton.setOnAction(evenement);
        //
        // 3-lambda
        bouton.setOnAction((event) -> {

            System.out.println("Mario!");
        });

        Fenetre.creer(scene, position*10, position*10,  "Beaucoup de choses");

    }


    private int lireNombre(int min, int max) {
        int nombre = min - 1;
        do {
            System.out.print("Choisir un exemple entre " + min + " et " + max + " svp ");
            try {
                nombre = clavier.nextInt();
            } catch (NumberFormatException e) {

            }

            if (nombre < min || nombre > max) {
                System.out.println("SVP entrez un nombre entre " + min + " et " + max);
            }
        } while (nombre < min || nombre > max);
        return  nombre;

    }
    @Override
    public void start(Stage fenetrePrinciple) {
        //int choix = lireNombre(1, 7);

        fenetrePrinciple.setTitle("Les exemples");
        fenetrePrinciple.show();
        for (int i = 1; i <= 7; i++) {
            Method methode = null;
            try {
                // ceci est une façon d'aller chercher une méthode
                // getMethod si publique
                // getDeclaredMethod sinon
                methode = Main.class.getDeclaredMethod("exemple" + i, Stage.class, Integer.class);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            try {
                methode.invoke(this, fenetrePrinciple, i);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
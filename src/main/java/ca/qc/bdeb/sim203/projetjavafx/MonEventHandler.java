package ca.qc.bdeb.sim203.projetjavafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MonEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Et tu, Mario?");
    }
}

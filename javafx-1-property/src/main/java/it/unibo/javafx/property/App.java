package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Controls Exercise!");
        final VBox mainPane = new VBox();
        final Counter counter = new Counter();
        
        // TODO aggiungere gli elementi come descritto da readme
        final Label label = new Label();
        label.textProperty().bind(counter.counterProperty().asString()); //associo a questa label l'oout con il numero del contatore

        final HBox buttons = new HBox(); //questo rappresenta il contenitore dei buttons
        final Button increment = new Button("+");
        final Button decrement = new Button("-");

        increment.setMinWidth(100);
        decrement.setMinWidth(100);

        increment.setOnAction(e->counter.increment());
        decrement.setOnAction(e->counter.decrement());

        //aggiungo i bottoni al contenitore
        buttons.getChildren().addAll(increment, decrement);

        //aggiungo i nodi al contenitore principale
        mainPane.getChildren().addAll(label, buttons);

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}

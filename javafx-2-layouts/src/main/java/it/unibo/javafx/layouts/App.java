package it.unibo.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Il root è un BorderPane, che divide la finestra in 5 aree: top, bottom, left, right, center.
        // Noi usiamo solo left e center.
        BorderPane root = new BorderPane();
        // Aggiungo i fogli di stile
        root.getStylesheets().add("dracula.css");
        root.getStylesheets().add("style.css");
        root.setId("root");
        // Left Pane, contiene il titolo e il form per aggiungere nuovi task.
        VBox leftPane = new VBox();
        leftPane.setId("left-pane");
        // TODO aggiungere il titolo e i pulsanti
        leftPane.setAlignment(Pos.TOP_CENTER);
        
        //titiolo del left pane
        Label leftPaneTitle = new Label("Todo App");
        leftPaneTitle.getStyleClass().add("title-1");
        leftPaneTitle.getStyleClass().add("accent");

        //button "Add" del left pane
        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");

        //aggiungo gli elementi al leftpane
        leftPane.getChildren().addAll(leftPaneTitle, newTaskField, addButton);
        //-----------------------------------------------------------------------

        //center pane, contiene la lista di task
        VBox rightPane = new VBox();
        rightPane.setId("right-pane");
        rightPane.setAlignment(Pos.TOP_CENTER);

        //title del right pane
        Label rightPaneTitle = new Label("Tasks");
        rightPaneTitle.getStyleClass().add("title-2");
        rightPaneTitle.getStyleClass().add("accent");

        //area dei task
        HBox tasksArea = new HBox();
        //occupa tutto lo spazio disponibile
        VBox.setVgrow(tasksArea, Priority.ALWAYS);
        tasksArea.setId("tasks-area");
        
        VBox todoList = new VBox();
        todoList.setAlignment(Pos.TOP_CENTER);
        Label todoPart = new Label("Todo");
        todoPart.getStyleClass().add("title-3");

        VBox doneList = new VBox();
        doneList.setAlignment(Pos.TOP_CENTER);
        Label donePart = new Label("Done");
        donePart.getStyleClass().add("title-3");

        //aggiungo gli elementi alle rispettive liste
        todoList.getChildren().addAll(todoPart);
        doneList.getChildren().addAll(donePart);

        //imposto larghezza minima alle liste
        HBox.setHgrow(todoList, Priority.ALWAYS);
        HBox.setHgrow(doneList, Priority.ALWAYS);
        tasksArea.getChildren().addAll(todoList, doneList);
        rightPane.getChildren().addAll(rightPaneTitle, tasksArea);

        //aggiungo un paio di task per esempio
        var task1 = createTaskSection("Task1");
        var task2 = createTaskSection("Task2");
        todoList.getChildren().addAll(task1, task2);

        //aggiungo i dati di qualche task completa per esempio
        VBox doneTask = new VBox(new Label("Task 2"));
        doneTask.getStyleClass().add("task");
        doneList.getChildren().add(doneTask);

        // Imposto i pannelli sinistro e centrale come figli del root.
        root.setLeft(leftPane);
        root.setCenter(rightPane);

        // Set scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("ToDo List App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Main {
        public static void main(String... args) {
            Application.launch(App.class, args);
        }
    }

    // Crea un todo composto da una label e un bottone per segnare il task come completato.
    public static Node createTaskSection(String content) {
        HBox task = new HBox();
        task.getStyleClass().add("task");
        Label taskLabel = new Label(content);
        VBox textBox = new VBox(taskLabel);
        Button doneButton = new Button("X");
        HBox.setHgrow(textBox, Priority.ALWAYS);
        task.getChildren().addAll(textBox, doneButton);
        return task;
    }
}

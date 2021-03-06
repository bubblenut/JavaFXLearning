package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class StroopEffect extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stroop Effect");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));

        primaryStage.show();
    }

    private Parent createInterface() {

        Button button = new Button("Добавить");
        button.setPrefSize(160,50);
        button.setMinSize(160, 50);

        Label[] labels = new Label[]{new Label("Синий"), new Label("Желтый"), new Label("Фиолетвый"), new Label("Черный")};
        Rectangle[] rectangles = new Rectangle[]{new Rectangle(228, 28), new Rectangle(228, 28)};


        labels[0].setTextFill(Color.PURPLE);
        labels[1].setTextFill(Color.GREEN);
        labels[2].setTextFill(Color.ORANGE);
        labels[3].setTextFill(Color.RED);

        rectangles[0].setFill(Color.BLUE);
        rectangles[1].setFill(Color.PURPLE);

        GridPane grid = new GridPane();
        grid.setStyle("-fx-font-size: 24px;");

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(col1);

        VBox vb1 = new VBox();
        vb1.setStyle("-fx-font-weight: bold");
        vb1.setAlignment(Pos.CENTER);
        GridPane.setValignment(button, VPos.TOP);

        //Начинаем добавлять
        grid.add(vb1, 0, 0);
        grid.add(button, 1, 0);
        vb1.getChildren().addAll(
                labels[0],
                labels[1],
                labels[2],
                rectangles[0],
                labels[3],
                rectangles[1]
        );


        // Вторая задача
        Color[] palette = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.VIOLET, Color.BLACK};
        String[] words = new String[]{"Красный", "Оранжевый", "Желтый", "Зеленый", "Голубой", "СИНИй", "Фиолетовый", "Черный"};

        Random randomize = new Random();

        button.addEventHandler(ActionEvent.ACTION, actionEvent -> {

            boolean isRect = randomize.nextBoolean();

            Color randomColor = palette[randomize.nextInt(8)];

            if(isRect){
                Rectangle newRect = new Rectangle(228, 28);
                newRect.setFill(randomColor);
                vb1.getChildren().add(newRect);
            }else{
                String randomWord = words[randomize.nextInt(8)];
                Label newText = new Label(randomWord);
                newText.setTextFill(randomColor);
                vb1.getChildren().add(newText);
            }

            if(vb1.getChildren().size() == 11){
                vb1.getChildren().remove(0);
            }

        });

        return grid;
    }
}

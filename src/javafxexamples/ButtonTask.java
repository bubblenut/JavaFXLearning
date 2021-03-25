package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class ButtonTask extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про слушателей");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));

        primaryStage.show();
    }

    private Parent createInterface() {
        Button b = new Button("Кнопка");
        Label label = new Label("Это метка с текстом");
        Image image = new Image("alien_hardcore_porn.jpg");
        ImageView imageView = new ImageView(image);



        GridPane grid = new GridPane();
        VBox vb1 = new VBox();
        grid.add(vb1, 0, 0);
        vb1.getChildren().addAll(
                b,
                label
        );



       AtomicInteger rage = new AtomicInteger(0);
        //Я разобрался как работает эта штука
        //Если я правильно все понял, eventHandler создает поток
        //Потому мы не можем безопасно  брать обычные int или Integer и переписывать их
        //А вот атомарные вполне можем
        //Короче это не от балды сделано, если надо будет - я объясню

        String[] alarms= new String[]{"Не нажимай", "Правда, не стоит", "Ради христа, прекрати", "Это для твоего же блага", "Еще одно нажатие, и я покажу тебе страшную фотку"};
        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            if (rage.get() < alarms.length){
                label.setText(alarms[rage.get()]);
            }else{
                vb1.getChildren().remove(b);
                vb1.getChildren().remove(label);
                vb1.getChildren().add(imageView);

            }
            rage.getAndIncrement();
        });

        return grid;
    }
}
package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private String appName = "Password Generator", genBtnName = "Generate Password",copybtntext="Copy To ClipBoard";
    private Button generateButton, copyButton;
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    private Image iconImage;
    private TextField inputLengthField;
    private Text showingTextArea;

    @Override
    public void start(Stage primaryStage)  {

        primaryStage.setTitle(appName);

        VBox layout = new VBox();
        layout.setPadding(new Insets(100, 20, 20, 20));
        layout.setSpacing(40);
        Scene scene = new Scene(layout, 400, 500);

        generateButton = new Button(genBtnName);
        copyButton = new Button(copybtntext);
        showingTextArea = new Text();
        inputLengthField = new TextField();
        iconImage = new Image("/key_icon.png");

        primaryStage.getIcons().add(iconImage);
        primaryStage.setResizable(true);
/*
        Image mybi = new Image("/bg.jpg");
        ImageView imageView = new ImageView(mybi);
        imageView.setFitHeight(scene.getHeight());
        imageView.setFitWidth(scene.getWidth());
*/

        layout.getChildren().addAll(inputLengthField, generateButton, showingTextArea, copyButton);

        primaryStage.setScene(scene);

        inputLengthField.setOnAction(e -> {
            if (!inputLengthField.getText().isEmpty())
                showingTextArea.setText(geek_Password(inputLengthField.getText()));
            else
                showingTextArea.setText("Enter Password Length to Generate");
        });
        generateButton.setOnAction(e -> {
            if (!inputLengthField.getText().isEmpty())
                showingTextArea .setText(geek_Password(inputLengthField.getText()));
            else
                showingTextArea.setText("Enter Password Length to Generate");
        });
        copyButton.setOnAction(e->{
            if(!showingTextArea.getText().isEmpty()){
                final ClipboardContent clipboardContent = new ClipboardContent();
                clipboardContent.putString(showingTextArea.getText());
                clipboard.setContent(clipboardContent);
            }
        });

//then you set to your node

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static String geek_Password(String length) {
        int len = Integer.parseInt(length);

        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";


        String values = Capital_chars + Small_chars +
                numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] = values.charAt(rndm_method.nextInt(values.length()));
        }
        return new String(password);
    }
}

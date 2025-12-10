import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class MoodMate extends Application {

    Label resultLabel = new Label();

    @Override
    public void start(Stage stage) {

        Label title = new Label("💙 MoodMate – Study Buddy");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        title.setTextFill(javafx.scene.paint.Color.DARKBLUE);

        Label moodLabel = new Label("How are you feeling right now?");
        moodLabel.setFont(Font.font(16));

        ComboBox<String> moodBox = new ComboBox<>();
        moodBox.getItems().addAll(
                "😵 Tired",
                "😐 Bored",
                "😎 Motivated",
                "😤 Stressed"
        );
        moodBox.setPromptText("Select your mood");

        Button suggestBtn = new Button("✨ Give Me Study Plan");
        suggestBtn.setStyle(
                "-fx-background-color: #4CAF50; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 14px; " +
                "-fx-padding: 10 20 10 20;"
        );

        resultLabel.setWrapText(true);
        resultLabel.setFont(Font.font(15));
        resultLabel.setPadding(new Insets(10));
        resultLabel.setStyle(
                "-fx-background-color: #F0F8FF; " +
                "-fx-border-color: #ADD8E6;"
        );

        suggestBtn.setOnAction(e -> {
            String mood = moodBox.getValue();

            if (mood == null) {
                resultLabel.setText("⚠️ Please select a mood first!");
                return;
            }

            switch (mood) {
                case "😵 Tired":
                    resultLabel.setText(
                            "🕒 Study: 25 minutes\n" +
                            "☕ Break: Power nap or light tea\n" +
                            "✨ Quote: 'Rest when tired, not quit.'"
                    );
                    break;

                case "😐 Bored":
                    resultLabel.setText(
                            "🕒 Study: 30 minutes\n" +
                            "🎧 Break: Music or walk\n" +
                            "✨ Quote: 'Discipline beats boredom.'"
                    );
                    break;

                case "😎 Motivated":
                    resultLabel.setText(
                            "🕒 Study: 60 minutes\n" +
                            "☕ Break: Reward yourself\n" +
                            "✨ Quote: 'You’re unstoppable today!'"
                    );
                    break;

                case "😤 Stressed":
                    resultLabel.setText(
                            "🕒 Study: 20 minutes\n" +
                            "🧘 Break: Deep breathing\n" +
                            "✨ Quote: 'Calm mind = sharp brain.'"
                    );
                    break;
            }
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));
        layout.getChildren().addAll(
                title,
                moodLabel,
                moodBox,
                suggestBtn,
                resultLabel
        );

        Scene scene = new Scene(layout, 450, 450);
        stage.setTitle("MoodMate");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

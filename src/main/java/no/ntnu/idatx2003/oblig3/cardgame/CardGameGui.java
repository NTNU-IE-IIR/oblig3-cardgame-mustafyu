package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.List;

/**
 * Represents a GUI for Cardgame
 * <p>
 * The GUI is used to play the card game. The GUI is used to display the cards and the game state.
 */
public class CardGameGui extends Application {

  private final DeckOfCards deck = new DeckOfCards();

  /**
   * Starts the application.
   *
   * @param stage the stage to display in the application.
   * @throws Exception if an error occurs.
   */

  @Override
  public void start(Stage stage) throws Exception {
    BorderPane borderPane = new BorderPane();

    /**
     * Handles the action event for dealing a hand of cards.
     */
    VBox dealHandBox = new VBox(10);
    Button dealhand = new Button("Deal hand");
    dealhand.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        List<PlayingCard> hand = deck.dealHand(5);
        System.out.println("Hand Dealt: " + hand);
        // Clear the display area
        displayArea.getChildren().clear();
        // Display the hand of cards
        for (PlayingCard card : hand) {
          displayArea.getChildren().add(new CardView(card));
        }
      }
    });
    dealHandBox.getChildren().add(dealhand);
    dealHandBox.setPadding(new Insets(10));
    dealHandBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    /**
     * Handles the action event for checking the hand of cards.
     */

    VBox checkHandBox = new VBox(10);
    Button checkhand = new Button("Check hand");
    checkhand.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        checkHand();
      }
    });

    checkHandBox.getChildren().add(checkhand);
    checkHandBox.setPadding(new Insets(10));
    checkHandBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    VBox handsDisplayBox = new VBox();
    handsDisplayBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    handsDisplayBox.setMinSize(300, 300);
    handsDisplayBox.setMaxSize(300, 300);
    handsDisplayBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    VBox buttonContainer = new VBox(10);
    buttonContainer.getChildren().addAll(dealhand,checkhand);
    buttonContainer.setAlignment(Pos.CENTER);

    buttonContainer.setPadding(new Insets(10));


    HBox contentBox = new HBox(10);
    contentBox.getChildren().addAll(handsDisplayBox, buttonContainer);
    contentBox.setAlignment(Pos.CENTER);

    borderPane.setCenter(contentBox);

    Scene scene = new Scene(borderPane, 800, 600);
    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();
    }

  // Method to check the hand
  private void checkHand() {
    // Implement your logic for checking the hand here
  }


  // Custom class representing a visual representation of a card
  private class CardView extends Pane {
    public CardView(PlayingCard card) {
      // Create a visual representation of the card
      // You can customize this based on your requirements
      setPrefSize(100, 100);
      setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
      setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
      setStyle("-fx-font-size: 16; -fx-alignment: center;");
      setCenterShape(true);
      setLayoutX(card.getFace() * 10);
      setLayoutY(card.getFace() * 10);
      setAccessibleText(card.getAsString());
    }
  }

  // Display area for showing the cards
  private final VBox displayArea = new VBox();

  /**
   * Launches the application.
   */

  public static void appMain(String[] args) {
    launch(args);
  }
}

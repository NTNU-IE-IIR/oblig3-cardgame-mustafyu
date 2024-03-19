package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.w3c.dom.Node;
import javafx.scene.control.TextArea;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.layout.TilePane.setAlignment;

/**
 * Represents a GUI for Cardgame
 * <p>
 * The GUI is used to play the card game. The GUI is used to display the cards and the game state.
 */
public class CardGameGui extends Application {

  private final DeckOfCards deck = new DeckOfCards();

  private final TextArea outputArea = new TextArea();

  private boolean handDealt = false;



  /**
   * Starts the application.
   *
   * @param stage the stage to display in the application.
   * @throws Exception if an error occurs.
   */

  @Override
  public void start(Stage stage) throws Exception {

    BorderPane borderPane = new BorderPane();

    HBox displayArea = new HBox(); // Change VBox to HBox for horizontal layout
    displayArea.setAlignment(Pos.CENTER);
    displayArea.setPadding(new Insets(10));
    displayArea.setSpacing(10);
    /**
     * Handles the action event for checking the hand of cards.
     */

    VBox checkHandBox = new VBox(10);
    Button checkhand = new Button("Check hand");

    checkhand.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if ( handDealt){
            analyzeHand();
          checkhand.setDisable(true);
        }
      }
    });

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
        checkhand.setDisable(false);
        handDealt = true;
      }
    });

    dealHandBox.getChildren().add(dealhand);
    dealHandBox.setPadding(new Insets(10));
    dealHandBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


    checkHandBox.getChildren().add(checkhand);
    checkHandBox.setPadding(new Insets(10));
    checkHandBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    VBox handsDisplayBox = new VBox();
    handsDisplayBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    handsDisplayBox.setMinSize(300, 300);
    handsDisplayBox.setMaxSize(300, 300);
    handsDisplayBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    handsDisplayBox.setAlignment(Pos.CENTER);

    handsDisplayBox.getChildren().add(displayArea);

    VBox buttonContainer = new VBox(10);
    buttonContainer.getChildren().addAll(dealhand, checkhand);
    buttonContainer.setAlignment(Pos.CENTER);

    buttonContainer.setPadding(new Insets(10));


    HBox contentBox = new HBox(10);
    contentBox.getChildren().addAll(handsDisplayBox, buttonContainer);
    contentBox.setAlignment(Pos.CENTER);

    borderPane.setCenter(contentBox);


    VBox contentAndAnalysisBox = new VBox(10);
    contentAndAnalysisBox.getChildren().addAll(contentBox, outputArea); // Add both contentBox and analysisBox to the VBox

    contentAndAnalysisBox.setAlignment(Pos.CENTER); // Center the VBox contents
    VBox.setMargin(outputArea, new Insets(0,0,0,-100)); // Add margin to the analysisBox

    borderPane.setCenter(contentAndAnalysisBox);


    outputArea.setEditable(false);
    outputArea.setWrapText(true);
    outputArea.setMaxWidth(300); // Set maximum width
    outputArea.setMaxHeight(150); // Set maximum height




    Scene scene = new Scene(borderPane, 800, 600);
    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();
  }

  // Method to check the hand
  private void analyzeHand() {
    // Get the current hand from the DeckOfCards instance
    List<PlayingCard> hand = deck.dealHand(5);

    // Call the methods from HandAnalyzer and perform the analyses
    int sum = CheckCardAnalize.sumOfCardValues(hand);
    String hearts = CheckCardAnalize.getHeartsCards(hand);
    boolean hasSparDame = CheckCardAnalize.hasQueenOfSpades(hand);
    boolean isFiveFlush = CheckCardAnalize.isFiveFlush(hand);

    // Update the TextArea with the analysis results
    outputArea.setText("Sum of card values: " + sum +
      "    Hearts: " + hearts + '\n' + '\n' +
      " Has Spar Dame: " + hasSparDame +
      "     Is 5-flush: " + isFiveFlush);
  }


  // Display area for showing the cards
  private final VBox displayArea = new VBox();

  /**
   * Launches the application.
   */

  public static void appMain(String[] args) {
    launch(args);
  }


    // Method to check if the cards form a 5-flush
    private class CardView extends Pane {
      public CardView(PlayingCard card) {
        // Create an image view for the card
        ImageView imageView = new ImageView();
        // Load the image based on the card's suit and rank
        String imageName = "/cards/" + card.getAsString() + ".png"; // Assuming the images are stored in the "card" directory
        InputStream inputStream = getClass().getResourceAsStream(imageName);
        if (inputStream != null) {
          javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream(imageName));
          imageView.setImage(image);
          imageView.setFitWidth(50);
          imageView.setFitHeight(80);// Centering each CardView
          setPadding(new Insets(20)); // Adjusting padding
          getChildren().add(imageView);
        } else {
          System.out.println("Image file not found: " + imageName);
        }
      }



    }
}

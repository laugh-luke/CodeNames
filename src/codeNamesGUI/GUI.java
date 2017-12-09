//Written By Luke

package codeNamesGUI;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.imageio.plugins.common.SubImageInputStream;

import codeNames.Clue;
import codeNames.Help;
import codeNames.Start;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

	/*
	 * @Override public void start(Stage primaryStage) { Button btn = new Button();
	 * btn.setText("Say 'Hello World'"); btn.setOnAction(new
	 * EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent event) {
	 * System.out.println("Hello World!"); } });
	 * 
	 * StackPane root = new StackPane(); root.getChildren().add(btn);
	 * 
	 * Scene scene = new Scene(root, 300, 250);
	 * 
	 * primaryStage.setTitle("Hello World!"); primaryStage.setScene(scene);
	 * primaryStage.show(); }
	 */

	private ArrayList<Parent> createContent(Start Game, Stage primaryStage, Stage secondaryStage) {
		Pane spyRoot = new Pane();
		spyRoot.setPrefSize(510, 700);

		Pane root = new Pane();
		root.setPrefSize(510, 700);

		// Clue Input

		TextField clueText = new TextField();
		clueText.setText("Word");
		clueText.setOnMouseClicked(event -> {
			clueText.setText("");
			// System.out.println("Clicked " + nClicks + " times.");
		});
		clueText.setTranslateX(5);
		clueText.setTranslateY(615);
		spyRoot.getChildren().add(clueText);

		ObservableList<String> options = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9");
		final ComboBox clueInt = new ComboBox(options);
		clueInt.setValue("0");

		// TextField clueInt = new TextField();
		// clueInt.setText("Number");
		// clueInt.setOnMouseClicked(event -> {
		// clueInt.setText("");
		// System.out.println("Clicked " + nClicks + " times.");

		clueInt.setTranslateX(155);
		clueInt.setTranslateY(615);
		spyRoot.getChildren().add(clueInt);

		// Information Tiles
		ArrayList<Tile> commandTiles = new ArrayList<Tile>();
		// Turn Status Tile

		/*
		 * Tile TurnTile = new Tile(Game, commandTiles, Tile.getType(), "peach","turn");
		 * TurnTile.setTranslateX(5); TurnTile.setTranslateY(510);
		 * spyRoot.getChildren().add(TurnTile); root.getChildren().add(TurnTile);
		 */

		updateTurnTile(Game, commandTiles, root);

		// Clue Word Tile
		Tile ClueWordTile = new Tile(Game, commandTiles, clueText.getText(), "plum", "clue", root,240,50);
		ClueWordTile.setTranslateX(5);
		ClueWordTile.setTranslateY(565);
		spyRoot.getChildren().add(ClueWordTile);
		root.getChildren().add(ClueWordTile);

		// Guesses Left Tile
		Tile GuessesLeftTile = new Tile(Game, commandTiles, "", "orange", "guess", root,245,50);
		GuessesLeftTile.setTranslateX(510-5-245);
		GuessesLeftTile.setTranslateY(565);
		spyRoot.getChildren().add(GuessesLeftTile);
		root.getChildren().add(GuessesLeftTile);

		// Clue Button

		Button clueButton = new Button();
		clueButton.setText("Give us ya clue!");
		clueButton.setTranslateX(245);
		clueButton.setTranslateY(615);
		clueButton.setOnMouseClicked(event -> {
			Clue nextClue = new Clue(clueText.getText(), Integer.parseInt((String) clueInt.getValue()));
			clueText.setText("");
			ClueWordTile.setText(nextClue.getWord());
			GuessesLeftTile.setText(Integer.toString(nextClue.getClueNumber()));
			// updatePlayerGrid();
			// System.out.println(nextClue.getWord() + " " + nextClue.getClueNumber());
		}

		);
		spyRoot.getChildren().add(clueButton);

		// Reset Button
		Button resetButton = new Button();
		resetButton.setText("Start New Game");
		resetButton.setTranslateX(375);
		resetButton.setTranslateY(615);
		resetButton.setOnMouseClicked(event -> {

			// This should really be a separate method

			// Make intermedate window
			Stage intermediateStage = new Stage();
			Pane intermediateRoot = new Pane();
			intermediateRoot.setPrefSize(350, 30);
			intermediateStage.setTitle("Reset game: are you sure?");

			// Yes Button
			Button yesButton = new Button();
			yesButton.setTranslateX(100);
			yesButton.setTranslateY(0);
			yesButton.setText("Yes");

			intermediateRoot.getChildren().add(yesButton);
			

			yesButton.setOnMouseClicked(event2 -> {
				primaryStage.close();
				secondaryStage.close();
				Stage stage1 = new Stage();
				Stage stage2 = new Stage();

				resetGame(stage1, stage2);
				intermediateStage.close();

			});

			// No Button
			Button noButton = new Button();
			noButton.setTranslateX(200);
			noButton.setTranslateY(0);
			noButton.setText("No");

			intermediateRoot.getChildren().add(noButton);
			intermediateStage.setScene(new Scene(intermediateRoot));

			intermediateStage.show();

			noButton.setOnMouseClicked(event2 -> {
				intermediateStage.close();
			});
		});
		spyRoot.getChildren().add(resetButton);

		//Help Button
		Button helpButton = new Button();
		helpButton.setText("Help Me!");
		helpButton.setTranslateX(405);
		helpButton.setTranslateY(665);
		helpButton.setOnMouseClicked(event -> {
			Text helpText= new Text();
			Help H = new Help();
			
			helpText.setText(("\n"+"\n"+H.getHelpAL()));
			System.out.println((H.getHelpAL()));
			Pane helpRoot = new Pane(helpText);
			helpText.wrappingWidthProperty().bind(helpRoot.widthProperty());
			System.out.println(helpText.getText());
			helpRoot.setPrefSize(510, 700);
		 	Stage helpStage = new Stage();
		 	helpStage.setScene(new Scene(helpRoot));
		 	helpStage.show();
		 	
		 	
		 	
		 	
		 	
		});
		root.getChildren().add(helpButton);
		
		// Card Tiles
		ArrayList<Tile> tileSet = new ArrayList<Tile>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				String wordValue = Game.getSpymasterGrid().getWordGrid().get(5 * i + j);
				String colourValue = Game.getSpymasterGrid().getColourGrid().get(5 * i + j);
				Tile tile = new Tile(Game, tileSet, wordValue, colourValue, "word", root,100,100);
				tile.setTranslateX(j * 100 + 5);
				tile.setTranslateY(i * 100 + 5);
				spyRoot.getChildren().add(tile);
				tileSet.add(tile);
			}
		}

		// Card Tiles
		ArrayList<Tile> playerTileSet = new ArrayList<Tile>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				String wordValue = Game.getPlayerGrid().getWordGrid().get(5 * i + j);
				String colourValue = Game.getPlayerGrid().getColourGrid().get(5 * i + j);
				Tile tile = new Tile(Game, playerTileSet, wordValue, colourValue, "word", root,100,100);
				tile.setTranslateX(j * 100 + 5);
				tile.setTranslateY(i * 100 + 5);
				root.getChildren().add(tile);
				playerTileSet.add(tile);
			}
		}

		ArrayList<Parent> bothPanes = new ArrayList<Parent>(Arrays.asList(spyRoot, root));

		return bothPanes;
	}
	/*
	 * private Parent playerContent(Start Game, ArrayList<Tile> globalTiles) {
	 * 
	 * 
	 * 
	 * // Information Tiles ArrayList<Tile> CommandTiles = new ArrayList<Tile>(); //
	 * Turn Status Tile
	 * 
	 * Tile TurnTile = new Tile(Game, CommandTiles,
	 * Game.getPlayerGrid().getCurrentTurn(), "white"); TurnTile.setTranslateX(5);
	 * TurnTile.setTranslateY(510); root.getChildren().add(TurnTile);
	 * 
	 * // Clue Word Tile Tile ClueWordTile = new Tile(Game, CommandTiles, "",
	 * "white"); ClueWordTile.setTranslateX(110); ClueWordTile.setTranslateY(510);
	 * root.getChildren().add(ClueWordTile);
	 * 
	 * // Guesses Left Tile Tile GuessesLeftTile = new Tile(Game, CommandTiles, "",
	 * "white"); GuessesLeftTile.setTranslateX(215);
	 * GuessesLeftTile.setTranslateY(510); root.getChildren().add(GuessesLeftTile);
	 * 
	 * // Card Tiles ArrayList<Tile> TileSet = new ArrayList<Tile>(); for (int i =
	 * 0; i < 5; i++) { for (int j = 0; j < 5; j++) { String wordValue =
	 * Game.getPlayerGrid().getWordGrid().get(5 * i + j); String colourValue =
	 * Game.getPlayerGrid().getColourGrid().get(5 * i + j); Tile tile = new
	 * Tile(Game, TileSet, wordValue, colourValue); tile.setTranslateX(j * 100 + 5);
	 * tile.setTranslateY(i * 100 + 5); root.getChildren().add(tile);
	 * TileSet.add(tile); } } return root; }
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {

		Start Game = new Start();
		Stage secondaryStage = new Stage();
		ArrayList<Parent> bothPanes = createContent(Game, primaryStage, secondaryStage);

		secondaryStage.setScene(new Scene(bothPanes.get(0)));
		secondaryStage.setTitle("Spymasters: Spymaster's Grid");

		primaryStage.setScene(new Scene(bothPanes.get(1)));
		primaryStage.setTitle("Spymasters: Player Grid");

		secondaryStage.show();
		primaryStage.show();
	}

	public static void main(String[] args) {
		/*
	   File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    System.out.println(path)*/
		launch(args);
	}

	private void resetGame(Stage stage1, Stage stage2) {

		Start Game = new Start();
		Stage secondaryStage = new Stage();
		ArrayList<Parent> bothPanes = createContent(Game, stage1, stage2);

		Scene scene2 = new Scene(bothPanes.get(0));
		stage2.setScene(scene2);

		Scene scene1 = new Scene(bothPanes.get(1));
		stage1.setScene(scene1);

		stage1.setTitle("Spymasters: Player Grid");
		stage2.setTitle("Spymasters: Spymaster's Grid");

		stage1.show();
		stage2.show();

	}
	
	/*private void getHelp() {
		Reader.read(path)
	}*/

	public static void updateTurnTile(Start Game, ArrayList<Tile> commandTiles, Pane root) {
		Tile TurnTile;
		if (Tile.getType().equals("")) {
			TurnTile = new Tile(Game, commandTiles, Game.getPlayerGrid().getCurrentTurn() + " starts", "peach", "turn",
					root,500,50);
		} else {
			TurnTile = new Tile(Game, commandTiles, Tile.getType(), "peach", "turn", root,500,50);
		}
		TurnTile.setTranslateX(5);
		TurnTile.setTranslateY(510);
		// spyRoot.getChildren().add(TurnTile);
		root.getChildren().add(TurnTile);
	}
}
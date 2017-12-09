package codeNamesGUI;

import java.util.ArrayList;

import codeNames.*;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class Tile extends StackPane{
		private static boolean gameEnded=false;
    	private Text text = new Text();
    	private static String type ="";

    	public void setText(String S) {
    		text.setText(S);
    	}
    	
		private void colourChanger(Rectangle R, String colour1) {
			String internal=colour1;
    		if (colour1=="red")
    		{
    			R.setFill(Color.RED);
    		}
    		else if (colour1=="blue")
    		{
    			R.setFill(Color.CORNFLOWERBLUE);
    		}
    		else if (colour1=="cream")
    		{
    			R.setFill(Color.YELLOW);
    		}
    		else if (colour1=="black")
    		{
    			R.setFill(Color.GRAY);
    		}
    		else if (colour1=="white"){
    			R.setFill(Color.WHITE); 
    		}
    		else if (colour1=="peach"){
    			R.setFill(Color.PEACHPUFF);
    		}
    		else if (colour1=="plum"){
    			R.setFill(Color.PLUM);
    		}
    		else if (colour1=="orange"){
    			R.setFill(Color.ORANGE);
    		}
    		else {
    			R.setFill(Color.GREEN);
    		}
			//System.out.println(internal);
		}
    	
    	public Tile(Start Game, ArrayList<Tile> tileset, String word, String colour,String type, Pane root, int sizeX, int sizeY) {
    		Rectangle border = new Rectangle(sizeX,sizeY);
    		
    		

    		
    		border.setStroke(Color.BLACK);
    		colourChanger(border,colour);
    		
    		text.setFont(Font.font(15));
    		text.setText(word);
    		
    		
    		setAlignment(Pos.CENTER);
    		getChildren().addAll(border, text);
    		
    		if (colour.equals("white")) {
	    		setOnMouseClicked(event ->{
	    			
	    			if (event.getButton() == MouseButton.PRIMARY) {
	    				if (!gameEnded) { // || (!border.getFill().equals("white"))) {
		    				//drawX();
		    				Guess G= new Guess(text.getText(), 1);
		    				//System.out.println();
		    				Game.getPlayerGrid().updatePlayerGrid(Game.getSpymasterGrid(), G);
		    				int a= tileset.indexOf( (Tile) event.getSource());
		    				//System.out.println("BOARD GUESS: ::" + G.getGuess()+ ":: INDEX IN GRID: " + a + " PLAYERGIRD WORD: ::" + Game.getPlayerGrid().getWordGrid().get(a) +":: ");
		    				colourChanger(border, Game.getPlayerGrid().getColourGrid().get(a));
		    				
		    				WinConditions W= new WinConditions(Game.getPlayerGrid().getInitialRed(), Game.getPlayerGrid().getInitialBlue());
		    				W.status(Game.getPlayerGrid().getColourGrid());
		    				int winInt= W.decision(G);
		    				/*if (this.gettype().equals("guess"));
		    						text.setText("x");*/
		    				//System.out.println("TURN:" + Game.getPlayerGrid().getCurrentTurn());
		    				//System.out.println(gameStatus(Game.getPlayerGrid().getCurrentTurn(),winInt));
		    				this.type=gameStatus(Game.getPlayerGrid().getCurrentTurn(),winInt);
		    				GUI.updateTurnTile(Game, tileset ,  root);
		    				
	    				}
	    			}
	
	    		});
	    	}
    	}
    	
    	public String getValue() {
    		return text.getText();
    	}
    	
    	public static String getType() {
    		return type;
    		}
    	
    	
    	public String gameStatus(String currentTurn, int winCondition) {
    		String S="";
    		
    		if (currentTurn.equals("blue") && winCondition==3) {
    			S+="Blue Team's Turn";
    		}
    		else if (currentTurn.equals("red") && winCondition==3) {
    			S+="Red Team's Turn";
    		}
    		else if ((currentTurn.equals("red") && winCondition==0) || ((currentTurn.equals("blue") && winCondition==2)))
    		{
    			S+="Blue Team Wins!";
    			gameEnded=true;
    		}
    		else if ((currentTurn.equals("blue") && winCondition==0) || ((currentTurn.equals("red") && winCondition==1)))
    		{
    			S+="Red Team Wins!";
    			gameEnded=true;
    		}
    		else if (currentTurn.equals("blue") && winCondition==4) {
    			S+="Red Team's Turn";
    		}
    		else if (currentTurn.equals("red") && winCondition==4) {
    			S+="Blue Team's Turn";
    		}
    		return S;
    	}
    	
    	/*private void getColour() {
    		return colourChanger(border,colour);
    	}*/
    	

    }
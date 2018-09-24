package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener {

    private TicTacToeModel model;
    
    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
         int width = model.getWidth();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        for (int row = 0; row < width; row++){
            
            for (int col = 0; col < width; col++){
                
                squares[row][col] = new JButton(); 
                squares[row][col].addActionListener(this);
                squares[row][col].setName("Square" + row + col);
                squares[row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(squares[row][col]);
                }

        this.add(squaresPanel);
        this.add(resultLabel);
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        /* Handle button clicks.  Extract the row and col values from the name
           of the button that was clicked, then make the mark in the grid using
           the Model's "makeMark()" method.  Finally, use the "updateSquares()"
           method to refresh the View.  If the game is over, show the result
           (from the Model's "getResult()" method) in the result label. */
        
        String name = ((JButton) event.getSource()).getName(); // Get button name
        
        // INSERT YOUR CODE HERE
        int row = Integer.parseInt(name.substring(6,7));
        int col = Integer.parseInt(name.substring(7,8));
        
        JButton button = (JButton) event.getSource();
          
        model.makeMark(row,col);
        updateSquares();
        
        if(model.isGameover()){
            showResult(model.getResult().toString());
        }
    }
        
    public void updateSquares() {

        /* Loop through all View buttons and (re)set the text of each button
           to reflect the grid contents (use the Model's "getMark()" method). */
        
        int width = model.getWidth();
        
       
        for(int i = 0; i < width ; i++){
            for(int j = 0; j < width ; j++){
             squares[i][j].setText(model.getMark(i,j).toString());
            }
         }
    }
        
    public void showResult(String message) {
        resultLabel.setText(message.toUpperCase());
    }
    
    
    
    //CONSOLE VERSION CODE BEGINS
	/*
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE 
		System.out.println();
		System.out.println();
        System.out.print("  ");
        for(int i=0; i<model.getWidth();i++){
            System.out.print(i);
        }
        System.out.println();
        for(int i=0; i<model.getWidth();i++){
            System.out.print(i+" ");
            for(int j=0; j<model.getWidth();j++){
                System.out.print(model.getMark(i, j));
            }
            System.out.print('\n');
        }
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE 
        if(!model.isXTurn()){
            System.out.println();
            System.out.println("Player 2 (O) Move: ");
            System.out.print("Enter the row and column numbers, separated by a space: ");
        }
        else{
            System.out.println();
            System.out.println("Player 1 (X) Move: ");
            System.out.print("Enter the row and column numbers, separated by a space: ");
        }
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE 
        System.out.println("Invalid Input");
    }

    public void showResult(String r) {

        /* Display final winner 

        System.out.println(r + "!");
    }
*/	
}
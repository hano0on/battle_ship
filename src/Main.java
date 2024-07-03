/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.*;
import View.*;
import Controller.*;
import java.util.Scanner;
/**
 *
 * @author huzai
 */
public class Main {
    public static void main(String[] args){
        
        
        
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. GUI Version");
            System.out.println("2. CLI Version");
            choice = scanner.nextInt();
        }
        while(choice != 1 && choice != 2);
        
        if(choice == 1){
            // Models
            Player player = new Player();
            Board  board = new Board();

            // Controller 
            GameController controller = new GameController(board, player);

            // Views
            GUIView  view = new GUIView(controller);

            view.showMainMenu();
            player.addObserver(view);
            board.addObserver(view);
        
        }
        else{
            CLIView cli = new CLIView();        
            String playerName = cli.askPlayerName();
            cli.player.setName(playerName);

            int shipPlacement = cli.askShipPlacementMode();
            if(shipPlacement == 2){
                do{
                    cli.confirmFileRead();
                }
                while(!cli.loadShipsFromFile());
            }
            else{
                cli.board.placeRandomlyAllShips();
            }

            cli.displayBoard(cli.board);

            do{
                String attack = cli.askTry();
                int [] coordinates = cli.convertToCoordinate(attack);
                cli.player.setTries(cli.player.getTries() + 1);
                cli.board.attack(coordinates[0], coordinates[1]);
                cli.displayBoard(cli.board);
            }
            while(!cli.board.isGameOver());

            cli.displayGameOver(cli.player);
        }
        
        
        
    
    }
}

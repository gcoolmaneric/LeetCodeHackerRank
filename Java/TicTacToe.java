/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodePractice;

import java.util.Random;

/**
 *
 * @author eric
 */
public class TicTacToe {
    private int n;          // Maximal size of Array
    private int steps;      // Steps counter 
    private char[][] board;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        TicTacToe game = new TicTacToe(3);
        game.gameloop();
        
    }
     
    public TicTacToe(int num) {
        n = num;
        board = new char[n][n];
    }
    
    public void gameloop()
    {   
       while(true)
       {
          int ranX = randInt(0, n);
          int ranY = randInt(0, n);
          // X
          move(ranX, ranY, 1);
          // O
          move(ranX, ranY, 1);
          calculateWinLose(this.board);
       }
    }
    
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    public int calculateWinLose(char[][] data)
    {
        if(steps <= n ) return -1;

        // OOO XXX
        int countYes = 0;
        int countNo = 0;
        int index = 0;
        for(int i=0; i < n ; i++) 
        {  
            if( data[i][index] == 'O')
                countYes++;
            if( countYes == n ) return 1;
            
            if( data[i][index] == 'X')
                countNo++;
            if( countNo == n ) return 1;
        }
       
        // O  X
        // O  X
        // O  X
        countYes = 0;
        countNo = 0;
        index = 0;
        for(int i=0; i < n ; i++) 
        {  
            if( data[index][i] == 'O')
                countYes++;
            if( countYes == n ) return 1;
            
            if( data[index][i] == 'X')
                countNo++;
            if( countNo == n ) return 1;
        }
        
        // X    O
        //  X    O
        //   X    O
        countYes = 0;
        countNo = 0;
        for(int i=0; i < n ; i++) 
        {  
            for(int j=0; j < n ; j++) 
            {
                if( data[i][j] == 'O')
                    countYes++;
                if( data[i][j] == 'X')
                    countNo++;
                if( countYes == n || countNo == n ) return 1;
            }     
        }
        
        //   X    O
        //  X    O
        // X    O 
        countYes = 0;
        countNo = 0;
        index = 0;
        for(int i=0; i < n ; i++) 
        {  
            if ( data[index--][i] == 'O')
                countYes++;
            if ( data[index--][i] == 'X')
                countNo++;
            if( countYes == n || countNo == n ) return 1;
        }
        return -1;
    }
    
    public int move(int x, int y, int player)
    {
        if( x >= n || y >= n ) return -1;
        
        // X
        if(player == 1 )
        {
            if( board[x][y] == ' ') {
                 board[x][y] = 'X';
                 steps++;
            }
        // O
        }else if(player == 2 ) 
        {
            if( board[x][y] == ' ') {
                 board[x][y] = 'O';
                  steps++;
            }
        }
        return -1;
    }
    
    
}

import java.util.Scanner;
public class TicTacToe {
    static char[][] board ={{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    static char currentPlayer ='X';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int move;
        boolean gameWon= false;

        while(true){
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move(1-9):");
            move=sc.nextInt();

            if(makeMove(move)){
                gameWon=checkWin();
                if(gameWon){
                    printBoard();
                    System.out.println("Player " + currentPlayer + "wins!");
                    break;
                }
                if(isDraw()){
                    printBoard();
                    System.out.println("It is a draw!");
                    break;
                }
                switchPlayer();
            }
            else{
                System.out.println("Invalid Move!");
            }
        }

    }
    static void printBoard(){
        System.out.println("\n" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n" + 
        "--+---+--\n" + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n" +
        "--+---+--\n" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "\n");
    }
    static boolean makeMove(int move){
        for(int i=0, k=1; i<3;i++){
            for(int j =0;j<3;j++,k++){
                if(move==k && board[i][j]!='X' && board[i][j]!='O'){
                    board[i][j]= currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }
    static boolean checkWin(){
        for(int i=0;i<3;i++){
            if((board[i][0]==currentPlayer &&
                board[i][1]==currentPlayer &&
                board[i][2]==currentPlayer)||
                (board[0][i]==currentPlayer &&
                 board[1][i]==currentPlayer &&
                 board[2][i]==currentPlayer))
                 return true;
        }
        if((board[0][0]==currentPlayer &&
            board[1][1]==currentPlayer &&
            board[2][2]==currentPlayer) ||
            (board[0][2]==currentPlayer &&
             board[1][1]==currentPlayer &&
             board[2][0]==currentPlayer))
             return true;

             return false;
    }

    static boolean isDraw(){
        for(char[] row: board)
             for(char c: row)
                if(c!='X' && c!='O') return false;
        return true;        
    }
    static void switchPlayer(){
        currentPlayer=(currentPlayer=='X') ? 'O' : 'X';
    }
}

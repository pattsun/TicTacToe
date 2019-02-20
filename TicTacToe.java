import java.util.Scanner;
public class TicTacToe{
    public static void main(String[] args){
        int size = 3;
        int[][] cell = new int[size][size];
        
        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                cell[x][y] = 0;
            }
        }
        
        String mark[] = {" ", "O", "X"};
        Scanner sc = new Scanner(System.in);
        
        for(int turn = 0; turn < size*size ; turn++){
            int player = turn%2+1;
            System.out.println("Player"+player+"の番です");

            int putX,putY;
            do{
                System.out.println("X座標を入力してください");
                putX = sc.nextInt();
                System.out.println("Y座標を入力してください");
                putY = sc.nextInt();
            }while(putX<0 || putY<0 || putX>=size || putY>=size || cell[putX][putY]!=0);
            cell[putX][putY] = player;
            
            //マス目をかく
            for(int y=0; y<size; y++){
                String row = "|";
                for(int x=0; x<size; x++){
                    row+=mark[cell[x][y]]+"|";
                }
                System.out.println(row);
            }
            
            //横にならんでいるか
            int tmp = 0;
            for(int x=0; x<size; x++){
                if(cell[x][putY] == player)tmp++;
            }
            if(tmp==size)win(player);

            //縦にならんでいるか
            tmp = 0;
            for(int y=0; y<size; y++){
                if(cell[putX][y] == player)tmp++;
            }
            if(tmp==size)win(player);

            //ななめにならんでいるか
            tmp = 0;
            for(int x=0; x<size; x++){
                if(cell[x][x] == player)tmp++;
            }
            if(tmp==size)win(player);

            //ななめにならんでいるか
            tmp = 0;
            for(int x=0; x<size; x++){
                if(cell[x][size-1-x] == player)tmp++;
            }
            if(tmp==size)win(player);

        }
        System.out.println("引き分けです");
    }
    
    private static void win(int player){
        System.out.println("Player"+player+"の勝ちです");
        System.exit(0);
    }
}

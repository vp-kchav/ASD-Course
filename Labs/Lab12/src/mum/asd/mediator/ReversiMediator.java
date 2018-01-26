package mum.asd.mediator;

import java.util.ArrayList;
import java.util.List;

public class ReversiMediator implements Mediator {

	private List<Player> players =  new ArrayList<Player>();
	Player turn;
	private int[][] board = new int[8][8];	
	
	
    public int[][] getBoard() {
        return board;
    }

    
    public void setBoard(int[][] board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	private void initialBoard() {
	 // initialize board
	    int start = 3;
	    for(Player p : getPlayers()) {
	        board[start][3] = p.getColor();
	        board[start][4] = p.getColor();
	        start++;
	    }
	}
	
	public ReversiMediator() {
	    initialBoard();
	}
	
	public ReversiMediator(List<Player> players) {
	    this.players = players;
	    initialBoard();
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	@Override
	public void move(Player player,int x, int y) {
		for(Player p : players) {
			if(!player.getName().equalsIgnoreCase(p.getName())) {
				turn = p;
			}
		}
		board[x][y] = player.getColor();
	}
	
	@Override
    public void print() {
		
        for(int i = 0; i <= 7; i++) {
            for(int j = 0; j <= 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("It's " + turn.getName() + " Now ");
    }

}

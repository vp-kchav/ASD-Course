package mum.asd.mediator;

import java.util.ArrayList;
import java.util.List;

public class ReversiMediator implements Mediator {

	List<Player> players =  new ArrayList<Player>();
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public ReversiMediator() {
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	@Override
	public void move(Player player) {
		for(Player p : players) {
			if(!player.getName().equalsIgnoreCase(p.getName())) {
				
			}
		}
	}

}

/*
 * Created on Jan 25, 2018
 */
package mum.asd.mediator;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String args[]) {
        Player p1 = new Player("player1");
        p1.setColor(1);
        Player p2 = new Player("player2");
        p2.setColor(2);
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        ReversiMediator rm = new ReversiMediator(players);
        p1.setMediator(rm);p2.setMediator(rm);
//        rm.print();
        p1.move(6, 6);
        rm.print();
        System.out.println("---");
        p2.move(6, 7);
        rm.print();
        p1.move(7, 7);
        rm.print();
    }

}

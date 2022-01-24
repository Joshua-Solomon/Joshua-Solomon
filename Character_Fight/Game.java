package projects.project2game;

import java.util.Random;
import projects.project2game.characters.*;

public class Game {
	
	public static void main(String args[]) {
		
		int round = 1;
		Archer Link = new Archer("Link");
		Brawler Mario = new Brawler("Mario");
		
		System.out.println("Starting game");
		
		while(Link.is_alive() && Mario.is_alive()) {
		System.out.println("Round: " + round + Link.statsForGame() + Mario.statsForGame());
		
		//alternates which character attacks first
		if(round % 2 > 0) {
			System.out.println(Mario.attack(Link));
			if(!Link.is_alive()) {
				break;
				//don't want the while loop to continue if Link is dead
			}
			System.out.println(Link.attack(Mario));
			round += 1;
		}
		
		else {
			System.out.println(Link.attack(Mario));
			if(!Mario.is_alive()) {
				break;
			}
			System.out.println(Mario.attack(Link));
			round += 1;
		}
		
		
		}
	}
	
}
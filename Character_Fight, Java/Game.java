package projects.project2game;

import java.util.Random;
import projects.project2game.characters.*;

/*Sample Output:
Starting game
Round: 1 Link: strength: 15/15 health: 20/20 Mario: strength: 15/15 health: 20/20
     Mario throws a punch with 6 points!
      Link's health was reduced by 6
     Link shoots an arrow with 5 points!
      Mario's health was reduced by 5
					[...]
Round: 4 Link: strength: 10/15 health: 4/20 Mario: strength: 7/15 health: 4/20
     Link shoots an arrow with 4 points!
      Mario's health was reduced by 4
>Mario has been defeated<
*/

public class Game {
	
	public static void main(String args[]) {
		
		int round = 1;
		Archer Link = new Archer("Link");
		Brawler Mario = new Brawler("Mario");
		
		System.out.println("Starting game");
		
		while(Link.is_alive() && Mario.is_alive()) {
		System.out.println("Round: " + round + Link.statsForGame() + Mario.statsForGame());
		
		/*Alternates which character attacks first*/
		if(round % 2 > 0) {
			System.out.println(Mario.attack(Link));
			if(!Link.is_alive()) {
				break;
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

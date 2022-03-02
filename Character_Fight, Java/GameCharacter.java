package projects.project2game.characters;

import java.util.Random;

abstract public class GameCharacter {
	
	/*Sample Output in Game.java*/
	
	protected int current_health, current_strength;
	protected final int TOTAL_HEALTH = 20;
	protected final int TOTAL_STRENGTH = 15;
	
	protected String name;
	protected String character_action;
	protected String attack_type;
	Random rand = new Random();
	
	//constructor
	public GameCharacter() {
		current_health = TOTAL_HEALTH;
		current_strength = TOTAL_STRENGTH;
		
		attack_type = "NO ATTACK TYPE";
		character_action = "NO ACTION";
		name = "NO NAME";
	}
	
	//returns fighter name for the victory message
	public String getName(){
		return name;
	}
	
	//when Character A attacks Character B, Character B "got_hit."
	public String attack(GameCharacter B) {
		int hit_points = current_strength / 3 + rand.nextInt(3);
		current_strength -= rand.nextInt(4)+1;
		character_action = ("     " + name + attack_type + " with " + hit_points + " points!");
		B.got_hit(hit_points);
		
		
		character_action += "\n" + B.toString();
		return character_action;
	}
	
	public void got_hit(int health_points) {
		current_health -= health_points;
		
		if(is_alive()) 
			character_action = ("      " + name + "'s health was reduced by " + health_points);
		else	
		{
			character_action = ("      " + name + "'s health was reduced by " + health_points + "\n");
			character_action += (">" + name + " has been defeated<");
		}
	}
	
	//returns true if hero is alive
	public boolean is_alive() {
		if(current_health > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//stats before the round
	public String statsForGame() {
		character_action = (" " + name + ": strength: " + current_strength + "/" + TOTAL_STRENGTH +
				" health: " + current_health + "/" + TOTAL_HEALTH);
		return character_action;
	}
	
	@Override
	public String toString(){
		return character_action;
	}
}

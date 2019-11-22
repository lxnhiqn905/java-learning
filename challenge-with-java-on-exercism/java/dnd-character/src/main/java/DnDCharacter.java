import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {
	
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	private int hitpoints;
	
	public DnDCharacter() {
		this.strength = ability();
		this.dexterity = ability();
		this.constitution = ability();
		this.intelligence = ability();
		this.wisdom = ability();
		this.charisma = ability();
		this.hitpoints = 10 + modifier(this.constitution);
	}
	
    int ability() {
        Random r = new Random();
        return IntStream.generate(() -> (1 + r.nextInt(6))).limit(4).sorted().skip(1).sum();
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.0 );
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
    	return this.dexterity;
    }

    int getConstitution() {
    	return this.constitution;
    }

    int getIntelligence() {
    	return this.intelligence;
    }

    int getWisdom() {
    	return this.wisdom;
    }

    int getCharisma() {
    	return this.charisma;
    }

    int getHitpoints() {
    	return this.hitpoints;
    }

}

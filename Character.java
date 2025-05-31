public class Character {
    private final String name;
    private final int rarity;

    public Character(String name, int rarity) {
        this.name = name;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public String toString() {
        return name + " - " + rarity + " stars";
    }
}

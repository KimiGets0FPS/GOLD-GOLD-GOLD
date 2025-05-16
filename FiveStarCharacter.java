public class FiveStarCharacter extends Character {
    private boolean eventCharacter;

    public FiveStarCharacter(String name, int rarity, boolean eventCharacter) {
        super(name, rarity);
        this.eventCharacter = eventCharacter;
    }

    public String getName() {
        return super.getName();
    }

    public int getRarity() {
        return super.getRarity();
    }

    public boolean getEventCharacter() {
        return eventCharacter;
    }
}

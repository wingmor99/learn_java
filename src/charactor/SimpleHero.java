package charactor;

public class SimpleHero {
    public String name;
    public float hp;
    public int damage;

    public SimpleHero(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}

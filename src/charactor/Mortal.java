package charactor;

public interface Mortal {
    public void bekilled(Hero h);

    default public void revive() {
        System.out.println("本英雄复活。");
    }
}

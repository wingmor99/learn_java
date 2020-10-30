package charactor1;

import charactor.Hero;

public class Support extends Hero {
    public Support(String heroName, float heroHP, float heroArmor, int heroMoveSpeed) {
        super(heroName, heroHP, heroArmor, heroMoveSpeed);
    }

    @Override
    public void attack() {

    }

    public void heal() {
        System.out.println(name + "治疗了一下，但是空了");
    }

    public void heal(Hero h) {
        System.out.println(name + "治疗了" + h.name + "一下");
    }

    public void heal(Hero h, int hp) {
        System.out.println(h.name + "血量为" + h.hp);
        h.recovery(hp);
        System.out.println(name + "治疗了" + h.name + hp + "血量");
        System.out.println(h.name + "血量为" + h.hp);
    }

    public static void main(String[] args) {
        Support sp = new Support("琴瑟仙女", 400, 15, 350);

        Hero h = new Hero("盖伦", 616.28f, 27.536f, 350) {
            @Override
            public void attack() {

            }
        };


        sp.heal();
        sp.heal(h);
        sp.heal(h, 100);
    }
}

package charactor;

public class APHero extends Hero implements AP , Mortal{

    public APHero(String name, float heroHP, float heroArmor, int heroMoveSpeed) {
        super(name, heroHP, heroArmor, heroMoveSpeed);
    }

    @Override
    public void magicAttack() {
        System.out.println(this.name + "进行了魔法攻击");
    }

    @Override
    public void bekilled(Hero h) {
        System.out.println(h.name + "kill" + this.name);
        System.out.println(this.name + "这个魔法英雄挂了");
    }

    @Override
    public void attack() {
        magicAttack();
    }


}

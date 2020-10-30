package charactor;

public class ADAPHero extends Hero implements AD, AP, Mortal{
    public ADAPHero(String name, float heroHP, float heroArmor, int heroMoveSpeed) {
        super(name, heroHP, heroArmor, heroMoveSpeed);
    }


    @Override
    public void physicAttack() {
        System.out.println(this.name + "进行了物理攻击");
    }

    @Override
    public void magicAttack() {
        System.out.println(this.name + "进行了魔法攻击");

    }

    @Override
    public void bekilled(Hero h) {

        System.out.println(h.name + "kill" + this.name);
        System.out.println(this.name + "这个混合英雄挂了");
    }

    @Override
    public void revive() {

    }

    @Override
    public void attack() {
        physicAttack();
        magicAttack();
    }
}

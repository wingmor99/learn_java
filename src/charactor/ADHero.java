package charactor;

import property.Item;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class ADHero extends Hero implements AD, Mortal{
    public ADHero(String heroName, float heroHP, float heroArmor, int heroMoveSpeed) {
        super(heroName, heroHP, heroArmor, heroMoveSpeed);
        System.out.println("AD Hero created.");
    }

    @Override
    public void attack() {
        System.out.println(name + "打了一下，但是不知道打了谁");
        physicAttack();
    }

//    public void attack(charactor.Hero h1) {
//        System.out.println(name + "打了一下" + h1.name);
//    }
//
//    public void attack(charactor.Hero h1, charactor.Hero h2) {
//        System.out.println(name + "打了一下" + h1.name + "和" + h2.name);
//    }


    public void attack(Hero...heroes) {
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(name + "攻击了" + heroes[i].name);
        }
    }

    @Override
    public void physicAttack() {
        System.out.println(this.name + "进行了物理攻击");
    }

    @Override
    public void bekilled(Hero h) {
        System.out.println(h.name + "kill" + this.name);
        System.out.println(this.name + "这个物理英雄挂了");
    }

    @Override
    public void userItem(Item i) {
        System.out.println("ad hero use item.");
        super.userItem(i);
    }

    public static void main(String[] args) {
        ADHero bh = new ADHero("赏金猎人", 400, 14, 350);


        Hero h1 = new Hero("盖伦", 616.28f, 27.536f, 350) {
            @Override
            public void attack() {

            }
        };

        Hero h2 = new Hero("提莫", 383f, 14f, 330) {
            @Override
            public void attack() {

            }
        };


        bh.attack();
        bh.attack(h1);
        bh.attack(h1, h2);

        bh.physicAttack();
    }

    // 子类隐藏父类方法
    public static void battleWin() {
        System.out.println("ad hero battle win.");
    }

    public int getMoveSpeed() {
        return this.moveSpeed;
    }

    public int getFatherSpeed() {
        return super.moveSpeed;
    }

}

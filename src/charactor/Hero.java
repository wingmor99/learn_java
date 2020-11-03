package charactor;

import property.Weapon;
import property.Item;
import property.MagicPotion;
import property.LifePotion;

import java.util.ArrayList;

public abstract class Hero {

    public Hero(String name, float heroHP,
                float heroArmor, int heroMoveSpeed) {
        this.name = name;
        hp = heroHP;
        armor = heroArmor;
        moveSpeed = heroMoveSpeed;
        System.out.println("Hero created");
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero() {
        System.out.println("Hero的无参的构造方法 ");
    }


    // 类的属性

    private int id;
    public String name = "Some hero";
    public float hp;
    float armor;
    int moveSpeed;
    int deadTime;
    int moneyLeft;
    int hasHead;
    static String copyright;
    float maxHP;

    {
        maxHP = 200;
    }

    public static final int itemCapcity = 6;


    // 类的方法， 无返回值， 所以viod
    void keng() {
        System.out.println("坑队友");
    }

    // 返回float
    float getArmor() {
        return armor;
    }

    // 无返回， 加速
    void addSpeed(int speed) {
        moveSpeed = moveSpeed + speed;
    }

    // 超神
    void legendary() {
        System.out.println("超神了");
    }

    float getHp() {
        return hp;
    }

    public void recovery(float blood) {
        hp = hp + blood;
        System.out.println("加血" + blood + "，" + "血量" + hp);
    }


    void getName1(String name) {
        name = name;
        System.out.println(name);
    }

    void getName2(String name) {
        this.name = name;
        System.out.println(name);
    }

    void huixue(int xp) {
        hp = hp + xp;
        xp = 0;
    }

    //    public void attack(Hero hero, int damage) {
//        hero.hp = hero.hp - damage;
//    }
    public void equip(Weapon w) {
    }


//    public void useMagicPotion(MagicPotion mp){
//        mp.effect();
//    }
//    public void useLifePotion(LifePotion lp) {
//        lp.effect();
//    }

    public void userItem(Item i) {
        i.effect();
    }

    public void kill(Mortal h) {
        h.bekilled(this);
    }

    public static void battleWin() {
        System.out.println("hero battle win.");
    }

    @Override
    public void finalize() {
        System.out.println("这个英雄正在被回收， 前往垃圾桶");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hero) {
            Hero h = (Hero) obj;
            return this.hp == h.hp;
        }
        return false;
    }

    public abstract void attack();

    // 非静态内部类
    class BattleScore {
        int kill;
        int die;
        int assit;

        public void legendary() {
            if (kill >= 8) {
                System.out.println(name + "超神");
            } else {
                System.out.println(name + "还没超神");
            }
        }
    }

    // 静态内部类
    static class EnemyCrystall {
        int hp = 5000;

        public void checkIfVictory() {
            if (hp == 0) {
                Hero.battleWin();
                System.out.println("win this game.");
            } else {
                System.out.println("still doesn't win this game.");
            }
        }
    }

    // 自定义异常
    public void attackHero(Hero h) throws EnemyHeroIsDeadException {
        if (h.hp == 0) {
            throw new EnemyHeroIsDeadException(h.name + "以及挂了");
        }
    }

//    @Override
//    public String toString() {
//        return name;
//    }


    // 创建新类
    public static void main(String[] args) {

        Hero.copyright = "Riot Games";

        Hero garen = new ADHero("盖伦", 616.28f, 27.536f, 350);

        // 给盖伦加速
        garen.addSpeed(100);
        System.out.println(garen.name + "血量" + garen.getHp());
        garen.recovery((float) 104.52);

        Hero teemo = new Hero("提莫", 383f, 14f, 330) {
            @Override
            public void attack() {

            }
        };
//        teemo.getName2("名字");
//        System.out.println(teemo.name);

        int xp = 100;
        teemo.huixue(xp);
        System.out.println(xp);

        System.out.println("提莫血量" + teemo.hp);
//        garen.attack(teemo, 100);
        System.out.println("提莫血量" + teemo.hp);

        Hero.battleWin();
        System.out.println(Hero.itemCapcity);

        ADHero ad = new ADHero("ad", 300, 14, 15);

//        garen = ad;
//
//        ad = (ADHero) garen;

        System.out.println(garen instanceof APHero);

        LifePotion lp = new LifePotion();
        MagicPotion mp = new MagicPotion();

//        garen.useLifePotion(lp);
//        garen.useMagicPotion(mp);
        garen.userItem(lp);
        garen.userItem(mp);
        ((ADHero) garen).bekilled(teemo);


        ADHero rw = new ADHero("锐雯", 616.28f, 27.536f, 500);
        APHero gh = new APHero("光辉", 616.28f, 27.536f, 350);
        ADAPHero kq = new ADAPHero("库奇", 616.28f, 27.536f, 350);
        System.out.println("round 1");
        rw.kill(gh);
        System.out.println("round 2");
        gh.kill(rw);
        System.out.println("round 3");
        rw.kill(kq);

        Hero.battleWin();
        ADHero.battleWin();

        new Hero("盖伦", 616.28f, 27.536f, 350) {
            @Override
            public void attack() {

            }
        };
        new ADHero("锐雯", 616.28f, 27.536f, 350);

        Hero h1 = new Hero() {
            @Override
            public void attack() {

            }
        };
        h1.hp = 100;
        Hero h2 = new Hero() {
            @Override
            public void attack() {
                System.out.println(this.name + "新的攻击手段。");
            }
        };
        h2.hp = 100;

        System.out.println(h1 == h2); // 不指向同一对象。

        BattleScore score = garen.new BattleScore();
        score.kill = 9;
        score.legendary();

        Hero.EnemyCrystall crystall = new Hero.EnemyCrystall();
        crystall.checkIfVictory();

        h2.attack();
        System.out.println(h2);


        //内部类
        int damege = 9;
        final int finalDamege = damege;
        class SomeHero extends Hero {
            @Override
            public void attack() {
                System.out.println(name + "新的攻击。" + finalDamege);
            }
        }


        SomeHero h3 = new SomeHero();
        h3.name = "迪普世";
        h3.attack();

        rw.revive();

        damege = 19;

        Hero deadTeemo = new Hero("提莫", 0, 14f, 330) {

            @Override
            public void attack() {

            }
        };

        try {
            garen.attackHero(deadTeemo);

        } catch (EnemyHeroIsDeadException e) {
            System.out.println("异常原因：" + e.getMessage());
            e.printStackTrace();
        }


        /**
         * 泛型容器
         */
        ArrayList<APHero> heros = new ArrayList<APHero>();

        heros.add(new APHero("锐雯", 616.28f, 27.536f, 500));

        APHero apHero = heros.get(0);

    }
}

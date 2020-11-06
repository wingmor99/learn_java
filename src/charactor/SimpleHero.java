package charactor;

public class SimpleHero {
    public String name;
    public float hp;
    public int damage;

    public SimpleHero(String s, float hp, int damage) {
        this.name = s;
        this.hp = hp;
        this.damage = damage;
    }

    public SimpleHero(String s){
        this.name = s;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isDead() {
        if (this.hp == 0) {
            return true;
        }
        return false;
    }

    public void attackHero(SimpleHero h2) {
        h2.hp -= damage;
        System.out.println(this.name + "攻击了" + h2.name + "伤害" + damage + ", " +
                h2.name + "的血变成了" + h2.hp);
        if (h2.isDead()) {
            System.out.println(h2.name + "被打死了！");
        }
    }

    public void hurt() {
        this.hp = hp - 1;
    }

    public void recover() {
        this.hp = hp + 1;
    }


}

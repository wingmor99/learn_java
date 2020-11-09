package charactor;

public class SimpleHero {
    public int id;
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
    public SimpleHero() {}

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

    public synchronized void hurt() {
        if (hp == 1) {
            try {
                // 该线程释放
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.hp = hp - 1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);


    }

    public synchronized void recover() {
        this.hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
        this.notify();
    }


}

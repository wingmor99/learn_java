package charactor;

public class Support extends Hero implements Healer, AD, AP {
    public Support(String name, float heroHP, float heroArmor, int heroMoveSpeed) {
        super(name, heroHP, heroArmor, heroMoveSpeed);
    }

    @Override
    public void heal() {
        System.out.println(this.name + "治疗了下");
    }

    @Override
    public void physicAttack() {

    }

    @Override
    public void magicAttack() {

    }

    @Override
    public void attack() {
        physicAttack();
        magicAttack();
    }
}

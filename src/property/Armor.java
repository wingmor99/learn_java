package property;

public class Armor extends Item {
    int ac;

    public static void main(String[] args) {
        Armor simpleArmor = new Armor();
        simpleArmor.name = "布甲";
        simpleArmor.price = 300;
        simpleArmor.ac = 15;

        Armor suoziArmor = new Armor();
        suoziArmor.name = "锁子甲";
        suoziArmor.price = 500;
        suoziArmor.ac = 40;
    }
}

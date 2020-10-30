package property;

public class Item {
    String name;
    int price;

    public void effect() {
        System.out.println("使用了物品后，天上闪了一道光");
    }

    public void buy() {
        System.out.println("购买");
    }

//    public abstract void disposable() {
//
//    }

    public static void main(String[] args) {
        Item bloodbutton = new Item();
        bloodbutton.name = "血瓶";
        bloodbutton.price = 50;

        Item strawshoes = new Item();
        strawshoes.name = "草鞋";
        strawshoes.price = 300;

        Item longsword = new Item();
        longsword.name = "草剑";
        longsword.price = 350;

        Item i = new Item();
        i.effect();

        LifePotion lp = new LifePotion();
        lp.effect();

    }


}

package property;

public class MagicPotion extends Item{
    @Override
    public void effect() {
        System.out.println("使用了蓝瓶，恢复了点魔法");
    }
}

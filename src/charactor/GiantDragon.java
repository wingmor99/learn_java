package charactor;

public class GiantDragon {

    // =====饿汉式单例 =====
//    private GiantDragon() {
//    }
//
//    private static GiantDragon instance = new GiantDragon();
//
//    public static GiantDragon getInstance() {
//        return instance;
//    }

    // ======懒汉式单例 =====

    private GiantDragon() {}

    private static GiantDragon instance;

    public static GiantDragon getInstance() {
        if (null == instance) {
            instance = new GiantDragon();
        }
        return instance;
    }

    // 单例三元素
    //1. 构造方法私有化
    //2. 静态属性指向实例
    //3. public static的 getInstance方法，返回第二步的静态属性
}

import charactor.APHero;
import charactor.Hero;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        ArrayList<APHero> apHeroList = new ArrayList<APHero>();
        apHeroList.add(new APHero());

        ArrayList<? extends Hero> heroList = apHeroList;

        /**
         * ? extends Hero 表示是一个Hero泛型的子类泛型
         * heroList 的泛型可以是Heo， APHero， ADHero
         * 从heroList取出来的一定是可以转型为Hero的
         *
         * 但是不能放东西，因为满足ADHero就不满足APHero。
         */


        ArrayList<? super Hero> heroListSuper = new ArrayList<Object>();

        /**
         *
         */


    }
}

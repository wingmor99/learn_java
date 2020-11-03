package collection;

import charactor.Hero;
import charactor.SimpleHero;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TestCollection {
//    @SuppressWarnings("rawtypes");

    public static void main(String[] args) {
        // 容器类
        ArrayList heros = new ArrayList();
//        heros.add(new Hero("盖伦") {
//            @Override
//            public void attack() {
//
//            }
//        });
//        System.out.println(heros.size());
//
//        heros.add(new Hero("wingmor") {
//            @Override
//            public void attack() {
//
//            }
//        });
//
//        System.out.println(heros.size());

        // 判断对象是否相同
        for (int i=0; i < 5; i++) {
            heros.add(new Hero("hero" + i) {
                @Override
                public void attack() {

                }
            });
        }

        Hero specialHero = new Hero("special hero") {
            @Override
            public void attack() {

            }
        };
        heros.add(specialHero);

        System.out.println(heros);

        Hero extraHero = new Hero("hero 10") {
            @Override
            public void attack() {

            }
        };

        // contains for abstract class
        System.out.println("虽然新的对象也叫hero 1，但是contain返回");
        System.out.println(heros.contains(extraHero));
        System.out.println(extraHero);
        System.out.println(heros.contains(specialHero));
        System.out.println(heros.indexOf(new Hero("2") {
            @Override
            public void attack() {

            }
        }));

        ArrayList simpleheros = new ArrayList();
        for (int i =0; i<5; i++) {
            simpleheros.add(new SimpleHero("Hero" + i));
        }


        // contains for normal class
        SimpleHero specialSimpleHero = new SimpleHero("special simple hero");
        simpleheros.add(specialSimpleHero);

        System.out.println(simpleheros);
        System.out.println(simpleheros.contains(new SimpleHero("Hero1")));
        System.out.println(simpleheros.contains(specialSimpleHero));

        System.out.println(simpleheros.get(0));
        System.out.println(simpleheros.indexOf(specialSimpleHero));

        /**
         * 范型Generic, 可以放Hero及其子类
         */
        List<Hero> genericheros = new LinkedList<Hero>();

        /**
         * or循环
         */
        System.out.println("-------------for 循环-----");
        for (int i = 0; i < simpleheros.size(); i++) {
//            Hero h = (Hero) heros.get(i);
            SimpleHero h = (SimpleHero) simpleheros.get(i);
            System.out.println(h);
        }
        /**
         * 迭代器
         */
        System.out.println("---------迭代器--------");
        Iterator<SimpleHero> it = simpleheros.iterator();
        while(it.hasNext()) {
            SimpleHero h = it.next();
            System.out.println(h);
        }
        /**
         * 迭代器， for写法
         */
        System.out.println("--------迭代器for写法--------");
        for (Iterator<SimpleHero> iterator = simpleheros.iterator(); iterator.hasNext();) {
            SimpleHero h = (SimpleHero) iterator.next();
            System.out.println(h);
        }

        /**
         * 增强型for循环
         */
        System.out.println("-------增强型for循环------");
        for (Object h : simpleheros
             ) {
            System.out.println(h);

        }

        /**
         * List查找效率低
         */
        System.out.println("List 查找");
        List<SimpleHero> shs = new ArrayList<SimpleHero>();
        for (int j = 0; j< 2000000; j++) {
            SimpleHero sh = new SimpleHero("Hero " + j);
            shs.add(sh);
        }

        // 10 词查找
        for (int i = 0; i<10; i++) {
            Collections.shuffle(shs);

            long startTime = System.currentTimeMillis();
            String target = "Hero 200000";

            for (SimpleHero sh: shs) {
                if (sh.name.equals(target)) {
                    System.out.println("找到了");
                    break;
                }
            }
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            System.out.println("一共花了：" + elapsed + " 毫秒");
        }

        /**
         * HashMap 查找
         */
        HashMap<String, SimpleHero> heroMap = new HashMap<String, SimpleHero>();
        for (int j = 0; j < 2000000; j++) {
            SimpleHero h = new SimpleHero("Hero " + j);
            heroMap.put(h.name, h);
        }
        System.out.println("准备完成");
        for (int i = 0; i<10; i++){
            long startTime = System.currentTimeMillis();
            SimpleHero target = heroMap.get("Hero 2000000");
            System.out.println("找到了");
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            System.out.println("一共花了：" + elapsed + " 毫秒");
        }
    }
}

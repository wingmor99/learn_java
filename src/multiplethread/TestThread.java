package multiplethread;

import charactor.SimpleHero;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {
        SimpleHero gareen = new SimpleHero("盖伦", 616, 50);
        SimpleHero teemo = new SimpleHero("提莫", 300, 30);
        SimpleHero bh = new SimpleHero("赏金猎人", 500, 65);
        SimpleHero leesin = new SimpleHero("盲僧", 455, 80);

        /**
         * 创建线程， 然后run
         */
//        KillThread killThread1 = new KillThread(gareen, teemo);
//        KillThread killThread2 = new KillThread(bh, leesin);
//        killThread1.start();
//        killThread2.start();

        /**
         * Runnable接口
         */
//        System.out.println("Runnable 接口============");
//        Battle battle1 = new Battle(gareen, teemo);
//        new Thread(battle1).start();
//
//        Battle battle2 = new Battle(bh, leesin);
//        new Thread(battle2).start();

        /**
         * 匿名类
         */
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while(!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };
//
//        t1.start();
//
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while(!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
//
//        t2.start();


        Thread t3 = new Thread() {
            @Override
            public void run() {
                int seconds = 0;
                while (seconds < 3) {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("玩了LOL" + seconds + "秒");
                    seconds++ ;
                }

            }
        };

//        t3.start();
//
//        t1.start();

        //代码是主线程
        try {
            // 吧t1加入到主线程
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        t2.start();

        Thread t4 = new Thread() {
            @Override
            public void run() {
                int seconds = 1;
                while (seconds < 4) {
                    System.out.println("第" + seconds + "发波动拳");
                    try {
                        Thread.sleep(1000);
                        if (seconds == 3){
                            System.out.println("开始充能");
                            Thread.sleep(2000);
                            seconds = 0;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds++;
                }

            }
        };

//        t4.start();

        System.out.println("盖伦初始血量是" + gareen.hp);
        /**
         * 占用对象， 线程安全类： 一次只有一个线程可以占用对象
         * https://how2j.cn/k/thread/thread-synchronized/355.html#nowhere
         */
        final Object someObject = new Object();

        Thread t5 = new Thread(){
            @Override
            public void run(){
                try {
                    System.out.println( now()+" t5 线程已经运行");
                    System.out.println( now()+this.getName()+ " 试图占有对象：someObject");
                    synchronized (someObject) {

                        System.out.println( now()+this.getName()+ " 占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println( now()+this.getName()+ " 释放对象：someObject");
                    }
                    System.out.println(now()+" t5 线程结束");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t5.setName(" t5");
//        t5.start();

        Thread t6 = new Thread(){

            @Override
            public void run(){
                try {
                    System.out.println( now()+" t6 线程已经运行");
                    System.out.println( now()+this.getName()+ " 试图占有对象：someObject");
                    synchronized (someObject) {
                        System.out.println( now()+this.getName()+ " 占有对象：someObject");
                        Thread.sleep(5000);
                        System.out.println( now()+this.getName()+ " 释放对象：someObject");
                    }
                    System.out.println(now()+" t6 线程结束");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t6.setName(" t6");
//        t6.start();

        gareen.hp=100;
        Thread t7 = new Thread(){
            @Override
            public void run(){
                while(true){

                    //因为减血更快，所以盖伦的血量迟早会到达1
                    //使用while循环判断是否是1，如果是1就不停的循环
                    //直到加血线程回复了血量
//                    while(gareen.hp==1){
//                        continue;
//                    }

                    gareen.hurt();
                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t7.start();

        Thread t8 = new Thread(){
            @Override
            public void run(){
                while(true){
                    gareen.recover();
                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t8.start();




    }
}

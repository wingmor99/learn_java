package multiplethread;

import charactor.SimpleHero;

public class TestThread {

    public static void main(String[] args) {
        SimpleHero gareen = new SimpleHero("盖伦", 616, 50);
        SimpleHero teemo = new SimpleHero("提莫", 300, 30);
        SimpleHero bh = new SimpleHero("赏金猎人", 500, 65);
        SimpleHero leesin = new SimpleHero("盲僧", 455, 80);

        /**
         * 创建线程， 然后run
         */
        KillThread killThread1 = new KillThread(gareen, teemo);
        KillThread killThread2 = new KillThread(bh, leesin);
        killThread1.start();
        killThread2.start();

    }
}

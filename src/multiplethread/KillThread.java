package multiplethread;

import charactor.Hero;
import charactor.SimpleHero;

public class KillThread extends Thread {
    private SimpleHero h1;
    private SimpleHero h2;

    public KillThread(SimpleHero h1, SimpleHero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run() {
        while(!h2.isDead()) {
            h1.attackHero(h2);
        }
    }

}

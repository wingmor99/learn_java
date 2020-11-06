package multiplethread;

import charactor.SimpleHero;

public class Battle implements Runnable{
    private SimpleHero h1;
    private SimpleHero h2;

    public Battle(SimpleHero h1, SimpleHero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run() {
        while(!h2.isDead()) {
            h1.attackHero(h2);
        }
    }
}

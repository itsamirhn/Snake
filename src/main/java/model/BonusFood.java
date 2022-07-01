package model;

import controller.Config;

public class BonusFood extends Food {

    public static final int MAX_TIMER = Config.getInstance().bonusFoodMoveTimer;
    private int timer = MAX_TIMER;
    public void tiktok() {
        if (isRemoved()) return;
        timer--;
        if (timer == 0) this.remove();
        this.getContainer().notifyListener();
    }
    @Override
    public int getScore() {
        return 3;
    }

    public float getAgeRatio() {
        return (float) timer / MAX_TIMER;
    }
    public BonusFood(Cell container){
        super(container);
    }

}

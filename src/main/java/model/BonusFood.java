package model;

import controller.Config;

public class BonusFood extends Food {
    private int timer = Config.getInstance().bonusFoodMoveTimer;
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
    public BonusFood(Cell container){
        super(container);
    }

}

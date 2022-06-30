package model;

public class BonusFood extends Food {
    private int timer = 30;
    public void tiktok() {
        if (isRemoved()) return;
        timer--;
        if (timer == 0) this.remove();
    }
    @Override
    public int getScore() {
        return 3;
    }
    public BonusFood(Cell container){
        super(container);
    }

}

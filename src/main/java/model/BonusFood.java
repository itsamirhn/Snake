package model;

public class BonusFood extends Food{
    @Override
    public int getScore() {
        return 3;
    }
    public BonusFood(Cell container){
        super(container);
    }

}

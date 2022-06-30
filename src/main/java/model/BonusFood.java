package model;

public class BonusFood extends Food{
    private int destroy = 50;
    public int getDestroy(){
        return this.destroy;
    }
    private boolean isRemoved = false;
    public void setDestroy(int destroy){
        this.destroy = destroy;
    }
    public void checkdestroy(){
        if(this.destroy == 0){
            this.remove();
            this.isRemoved = true;
        }
    }
    public boolean isRemoved(){
        return this.isRemoved;
    }
    @Override
    public int getScore() {
        return 3;
    }
    public BonusFood(Cell container){
        super(container);
    }

}

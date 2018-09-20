package ca.ualberta.cs.lonelytwitter;

public class Animal {
    protected String type;
    protected String food;

    public void setType(String type){
        this.type = type;
    }

    public void setFood(String food){
        this.food = food;
    }

    public String getType(){
        return this.type;
    }

    public String getFood() {
        return this.food;
    }
}

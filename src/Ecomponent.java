//Name:Zheng Chuanyang
//ID:17251311
// abstrat class, have several methods
public abstract class Ecomponent {
    private String name;
    private int value;
    public Ecomponent()
    {
        this("");
    }

    public Ecomponent(int value)
    {
        this.value=value;
    }

    public Ecomponent(String name)
    {
        this.name=name;
    }

    //return name of E
    public String getName() {
        return name;
    }// give name

    public abstract int outPut();//give output
    public abstract void setInput(int setNumber,Ecomponent e);//set in put
    public abstract boolean checkNull();// null or not?

}

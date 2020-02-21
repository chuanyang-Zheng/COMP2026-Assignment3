//Name:Zheng Chuanyang
//ID:17251311
//extend Ecomponent, give output, setinput,output,checknull
public class EcomponentConstant extends Ecomponent  {

    private final int value;

    public EcomponentConstant(int value)
    {
        super("");
        this.value=value;//value
    }

    //define set input
    //system out of band
    public void setInput(int setNumber,Ecomponent e)
    {
        System.out.println(getName()+": pin number out of range("+0+")");//out of band
    }

    //return value
    public int outPut()
    {
        return value;
    }

    //always true
    public boolean checkNull()
    {
        return true;
    }
}

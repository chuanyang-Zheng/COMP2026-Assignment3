//Name:Zheng Chuanyang
//ID:17251311
//extend Ecomponent,define output, seti input , checknull
public class EcomponentNot extends Ecomponent {
    private Ecomponent[] inputArray=new Ecomponent[1];
    public EcomponentNot(String name)
    {
        super(name);
    }

    //give a eComponent
    //add this to listEcomponent e,int setNumber
    public void setInput(int setNumber,Ecomponent e)
    {
        if(setNumber<=1)
            inputArray[setNumber]=e;//add a input
        else
            System.out.println(getName()+": pin number out of range("+1+")");
    }




    //check input, give output
    //return int
    public int outPut()
    {
        if(inputArray[0].outPut()==0)
            return 1;//all 1,return 1

        return 0;//not all 1,return 0
    }

    public boolean checkNull()
    {
        if(inputArray[0]!=null&&inputArray[0].checkNull()==true)
            return true;
        System.out.println(getName()+": input 0 not set");//say not set
        return false;
    }

    //toString
    //return String
    //for list command
    public String toString()
    {
        if(inputArray[0]==null)
            return String.format(getName()+"[%-6s]","");
        return String.format(getName()+" [%-6s]",inputArray[0].getName());
    }
}

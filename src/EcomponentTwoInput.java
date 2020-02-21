//Name:Zheng Chuanyang
//ID:17251311
//extend Ecomponent. define checknull and toString
public abstract   class EcomponentTwoInput extends Ecomponent {
    private Ecomponent[] inputArray=new Ecomponent[2];
    public EcomponentTwoInput(String name)
    {
        super(name);
    }

    //give a eComponent
    //add this to list
    public void setInput( int setNumber,Ecomponent e)
    {
        if(setNumber<=1)
            inputArray[setNumber]=e;//add a input
        else
            System.out.println(getName()+": pin number out of range("+2+")");
    }

    //check input, give output
    //return int
    public abstract int outPut();

    //check whether input is OK
    //return boolean
    public boolean checkNull()
    {
        if(inputArray[0]!=null&&inputArray[1]!=null&&inputArray[0].checkNull()==true&&inputArray[1].checkNull()==true)//all set?
            return true;//all set

        for(int i=0;i<inputArray.length;i++)
            if(inputArray[i]==null)// not set
                System.out.println(getName()+": input "+i+" not set");//say not set
        return false;
    }

    //return String
    //for list command
    public String toString()
    {
        if(inputArray[0]==null&&inputArray[1]==null)
            return String.format(getName()+" [%-6s,%-6s]","","");

        if(inputArray[0]==null)
            return String.format(getName()+" [%-6s,%-6s]","",inputArray[1].getName());
        if(inputArray[1]==null)
            return String.format(getName()+" [%-6s,%-6s]",inputArray[0].getName(),"");
        return String.format(getName()+" [%-6s,%-6s]",inputArray[0].getName(),inputArray[1].getName());
    }

    public Ecomponent[] getInputArray() {
        return inputArray;
    }
}

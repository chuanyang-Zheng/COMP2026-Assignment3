//Name:Zheng Chuanyang
//ID:17251311
//extend twoinput. define output
public class EcomponentOr extends EcomponentTwoInput {
    private Ecomponent[] inputArray=new Ecomponent[2];
    public EcomponentOr(String name)
    {
        super(name);
    }



    //check input, give output
    //return int
    public int outPut()
    {
        int out0=getInputArray()[0].outPut();
        int out1=getInputArray()[1].outPut();
        if(out0==1||out1==1)
            return 1;//all 1,return 1

        return 0;//not all 1,return 0
    }


}

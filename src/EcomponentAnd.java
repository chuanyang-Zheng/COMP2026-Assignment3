import java.util.ArrayList;
import java.util.List;
//Name:Zheng Chuanyang
//ID:17251311
//extend twoinput. define output
public class EcomponentAnd extends EcomponentTwoInput {

    public EcomponentAnd(String name)
    {
        super(name);
    }



    //check input, give output
    //return int
    public int outPut()
    {
        int out0=getInputArray()[0].outPut();
        int out1=getInputArray()[1].outPut();
        if(out0==1&&out1==1)
            return 1;//all 1,return 1

        return 0;//not all 1,return 0
    }






}

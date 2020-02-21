import java.util.Scanner;
//Name:Zheng Chuanyang
//ID:17251311
//extend twoinput. define output,checknull,set input
public class EcomponentUserInput extends Ecomponent {
    private String name;
    private String prompt;

    public EcomponentUserInput(String name, String prompt)
    {
        super(name);
        this.prompt=prompt;

    }

    //let user give input
    @Override
    public int outPut() {
        Scanner in=new Scanner(System.in);//user inout
        System.out.print(this.prompt+" :");
        while(true) {
            String outputString = in.next();
            boolean judgeData = true;

            //check
            if (outputString.compareToIgnoreCase("1") != 0 && outputString.compareToIgnoreCase("0") != 0) {//data hve problems
                judgeData = false;
                System.out.println("Invalid Input");

            }
            //check over

            if (judgeData == true)// data is ok
                return Integer.parseInt(outputString);

            System.out.print(this.prompt+" :");
        }
    }

    //always 0. system that out of band
    public void setInput(int setNumber,Ecomponent e)
    {
        System.out.println(getName()+": pin number out of range("+0+")");
    }

    //return String
    //for list command
    public String toString()
    {
        return getName();
    }

    public boolean checkNull()
    {
        return true;
    }
}

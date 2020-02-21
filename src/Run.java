import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Name:Zheng Chuanyang
//ID:17251311
//divide command in to small command
//sovle command setp by setp
public class Run {
    boolean quitJudge=true;//judge Quit or not
    private List<Ecomponent> EcomponentList=new ArrayList<>();
    public static void main(String[] args) throws Exception
    {
        new Run().runApp(args);
    }

    void runApp(String[] args) throws Exception
    {
        Scanner in=new Scanner(System.in);
        if(args.length>0)
        {
            loadCommandFile(args[0]);//load Command FIle
        }
        if(quitJudge==true)
        {
            while(true) {
                String command = in.nextLine();
                programRun(command);
                if (quitJudge == false)
                    break;
            }
        }
    }

    void loadCommandFile(String inputCommandFileName) throws Exception
    {
        File inputCommandFile=new File(inputCommandFileName);
        try {
            int count = 1;//count load line
            Scanner scannerInputCommand = new Scanner(inputCommandFile);//try load file
            while (scannerInputCommand.hasNextLine()) {
                String command = scannerInputCommand.nextLine();//get next LIne
                programRun(command);//receive and deal with command
                if (quitJudge == false)
                    break;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Do not find: "+inputCommandFileName);
        }
    }

    //Give command
    //Get First sub of string. determine next step
    //run next step
    void programRun(String command)
    {
        try {
            if (OperationMethod.getString(command, 1).compareToIgnoreCase("new") == 0)
                runNewCommand(command);//run new related command
            else if (OperationMethod.getString(command, 1).compareToIgnoreCase("set") == 0)
                runSetCommand(command);//run set related command
            else if (OperationMethod.getString(command, 1).compareToIgnoreCase("input") == 0)
                runInputCommand(command);
            else if (OperationMethod.getString(command, 1).compareToIgnoreCase("output") == 0)
                runOutputCommand(command);
            else if (OperationMethod.getString(command, 1).compareToIgnoreCase("list") == 0)
                runListComnand();
            else if (OperationMethod.getString(command, 1).compareToIgnoreCase("quit") == 0)
                runQuitCommand();
            else
                System.out.println("Invalid Command: \"" + command+"\"");
        }
        catch (Exception e)
        {
            System.out.println("Error: "+command);
            System.out.println("Press enter to continue");
            Scanner errorScanner=new Scanner(System.in);
            String dump=errorScanner.nextLine();
        }

    }

    //receive string
    //get second string of command
    //determine where to go
    void runNewCommand(String command)
    {
        boolean judgeData=true;//data not is true;

        //check data
        if(OperationMethod.findEcomponentJudge(EcomponentList,OperationMethod.getString(command,3))==true)//check the name
        {
            judgeData=false;//already has the name;
            System.out.println("Already have the name");
        }
        //check data over

        if(judgeData==true) {
            if (OperationMethod.getStringNumber(command) == 3) {// finst type of new
                if (OperationMethod.getString(command, 2).compareToIgnoreCase("and") == 0)
                    EcomponentList.add(new EcomponentAnd(OperationMethod.getString(command, 3)));//run new and related command
                else if (OperationMethod.getString(command, 2).compareToIgnoreCase("or") == 0)
                    EcomponentList.add(new EcomponentOr(OperationMethod.getString(command, 3)));//run new or related command
                else if (OperationMethod.getString(command, 2).compareToIgnoreCase("xor") == 0)
                    EcomponentList.add(new EcomponentXor(OperationMethod.getString(command, 3)));//run new xor related command
                else if (OperationMethod.getString(command, 2).compareToIgnoreCase("not") == 0)
                    EcomponentList.add(new EcomponentNot(OperationMethod.getString(command, 3)));//run new not related command
                else if (OperationMethod.getString(command, 2).compareToIgnoreCase("nand") == 0)
                    EcomponentList.add(new EcomponentNand(OperationMethod.getString(command, 3)));//run new nand related command
                else
                    System.out.println("Valid Command: " + command);
            } else if (OperationMethod.getStringNumber(command) >= 4) {//userinput
                if (OperationMethod.getString(command, 2).compareToIgnoreCase("userinput") == 0) {
                    Scanner EcomponentUserInputScanner = new Scanner(command);
                    String dump = EcomponentUserInputScanner.next();// not "new"
                    String dump2 = EcomponentUserInputScanner.next();//not Ecomponent type
                    String dump3 = EcomponentUserInputScanner.next();//no "name"
                    String prompt = EcomponentUserInputScanner.nextLine();//get prompt
                    EcomponentList.add(new EcomponentUserInput(OperationMethod.getString(command, 3), prompt));//run new userinput related command
                } else
                    System.out.println("Valid Command: " + command);
            } else
                System.out.println("Valid Input: " + command);
        }
    }



    //run setcommand
    void runSetCommand(String command)
    {
        boolean judgeData=true;//judge Data

        //check Data
        if(OperationMethod.getStringNumber(command)!=4) {
            judgeData = false;
            System.out.println("Invalid Input");
        }

       else if(OperationMethod.getString(command,3).compareToIgnoreCase("0")!=0&&OperationMethod.getString(command,3).compareToIgnoreCase("1")!=0&&OperationMethod.getString(command,4).compareToIgnoreCase("0")!=0&&OperationMethod.getString(command,4).compareToIgnoreCase("1")!=0)//judge data
       {
           judgeData=false;
           System.out.println("Input number is not correct");//input pin is not correct
       }
        //judge Data over

        if(judgeData==true) {
            Ecomponent theEcomponentFind=OperationMethod.findEcomponent(EcomponentList,OperationMethod.getString(command,2));//find the component and set it
            theEcomponentFind.setInput(Integer.parseInt(OperationMethod.getString(command,3)),new EcomponentConstant(Integer.parseInt(command,4)));//set
        }
    }

    //run output Command
    //check Data and run
    void runOutputCommand(String command)
    {
        boolean judgeData=true;


        //check data
        if(OperationMethod.getStringNumber(command)!=2)//format not correct
            judgeData=false;
        //check data over

        if(judgeData==true)//data not problem
        {
            if(OperationMethod.findEcomponentJudge(EcomponentList,OperationMethod.getString(command,2))==true)//find the Ecomponent
            {
                Ecomponent theEcomponentFind = OperationMethod.findEcomponent(EcomponentList, OperationMethod.getString(command, 2));// find Ecomponent by name

                if(theEcomponentFind.checkNull()==true) {
                    if (theEcomponentFind.outPut() == 1)//out is 1
                        System.out.println("true");
                    else
                        System.out.println("false");
                }
            }
            else//do not find
            System.out.println("Do not find "+OperationMethod.getString(command,2));//ssay do not find
        }
        else//data have problems
            System.out.println("Invalid Input");
    }

    //run Input Command
    void runInputCommand(String command)
    {
        boolean judgeData=true;

        //heck data
        if(OperationMethod.getStringNumber(command)!=4) {
            judgeData = false;
            System.out.println("Invalid Input");
        }
        else if(OperationMethod.getString(command,3).compareToIgnoreCase("0")!=0&&OperationMethod.getString(command,3).compareToIgnoreCase("1")!=0)//pin wrong
        {
            judgeData=false;
            System.out.println("Input number is not correct");
        }

        if(judgeData==true) {

            boolean findJudge=true;//judge find or not
            Ecomponent theEcomponentFind = OperationMethod.findEcomponent(EcomponentList, OperationMethod.getString(command, 2));//get target Ecomponent
            Ecomponent inputEcomponentFind = OperationMethod.findEcomponent(EcomponentList, OperationMethod.getString(command, 4));//get set Ecomponent
            //check begin
            if(theEcomponentFind==null)//no this Ecomponent
            {
                findJudge=false;
                System.out.println("Do not find "+OperationMethod.getString(command, 2));
            }

            if(inputEcomponentFind==null)//no this Ecomponent
            {
                findJudge=false;
                System.out.println("Do not find "+OperationMethod.getString(command, 4));
            }

            if(OperationMethod.getString(command, 2).compareToIgnoreCase(OperationMethod.getString(command, 4))==0)
            {
                findJudge=false;
                System.out.println("The first name: "+OperationMethod.getString(command, 2) +" is the same as the second name: "+OperationMethod.getString(command, 2));//dunpicate
            }

            if(findJudge==true) {

                theEcomponentFind.setInput(Integer.parseInt(OperationMethod.getString(command, 3)), inputEcomponentFind);//set
            }
        }
    }

    //run list command
    void runListComnand()
    {
        for(int i=0;i<EcomponentList.size();i++)
            System.out.println(EcomponentList.get(i));
    }

    //run quit
    void runQuitCommand()
    {
        System.out.println("Goodbye!");
        quitJudge=false;
    }


}

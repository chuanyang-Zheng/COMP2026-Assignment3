import java.util.List;
//Name:Zheng Chuanyang
//ID:17251311
//some methods may use
public class OperationMethod {

//    public static String[] getStringArray(String s
//    {
//
//    }

    //get how mantysub string of string
    //return int
    public static int getStringNumber(String s)
    {

        int count=0;//count
        boolean judgePrevious=true;//for i =0
        String word="";//will return this one
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
                judgePrevious=true;//last one is " "
            else
            {
                if(judgePrevious)//last one is " "
                {
                    count++;//count++
                    judgePrevious=false;//last one is not " "
                }
            }
        }

        return count;// how many sub string

    }

    //get a target string
    //return string
    public static String getString(String s,int target)
    {
        int count=0;//count
        boolean judgePrevious=true;//for i =0
        String word="";//will return this one
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
                judgePrevious=true;//previous one is " "
            else
            {
                if(judgePrevious)//previous is " "
                {
                    count++;//count+1
                    judgePrevious=false;
                }
                if(count==target)//get target
                    word=word+s.charAt(i);
            }
        }

        return word;

    }

    //find a Ecomponent by name
    //give EcomponentList, name
    //return Ecomponent
    public static Ecomponent findEcomponent(List<Ecomponent> EcmponentList, String name)
    {
        for(int i=0;i<EcmponentList.size();i++)
            if(EcmponentList.get(i).getName().compareToIgnoreCase(name)==0)
                return EcmponentList.get(i);
        return null;
    }

    //judge whether have the name
    //give EcomponentList ,name
    //return boolean
    public static boolean findEcomponentJudge(List<Ecomponent> EcmponentList, String name)
    {
        for(int i=0;i<EcmponentList.size();i++)
            if(EcmponentList.get(i).getName().compareToIgnoreCase(name)==0)//find the name
                return true;//if find the name, return true
        return false;//do not find the name
    }
}

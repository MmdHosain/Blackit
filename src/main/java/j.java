import java.util.*;

public class j {


    static Scanner myObj = new Scanner(System.in);
    private static Object in;


    public static void out(String output){
        System.out.print(output);
    }
    public static void out(String output, int endl){
        System.out.println(output);
    }
    public static void out(int output, int endl){
        System.out.println(output);
    }
    public static void out(int output){
        System.out.print(output);
    }
    public static String in(){
        return myObj.nextLine();
    }
    public static int in(int is_int){
        return Integer.parseInt(myObj.nextLine());
    }
    public static  int menu(ArrayList<String> op) {

        int cursor = 1;
        while (true)
        {
            for (int i = 0; i < op.size(); i++) {
                opShow(op.get(i),i+1,cursor,1);
            }


//            switch (j.in(1)) {
//                case 2:
//                    cursor++;
//
//                    if (cursor> op.size()) cursor = 1;
//                    break;
//                case 8:
//                    cursor--;
//                    if (cursor<1) cursor = op.size();
//                    break;
//                case 5:
//                    return cursor;
//            }


            int x = j.in(1);

            return x;
        }

    }
    public static  int menu(ArrayList<String> op,int numerical) {

        int cursor = 1;
        while (true)
        {
            j.out("",1);
            for (int i = 0; i < op.size(); i++) {
                opShow(op.get(i),i+1,cursor,numerical);
            }


//            switch (j.in(1)) {
//                case 2:
//                    cursor++;
//
//                    if (cursor> op.size()) cursor = 1;
//                    break;
//                case 8:
//                    cursor--;
//                    if (cursor<1) cursor = op.size();
//                    break;
//                case 5:
//                    return cursor;
//            }
            return j.in(1);
        }

    }
    private static void opShow(String output,int opNum,int cursor,int numerical){
        if (numerical == 1){
            j.out(opNum);
        }
        j.out(" "+output);
        if (cursor == opNum) {
            //j.out(" <<*");
        }
        j.out("",1);
    }
    public static int find(ArrayList<Account> list,Object user){
        int result = -1;
        for (int i = 0; i < list.size(); i++) {
            if (user == list.get(i)){
                if(result==-1) {
                    result = i;
                }
                else result = -2;
            }
        }
        return result;
    }
}

import java.util.ArrayList;
import java.io.*;

public class Main {

    private static final ArrayList<Account> accountlist = new ArrayList<>();
    private static final ArrayList<Post> postlist = new ArrayList<>();
    private static final ArrayList<Sub> sublist = new ArrayList<>();

    static Account user ;

    public static void main(String[] args) throws Exception {

        //readFile();

        initializer();
        mainMenu();
        writeToFile();
    }
    public static void mainMenu () throws Exception {
        while(true) {

            j.out("welcome to BLACKIT",1);
            ArrayList<String> options = new ArrayList<>();
            options.add("log in");
            options.add("Sign up");
            options.add("Exit");
            switch (j.menu(options)) {
                case 1:
                    logIn();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    return;
            }
        }
    }
    public static void signUp() throws Exception {
        accountlist.add(new Account(accountlist));
    }
    public static void logIn() throws Exception {

        j.out("Enter user name ", 1);
        String username = j.in();
        j.out("enter password ", 1);
        String password = j.in();
        password = Account.hashWithSalt(password);
        for (int i = 0; i < accountlist.size(); i++) {
            if(username.equals(accountlist.get(i).username) && password.equals(accountlist.get(i).password)){
                user = accountlist.get(i);
                accountMenu();
                break;
            }
        }
        j.out("password is wrong",1);
    }
    public static void accountMenu() throws Exception {
        while(true){
            ArrayList<String> options = new ArrayList<>();
            options.add("search");
            options.add("Personal");
            options.add("show posts");
            options.add("Exit");
            switch (j.menu(options)){
                case 1:
                    searchMenu();
                    break;
                case 2:
                    personalMenu();
                    break;
                case 3:
                    showPosts();
                    break;
                case 4:
                    return;
            }
        }
    }
    public static void searchMenu(){
        while(true)
        {
            ArrayList<String> options = new ArrayList<>();
            options.add("subblackit search");
            options.add("Account search");
            options.add("post search");
            options.add("Exit");


            int x = j.menu(options);
            String searchText = null;
            if (x<4) {
                j.out("what to search for?", 1);
                searchText =  j.in();
            }

            switch (x) {
                case 1:
                    int searchResult1= subSearch(searchText);
                    if(searchResult1>=0) {
                        Sub sub1 = sublist.get(searchResult1);
                        ArrayList<String> options1 = new ArrayList<>();
                        j.out(sub1.title+"   " + sub1.memberList.size() + " members " +  "  " + sub1.getKarma() + " karma ",1);
                        options1.add("show posts");
                        options1.add("join");
                        options1.add("Exit");
                        switch (j.menu(options1)){
                            case 1:
                                Sub.showPosts(sub1.postList);
                                break;
                            case 2:
                                sub1.addMember(user);
                                break;
                            case 3:
                                return;
                        }
                    }
                    break;
                case 2:
                    int searchResult2 = accountSearch(searchText);
                    if(searchResult2>=0)
                    {
                        Account account = accountlist.get(searchResult2);
                        ArrayList<String> options2 = new ArrayList<>();
                        j.out(account.username+"   " + account.accountPosts.memberList.size() + " members " ,1);
                        options2.add("show posts");
                        options2.add("join");
                        options2.add("Exit");

                        switch (j.menu(options2)){
                            case 1:
                                account.showPosts();
                                break;
                            case 2:
                                account.accountPosts.addMember(user);
                                break;
                            case 3:
                                return;
                        }
                    }

                    break;
                case 3:
                    postSearch(searchText);
                    break;
                case 4:
                    return;

            }
        }
    }
    public static int subSearch(String searchText){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> resultID = new ArrayList<>();


        for (int i = 0; i < sublist.size(); i++) {
            if(sublist.get(i).title.contains(searchText)){
                result.add(sublist.get(i).title +"   "+ sublist.get(i).memberList.size() +" members" +  "  " + sublist.get(i).getKarma() + " karma ");
                resultID.add(i);
            }
        }
        if (!result.isEmpty()){
            return resultID.get(j.menu(result)-1) ;
        }
        else {
            j.out("nothing to show",1);
            return -1;
        }
    }
    public static void postSearch(String searchText) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> resultID = new ArrayList<>();

        for (int i = 0; i < postlist.size(); i++) {
            if(postlist.get(i).title.contains(searchText)){
                result.add(postlist.get(i).title);
                resultID.add(i);
            }
        }
        postlist.get(resultID.get(j.menu(result)-1)).showPost();
    }
    public static int accountSearch(String searchText) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> resultID = new ArrayList<>();

        for (int i = 0; i < accountlist.size(); i++) {
            if(accountlist.get(i).username.contains(searchText)){
                result.add(accountlist.get(i).username);
                resultID.add(i);
            }
        }
        return resultID.get(j.menu(result)-1);
    }
    public static void showPosts() {
        ArrayList<Post> postList = new ArrayList<>();
        for (int i = 0; i < user.joinedSubs.size(); i++) {

            Sub sub = user.joinedSubs.get(i);
            int size = sub.postList.size();
            int limitToFive = Math.min(5,size);

            for (int j = 0; j < limitToFive; j++) {
                postList.add(sub.postList.get(size-1-j));
            }
        }
        for (int i = 0; i < user.joinedSubs.size(); i++) {
            Sub sub = user.joinedSubs.get(i);
            int size = sub.postList.size();
            if (size>5) {
                for (int j = 0; j < size-5; j++) {
                    postList.add(sub.postList.get(size-5 - 1 - j));
                }
            }
        }
        Sub.showTimeLine(postList);

    }
    public static void personalMenu() throws Exception {
        while (true) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Account");
            options.add("joined sub blackits");
            options.add("admin sub blackits");
            options.add("create post");
            options.add("create sub blackit");
            options.add("Up voted posts");
            options.add("exit");

            switch (j.menu(options)) {
                case 1:
                    personalAccountMenu();
                    break;
                case 2:
                    user.showJoined(postlist);
                    break;
                case 3:
                    user.showOwned(postlist, accountlist);
                    break;
                case 4:
                    j.out("what to search for?", 1);
                    String searchText = j.in();
                    user.addPost(sublist.get(subSearch(searchText)), postlist);
                    break;
                case 5:
                    j.out("enter sub blackit title",1);
                    sublist.add(new Sub(j.in(), user));
                    user.addOwnedSub(sublist.getLast());
                    break;
                case 6:
                    j.out("upvoted posts",1);
                    Sub.showPosts(user.upVotedPosts);
                    break;
                case 7:
                    return;
            }
        }
    }
    public static void personalAccountMenu() throws Exception {
        while (true){
            ArrayList<String> options = new ArrayList<>();
            options.add("change Username");
            options.add("change Password");
            options.add("change email");
            options.add("Exit");

            switch (j.menu(options)) {
                case 1:
                    user.changeUsername(accountlist);
                    break;
                case 2:
                    user.changePassword();
                    break;
                case 3:
                    user.changeEmail();
                    break;
                case 4:
                    return;
            }
        }
    }
    public static void readFile()
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Accounts.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                j.out("*");

            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeToFile()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Accounts.txt")))
        {
            for (Account acc : accountlist) {
                writer.write(acc.username + " ");
                writer.write(acc.email + " ");
                writer.write(acc.password + " ");
                writer.write(acc.accountID + " ");

                writer.newLine();  // This writes a newline
            }
        }
        catch (IOException ignored) {}
    }
    public static void initializer() throws Exception {
        accountlist.add(new Account("admin","0000"));
        accountlist.add(new Account("vahid","0000"));

        Account admin = accountlist.getFirst();
        sublist.add(new Sub("sub 1",admin));
        admin.addOwnedSub(sublist.getLast());
        sublist.add(new Sub("sub 2",admin));
        admin.addOwnedSub(sublist.getLast());

        postlist.add(new Post("funny post","some joke", admin, sublist.get(1)));
        sublist.getFirst().addPost(postlist.getLast());
        postlist.add(new Post("funny post 2","some more joke", admin, sublist.get(1)));
        sublist.getFirst().addPost(postlist.getLast());
        postlist.add(new Post("post 1 ","barbari khorim",admin, sublist.getFirst()));
        sublist.getFirst().addPost(postlist.getLast());
        postlist.add(new Post("post 2","porteghal mikhorim",admin, sublist.getFirst()));
        sublist.getFirst().addPost(postlist.getLast());
        postlist.add(new Post("post 2","shirini mikhorim",admin, sublist.getFirst()));
        sublist.getFirst().addPost(postlist.getLast());

        user = accountlist.getFirst();
    }

}




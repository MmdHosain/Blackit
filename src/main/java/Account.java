import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    public ArrayList<Sub> ownedSubs = new ArrayList<>();
    public ArrayList<Sub> joinedSubs = new ArrayList<>();
    Sub accountPosts;
    String username;
    protected String password;
    protected UUID accountID;
    protected String email;
    protected boolean isActive = false;
    int karma = 0;
    public Account (List<Account> accountList) throws Exception {
        setUsername(accountList);
        setPassword();
        setEmail();
        this.accountID = UUID.randomUUID();
        accountPosts = new Sub(username + " posts",this) ;
    }
    public Account (String username , String password) throws Exception {
        this.username = username;
        this.password = hashWithSalt(password);
        this.email = "dsa@gmail.com";
        this.accountID = UUID.randomUUID();
        accountPosts = new Sub(username + " posts",this) ;

    }
    protected void setPassword() throws Exception {
        boolean isOk = false;
        while (!isOk) {
            j.out("Enter your password:", 1);
            String tempPassword = j.in();

            j.out("Enter your password again:", 1);

            if (Objects.equals(tempPassword, j.in())) {

                this.password = hashWithSalt(tempPassword);
                isOk = true;
            } else {
                j.out("password did not mach", 1);
            }
        }
    }
    public void setUsername(List<Account> accountList){
        j.out("Enter username",1);
        String username = j.in();
        if (!validateUserName(accountList,username)) {
            setUsername(accountList);
        }
        else {
            this.username = username;
        }
    }
    public void setEmail(){
        j.out("Enter Email",1);
        String email = j.in();
        if (validateEmail(email)){
            this.email = email;
        }
        else {
            j.out("Email is not correct. ");
            j.out("try again please", 1);
            setEmail();
        }
    }
    private boolean validateUserName(List<Account> arraylist, String current) {

        for (int i = 0; i < arraylist.size(); i++) {
            if (current.equals(arraylist.get(i).username)) {
                j.out("User Name is not valid", 1);
                j.out("Enter another User name", 1);
                return false;
            }
        }
        return true;
    }
    public void joinSub(Sub sub){
        joinedSubs.add(sub);
    }
    public void unJoinSub(Sub sub){
        joinedSubs.remove(sub);
    }
    public void changeUsername(List<Account> accountList) throws Exception {
        if(checkPassword()){
            setUsername(accountList);
            j.out("successfully changed",1);
        }
    }
    public void changePassword() throws Exception {
        if(checkPassword()){
            setPassword();
            j.out("successfully changed",1);

        }
    }
    public void changeEmail() throws Exception {
        if(checkPassword()){
            setEmail();
            j.out("successfully changed",1);

        }
    }
    private boolean checkPassword() throws Exception {
        j.out("Enter  your current password",1);
        if(hashWithSalt(password).equals(j.in())){
            return true;
        }
        else {
            j.out("Wrong password",1);
            return false;
        }
    }
    private static boolean validateEmail(String email) {
        String regex = "([qwertyuiopasdfghjklzxcvbnm1234567890_]+@[qwertyuiopasdfghjklzxcvbnm1234567890_]+.[qwertyuiopasdfghjklzxcvbnm1234567890_]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()){
            return true;
        }
        else {
            j.out("Invalid Email",1);
            return false;
        }
    }
    public void showJoined(ArrayList<Post> postList){
        ArrayList<String> result = new ArrayList<>();
        if (joinedSubs.isEmpty()) {
            j.out("nothing to show", 1);
        }
        else {
            for (int i = 0; i < joinedSubs.size(); i++) {
                result.add(joinedSubs.get(i).title);
            }
            Sub sub = joinedSubs.get(j.menu(result) - 1);
            while (true){
                ArrayList<String> options = new ArrayList<>();
                options.add("show posts");
                options.add("leave this Sub Blackit ");
                options.add("add post");
                options.add("Exit");
                switch (j.menu(options)) {
                    case 1:
                        Sub.showPosts(sub.postList);
                        break;
                    case 2:
                        sub.rewoveMember(this);
                        break;
                    case 3:
                        addPost(sub,postList);
                        break;
                    case 4:
                        return;
                }
            }
        }
    }
    public void showOwned(ArrayList<Post> postList,ArrayList<Account> accountList){

        ArrayList<String> result = new ArrayList<>();
        if (ownedSubs.isEmpty()){
            j.out("nothing to show", 1);
        }
        else {
            for (int i = 0; i < ownedSubs.size(); i++) {
                result.add(ownedSubs.get(i).title);
            }
            Sub sub = ownedSubs.get(j.menu(result) - 1);
            while (true) {
                ArrayList<String> options = new ArrayList<>();
                options.add("show posts");
                options.add("join this Sub Blackit ");
                options.add("add post");
                options.add("add admin");
                options.add("Exit");
                switch (j.menu(options)) {
                    case 1:
                        Sub.showPosts(sub.postList);
                        break;
                    case 2:
                        sub.addMember(this);
                        j.out("joined successfully",1);
                        break;
                    case 3:
                        addPost(sub,postList);
                        break;
                    case 4:
                        j.out("who do you want to be admin?",1);

                        sub.addAdmin(accountList,Main.accountSearch(j.in()));
                        break;
                    case 5:
                        return;
                }
            }
        }
    }

    public void addOwnedSub(Sub sub){
        ownedSubs.add(sub);
    }

    public void addPost(Sub sub, ArrayList<Post> postlist){
        j.out("Enter Title",1);
        String title = j.in();
        j.out("Enter your text",1);
        String text = j.in();
        postlist.add(new Post(title,text,this,sub));
        accountPosts.postList.add(postlist.getLast());
        sub.postList.add(postlist.getLast());
    }
    public void showPosts(){
        Sub.showPosts(accountPosts.postList);
    }

    public static String hashWithSalt(String password) throws Exception {
        return String.valueOf(password.hashCode());
    }
}
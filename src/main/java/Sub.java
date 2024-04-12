import java.util.ArrayList;
import java.util.List;

public class Sub {
    public ArrayList<Account> adminList = new ArrayList<>();
    public ArrayList<Account> memberList = new ArrayList<>();
    public ArrayList<Post> postList = new ArrayList<>();
    Account owner;
    String title = "-";
    public Sub(String title, Account owner){
        this.title = title;
        this.owner = owner;
    }
    public void addMember(Account user){
        memberList.add(user);
        user.joinSub(this);
    }
    public void rewoveMember(Account user){
        memberList.remove(user);
        user.unJoinSub(this);
    }

    public void addPost(Post post){
        postList.add(post);
    }
    public void addAdmin(ArrayList<Account> list,int accID){
            Account acc = list.get(accID);
            adminList.add(acc);
            j.out(acc.username + " is admin now",1);
    }

    public static void showPosts(ArrayList<Post> postList){  //***********
        int pointer = 0 ;
        if (postList.isEmpty()) {
            j.out("nothing to show",1);
            return;
        }
        while (true){
            Post post = postList.get(pointer);
            post.showPost();
            ArrayList<String> options = new ArrayList<>();
            options.add("go next");
            options.add("go back");
            options.add("up vote");
            options.add("down vote");
            options.add("add comment");
            options.add("show comments");

            options.add("Exit");
            switch (j.menu(options)){
                case 1:
                    pointer ++;
                    if (pointer >= postList.size())
                        pointer --;
                    break;
                case 2:
                    pointer --;
                    if (pointer <  0)
                        pointer ++;
                    break;
                case 3:
                    post.karma ++;
                    break;
                case 4:
                    post.karma --;
                    break;
                case 5:
                    post.addComment(post.sub);
                    break;
                case 6:
                    post.showComments();
                    break;
                case 7:
                    return;

            }
        }
    }
//    public void showPosts(ArrayList<Post> postList){
//        int pointer = 0 ;
//        while (true){
//
//
//            Post post = postList.get(pointer);
//            post.showPost();
//            ArrayList<String> options = new ArrayList<>();
//            options.add("6 go next");
//            options.add("4 go back");
//            options.add("5 up vote");
//            options.add("2 down vote");
//            options.add("3 add comment");
//            options.add("9 show comments");
//
//            options.add("7 Exit");
//            switch (j.menu(options)){
//                case 6:
//                    pointer ++;
//                    if (pointer >= postList.size())
//                        pointer --;
//                    break;
//                case 4:
//                    pointer --;
//                    if (pointer <  0)
//                        pointer ++;
//                    break;
//                case 5:
//                    post.karma ++;
//                    break;
//                case 2:
//                    post.karma --;
//                    break;
//                case 3:
//                    post.addComment(post.sub);
//                    break;
//                case 9:
//                    post.showComments();
//                    break;
//                case 7:
//                    return;
//
//            }
//        }
//    }
}

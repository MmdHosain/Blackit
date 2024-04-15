import java.util.ArrayList;

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
    public int getKarma(){
        int result= 0;
        for (int i = 0; i < postList.size(); i++) {
            result += postList.get(i).karma;
        }
        return result;
    }

    public void addPost(Post post){
        postList.add(post);
    }
    public void addAdmin(ArrayList<Account> list,int accID){
            Account acc = list.get(accID);
            adminList.add(acc);
            j.out(acc.username + " is admin now",1);
    }

    public static void showPosts(ArrayList<Post> postList){
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
            int y = 0;

            for (var account : post.sub.adminList) {
                if (account.username.equals(Main.user.username)){
                    y=1;
                }
            }
            if (y==1){
                options.add("enter \"100\" to delete");
            }
            int x =j.menu(options);
            if(y==1&&x==100){
                post.delete();
            }
            switch (x){
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
                    Main.user.upVote(post);
                    break;
                case 4:
                    Main.user.downVote(post);
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
    public static void managePosts(ArrayList<Post> postList){
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
            options.add("delete post");

            options.add("Exit");


            int x =j.menu(options);

            post.delete();

            switch (x){
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
                    Main.user.upVote(post);
                    break;
                case 4:
                    Main.user.downVote(post);
                    break;
                case 5:
                    post.addComment(post.sub);
                    break;
                case 6:
                    post.showComments();
                    break;
                case 7:
                    post.delete();
                    break;
                case 8:
                    return;

            }
        }
    }

    public static void showTimeLine(ArrayList<Post> postList){
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
                    Main.user.upVote(post);
                    break;
                case 4:
                    Main.user.downVote(post);
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

}

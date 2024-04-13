import java.util.ArrayList;

public class Post {
    public ArrayList<Post> commentList = new ArrayList<>();
    public ArrayList<Account> upVoteList = new ArrayList<>();
    public ArrayList<Account> downVoteList = new ArrayList<>();


    Account creator;
    String title = "-";
    int karma = 0 ;
    String text="-";

    Sub sub;
    public Post(String title, String text, Account creator, Sub subblackit){
        this.title= title;
        this.text = text;
        this.creator = creator;
        this.sub = subblackit;
    }

    public void addComment(Sub sub){
        j.out("Enter your text");
        String text = j.in();
        commentList.add(new Post("comment",text,creator,sub));
        Main.user.accountPosts.postList.add((commentList.getLast()));
    }
    public void showComments(){
        for (int i = 0; i < commentList.size(); i++) {
            Post.showComment(commentList.get(i),this);
        }
    }
    public void delete(){
        text ="deleted";
        title ="deleted";
    }

    public void showPost(){
        j.out("\n\n");
        j.out("posted into " + sub.title,1) ;
        j.out(" by " + creator.username,1);
        j.out("",1);
        j.out(title,1);
        j.out(text,1);
        //j.out("karma");j.out(karma,1);
    }
    private static void showComment(Post comment,Post post){
        j.out("replied on " + post.title + " by " + post.creator.username,1);
        j.out(comment.text,1);
        j.out("karma");j.out(comment.karma,1);
    }

}

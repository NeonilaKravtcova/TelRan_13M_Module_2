package de.telran.data;

public class Post {
    private User author;
    private int postId;
    public static int postsQty = 0;
    private String title;
    private String content;
    private int likes= 0;
    private int dislikes= 0;

    public Post(User author, String title, String content) {
        this.author = author;
        this.postId = ++postsQty;
        this.title = title;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public int getPostId() {
        return postId;
    }

    public static int getPostsQty() {
        return postsQty;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post # " + postId +
                ", posted by " + author +
                ", title \"" + title.toUpperCase() +
                "\"\n\"" + content + "\"" +
                "\nlikes: " + likes +
                ", dislikes: " + dislikes;
    }

    public int addLike(){
        return likes++;
    }

    public int getDislike(){
        return dislikes++;
    }
}

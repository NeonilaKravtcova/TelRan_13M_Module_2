package de.telran.application;

import de.telran.dao.Forum;
import de.telran.data.Post;
import de.telran.data.User;
import de.telran.data.UserAdmin;

import java.util.Scanner;

public class ForumApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user1 = new User("Vasya", 28);
        User user2 = new User ("Masha", 24);
        UserAdmin admin = new UserAdmin("Max", 32, "space");

        Post post1 = new Post(user1, "Hallo", "Today is a beautiful day!");
        Post post2 = new Post(user2, "Woou!", "Great day!");
        Post post3 = new Post(admin, "Dream", "Bla bla bla bla");
        Post post4 = new Post(user2, "Nice", "To meet you");
        Post post5 = new Post(user1, "Never", "Say me tomorrow");
        Post post6 = new Post(user1, "Good bye", "See you later");

        Forum forum = new Forum(100);
        forum.addPost(post1);
        forum.addPost(post2);
        forum.addPost(post3);
        forum.addPost(post4);
        forum.addPost(post5);
        forum.addPost(post6);

        System.out.println(post1.getLikes());
        post1.addLike();
        post1.addLike();
        post1.addLike();
        System.out.println(post1.getLikes());

        //forum.updatePostByAdmin(115, scanner);
        //forum.updatePostByAdmin(post1.getPostId(), scanner);
        forum.displayPosts();

        forum.deletePostByAdmin(post3.getPostId(), scanner);
        forum.displayPosts();

        forum.deletePostByAdmin(12, scanner);
        forum.displayPosts();

        scanner.close();
    }
}

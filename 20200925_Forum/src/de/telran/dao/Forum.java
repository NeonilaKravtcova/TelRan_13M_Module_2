package de.telran.dao;

import de.telran.data.Post;
import de.telran.data.UserAdmin;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Scanner;

public class Forum {
    private Post[] posts;
    private int size;

    public Forum(int capacity) {
        posts = new Post[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean addPost(Post post) {
        if (size < posts.length) {
            posts[size] = post;
            size++;
            return true;
        }
        return false;
    }

    private Post[] getLastPostsByAuthor(String author, int n) {
        int count = 0;
        Post[] authorsPosts = new Post[n];
        for (int i = 0; i < size; i++) {
            if (posts[i].getAuthor().getUserName().equalsIgnoreCase(author) && count < n) {
                authorsPosts[count] = posts[i];
                count++;
            }
        }
        return authorsPosts;
    }

    public int getCountLikesByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equalsIgnoreCase(title)) {
                return posts[i].getLikes();
            }
        }
        return -1;
    }

    public void updatePostByAdmin(int postId, Scanner scanner) {
        if (checkPassword(scanner)) {
            boolean updated = false;
            for (int i = 0; i < size; i++) {
                if (posts[i].getPostId() == postId) {
                    System.out.println("Old content: " + posts[i].getContent());
                    System.out.print("Enter new content: ");
                    posts[i].setContent(scanner.nextLine());
                    System.out.println("Content is changed to: " + posts[i].getContent());
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                System.out.println("Post not found");
            }
        } else {
            System.out.println("Access is denied");
        }
    }

    public void deletePostByAdmin(int postId, Scanner scanner) {
        System.out.println("You are going to delete a post");
        if (checkPassword(scanner)) {
            boolean deleted = false;
            for (int i = 0; i < size; i++) {
                if (posts[i].getPostId() == postId) {
                    for (int j = i; j < size - 1; j++) {
                        posts[j] = posts[j + 1];
                    }
                    System.out.println("Post is deleted");
                    deleted = true;
                    size--;
                    Post.postsQty--;
                    break;
                }
            }
            if (!deleted) {
                System.out.println("Post is not found");
            }
        } else {
            System.out.println("Access is denied");
        }
    }

    private boolean checkPassword(Scanner scanner) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getAuthor().getClass().getSimpleName().equals("UserAdmin")) {
                UserAdmin admin = (UserAdmin) posts[i].getAuthor();
                int count = 3;
                while (count > 0) {
                    System.out.print("Please, enter your password: ");
                    String password = scanner.nextLine();
                    if (admin.getPassword().equals(password)) {
                        return true;
                    } else {
                        count--;
                    }
                }
            }
        }
        return false;
    }

    public void displayPosts() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i].getPostId() + ". " + posts[i].getTitle() + " by " + posts[i].getAuthor());
            System.out.println("-------------------------");
            System.out.println("  \"" + posts[i].getContent() + "\"\n");
        }
    }
}

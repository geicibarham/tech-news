package com.technews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    @Column(unique = true)
    private String Email;
    private String password;
    @Transient
    boolean loggedIn;

    @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> posts;

    @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;

    @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

  public User() {

  }

   public User (Integer id, String username,String email, String password) {
      this.id=id;
      this.username = username;
      this.email = email;
      this.password = password;
   }

   public Integer getId(){
      return id;
   }
   public void setId(Integer id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
    }

    public void setUsername( String username){
      this.username = username;
    }

    public String getEmail(){
      return email;
    }

    public void setEmail (String email) {
      this.email = email;
    }

    public void setEmail(string email) {
      this.email = email;
    }

    public String getPassword(){
      return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public  List <Post> getPosts(){
      return posts;
    }

   public void setPosts(List<Post> posts){
      this.posts = posts;
   }

   public List <Vote> getVotes(){
      return votes;
   }

   public List <Comment> getComments (){
      return comments;
   }

   public void setComments(List <Comment> comments) {
     this.comments = comments;
   }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getVoteCount() == post.getVoteCount() &&
                Objects.equals(getId(), post.getId()) &&
                Objects.equals(getTitle(), post.getTitle()) &&
                Objects.equals(getPostUrl(), post.getPostUrl()) &&
                Objects.equals(getUserName(), post.getUserName()) &&
                Objects.equals(getUserId(), post.getUserId()) &&
                Objects.equals(getPostedAt(), post.getPostedAt()) &&
                Objects.equals(getUpdatedAt(), post.getUpdatedAt()) &&
                Objects.equals(getComments(), post.getComments());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPostUrl(), getUserName(), getVoteCount(), getUserId(), getPostedAt(), getUpdatedAt(), getComments());
    }
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}

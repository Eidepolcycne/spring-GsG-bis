package com.wildcodeSchool.projetbis.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String mail;
    private String password;
    private String role;



    @ManyToMany
    @JoinTable(name= "favorite_articles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> favoriteArticles;

    @ManyToMany
    @JoinTable(name= "favorite_recipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> favorite_recipes;

    @ManyToMany
    @JoinTable(name= "Like_recipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> like_recipes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Article> articles;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Article> getFavoriteArticles() {
        return favoriteArticles;
    }

    public void setFavoriteArticles(List<Article> favoriteArticles) {
        this.favoriteArticles = favoriteArticles;
    }

    public List<Recipe> getFavorite_recipes() {
        return favorite_recipes;
    }

    public void setFavorite_recipes(List<Recipe> favorite_recipes) {
        this.favorite_recipes = favorite_recipes;
    }

    public List<Recipe> getLike_recipes() {
        return like_recipes;
    }

    public void setLike_recipes(List<Recipe> like_recipes) {
        this.like_recipes = like_recipes;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "booksList")
    private List<Author> authorsList;

    @ManyToMany(mappedBy = "booksList")
    private List<BookShop> bookShopList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    public List<BookShop> getBookShopList() {
        return bookShopList;
    }

    public void setBookShopList(List<BookShop> bookShopList) {
        this.bookShopList = bookShopList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

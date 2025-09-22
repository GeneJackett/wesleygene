package com.personalsite.wesleygene.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "blog_category")
    private String blogCategory;
    @Column(name = "blog_title")
    private String blogTitle;
    @Column(name = "blog_summary")
    private String blogSummary;
    @Column(name = "blog_content")
    private String blogContent;
    @Column(name = "blog_date")
    private String blogDate;
    @Column(name = "blog_update_date")
    private String blogUpdateDate;
    
    public Blog(){

    }
    
    public Blog(Long id, String blogCategory, String blogTitle, String blogSummary, String blogContent, String blogUpdateDate, String blogDate) {
        super();
        this.id = id;
        this.blogCategory = blogCategory;
        this.blogTitle = blogTitle;
        this.blogSummary = blogSummary;
        this.blogContent = blogContent;
        this.blogUpdateDate = blogUpdateDate;
        this.blogDate = blogDate;
    }

    public String getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(String blogCategory) {
        this.blogCategory = blogCategory;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogUpdateDate() {
        return blogUpdateDate;
    }

    public void setBlogUpdateDate(String blogUpdateDate) {
        this.blogUpdateDate = blogUpdateDate;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

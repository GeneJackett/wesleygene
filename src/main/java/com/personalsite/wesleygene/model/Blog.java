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
    @Column(name = "category")
    private String category;
    @Column(name = "blog_title")
    private String blog_title;
    @Column(name = "blog_summary")
    private String blog_summary;
    @Column(name = "blog_content")
    private String blog_content;
    @Column(name = "blog_date")
    private String blog_date;
    @Column(name = "blog_update_date")
    private String blog_update_date;
    
    public Blog(){

    }
    
    public Blog(long id, String category, String blogTitle, String blogSummary, String blogContent, String blog_update_date, String blogDate) {
        super();
        this.id = id;
        this.category = category;
        this.blog_title = blogTitle;
        this.blog_summary = blogSummary;
        this.blog_content = blogContent;
        this.blog_update_date = blog_update_date;
        this.blog_date = blogDate;
    }

    public String getBlogCategory() {
        return category;
    }

    public void setBlogCategory(String category) {
        this.category = category;
    }

    public String getBlogTitle() {
        return blog_title;
    }

    public void setBlogTitle(String blogTitle) {
        this.blog_title = blogTitle;
    }

    public String getBlog_update_date() {
        return blog_update_date;
    }

    public void setBlog_update_date(String blog_update_date) {
        this.blog_update_date = blog_update_date;
    }

    public String getBlogDate() {
        return blog_date;
    }

    public void setBlogDate(String blogDate) {
        this.blog_date = blogDate;
    }

    public String getBlogContent() {
        return blog_content;
    }

    public void setBlogContent(String blogContent) {
        this.blog_content = blogContent;
    }

    public String getBlogSummary() {
        return blog_summary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blog_summary = blogSummary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

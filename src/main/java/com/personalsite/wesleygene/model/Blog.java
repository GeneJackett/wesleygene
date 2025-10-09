package com.personalsite.wesleygene.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Data
@Entity
@Table(name ="blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "blog_category")
    private String category;
    @Column(name = "blog_title")
    private String blogTitle;
    @Column(name = "blog_summary")
    private String blogSummary;
    @Column(name = "blog_content")
    private String blogContent;
    @UpdateTimestamp
    @Column(name = "blog_last_update")
    private Instant blogLastUpdate;
    @CreationTimestamp
    @Column(name = "blog_create_date", updatable = false)
    private Instant blogCreateDate;

    public Blog(){

    }

    public Blog(String category, String blogTitle, String blogSummary, String blogContent, Instant blogLastUpdate, Instant blogCreateDate) {
        super();
        this.category = category;
        this.blogTitle = blogTitle;
        this.blogSummary = blogSummary;
        this.blogContent = blogContent;
        this.blogLastUpdate = blogLastUpdate;
        this.blogCreateDate = blogCreateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Instant getBlogLastUpdate() {
        return blogLastUpdate;
    }

    public Instant getBlogCreateDate() {
        return blogCreateDate;
    }
}

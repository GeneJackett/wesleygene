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
    @Column(name = "blog_title")
    private String blogTitle;
    @Column(name = "blog_summary")
    private String blogSummary;
    @Column(name = "blog_content")
    private Double blogContent;
    @Column(name = "blog_date")
    private String blogDate;
    @Column(name = "blog_update_date")
    private String blogUpdateDate;
    
    public Blog(){

    }
    
    public Blog(Integer id, String blogTitle, String blogSummary, String blogContent, String blogUpdateDate, String blogDate) {
        super();
        this.blogTitle = blogTitle;
        this.blogId = blogId;
        this.totalSaleAmount = totalSaleAmount;
        this.blogDate = blogDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCustomerId(String blogTitle) {return blogTitle;}
    public void setCustomerId(String blogTitle) {
        this.blogTitle = blogTitle;
    }
    public String getBlogId() {
        return blogId;
    }
    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
    public Double getTotalSaleAmount() {
        return totalSaleAmount;
    }
    public void setTotalSaleAmount(Double totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }
    public String getBlogDate() {
        return blogDate;
    }
    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }
}

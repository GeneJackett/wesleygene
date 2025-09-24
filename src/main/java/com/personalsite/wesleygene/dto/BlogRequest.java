package com.personalsite.wesleygene.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogRequest {
    private String blog_category;
    private String blog_title;
    private String blog_summary;
    private String blog_content;
    private String blog_last_update;
    private String blog_create_date;

}

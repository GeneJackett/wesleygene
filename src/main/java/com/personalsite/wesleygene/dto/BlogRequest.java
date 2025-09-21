package com.personalsite.wesleygene.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogRequest {
    private String Title;
    private String Summary;
    private String Content;
    private String LastUpdate;
    private String CreateDate;
}

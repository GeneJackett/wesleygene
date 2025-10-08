package com.personalsite.wesleygene.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class BlogRequest {
    private String category;
    private String blogTitle;
    private String blogSummary;
    private String blogContent;
    private Instant blogLastUpdate;
    private Instant blogCreateDate;
}

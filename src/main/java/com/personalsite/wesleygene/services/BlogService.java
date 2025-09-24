package com.personalsite.wesleygene.services;

import com.personalsite.wesleygene.dto.BlogRequest;
import com.personalsite.wesleygene.model.Blog;
import com.personalsite.wesleygene.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository BlogRepository;


    @Autowired
    public BlogService(BlogRepository BlogRepository) {
        this.BlogRepository = BlogRepository;

    }

    public List<Blog> getAllBlogs() {
        return BlogRepository.findAll();
    }

    public Blog createBlog(BlogRequest request) {
        Blog newBlog = new Blog();
        newBlog.setBlogCategory(request.getBlog_category());
        newBlog.setBlogTitle(request.getBlog_title());
        newBlog.setBlogSummary(request.getBlog_summary());
        newBlog.setBlogContent(request.getBlog_content());
        newBlog.setBlog_update_date(request.getBlog_last_update());
        newBlog.setBlogDate(request.getBlog_create_date());
        return BlogRepository.save(newBlog);
    }

    public Optional<Blog> updateBlog(BlogRequest request, long id) {
        if (BlogRepository.existsById(id)) {
            Blog existingBlog = new Blog();
            existingBlog.setId(id);
            existingBlog.setBlogTitle(request.getBlog_title());
            existingBlog.setBlogSummary(request.getBlog_summary());
            return Optional.of(BlogRepository.save(existingBlog));
        }
        return Optional.empty();
    }

    public Blog deleteBlogById(long id) {

        return BlogRepository.deleteBlogById(id);

    }

    public List<Blog> getBlogsByCategory(String blog_category) {
       return BlogRepository.getBlogsByCategory(blog_category);
    }
}

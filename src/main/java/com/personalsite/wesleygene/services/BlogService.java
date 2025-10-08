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
        newBlog.setCategory(request.getCategory());
        newBlog.setBlogTitle(request.getBlogTitle());
        newBlog.setBlogSummary(request.getBlogSummary());
        newBlog.setBlogContent(request.getBlogContent());
        return BlogRepository.save(newBlog);
    }

    public Optional<Blog> updateBlog(BlogRequest request, long id) {
        if (BlogRepository.existsById(id)) {
            Blog existingBlog = new Blog();
            existingBlog.setId(id);
            existingBlog.setBlogTitle(request.getBlogTitle());
            existingBlog.setBlogSummary(request.getBlogSummary());
            return Optional.of(BlogRepository.save(existingBlog));
        }
        return Optional.empty();
    }

    public Blog deleteBlogById(long id) {

        return BlogRepository.deleteBlogById(id);

    }

    public List<Blog> getBlogsByCategory(String category) {
       return BlogRepository.getBlogsByCategory(category);
    }
}

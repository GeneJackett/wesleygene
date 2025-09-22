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

    private BlogRepository BlogRepository;


    @Autowired
    public BlogService(BlogRepository BlogRepository) {
        this.BlogRepository = BlogRepository;

    }

    public List<Blog> getAllBlogs() {
        return BlogRepository.findAll();
    }

    public Blog createBlog(BlogRequest request) {
        Blog newBlog = new Blog();
//        newBlog.setCustomerId(request.getCustomerId());
//        newBlog.setBlogId(request.getBlogId());
//        newBlog.setTotalSaleAmount(request.getTotalSaleAmount());
//        newBlog.setBlogDate(request.getBlogDate());
        return BlogRepository.save(newBlog);
    }

    public Optional<Blog> updateBlog(BlogRequest request, long id) {
        if (BlogRepository.existsById(id)) {
            Blog existingBlog = new Blog();
            existingBlog.setId(id);
            existingBlog.setBlogTitle(request.getTitle());
            existingBlog.setBlogSummary(request.getSummary());
            existingBlog.setBlogDate(request.getCreateDate());
            return Optional.of(BlogRepository.save(existingBlog));
        }
        return Optional.empty();
    }

    public Blog deleteBlogById(long id) {
        return BlogRepository.deleteById(id);

    }


    public List<Blog> getBlogsByCategory(String category) {
        BlogRepository.get
    }
}

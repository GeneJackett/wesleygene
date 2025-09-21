package com.personalsite.wesleygene.services;

import com.ordersdemo.ordersdemo.dto.BlogRequest;
import com.ordersdemo.ordersdemo.model.Blog;
import com.ordersdemo.ordersdemo.repository.BlogRepository;
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
        newBlog.setCustomerId(request.getCustomerId());
        newBlog.setBlogId(request.getBlogId());
        newBlog.setTotalSaleAmount(request.getTotalSaleAmount());
        newBlog.setBlogDate(request.getBlogDate());
        return BlogRepository.save(newBlog);
    }

    public Optional<Blog> updateBlog(BlogRequest request, long id) {
        if (BlogRepository.existsById(id)) {
            Blog existingBlog = new Blog();
            existingBlog.setId(id);
            existingBlog.setCustomerId(request.getCustomerId());
            existingBlog.setBlogId(request.getBlogId());
            existingBlog.setTotalSaleAmount(request.getTotalSaleAmount());
            existingBlog.setBlogDate(request.getBlogDate());
            return Optional.of(BlogRepository.save(existingBlog));
        }
        return Optional.empty();
    }

    public Boolean deleteBlogById(long id) {
        if (BlogRepository.public List <Blog> getBlogsByCustomerId(String customerId) {
            return BlogRepository.getBlogsB2yCustomerId(customerId);
        }existsById(id)) {
            BlogRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

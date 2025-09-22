package com.personalsite.wesleygene.controller;

import com.personalsite.wesleygene.dto.BlogRequest;
import com.personalsite.wesleygene.model.Blog;
import com.personalsite.wesleygene.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200/Blogs") // allow angular frontend
public class BlogController {

    @Autowired
    private final BlogService BlogService;

    public BlogController(BlogService BlogService){
        this.BlogService = BlogService;
    }
    @GetMapping("/admin")
    public String admin(){
        return "Here!";
    }

    //get all Blogs
    @GetMapping("/Blogs")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> Blogs = BlogService.getAllBlogs();
       return (Blogs != null) ? ResponseEntity.ok(Blogs)
                       : ResponseEntity.notFound().build();
        
    }

    @GetMapping("/getBlogsByCategory")
    public ResponseEntity<List<Blog>> getBlogsByCategory(@RequestParam String category){
         List<Blog> Blogs = BlogService.getBlogsByCategory(category);
        return (Blogs != null) ? ResponseEntity.ok(Blogs)
                : ResponseEntity.notFound().build();
    }

    //request sent to db to remove record
    //print out success response after
    //what happens if we call the same delete request and no record matches?
    //
    @DeleteMapping("/delete/Blog")
    public ResponseEntity<Blog> deleteBlogById(Long id){
          Blog deleteBlogById = BlogService.deleteBlogById(id);
        return ResponseEntity.ok(deleteBlogById);
    } 

    //but what happens if 
    @PostMapping("/create/Blog")
    public ResponseEntity<Blog> createBlog(@RequestBody BlogRequest request){
        Blog savedBlog = BlogService.createBlog(request);
        return ResponseEntity.ok(savedBlog);
    }

    
    @PutMapping("/update/Blog/{id}")
    public ResponseEntity<Blog> updateBlog(@RequestBody BlogRequest request, @PathVariable Long id){
        return BlogService.updateBlog(request, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
}

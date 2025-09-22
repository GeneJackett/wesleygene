package com.personalsite.wesleygene.repository;

import com.personalsite.wesleygene.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

    List<Blog> getBlogCategorySports(String blogCategory);
}



package com.blog.blog.service;

import com.blog.blog.model.News;
import com.blog.blog.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UserService userService;



    public List<News> getNewsByUserId(Long authtorId) {

        return newsRepository.findByAuthorId(authtorId);
    }

    public News getNewsById(Long id) {

        Optional<News> news = newsRepository.findById(id);
        return news.orElse(null);
    }

    public void addNews (News news) throws IllegalArgumentException {
        newsRepository.save(news);
    }


    public void delNews (News news) throws IllegalArgumentException {
        newsRepository.delete(news);
    }



}

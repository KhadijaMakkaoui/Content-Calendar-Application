package com.dev.contentcalender.repository;

import com.dev.contentcalender.model.Content;
import com.dev.contentcalender.model.Status;
import com.dev.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c=new Content(1,
                "My first blog post",
                "my first desc of blog",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(c);
    }

    public void save(Content content) {
       contentList.removeIf(c->c.getId().equals(content.getId()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.getId().equals(id)).count()==1;

    }
}

package com.dev.contentcalender.model;

import java.time.LocalDateTime;

public class Content {
    Integer id;
    String title;
    String desc;
    Status status;
    Type contentType;
    LocalDateTime dateCreated;
    LocalDateTime dateUpdated;
    String url;
}

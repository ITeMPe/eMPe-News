package mp.empe.news.entity;

import javax.persistence.Entity;

@Entity
public class News {

    private String country;
    private String category;
    private String articles;
    private String author;
    private String title;
    private String description;
    private String date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;
}

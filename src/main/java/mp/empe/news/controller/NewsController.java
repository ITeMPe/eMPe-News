package mp.empe.news.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class NewsController {

    static final String key = d5cb1c65bb3442048ecba183138ceaef;

    @GetMapping("/headlines/{country_id}/{category_id}")
    public String printWelcome(@PathVariable("country_id") String country_id, @PathVariable("category_id") String category_id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?country="+country_id+"&category="+category_id+"&apiKey="+key;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/everything")
    public String get_everything(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=d5cb1c65bb3442048ecba183138ceaef";
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/sources")
    public String get_sources(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=d5cb1c65bb3442048ecba183138ceaef";
        return restTemplate.getForObject(url, String.class);
    }

}

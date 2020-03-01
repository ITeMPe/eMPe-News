package mp.empe.news.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class NewsController {


    @GetMapping("/")
    public String get_home_page(){
        return "Home Page";
    }


    @GetMapping("/headlines")
    public String get_top_headlines(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?country=pl&category=technology&apiKey=d5cb1c65bb3442048ecba183138ceaef";
        String result =  restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/everything")
    public String get_everything(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=d5cb1c65bb3442048ecba183138ceaef";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/sources")
    public String get_sources(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=d5cb1c65bb3442048ecba183138ceaef";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

}

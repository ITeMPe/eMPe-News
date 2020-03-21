package mp.empe.news.controller;


import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class NewsController {
    /*
    My private key for newAPI
     */
    static final String key = "d5cb1c65bb3442048ecba183138ceaef";

    @GetMapping("/headlines/{country_id}/{category_id}")
    public String get_top_headlines(@PathVariable("country_id") String country_id, @PathVariable("category_id") String category_id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?country="+country_id+"&category="+category_id+"&apiKey="+key;
        String result =  restTemplate.getForObject(url, String.class);

        Map<String, String> mydata = new HashMap<String, String>();
        mydata.put("country", country_id);
        mydata.put("category", category_id);
        mydata.put("articles", result);

//        Map<String, String> alldata = new HashMap<String, String>();
//        alldata.put("data", mydata);

        // Create JSON object from Java Map
        JSONObject tomJsonObj = new JSONObject(mydata);
        System.out.println(mydata);
        return  tomJsonObj.toString();
    }

    @GetMapping("/everything")
    public String get_everything(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey="+key;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/sources")
    public String get_sources(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey="+key;
        return restTemplate.getForObject(url, String.class);
    }

}

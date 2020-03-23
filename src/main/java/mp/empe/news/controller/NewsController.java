package mp.empe.news.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class NewsController {

    /*
    My private key for newAPI
     */
    static final String key = "d5cb1c65bb3442048ecba183138ceaef";

    /**
     * Endpoint required
     * @param country_id Information from which country they are news [String]
     * @param category_id Information about category in news [String]
     * @return json as String
     */
    @GetMapping("/news/{country_id}/{category_id}")
    public String get_top_headlines(@PathVariable("country_id") String country_id, @PathVariable("category_id") String category_id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?country="+country_id+"&category="+category_id+"&apiKey="+key;
        String result =  restTemplate.getForObject(url, String.class);
       try {

           JSONObject jsonResult = new JSONObject(result);
           jsonResult.putOpt("country",country_id);
           jsonResult.putOpt("category",category_id);
           System.out.println(jsonResult);
           System.out.println(jsonResult.toString());
           return jsonResult.toString();
       }
       catch (Exception e)
        {
            return "{upssss....}";
        }
    }

    /**
     * TODO
     * For develop in future
     * @return json as String
     */
    @GetMapping("/news/everything")
    public String get_everything(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey="+key;
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * TODO
     * For develop in future
     * @return json as String
     */
    @GetMapping("/news/sources")
    public String get_sources(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey="+key;
        return restTemplate.getForObject(url, String.class);
    }

}

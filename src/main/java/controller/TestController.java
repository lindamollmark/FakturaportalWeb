package controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Linda on 2016-03-11.
 */
    @RestController
    public class TestController {

        @CrossOrigin(origins = "http://localhost:9000")
        @RequestMapping("/hello/{name}")
        @ResponseBody
        String hello(@PathVariable String name){
            RestRespond respond = new RestRespond();
            respond.simpleRespond = "Tja, " + name + "!";
            String json = new Gson().toJson(respond);
            return json;
//        return respond.simpleRespond;
        }
}

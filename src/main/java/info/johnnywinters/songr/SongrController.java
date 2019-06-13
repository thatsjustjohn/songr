package info.johnnywinters.songr;

import org.springframework.web.bind.annotation.*;

@RestController
public class SongrController {

    // Specify the route for this method
    @GetMapping("/hello")
    public String getHelloWorld(){
        return "Hello, World!";
    }

    @GetMapping("/capitalize/{sentence}")
    public String capitalizePath(@PathVariable String sentence){
        if(sentence == null) return null;
        return sentence.toUpperCase();
    }

    @RequestMapping(value = "/reverse", method = RequestMethod.GET)
    @ResponseBody
    public String reverseSentence(
            @RequestParam("sentence") String sentence) {
        if(sentence == null) return null;
        String[] sentenceSplit = sentence.split(" ");
        StringBuilder returnSentence = new StringBuilder();
        for(int i = (sentenceSplit.length - 1); i >= 0; i--){
            returnSentence.append(sentenceSplit[i]);
            if(i != 0){
                returnSentence.append(" ");
            }
        }
        return returnSentence.toString();
    }
}

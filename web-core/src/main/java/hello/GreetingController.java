package hello;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
class GreetingController2 {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/greeting/{id}")
    public String Detailedgreeting(@PathVariable("id") String id, Model model) {
    	model.addAttribute("appid", id);
    	return "greeting";
    }
    
}

@RestController
//@Controller
public class GreetingController {

	@Autowired
	private AppRepository repository;
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
//    }
    
    @RequestMapping("/testjson")
    public Appinfo getCustomer() {
    	Appinfo res = repository.findByAppid("C10000291");
    	return res; 
    }
    
    @RequestMapping("/api/Top20")
    public List<Appinfo> mainPageApps() {
    	List<Appinfo> res = repository.findTop20ByOrderByScoreDesc();
    	return res;
    }
    
    @RequestMapping(value = "api/app/{appid}", method = RequestMethod.GET)
    public Appinfo detailPageApp(@PathVariable("appid") String appid) {
    	Appinfo res = repository.findByAppid(appid);
    	return res;
    }
    
    
    @RequestMapping(value = "api/apps/{applist}", method = RequestMethod.GET)
    public List<Appinfo> queryAppList(@PathVariable("applist") String applist) {
    	String[] arg = applist.split(",");
    	List<Appinfo> res = repository.findByAppidIn(arg);
    	return res;
    }
    
//    @RequestMapping(value = "/{appid}", method = RequestMethod.GET)
//    public String detailPageApp(@PathVariable("appid") String appid, ModelMap model) {
//    	Appinfo res = repository.findByAppid(appid);
//    	
////    	model.addAttribute("app", res);
//    	// Here it returns a jsp file in a string instead
//    	return "hahah";
//    }
    
}
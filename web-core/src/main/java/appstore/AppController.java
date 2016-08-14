package appstore;
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
class AppControllerRenderTemplates {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "singleapp";
    }
    
    @RequestMapping("/app/{id}")
    public String Detailedgreeting(@PathVariable("id") String id, ModelMap model) {
    	model.addAttribute("appid", id);
    	return "singleapp";
    }
    
    
}

@RestController
//@Controller
public class AppController {

	@Autowired
	private AppRepository repository;
    
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
    
}
package fx.leyu.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloReaderController {
    @RequestMapping(value = "hello")
    public ModelAndView sayHello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello world");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}

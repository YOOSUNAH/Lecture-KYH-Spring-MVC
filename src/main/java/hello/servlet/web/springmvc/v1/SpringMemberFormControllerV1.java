package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
     return new ModelAndView("new-form");
    }
}



/** @Controller
 * 스프링이 자동으로 스프링 빈으로 등록한다.
 * 스프링 MVC애노테이션 기반 컨트롤러로 인식한다.
 *
 *
 */
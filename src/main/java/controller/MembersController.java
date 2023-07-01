package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jsp/members")
public class MembersController {

    @RequestMapping(method = RequestMethod.GET)
    public String showMembersPage() {
        // TODO: Add your logic to handle the request and return the appropriate view name
        return "jsp/members";
    }
}

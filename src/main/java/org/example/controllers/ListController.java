package org.example.controllers;

import org.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.models.Message;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class ListController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndexPage() {
        //return "form.jsp";
        return "index";
    }

    @GetMapping(value = "/bye")
    public String getBy() {
        return "bye";
    }

    @RequestMapping(value = "/redirectToForm", method = RequestMethod.GET)
    public String redirectToFormMeth() {
        return "redirect:/formPage";
    }

    @RequestMapping(value = "/formPage", method = RequestMethod.GET)
    // public String getFormPage() {
    public ModelAndView getFormPage(ModelAndView modelAndView) {
        modelAndView.setViewName("form");
        modelAndView.addObject("messageNumb", messageService.getMessageList().size());
        Boolean sendingResult = false;
        modelAndView.addObject("sendingResult", sendingResult);
        return modelAndView;
    }

    @RequestMapping(value = "/formPage", method = RequestMethod.POST)
    public ModelAndView createMessage(@ModelAttribute("message") Message mess, ModelAndView modelAndView) {
        messageService.createMessage(mess);
        modelAndView.setViewName("form");
        modelAndView.addObject("messageNumb", messageService.getMessageList().size());
        Boolean sendingResult = true;
        modelAndView.addObject("sendingResult", sendingResult);
        return modelAndView;
    }

    @RequestMapping(value = "/redirectToList", method = RequestMethod.GET)
    public String redirectToListMeth() {
        return "redirect:/messageList";
    }

    @RequestMapping(value = "/messageList", method = RequestMethod.GET)
    public ModelAndView showMessageList(ModelAndView modelAndView) {
        modelAndView.setViewName("messageList");
        List<Message> messageList = messageService.getMessageList();
        modelAndView.addObject("messageList", messageList);
        return modelAndView;
    }

//    @RequestMapping(value="/createMessage",method=RequestMethod.GET) //createMessage
//    public String createMessage(@RequestParam("name") String userName,
//                                  @RequestParam("email") String email,
//                                  @RequestParam(required=false,name="subject") String subject,
//                                  @RequestParam(name="message") String messageText){
//        Message message = new Message(userName, email, subject, messageText);
//        messageService.createMessage(message);
//        return "redirect:/messageList";
//    }
}

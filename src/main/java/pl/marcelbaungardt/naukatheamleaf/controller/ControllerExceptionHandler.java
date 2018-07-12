package pl.marcelbaungardt.naukatheamleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.marcelbaungardt.naukatheamleaf.error.UserNotFoundExpection;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundExpection.class)
    public ModelAndView handleUserNotFound(Exception ex){

        ModelAndView modelAndView=new ModelAndView();

        log.error("Handlig User not fund exception");
        log.error(ex.getMessage());

        modelAndView.setViewName("error404");
        modelAndView.addObject("exception",ex);

        return modelAndView;
    }
}

package org.perscholas.springboot.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @RequestMapping(value = "/error/404")
    public String error404(HttpServletRequest request) {
        // This is used in the security config for 404 pages
        log.info("endpoint:/error/404 - Requested URL not found : " + request.getMethod());

        return "error/404";
    }
}

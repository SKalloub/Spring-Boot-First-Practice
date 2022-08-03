package com.example.springboot_practice.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@ControllerAdvice
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            if (ex instanceof IllegalArgumentException) {
                return handleIllegalArgument((IllegalArgumentException) ex,request, response, handler);
            }
            String accept = request.getHeader(HttpHeaders.ACCEPT);
            System.err.println(accept);
            System.out.println(ex.getMessage());
        }
        catch (Exception handlerException) {
            System.err.println((ex.getClass().getName()+" Resulting in "+handlerException));
        }
        return new ModelAndView();
    }

    private ModelAndView handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        response.sendError(HttpServletResponse.SC_CONFLICT);
        String accept = request.getHeader(HttpHeaders.ACCEPT);
        System.out.println("Illegal Argument Exception");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}

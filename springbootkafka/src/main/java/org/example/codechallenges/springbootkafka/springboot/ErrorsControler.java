package org.example.codechallenges.springbootkafka.springboot;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

@Controller
public class ErrorsControler implements ErrorController {
    private static final Logger LOG = LogManager.getFormatterLogger(ErrorsControler.class);

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = "/error", produces = "application/json")
    public @ResponseBody Map<String, Object> handleError(HttpServletRequest req, ErrorAttributeOptions options)
    {
        ServletWebRequest webRequest = new ServletWebRequest(req);
        Map<String, Object> error = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
        error.put("locale", webRequest.getLocale().toString());
        if(errorAttributes.getError(webRequest)!=null) {
            error.put("message", errorAttributes.getError(webRequest).toString());
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            errorAttributes.getError(webRequest).printStackTrace(printWriter);
            String stackTrace = stringWriter.toString();
            error.put("stacktrace", stackTrace);
        }

        LOG.error(error);

        return error;
    }

}

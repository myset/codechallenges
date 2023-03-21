package org.example.codechallenges.springbootkafka.springboot;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class HealthcheckController {
    private static final Logger LOG = LogManager.getFormatterLogger(HealthcheckController.class);

    @GetMapping(value = "/healthcheck",produces = "application/json")
    public String healthcheck(HttpServletResponse response) {
        // Debug headers
        response.setHeader("Custom-Header","custom-value");
        response.getHeaderNames().forEach((key) -> {
            LOG.info(String.format("Header '%s' = %s", key, response.getHeader(key)));
        });
        try {
            return String.format("{\"status\":\"%s\", \"currentTime\":\"%s\"}", "OK", ZonedDateTime.now(ZoneId.systemDefault()));
        }catch (Exception e) {
            LOG.error(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

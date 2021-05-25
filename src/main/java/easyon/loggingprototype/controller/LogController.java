package easyon.loggingprototype.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import easyon.loggingprototype.model.ErrorLog;
import easyon.loggingprototype.model.Log;
import easyon.loggingprototype.repository.LoggingRepository;

@RestController
public class LogController {
    private LoggingRepository loggingRepository;

    public LogController(LoggingRepository loggingRepository){
        this.loggingRepository = loggingRepository;
    }

    @PostMapping("/log")
    public ResponseEntity log(){
        Log log = new Log();
        log.setOrigin("LogController");
        log.setDescription("Some simple event log");
        log.setOrderNumber(1);
        this.loggingRepository.log(log );
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping("/error")
    public ResponseEntity error(){
        ErrorLog log = new ErrorLog();
        log.setOrigin("LogController");
        log.setDescription("An error occured");
        log.setOrderNumber(2);
        this.loggingRepository.log(log );
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @GetMapping("/log")
    public ResponseEntity<List<Log>> getLogs(){
        List<Log> logs = this.loggingRepository.getLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }
}

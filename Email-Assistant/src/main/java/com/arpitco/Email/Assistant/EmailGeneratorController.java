package com.arpitco.Email.Assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

// don't run it with terminal mvn spring-boot:run command, it gives error as unable to access .env file 
// go to "run and debug" to run it. I've added envFile config in .vscode -> launch.json file 

// @CrossOrigin(origins = "*")
@CrossOrigin(origins = { "http://localhost:5173/",
    "https://mail.google.com" })
@RequestMapping("/api/email")
@RestController
@AllArgsConstructor
public class EmailGeneratorController {

  // @Autowired //
  private final EmailGeneratorService emailGeneratorService;

  @PostMapping("/generate")
  public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
    String response = emailGeneratorService.generateEmailReply(emailRequest);
    return ResponseEntity.ok(response);
  }

}

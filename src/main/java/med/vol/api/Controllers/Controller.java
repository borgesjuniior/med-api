package med.vol.api.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("hello")
public class Controller {

  @GetMapping
  public String helloWorld() {
    return "Hello World!";
  };
}

package main.java;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@ComponentScan("main.java")
public class MyApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApplication.class, args);
	}
	
	
}

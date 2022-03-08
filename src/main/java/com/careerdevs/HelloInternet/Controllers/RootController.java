package com.careerdevs.HelloInternet.Controllers;
//A SpringBoot best practice is to store all the server route handlers (methods that handle incoming requests) inside ‘controller’ classes. And these classes should be stored inside of a ‘controllers’ package.


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RootController {

    @GetMapping("/")
    private String rootRoute() {
        return "You requested the root route";
    }

    @GetMapping("/random")
    private Integer randomNumber() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 50 + 1;
        int randomInt = (int) randomDouble;
        return randomInt;
    }

    @GetMapping("/joke")
    private String joke() {
        ArrayList<String> jokeArray = new ArrayList<String>();
        jokeArray.add("A man walks into a library and asks the librarian for books about paranoia. She whispers, \"They're right behind you!");
        jokeArray.add("Want to hear a roof joke? The first one's on the house.");
        jokeArray.add("What should you do if you're attacked by a group of clowns? Go straight for the juggler.");
        jokeArray.add("Why don't koalas count as bears? They don't have the right koalafications.");
        jokeArray.add("I saw a movie about how ships are put together. It was riveting.");
        int index = (int) (Math.random() * jokeArray.size());
        return jokeArray.get(index);
    }
//    @GetMapping
//    public  void test(@PathVariable("id") String id){
//        System.out.println("id" +id);
//    }
//    @PostMapping
//    public void test2(@RequestParam(value ="id",required = false,defaultValue  ="0")String id,@RequestParam(value="age")String age){
//        System.out.println("id"+id);
//        System.out.println("age"+age);
//    }

}

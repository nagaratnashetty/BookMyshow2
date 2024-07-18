package com.example.bookmyshow.Controllers;
import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Requests.AddMovieRequest;
import com.example.bookmyshow.Requests.UpdateMovieRequest;
import com.example.bookmyshow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController { 

    @Autowired
    private MovieService movieService;

    @PostMapping("add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest movieRequest){

        String response = movieService.addMovie(movieRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateMovieAttributes(@RequestBody UpdateMovieRequest updateMovieRequest){

        String response = movieService.updateMovieAttributes(updateMovieRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }





}

//@RestController is a convenience annotation that combines @Controller (to mark the class as a controller)
// and @ResponseBody (to indicate that the return value of controller methods should be serialized directly into
// the HTTP response body). This simplifies the creation of RESTful APIs in Spring applications.
//@RestController is used to annotate the MovieController class, indicating that it's a RESTful controller.
//@RequestMapping("movie") is used to specify that all endpoints in this controller are relative to the "/movie"
// base path. For example, GET /movie/1 would map to the getMovie method with ID 1.
//@GetMapping, @PostMapping, @PutMapping, and @DeleteMapping are used to map HTTP GET, POST, PUT, and DELETE
// requests, respectively, to specific methods in the controller.
//@PathVariable is used to extract variables from the request URL (e.g., the movie ID in @GetMapping("/{id}")).
//@RequestBody is used to deserialize the request body into a Java object (e.g., a Movie object in @PostMapping("/add")
// and @PutMapping("/{id}")).


//In this example, the @Autowired annotation is used to inject an instance of MovieService into the movieService field.
// Spring will automatically find a bean of type MovieService (assuming it's defined as a bean in your application
// context) and inject it into the movieService field when an instance of MovieController is created.

//This dependency injection approach simplifies the management of dependencies in your Spring application and promotes
// loose coupling between components. It allows you to easily swap implementations or mock dependencies for testing
// purposes.In this example, the @Autowired annotation is used to inject an instance of MovieService into the
// movieService field. Spring will automatically find a bean of type MovieService (assuming it's defined as a bean
// in your application context) and inject it into the movieService field when an instance of MovieController is
// created.
//This dependency injection approach simplifies the management of dependencies in your Spring application and promotes
// loose coupling between components. It allows you to easily swap implementations or mock dependencies for testing
// purposes.

//@PostMapping("add"): This annotation maps HTTP POST requests with the URL path "/add" to this method. It signifies
// that this endpoint is used for adding a new movie.


//public ResponseEntity addMovie(@RequestBody AddMovieRequest movieRequest): This method takes a AddMovieRequest
// object as its parameter, which is typically a class representing the data required to add a movie. The @RequestBody
// annotation tells Spring to deserialize the incoming HTTP request body into an instance of AddMovieRequest.

//String response = movieService.addMovie(movieRequest);: This line calls the addMovie method of the movieService
// instance (assuming movieService is a service class that handles movie-related operations). It passes
// the AddMovieRequest object to this method to add the movie to the system.

//return new ResponseEntity(response, HttpStatus.OK);: After adding the movie, the method creates a ResponseEntity
// object. This class is used to customize the HTTP response returned by the API endpoint. In this case, it returns
// the response string (which could be a success message or an error message) with an HTTP status code of 200 (OK).




//Using ResponseEntity in Spring MVC or Spring Boot provides several advantages and flexibility in handling HTTP
// responses in RESTful APIs. Here are some reasons why you might choose to use ResponseEntity:

//Customization of Response Body: With ResponseEntity, you can set the response body to any object you want.
// This allows you to return not just simple strings or objects but also more complex data structures, DTOs,
// or even files. This flexibility is crucial when designing APIs that need to return various types of data.

//Fine-grained Control over HTTP Status Codes: You can explicitly set the HTTP status code for the response
// using ResponseEntity. This is beneficial for conveying the status of the operation accurately. For example,
// returning HttpStatus.CREATED (201) for successful resource creation, HttpStatus.BAD_REQUEST (400) for client errors,
// or HttpStatus.INTERNAL_SERVER_ERROR (500) for server errors.
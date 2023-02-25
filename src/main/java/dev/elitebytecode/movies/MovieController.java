package dev.elitebytecode.movies;
//Step 3-1
// This class has RestController responsibilities (REST)
//  Role of this class is to get allmovies() from service class and return them
//  with in a list and status of okay and make them available for mappings

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
// will create and api route
@RequestMapping("/api/vi/movies/")

public class MovieController {

    // auto instantiates an instance
    @Autowired
    private MovieService movieService;

    @GetMapping
    //Testing Purposes 1
    //    public String allMovies(){
    //        return "All Movies";
    //    }
    //Testing Purposes 2
    //It's best to return a ResponseEntity<dataType>
    //    public ResponseEntity<String> getAllMovies(){
    //        return new ResponseEntity<String>("All movies", HttpStatus.OK);
    //    }

    //Step 3-3
    // Return all movies
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    // find a single movie by its id
    // Convert the path object into and id.
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }

//    @GetMapping("/{title}")
//    public ResponseEntity<Optional<Movie>> getSingleMovieByTitle(@PathVariable String title){
//        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByTitle(title), HttpStatus.OK);
//    }
}

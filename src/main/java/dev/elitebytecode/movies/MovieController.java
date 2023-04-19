package dev.elitebytecode.movies;
//Step 3-1
// This class has RestController responsibilities (REST)
//  Role of this class is to get allmovies() from service class and return them
//  with in a list and status of okay and make them available for mappings

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /**
     * List all movies
     * @return movie list
     */
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    // find a single movie by its id
    // Convert the path object into and id.
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbID(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbID(imdbId), HttpStatus.OK);
    }

    /**
     * Creates/Posts a new movie
     * @param movie
     * @return
     */
    @PostMapping("/add-movie")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.OK);

    }

    /**
     * Updates a movie document
     * @param movie
     * @return movie document updated
     */
    @PutMapping("updateMovie/{imdbId}")
    public ResponseEntity<Optional<Movie>> updateMovieByImdbId(@RequestBody Movie movie){
        return new ResponseEntity<Optional<Movie>>(movieService.updateMovieImdbId(movie), HttpStatus.OK);
    }

    /**
     * Deletes a movie from DB
     * @param _id // movie object id
     */
    @DeleteMapping("deleteMovie/{_id}")
    public void deleteMovieByImdbId(@PathVariable ObjectId _id){
        movieService.deleteMovieByImdbId(_id);
    }

}

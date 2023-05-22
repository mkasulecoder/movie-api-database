package dev.elitebytecode.movies;
//Step 3-1
// This class has RestController responsibilities (REST)
//  Role of this class is to get allmovies() from service class and return them
//  with in a list and status of okay and make them available for mappings

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// will create and api route
@RequestMapping("/api/v1/movies/")
@CrossOrigin

public class MovieController {

    // auto instantiates an instance
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    // find a single movie by its id
    // Convert the path object into and id.
    @GetMapping("find-movie/{_id}")
    public ResponseEntity<Optional<Movie>> getMovieByID(@PathVariable ObjectId _id){
        return new ResponseEntity<Optional<Movie>>(movieService.findSingleMovieByID(_id), HttpStatus.OK);
    }

    // find a single movie by its title
    // Convert the path object into and id.
    @GetMapping("find-movie-title/{title}")
    public ResponseEntity<Optional<Movie>> getMovieByTitle(@PathVariable String title){
        return new ResponseEntity<Optional<Movie>>(movieService.findSingleMovieByTitle(title), HttpStatus.OK);
    }

    /**
     * Creates/Posts a new movie
     * @param movie
     * @return
     */
    @PostMapping("/add-movie")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.CREATED);

    }

    /**
     * Updates a movie document
     * @param movie
     * @return movie document updated
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("updateMovie/{_id}")
    public void updateMovieById(@PathVariable ObjectId _id, @RequestBody Movie movie){
       movieService.updateSingleMovieById(_id, movie);
    }

    /**
     * Deletes a movie from DB
     * @param _id // movie object id
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("delete-movie/{_id}")
    public void deleteMovieByImdbId(@PathVariable ObjectId _id){
        movieService.deleteSingleMovieByImdbId(_id);
    }

}

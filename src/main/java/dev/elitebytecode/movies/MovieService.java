package dev.elitebytecode.movies;
//Step 4

//Here is where the business logic is placed
// Uses the movie-repo to access movies from the mongo-repo database using repo methods.

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Show that this is a service
@Service
public class MovieService {
    @Autowired // auto instantiates
    private MovieRepository movieRepository;

    //Get or return all movies
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    //Return single movie by id
    // Use Optional to tell java to return null if id is not matching db
    public Optional<Movie> findSingleMovieByID(Object id){
        return movieRepository.findById((ObjectId) id);
    }

   // Return single movie by Title
    public Optional<Movie> findSingleMovieByTitle(String title){
        return movieRepository.findMovieByTitle(title);
    }

    // Add new movie
    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    // Update movies with save repo method
    public Optional<Movie> updateSingleMovieById(ObjectId id, Movie movie){
        return Optional.of(movieRepository.insert(movie));
    }

    // Delete movie by Id
    public void deleteSingleMovieByImdbId(Object id){
        movieRepository.deleteById((ObjectId) id);
    }

}

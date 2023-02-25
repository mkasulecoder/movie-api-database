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

    //Return all movies
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    //Return single movie by id
    // Use Optional to tell java to return null if id is not matching db
    public Optional<Movie> singleMovie(ObjectId id){
        return movieRepository.findById(id);
    }

   //Return single movie by imdbId based on the custom method made in repo
    public Optional<Movie> singleMovieByTitle(String title){
        return movieRepository.findMovieByTitle(title);
    }
}

package dev.elitebytecode.movies;
//Step 3-2

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Data access layer for API
//lets framework know that this is a repository, and
// it will pull available data from mongodb-db repository plus all it's methods
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>  {

    //Find movie by particular value from db e.g. imdbId
    // This is a custom method we can use get movies by imdb and keep object ids private
    Optional<Movie> findMovieByTitle(String title);

//    Optional<Movie> singleMovieByImdbID(String id);

}

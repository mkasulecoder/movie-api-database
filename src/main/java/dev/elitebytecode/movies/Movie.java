package dev.elitebytecode.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// Tells framework that this class represents each movie in the collection under the db
@Document(collection= "movies")
//Declares all setters and getters
@Data
//Declares constructor with arguments
@AllArgsConstructor
// Declares a no-arg constructor
@NoArgsConstructor
public class Movie {

    @Id // tells the object id to be treated as a unique identifier
    private ObjectId _id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private List<String> genres;
    private String poster;
    private List<String> backdrops;

    // Use the document-reference from mongodb to
    // Create a separate relational collection/table of reviews within the movie-api-db database
    // this creates a relationship between the movie object and review object
    @DocumentReference
    private List<Review> reviewsIds;

}

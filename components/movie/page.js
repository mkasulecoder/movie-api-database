import { useEffect, useState } from "react";
import Image from "next/image";

function AllMovies() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/movies/")
      .then((response) => response.json())
      .then((result) => setMovies(result));
  }, []);

  console.log(movies);

  return (
    <div>
      <div>
        {/* Movies */}
        <div className='container movie-section text-white w-100 my-3 w-100'>
          {movies.map((movie) => (
            <div key={movie.imdbId} className='movie m-2'>
              <div>
                {/* <Image
                  src='{movie.poster}'
                  fill={true}
                  alt='`{movie.title}` Image'
                /> */}
                <img src={movie.poster} alt='`{movie.title}`  Image' />
              </div>
              <div className='movie-info'>
                <h3>{movie.title}</h3>
                <a href={movie.poster} target='_blank'>
                  Poster
                </a>
              </div>
              <div class='overview'>
                <h4>{movie.title} </h4>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default AllMovies;

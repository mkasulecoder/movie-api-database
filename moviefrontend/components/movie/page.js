import { useEffect, useState } from "react";

function AllMovies() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/movies")
      .then((response) => response.json())
      .then((result) => setMovies(result.title));
  }, []);

  return (
    <div>
      {/* <ul>{listMovies}</ul> */}
      {movies.map((movie) => {
        <li key={movie.id}>{movie.title}</li>;
      })}
    </div>
  );
}

export default AllMovies;

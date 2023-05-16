import { useEffect, useState } from "react";
import Modal from "react-modal";
import ReactPlayer from "react-player";

function AllMovies() {
  const [movies, setMovies] = useState([]);
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [selectedMovie, setSelectedMovie] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/movies/")
      .then((response) => response.json())
      .then((result) => setMovies(result));
  }, []);

  const handleWatchNowClick = (movie) => {
    setSelectedMovie(movie);
    setModalIsOpen(true);
  };

  const closeModal = () => {
    setModalIsOpen(false);
    setSelectedMovie(null);
  };

  return (
    <div>
      {/* Movies */}
      <div className='container movie-section text-white w-100 my-3 w-100'>
        {movies.map((movie) => (
          <div key={movie.id} className='movie m-2'>
            <div>
              <img src={movie.poster} alt='`{movie.title}`  Image' />
            </div>
            <div className='movie-info'>
              <div className=''>
                <h3 className='fw-bold'>{movie.title}</h3>
              </div>
              <div className='d-flex flex-column justify-content-start align-items-start gap-1'>
                <span className='orange fw-bold'>{movie.genres[0]}</span>
                <span className='green'>Released {movie.releaseDate}</span>
              </div>
            </div>
            <div class='overview w-100'>
              <h4>{movie.title}</h4>
              <div class='mb-2'>
                {movie.genres.map((genre) => (
                  <span key={genre.id} className='mr-3 green'>
                    {genre}
                    {"  "}
                  </span>
                ))}
              </div>
              <div className='d-flex flex-row align-items-center justify-content-center'>
                <button
                  className='btn btn-warning w-100 fw-bold'
                  onClick={() => handleWatchNowClick(movie)}
                >
                  Watch Now
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* Modal */}
      <Modal
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
        contentLabel='Video Modal'
        style={{
          overlay: {
            backgroundColor: "rgba(0, 0, 0, 0.5)",
          },
          content: {
            width: "850px",
            height: "85vh",
            margin: "auto", // Center the modal horizontally
            padding: "0px",
            border: "none",
          },
        }}
      >
        {selectedMovie && (
          <div>
            <ReactPlayer
              url={selectedMovie.trailerLink}
              width='100wh'
              height='85vh'
              controls={true}
              playing={true}
              className='bg-dark overflow-hidden'
            />
          </div>
        )}
      </Modal>
    </div>
  );
}

export default AllMovies;

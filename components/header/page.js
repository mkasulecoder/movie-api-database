import React, { useState, useEffect } from "react";

function Header() {
  const [searchMovie, setSearchMovie] = useState(null);

  const handleOnSearch = (e) => {
    setSearchMovie(e.target.value);
  };

  const handleOnSubmit = (e) => {
    e.preventDefault();
    // console.log(searchMovie);
    //call the search by title api
    fetch(`http://localhost:8080/api/v1/movies/find-movie-title/${searchMovie}`)
      .then((response) => response.json())
      .then((foundMovie) => {
        // search and filter if foundMovie contains any searchMovie words
        console.log(foundMovie.title + " movie was found");
        // split searchMovie text into words
      });
  };
  return (
    <div className='w-100'>
      <header className='d-flex flex-row justify-content-between align-items-center w-100'>
        <h1 className='fw-bold'>MovieMingle</h1>
        <form id='form' onSubmit={handleOnSubmit}>
          <input
            type='text'
            id='search'
            className='search'
            placeholder='Search'
            onChange={handleOnSearch}
          />
        </form>
      </header>
    </div>
  );
}

export default Header;

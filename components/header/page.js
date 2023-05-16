import React from "react";

function Header() {
  return (
    <div className='w-100'>
      <header className='d-flex flex-row justify-content-between align-items-center w-100'>
        <h1>All Movies</h1>
        <form id='form'>
          <input type='text' id='search' class='search' placeholder='Search' />
        </form>
      </header>
    </div>
  );
}

export default Header;

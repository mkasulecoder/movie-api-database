"use client";
import Image from "next/image";
import AllMovies from "../../components/movie/page";
import Header from "../../components/header/page";

export default function Home() {
  return (
    <main className='d-flex flex-column align-items-center justify-content-center w-100'>
      <Header />
      <AllMovies />
    </main>
  );
}

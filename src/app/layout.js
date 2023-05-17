import "bootstrap/dist/css/bootstrap.min.css";
import "./globals.css";

export const metadata = {
  title: "MovieMingle | Find your cinematic soulmate!",
  description:
    "Find your cinematic soulmate! Our app intelligently matches movies and TV shows based on your preferences, ensuring you never miss out on the perfect watch. Explore new favorites and enjoy a tailored movie experience like never before.",
};

export default function RootLayout({ children }) {
  return (
    <html lang='en'>
      <body>{children}</body>
    </html>
  );
}

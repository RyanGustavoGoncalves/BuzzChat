import React from 'react';

import Container from './components/layout/Container';
import Navbar from './components/layout/Navbar';
import Footer from './components/layout/Footer';

function App({ children }) {
  return (
    <>
      <Navbar />
      <Container customClass="min-height">
        {children}
      </Container>
      <Footer />
    </>
  );
}

export default App;

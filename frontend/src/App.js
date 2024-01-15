import React from 'react';

import Container from './components/layout/Container';
import Navbar from './components/layout/Navbar';
import Footer from './components/layout/Footer';
import Aside from './components/layout/Aside';
import Main from './components/layout/Main'

function App({ children }) {
  return (
    <>
      <Navbar />
      <Aside/>
      <Main/>
      <Container customClass="min-height">
        {children}
      </Container>
      <Footer />
    </>
  );
}

export default App;

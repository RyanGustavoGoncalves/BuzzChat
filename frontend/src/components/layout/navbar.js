import { Link } from 'react-router-dom';
import Container from './Container';
import styles from './Navbar.module.css';
import logo from '../img/logo-bc.png';
import { VscSearch } from "react-icons/vsc";

function Navbar() {
    return (
        <nav class={styles.navbar}>
            <Container>
                <Link to='/'><img src={logo} alt='Bird' class={styles.img} /></Link>
                <input type="search" placeholder="Pesquisar" className={styles.searchInput}/>
                    <button type="button" className={styles.searchButton}><VscSearch /></button>
            </Container>   
        </nav>
    );
};

export default Navbar; 
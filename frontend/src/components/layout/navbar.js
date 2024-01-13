import { Link } from 'react-router-dom';
import Container from './Container';
import styles from './navbar.module.css'
import logo from '../img/logo-bc.png'

function Navbar() {
    return (
        <nav class={styles.navbar}>
            <Container>
                <Link to='/'><img src={logo} alt='Bird' class={styles.img} /></Link>
                <ul class={styles.list}>
                    <li class={styles.item}><Link to='/'>Home</Link></li>
                    <li class={styles.item}><Link to='/Account'>Account</Link></li>
                    <li class={styles.item}><Link to='/Register'>Sign Up</Link></li>
                    <li class={styles.item}><Link to='/Signin'>Sign In</Link></li>
                </ul>
            </Container>
        </nav>
    );
};

export default Navbar; 
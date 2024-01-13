import Container from './container';
import styles from './footer.module.css'
import {FaInstagram, FaLinkedin} from 'react-icons/fa'


function Footer(){
    return(
        <footer class={styles.footer}>
            <ul>
                <li> <FaInstagram/></li>
                <li> <FaInstagram/></li>
                <li> <FaLinkedin/></li>
                <li> <FaLinkedin/></li>
            </ul>
            <p>
                <span>BuzzChat</span>&copy; 2024
            </p>
        </footer>
    );
};

export default Footer;
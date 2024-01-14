import styles from './Footer.module.css'
import {FaInstagram, FaLinkedin} from 'react-icons/fa'


function Footer(){
    return(
        <footer className={styles.footer}>
            <ul className={styles.social_list}>
                <li className={styles.social_list}> <FaInstagram/></li>
                <li className={styles.social_list}> <FaInstagram/></li>
                <li className={styles.social_list}> <FaLinkedin/></li>
                <li className={styles.social_list}> <FaLinkedin/></li>
            </ul>
            <p className={styles.copy_right}>
                &copy; <span>BuzzChat</span> 2024
            </p>
        </footer>
    );
};

export default Footer;
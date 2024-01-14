import React from 'react';
import { Link } from 'react-router-dom';
import Container from './Container';
import styles from '../layout/Aside.module.css'
import { VscHome, VscAccount, VscPersonAdd, VscPerson } from "react-icons/vsc";

function Aside(){
    return(
        <>
            <aside className={styles.aside}>
                <Container>
                    <ul class={styles.list}>
                        <li className={styles.item}><Link to='/'> <VscHome /> Home</Link></li>
                        <li className={styles.item}><Link to='/Account'> <VscAccount /> Account</Link></li>
                        <li className={styles.item}><Link to='/Register'> <VscPersonAdd /> Sign Up</Link></li>
                        <li className={styles.item}><Link to='/Signin'> <VscPerson /> Sign In</Link></li>
                    </ul>
                </Container>
            </aside>
        </>
    );
};

export default Aside;
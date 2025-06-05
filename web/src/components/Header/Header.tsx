import styles from './Header.module.css';
import pandaLogo from './panda_with_cord.jpg';

function Header() {
    return (
        <>
            <div className={styles.headerShop}>
                <img src={pandaLogo} alt="panda logo" />
                <h1>Sellink</h1>
            </div>
        </>
    );
}

export default Header;
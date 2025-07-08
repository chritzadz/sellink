import SearchBar from '../SearchBar';
import pandaLogo from './panda_with_cord.jpg';
import { FaShoppingCart } from "react-icons/fa";
import { MdOutlineLanguage } from "react-icons/md";
import { HiMiniBars3 } from "react-icons/hi2";





function Header() {
    return (
        <>
            <div className="shadow-sm max-w-full h-15 flex items-center overflow-hidden border-b border-gray-300">
                <h1 className="m-0 text-3xl w-2/10 h-10 pl-12">Sellink</h1>
                <div className="w-6/10 h-10 items-center flex justify-center">
                    <div className="w-2/3">
                        <SearchBar/>
                    </div>
                </div>
                <div className='w-2/10 content-end flex h-10 gap-3 justify-end pr-12'>
                    <div className="w-10 h-10 items-center flex justify-center">
                        <FaShoppingCart className='w-5 h-5'/>
                    </div>
                    <div className="w-10 h-10 items-center flex justify-center">
                        <MdOutlineLanguage className="w-6 h-6"/>
                    </div>
                    <div className="w-10 h-10 items-center flex justify-center">
                        <HiMiniBars3 className="w-6 h-6"/>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Header;
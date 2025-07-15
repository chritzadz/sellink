import { FaSearch } from "react-icons/fa";

function SearchBar() {
    return (
        <div className="bg-off-off-white flex rounded-2xl h-8 w-full items-center border-2 border-black-custom">
            <div className='w-1/5 h-full flex items-center justify-center border-r border-black-custom'>
                <FaSearch className=""/>
            </div>
            <div className="w-4/5 flex items-center px-2 h-full border-l border-black-custom">
                <input type="text" placeholder="Search here..." className="w-full" />
            </div>

        </div>
    );
}

export default SearchBar;
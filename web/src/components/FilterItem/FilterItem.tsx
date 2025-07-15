import type { List } from "postcss/lib/list";
import Category from "../../model/Category"

interface FilterItemProps {
    categoryName: String;
    onClick: (name: String) => void;
}

function FilterItem({categoryName, onClick}: FilterItemProps) {
    return(
        <>
            <div onClick={() => onClick(categoryName)} className="bg-light-green-custom flex items-center justify-center round rounded-3xl border border-black">
                <p className="mx-3 my-2 text-xs font-bold">{categoryName}</p>
            </div>
        </>
    )
}

export default FilterItem;
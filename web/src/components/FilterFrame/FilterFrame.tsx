import type { List } from "postcss/lib/list";
import Category from "../../model/Category"
import FilterItem from "../FilterItem"

interface FilterFrameProps {
    categories: Category[];
    onCategoryClick: (categoryName: string) => void;
}

function FilterFrame({categories, onCategoryClick}: FilterFrameProps) {
    return(
        <>
            <div className="w-1/2 flex items-center flex-row h-15 mx-5 gap-3 overflow-hidden">
                {categories.map((category, index) => (
                        <FilterItem categoryName={category.name} onClick={() => onCategoryClick(category.name)}/>
                ))}
            </div>
        </>
    )
}

export default FilterFrame;
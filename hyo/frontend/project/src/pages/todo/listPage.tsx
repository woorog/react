import { useSearchParams } from "react-router";

function ListPage() {
    
        const [queryParams] = useSearchParams();
        
        const page: string | null = queryParams.get("page");
        const size: string | null = queryParams.get("size");
        
        console.log("Page:", page);
        console.log("Size:", size);
        console.log("Query Params:", queryParams.toString());

    return(



        <div className="bg-white w-full">
            <div className="text-4xl">Todo List Page {page} {size} </div>
        </div>
    );
}

export default ListPage;
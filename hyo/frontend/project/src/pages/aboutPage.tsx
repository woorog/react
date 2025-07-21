import { NavLink } from "react-router";

function AboutPage() {
    return ( 
        <div className="text-3xl">
            <div className="flex">
                <NavLink to="/">Main</NavLink>
            </div>
            <h1>About Page</h1>
        </div>
     );
}

export default AboutPage;
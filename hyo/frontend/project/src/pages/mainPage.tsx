//tsx 와 ts
//tsx는 리액트 컴포넌트를 작성할 때 사용하고, ts는 일반적인 타입스크립트 파일입니다.

import { NavLink } from "react-router";

function MainPage() {
    return ( 
        <div className="text-3xl">
            <div className="flex">
                <NavLink to="/about">About</NavLink>
            </div>
            <div> Main Page</div>
        </div>
     );
}

export default MainPage;

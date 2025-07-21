import { createBrowserRouter } from "react-router";


import { lazy, Suspense } from "react";
import BasicLayout from "../layouts/basicLayout";
import todoRouter from "./todoRouter";
const Loading = () => <div>Loading...</div>;

const Main = lazy(() => import("../pages/mainPage"));
const About = lazy(()=> import("../pages/aboutPage"));


const router = createBrowserRouter([
  {
    path: "",
    Component: BasicLayout,//- 컴포넌트 대문자 이후에 문제야기
    children:[
      {index:true,
        element: <Suspense fallback={<Loading />}> <Main/> </Suspense>,
      },
      {
        path: "about",
        element: <Suspense fallback={<Loading />}><About /></Suspense>
      },
      todoRouter()     
    ]
    
  },
]);

export default router;
import { createBrowserRouter } from "react-router";


// 로딩 컴포넌트
import { lazy, Suspense } from "react";
const Loading = () => <div>Loading...</div>;

// lazy?
// 전부다 로딩하면 느림 => 호출전까지 부르지 않게 설정
const Main = lazy(() => import("../pages/mainPage"));
const About = lazy(()=> import("../pages/aboutPage"));


const MainPage = lazy(() => import("../pages/mainPage"));

// suspense = 불러오는 동안 무엇을 할건지 정할 수 잇음
const router = createBrowserRouter([
  {
    path: "",
    // 메인 페이지 호출 시 로딩하다가 MainPage를 불러옴
    element: <Suspense fallback={<Loading />}> <Main/> </Suspense>,
  },
// 새로고침이 무섭다?
// 기존 페이지 main에서 about으로 옴 -> 새로고침하면 main이 네트워크에서 없어짐
  {
    path: "about",
    element: (<Suspense fallback={<Loading />}><About /></Suspense>),
  },
])

export default router;
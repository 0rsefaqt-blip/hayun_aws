import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Posts from './Posts';
import PostDetail from './PostDetail';

function App() {
  return (
    <BrowserRouter>
      <nav style={{ padding: '10px', borderBottom: '1px solid #ccc' }}>
        <Link to="/posts">게시글 목록</Link>
      </nav>

      <Routes>
        <Route path="/posts" element={<Posts />} />
        <Route path="/post/detail/:id" element={<PostDetail />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
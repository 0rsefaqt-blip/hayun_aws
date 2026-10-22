import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

async function getPosts(setPosts) {
  try {
    const response = await fetch("/api/posts");
    if (!response.ok) return;
    const result = await response.json();
    setPosts(result.content);
  } catch (e) {
    console.error(e);
  }
}

function Posts() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    getPosts(setPosts);
  }, []);

  return (
    <div>
      <h1>게시글 목록</h1>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          {posts.length === 0 ? (
            <tr>
              <td colSpan={3}>등록된 게시글이 없습니다.</td>
            </tr>
          ) : (
            posts.map((post) => (
              <tr key={post.id}>
                <td>{post.id}</td>
                <td>
                  <Link to={"/post/detail/" + post.id}>{post.title}</Link>
                </td>
                <td>{post.createdAt}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default Posts;
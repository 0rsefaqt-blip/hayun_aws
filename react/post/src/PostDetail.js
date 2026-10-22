import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

async function getPost(id, setPost) {
  try {
    const response = await fetch("/api/posts/" + id);
    if (!response.ok) return;
    const result = await response.json();
    setPost(result);
  } catch (e) {
    console.error(e);
  }
}

function PostDetail() {
  const { id } = useParams();
  const [post, setPost] = useState({});

  useEffect(() => {
    getPost(id, setPost);
  }, [id]);

  return (
    <div>
      <h1>{post.title}</h1>
      <p>번호 : {post.id} / 작성일 : {post.createdAt}</p>
      <p>{post.content}</p>
    </div>
  );
}

export default PostDetail;
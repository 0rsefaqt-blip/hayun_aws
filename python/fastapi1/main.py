# main.py
from fastapi import FastAPI, Query

app = FastAPI(title="AI Server")

# 기본 설명
@app.get("/")
def health() -> dict:
    return {"status": "ok"}

# 스프링의 @PathVariable 처리를 fastAI에서는 어떻게 하는지
@app.get("/users/{user_id}")
def get_user(user_id:int) -> dict:
    
    return { "userId" : user_id }

# url에 ?변수1=값&변수2=값 형태로 오는 경우
@app.get("/search")
def search(q:str, page:int = 1, keyword:str | None = None) -> dict:

		return {"query" : q, "page" : page, "keyword" : keyword}

@app.get("/products")
def list_products(
		#인자 값을 검사. ge: 크거나 같다, le: 작거나 같다
    page: int = Query(default=1, ge=1),
    size: int = Query(default=10, ge=1, le=100),
) -> dict:
    return {"page": page, "size": size}

class UserResponse(BaseModel):
    id: int
    email: str
    name: str

@app.get("/users2/{user_id}", response_model=UserResponse, status_code=201)
def get_user2(user_id:int) -> dict:
    
    return { "id":1, "email":"xxx@naver.com", "name":"홍길동", "phone":"011-1111-1111" }
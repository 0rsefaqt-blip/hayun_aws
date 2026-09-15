

export function Diary(){

  const [data, setData] = useState({ diary_date:'', title : '', content:'', is_public:'', feel:'',})

  return(
    <form>
        {/* 일기 날짜 */}
        <div>
          <label>날짜</label>
          <input type="date" name="diary_date" />
        </div>

        {/* 제목 */}
        <div>
          <label>제목</label>
          <input type="text" name="title" placeholder="제목을 입력하세요" />
        </div>

        {/* 내용 */}
        <div>
          <label>내용</label>
          <textarea name="content" placeholder="오늘의 이야기를 적어보세요"></textarea>
        </div>

        {/* 이미지 링크 첨부 */} 
        <input
          type="file"
          name="image"
          accept="image/*"
        />

        {/* 공개 여부 */}
        <div>
          <label>공개 여부</label>
          <input type="checkbox" name="is_public" />
          공개
        </div>
        <div>
          <select name="" id="feel">내 상태</select>
        </div>

        <button type="submit">작성하기</button>
      </form>
    
  );
}
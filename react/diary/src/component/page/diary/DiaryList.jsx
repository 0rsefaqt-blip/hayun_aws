import { useState } from "react";
import { Container, Tabs, Tab } from "react-bootstrap";


export function DiaryList() {
   
   const [activeTab, setActiveTab] = useState("mine");

   return (
      <Container className="py-4" style={{ maxWidth: "700px" }}>
         <h1 className="mb-4 fs-3">일기 목록</h1>

         <Tabs
            activeKey={activeTab}
            onSelect={(key) => setActiveTab(key)}
            className="mb-3"
            justify
         >
            <Tab eventKey="mine" title="내 일기" />
            <Tab eventKey="public" title="공개 일기" />
         </Tabs>

				{
					activeTab === 'mine' ? <MyDiaries /> : <PublicDiaries/>
				}
      </Container>
	);
}

function MyDiaries() {
	return(
		<div>
			<h1>내 일기</h1>
		</div>
	)
}

function PublicDiaries() {
	return(
		<div>
			<h1>공개 일기</h1>
		</div>
	)
}


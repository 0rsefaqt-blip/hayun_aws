import { useState } from 'react';

export default function Signup() {
  // 폼 입력값
  const [data, setData] = useState({
    email: '',
    password: '',
    passwordConfirm: '',
    nickname: '',
    birthDate: '',
  });

  // 이메일 인증 상태: 'idle' | 'sent' | 'verified'
  const [verifyStatus, setVerifyStatus] = useState('idle');
  const [code, setCode] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setData((prev) => ({ ...prev, [name]: value }));
  };

  // FR-02: 인증번호 발송
  const handleSendCode = async () => {
    // TODO: 컨트롤러 연동 - POST /api/auth/email-code { email: data.email, purpose: 'SIGNUP' }
    setVerifyStatus('sent');
  };

  // FR-03: 인증번호 확인
  const handleVerifyCode = async () => {
    // TODO: 컨트롤러 연동 - POST /api/auth/email-code/verify { email: data.email, code }
    setVerifyStatus('verified');
  };

  // FR-01: 회원가입
  const handleSubmit = async (e) => {
    e.preventDefault();
    // TODO: 컨트롤러 연동 - POST /api/members { ...data }
    console.log('signup payload', data);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>이메일</label>
        <input
          name="email"
          type="email"
          value={data.email}
          onChange={handleChange}
          disabled={verifyStatus === 'verified'}
        />
        <button type="button" onClick={handleSendCode} disabled={verifyStatus === 'verified'}>
          인증번호 발송
        </button>
      </div>

      {verifyStatus === 'sent' && (
        <div>
          <label>인증번호</label>
          <input value={code} onChange={(e) => setCode(e.target.value)} />
          <button type="button" onClick={handleVerifyCode}>
            확인
          </button>
        </div>
      )}

      {verifyStatus === 'verified' && <p>이메일 인증 완료</p>}

      <div>
        <label>비밀번호</label>
        <input name="password" type="password" value={data.password} onChange={handleChange} />
      </div>

      <div>
        <label>비밀번호 확인</label>
        <input
          name="passwordConfirm"
          type="password"
          value={data.passwordConfirm}
          onChange={handleChange}
        />
      </div>

      <div>
        <label>닉네임</label>
        <input name="nickname" value={data.nickname} onChange={handleChange} />
      </div>

      <div>
        <label>생년월일</label>
        <input name="birthDate" type="date" value={data.birthDate} onChange={handleChange} />
      </div>

      <button type="submit">가입하기</button>
    </form>
  );
}

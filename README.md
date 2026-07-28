# 🌟 Albaone (알바원) - 종합 아르바이트 관리 플랫폼

## 📖 프로젝트 소개
**Albaone**은 단순한 구인구직을 넘어, 채용 후 근태 관리, 전자 근로계약, 급여 및 퇴직금 계산까지 아르바이트의 모든 사이클을 통합 관리할 수 있는 웹 플랫폼입니다.

## 🛠 기술 스택
- **Backend:** Java, Spring MVC, Maven
- **Frontend:** JSP, HTML/CSS, JavaScript
- **Database:** RDBMS (SQL 스크립트 기반)
- **Architecture:** Layered Architecture (Controller - Service - Repository - Domain)

## ✨ 주요 기능
1. **👤 회원 관리 (User)**
   - 개인 회원(알바생)과 기업 회원(고용주) 분리 가입 및 관리
2. **📋 구인구직 (Job & Resume)**
   - 고용주의 채용 공고(Job Post) 작성 및 관리
   - 알바생의 이력서(Resume) 등록 및 입사 지원(Apply)
3. **📝 전자 근로계약 (Employment Contract)**
   - 웹 기반 근로계약서 작성, 조회 및 양식 다운로드 지원
4. **⏰ 스마트 근태 관리 (Attendance)**
   - QR 코드를 활용한 빠르고 정확한 출퇴근 기록
5. **💰 급여 및 퇴직금 정산 (Salary & Severance)**
   - 근태 기록 기반 급여 계산 및 퇴직금 정산 기능
6. **⭐ 평가 및 리뷰 (Review & Rate)**
   - 알바생-고용주 간의 상호 리뷰 및 평가 시스템
7. **📱 SMS 알림 (SMS)**
   - 합격 통보 및 중요 안내 SMS 발송

## 📁 프로젝트 구조
```text
albaone/
├── src/main/java/com/springmvc/
│   ├── controller/      # 웹 요청 처리 및 뷰 매핑
│   ├── service/         # 핵심 비즈니스 로직
│   ├── repository/      # DB 데이터 접근 (DAO)
│   ├── domain/          # 데이터 모델 (DTO)
│   └── exception/       # 전역 에러 핸들링
├── src/main/webapp/WEB-INF/
│   ├── views/           # 사용자 UI (JSP 화면)
│   ├── resources/       # 정적 자원 (CSS, JS, Image, DB SQL)
│   └── spring/          # 스프링 프레임워크 설정 파일
└── pom.xml              # Maven 라이브러리 의존성 관리
```

## 🚀 환경 세팅 및 실행
1. 프로젝트 저장소를 클론합니다.
2. `src/main/webapp/WEB-INF/resources/sql/` 내의 SQL 스크립트를 사용하여 데이터베이스 스키마와 초기 데이터를 구성합니다.
3. IDE(Eclipse, IntelliJ 등)에서 Maven 프로젝트로 Import하여 의존성을 설치합니다.
4. Tomcat 등 WAS를 설정하고 프로젝트를 배포하여 웹 서버를 실행합니다.

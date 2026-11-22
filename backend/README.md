# 백엔드

음성 수신, 요청 상태, 예문·기록과 삭제 처리를 담당합니다.

기술 스택과 첫 구현 범위는 팀에서 결정합니다. 현재는 준비 폴더입니다.

## 기본 설정

#### build.gradle
1. JDK 버전 : 21
2. 스프링 버전 : 4.1.2

#### application.properties
1. DB 비밀번호가 입력되기 때문에 application.properties에서 ~~.properties 설정 파일을 import하는 식으로 분리해서 작업합니다.
2. commit할 때는 ~~.properties 설정 파일은 제외하고 commit을 합니다.
3. 설정을 어떻게 할 지는 중요한 정보를 제외한 예시 파일을 통해 공유합니다. (현재 application-secret-example.properties 를 템플릿으로 올려놨습니다!)

#### DB
PostgreSQL을 사용하며, 각자 설치하고 루트 계정 설정 후, 해당 계정 비밀번호를 ~~.properties 설정 파일에 입력해서 스프링과 DB를 연결해서 사용합니다.

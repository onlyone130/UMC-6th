- OAuth2 방식
    - OAuth2란 무엇일까요? 
     사용자가 자신의 자격 증명을 제3자 애플리케이션에 제공하지 않고, 애플리케이션이 사용자의 권한을 위임받아 보호된 자원에 접근할 수 있도록 하는 표준 인증 프로토콜이다.
    - 우리 주변에서 OAuth2 방식이 주로 사용되는 곳은 어디일까요? (Hint: 간편 로그인)
      간편 로그인이라고도 불리는 소셜 로그인에 사용된다. Google, Twitter 와 같은 소셜 네트워크 서비스에 로그인할 때 많이 사용된다.
    - 토큰이란 무엇일까요?
     특정한 권한을 가진 인증 정보로, 사용자가 인증을 완료한 후에 애플리케이션이 사용자를 대신하여 자원에 접근할 수 있도록 해준다.
    - OAuth2에서 사용되는 토큰은 어떤 것이 있고, 각각 어떤 용도일까요?
        1. Access Token (액세스 토큰)
            - 사용자가 자원 서버에 접근할 때 필요한 토큰으로, 특정 기간 동안 유효하며 주로 API 호출에 사용된다.
        2. Refresh Token (리프레시 토큰)
            - 액세스 토큰이 만료되었을 때, 새로운 액세스 토큰을 발급받기 위해 사용하는 토큰이다. 리프레시 토큰은 보통 액세스 토큰보다 긴 수명을 가진다.
    - OAuth2 방식의 장점과 단점은 무엇일까요?
        - 장점
        1. 사용자 자격 증명을 직접 공유하지 않아도 되기 때문에 보안성이 높다.
        2. 다양한 클라이언트 애플리케이션이 표준화된 방식으로 자원에 접근할 수 있다.
        - 단점 
        1. 구현이 복잡할 수 있으며, 잘못된 구현은 보안 취약점을 초래할 수 있다.
        2. 토큰 탈취 등의 보안 이슈가 발생할 수 있다.
- Cookie와 Session
    - Cookie란 무엇일까요?
        - 웹 서버가 사용자를 기억하고 식별하기 위해 브라우저에 저장하는 데이터이다. 
        http에서 클라이언트의 상태 정보를 클라이언트의 pc에 저장하였다가 필요할 때 정보를 참조하거나 재사용할 수 있다.
        - 특징
            1. 이름, 값, 만료일(저장 기간 설정), 경로 정보로 구성되어 있다.
            2. 클라이언트에 총 300개의 쿠키를 저장할 수 있다.
            3. 하나의 도메인 당 20개의 쿠키를 가질 수 있다.
            4. 하나의 쿠키는 4KB(=4096byte)까지 저장 가능하다.
    - Cookie는 어떤 형식으로 이루어져 있나요?
     key-value 형식의 문자열 형태로 저장되어있다.
    서버가 클라이언트에 정보를 전달할 때 저장하고자 하는 정보를 응답 헤어에 저장하여 전달한다. 
    예를 들어, 로그인했을 때 set-cookie의 형태로 반환을 받은 쿠키를 던져 요청하는 동작 구조를 가진다.
    
    ```jsx
    { 
    	"Set-Cookie" : "id=user123",
    	"Set-Cookie" : "pw=pw1234@"
    }
    ```
    
    - Session이란 무엇일까요?
        - 일정 시간동안 같은 사용자나 브라우저로부터 들어오는 일련의 요구를 하나의 상태로 보고, 그 상태를 일정하게 유지하는 기술이다. 여기서 일정한 시간은 방문자가 웹 브라우저를 통해 웹 서버에 접속한 시점으로부터 웹 브라우저를 종료하여 연결을 끝내는 시점을 말한다.
        한마디로 정리하면, 방문자가 웹 서버에 접속해 있는 상태를 하나의 단위로 보는 것이다.
        - 특징
            1. 웹 서버에 웹 컨테이너의 상태를 유지하기 위한 정보를 저장한다.
            2. 웹 서버의 저장되는 쿠키(=세션 쿠키)
            3. 브라우저를 닫거나, 서버에서 세션을 삭제했을 때만 삭제가 되기 때문에 쿠키보다 비교적 보안이 좋다.
            4. 서버 용량이 허용하는 한에서는 저장 데이터에 제한이 없다.
            5. 각 클라이언트에 고유 Session ID를 부여한다.
    - Cookie와 Session을 사용하는 이유는 무엇일까요?
     http 프로토콜의 특징이자 약점을 보완하기 위해서 사용한다. 
    여기서 말하는 http 프로토콜의 특징이자 약점은 다음과 같다. 정보가 유지되지 않으면, 매번 페이지를 이도알 때마다 로그인을 다시 하거나, 상품을 선택했는데 구매 페이지에서 선택한 상품의 정보가 없거나 하는 등의 일이 발생할 수 있다는 점이다.
    - Cookie와 Session의 차이는 무엇일까요?
    -Cookie는 개인 pc에 저장되는 반면, Session은 접속중인 웹 서버에 저장된다.
        
        ![스크린샷 2024-06-12 오후 3.14.46.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/0b1ef4ac-e496-4580-b38b-d022f9ca73e5/5559af47-a15d-4848-ae7c-ff2040227a3b/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-06-12_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_3.14.46.png)
        
- JWT 방식
    - JWT (JSON Web Token)은 무엇일까요?
     Json 객체 인증에 필요한 정보들을 담은 후 비밀 키로 서명한 토큰으로, 인터넷 표준 인증 방식이다. 공식적으로 인증(Authentication)&권한허가(Authorization) 방식으로 사용된다.
    - JWT 방식의 토큰은 어떤 구조로 되어있고, 각각 어떤 용도로 사용되나요?
        1. Header (헤더) : 토큰의 타입과 해싱 알고리즘 정보를 포함한다.
            
            ```jsx
            {
              "alg": "HS256",
              "typ": "JWT"
            }
            
            ```
            
        2. Payload (페이로드) : 토큰에 담길 데이터(클레임, claim)를 포함한다. 클레임은 주로 사용자의 정보와 토큰의 메타 데이터를 포함한다.
            - 클레임의 종류
                
                1) 등록된 클레임 : 토큰의 정보를 설명하는 표준 클레임
                
                2) 공개 클레임 : 사용자 정의 클레임, 충돌을 피하기 위해 URI 형식으로 이름을 작성하는 것이 좋다.
                
                3) 비공개 클레임 : 토큰 제공자와 사용자 간에 협의된 클레임
                
            
            ```jsx
            {
              "sub": "1234567890",
              "name": "John Doe",
              "admin": true,
              "iat": 1516239022
            }
            
            ```
            
        3. Signature (서명) : 헤더와 페이로드의 무결성을 검증하기 위해 사용되며, 토큰이 위조되지 않았는지 확인하는데에 사용된다. 
            
            ```jsx
            HMACSHA256(
              base64UrlEncode(header) + "." +
              base64UrlEncode(payload),
              secret
            )
            
            ```
            
    - JWT 방식의 장점과 단점은 무엇일까요?
        - 장점
            1. 로컬에 저장하기 때문에 서버 용량에 영향을 끼치거나 받지 않는다.
            2. 공개키나 개인키 또는 비밀키를 통하여 서명되기 때문에 보다 안전하다.
            3. 모바일 앱에서 사용하기에 적합하다.
            4. http 헤더나 url 파라미터를 통하여 전송되기 때문에 네트워크 부하가 적다.
        - 단점
            1. 토큰의 크기가 커질수록 트래픽에 영향을 미칠 수 있다.
            2. 토큰은 발급되면 만료 기간 변경이 불가능하기 때문에 토큰 만료 처리를 구현해야한다.

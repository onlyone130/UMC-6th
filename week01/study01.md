[1️⃣**Chapter 1. Platform & Layout**](https://www.notion.so/Chapter-1-Platform-Layout-d85355d0d8c6484ab506d2176db987cc?pvs=21) 

- 플랫폼이란 무엇인가요?
    - 정의: 응용 소프트웨어를 실행하기 위해 쓰이는 하드웨어와 소프트웨어의 결합이다.
    소프트웨어를 실행할 수 있는 기반이라고도 불린다.
    - 특징: 소프트웨어 개발 중에서도 핵심적이고 기술적으로 어려운 부분이다.
    - 종류: 윈도우, 리눅스, OS X운영체제 (OS)란 무엇인가요?
- 운영체제(OS)란 무엇인가요?
    
    운영체제란 컴퓨터의 하드웨어 시스템을 효율적으로 운영하기 위해 만들어진 소프트웨어이다.
    
    사용자의 편의를 위하여 인터페이스를 제공하는 역할을 한다.
    
    - 운영체제의 종류 : 
    개인용 OS (윈도우, 맥, 리눅스)
    서버용 OS (윈도우 서버, 리눅스, 유닉스)
    모바일 OS(안드로이드,ios)
    - 운영체제의 기능:
    응용 프로그램과 컴퓨터 하드웨어 사이의 중재 역할을 수행한다.
- Android OS란 무엇인가요?
    - 정의: 리눅스 커널 버전을 비롯하여 오픈 소스 소프트웨어에 기반을 둔 모바일 운영체제이다.
    - 특징: 리눅스 커널 위에서 동작하고, 자바와 코틀린으로 앱을 만들어 동작한다.
- Android의 Architecture
    - 안드로이드의 권장 아키텍쳐는 무엇일까요?
        - UI 레이어, 데이터 레이어
    - 안드로이드 아키텍쳐 컴포넌트 (AAC)는 무엇일까요?
        - 안드로이드에서 사용하는 5개의 라이브러리로, Lifcycles, LiveData, ViewModel, Room, Paging, Databinding, Navigation, WorkManager 가 있다.
- 공식문서를 잘 참고하는 것이 왜 중요할까요?
    - 중요한 이유: 해당 기술이나 프레임워크를 만든 개발자들이 직접 작성한 문서이기 때문에 가장 정확하고 신뢰할 수 있는 정보를 제공한다.
    - 안드로이드 공식문서 **( 꼭 한번 들어가서 확인 해보기 )**
- Manifest의 주요 속성 10가지에는 무엇이 있으며, 어떤 기능을 할까요?
    1. <Manifest> : AndroidManifest.xml 파일의 루트 요소, <application> 요소를 포함해야 한다.
    xmlns:android 및 package 속성을 지정한다.
    2. <application> : 애플리케이션 선언, 모든 구성요소에 영햐을 줄 수 있는 속성을 가진다.
    3. <activity> : 애플리케이션의 시각적 사용자 인터페이스 요소를 구현하는 활동을 선언한다.
    모든 활동은 manifest 파일의 <activity> 요소로 나타내야 한다.
    4. <intent-filter> : 활동, 서비스, broadcast reciver가 응답할 수 있는 인텐트의 유형을 지정한다.
    5. <action> : 인텐트 필터에 작업을 추가한다. <intent-filter> 요소에 <action> 요소가 하나 이상 포함 되어야한다.
    6. <permission> : 애플리케이션의 특정 구성요소 또는 기능에 대한 액세스를 제한하는 데 사용될 수 있는 보안 권한들 선언한다.
    7. <uses-permission> : 이 올바르게 작동되게 하기 위해 사용자가 반드시 부여해야하는 시스템 권한이다.
    8. <provider> : 콘텐츠 제공자 구성요소를 선언한다. 콘텐츠 제공자는 애플리케이션에서 관리되는 데이터에 관해 구조화된 액세스를 제공하는 ContentProvider 서브클래스이다.
    9. <receiver> : broadcast receiver를 애플리케이션의 구성요소 중 하나로 선언한다. broadcast receiver를 사용하면 애플리케이션의 다른 구성요소가 실행되고 있지 않을 때도 시스템이나 다른 애플리케이션에서 브로드캐스트하는 인텐트를 애플리케이션에서 수신 가능하다.
    10. <service> : 서비스를 에플리케이션의 구성요소 중 하나로 선언한다. 시각적 사용자 인터페이스가 없다.
- Manifest의 4대 컴포넌트에는 무엇이 있으며, 어떤 기능을 할까요?
    1. 액티비티(Activity) : 사용자가 앱과 상호작용하는 하나의 화면을 의미하고 사용자에게 드러나는 화면을 의미한다.
    컴포넌트끼리는 인텐트를 통해서 상호작용하기 때문에 인텐트를 통해서 다른 액티비티를 호출할 수 있다. 하나 이상의 View 또는 ViewGroup을 포함하고 있어야 한다. 액티비티 내에 프래그먼트를 추가하여 화면을 분할할 수 있다.
    2. 서비스(Service) : 사용자와 직접적으로 상호작용하지는 않는다. 서비스는 메인 스레드에서 동작을 하기 때문에 서비스 내에서 별도의 스레드를 생성하여 작업을 처리해야한다.
    3. 브로드캐스터(BroadCast Receiver) : 각종 이벤트와 정보를 받아와 핸들링하는 컴포넌트이다. 사용자 인터페이스를 표시하지는 않지만, 상태 표시줄 알림을 생성하여 사용자에게 이벤트가 발생했다고 알릴 수 있는 기능을 포함한다.
    4. 콘텐츠 제공자(Contents Provider) : 파일 시스템, SQLite 데이터베이스, 웹상이나 앱에 액세스할 수 있는 다른 모든 영구 저장 위치에 저장 가능한 앱 데이터의 공유형 집합을 관리한다. 작은 데이터들은 인텐트로 데이터를 공유할 수 있지만, 콘텐츠 제공자는 음악이나 사진 파일과 같이 용량이 큰 데이터들을 공유할 때 사용한다.
- Intent란 무엇일까요?
    - Intent의 역할은 무엇일까요?
        
        서로 독립적으로 동작하는 4대 컴포넌트 간의 상호 통신을 위한 장치이다.
        컴포넌트에 액션이나 데이터를 전달한다. 이를 통하여 다른 앱의 컴포넌트를 활성화시킬 수 있다.
        
    - 명시적 Intent와 암시적 Intent의 차이는 무엇일까요?
        
        명시적 Intent는 앱의 화면 전환을 하는 방법이다. 하나의 액티비티에서 다른 액티비티로 전환할 때 사용한다.
        암시적 Intent는 액션에 따라 해당하는 적합한 애플리케이션의 클래스를 호출한다. 웹브라우저의 호출, 이메일 전송, 전화앱으로의 통화 등이 그 예시이다.
        
- 안드로이드에서 자주 사용되는 용어에는 무엇이 있을까요?
    1. TextView
    2. Button
    3. ImageView
    4. RecyclerView
    5. ScrollView
    6. NestedScrollView
    7. BottomNavigationView
    8. TabLayout
    9. FloatingActionButton
    10. margin
    11. padding
    12. chainStyle
    13. id 네이밍
- Layout에는 어떤 종류가 있을까요?
    
    LinearLayout, RelativeLayout, ConstraintLayout, TableLayout, GridLayout, FrameLayout 등이 있다.
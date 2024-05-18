- Lifecycle
    - Lifecycle이란 무엇일까요?
    안드로이드 애플리케이션의 각 컴포넌트(Activity, Fragment 등)가 어떤 상태에 있는지를 나타내는 개념이다. 안드로이드 시스템은 다양한 이벤트에 따라 컴포넌트의 상태를 변경하고, 개발자는 이러한 상태 변화에 대응하여 적절한 동작을 수행할 수 있다.
    - Lifecycle은 왜 등장하게 되었을까요?
    1. 자원 관리
    : 모바일 장치는 제한된 자원을 가지고 있다. 시스템은 비활성 상태의 애플리케이션을 자동으로 종료하여 메모리와 배터리 자원을 효율적으로 관리할 필요가 있다.
    
    2. 사용자 경험
    : 사용자가 애플리케이션을 사용하는 동안 원활한 경험을 제공하기 위해서는 애플리케이션이 적절히 상태를 관리하고 사용자 인터페이스를 유지해야한다.
    
    3. 상태 유지 및 복구
    : 사용자가 화면을 회전하거나 다른 애플리케이션으로 전환했다가 다시 돌아왔을 때, 애플리케이션이 이전 상태를 유지하거나 복구할 수 있어야 한다.
    
    4. 코드 구조화
    : Life Cycle을 통해 개발자는 코드의 구조를 명확하게 하고, 각 상태 변화에 대해 적절한 동작을 정의할 수 있다. 이러한 특징은 유지보수와 확장을 용이하게 한다. 
    
    Life Cycle은 안드로이드 애플리케이션의 안정성과 성능을 향상시키고, 개발자가 복잡한 상태 관리를 쉽게 할 수 있도록 도와준다. 이로 인하여 안드로이드 애플리케이션은 더욱 효율적이고 사용자 친화적으로 동작할 수 있다.
- Activity의 Lifecycle
    - Activity의 대표적인 Lifecycle은 어떤게 있을까요?
        1. **onCreate()**: Activity가 처음 생성될 때 호출됩니다. 초기화 작업을 수행하며, UI를 설정하고 필요한 리소스를 로드합니다.
        2. **onStart()**: Activity가 사용자에게 보이기 시작할 때 호출됩니다. UI와 관련된 리소스를 초기화합니다.
        3. **onResume()**: Activity가 사용자와 상호작용을 시작할 준비가 되었을 때 호출됩니다. Activity가 포그라운드에 있으며 사용자 입력에 응답할 수 있습니다.
        4. **onPause()**: Activity가 포그라운드에서 벗어나려 할 때 호출됩니다. 일시적인 데이터 저장이나 애니메이션 중단 등의 작업을 수행합니다.
        5. **onStop()**: Activity가 더 이상 사용자에게 보이지 않을 때 호출됩니다. 더 이상 필요 없는 리소스를 해제하거나 지속적인 작업을 중단할 수 있습니다.
        6. **onDestroy()**: Activity가 완전히 종료될 때 호출됩니다. 모든 리소스를 해제하고 마무리 작업을 수행합니다.
        7. **onRestart()**: Activity가 중지 상태에서 다시 시작될 때 호출됩니다. **`onStart()`**가 호출되기 전에 호출됩니다.
    - 각 Lifecycle을 활용하는 실제 예시들은 어떤게 있을까요?
    
    **onCreate()**
    
    - **예시**: 데이터베이스 초기화, 뷰 바인딩, 인텐트 데이터 처리.
        
        ```jsx
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            // 초기화 작업
            initDatabase()
            bindViews()
            handleIntent(intent)
        }
        
        private fun initDatabase() {
            // 데이터베이스 초기화 코드
        }
        
        private fun bindViews() {
            // 뷰 바인딩 코드
        }
        
        private fun handleIntent(intent: Intent) {
            // 인텐트 데이터 처리 코드
        }
        
        ```
        
    
    **onStart()**
    
    - **예시**: UI 업데이트, 애니메이션 시작, 센서 리스너 등록.
        
        ```jsx
        override fun onStart() {
            super.onStart()
            // UI 갱신 작업
            updateUI()
            startAnimations()
            registerSensorListeners()
        }
        
        private fun updateUI() {
            // UI 갱신 코드
        }
        
        private fun startAnimations() {
            // 애니메이션 시작 코드
        }
        
        private fun registerSensorListeners() {
            // 센서 리스너 등록 코드
        }
        
        ```
        
    
    **onResume()**
    
    - **예시**: 카메라 미리보기 시작, GPS 위치 업데이트 시작.
        
        ```jsx
        override fun onResume() {
            super.onResume()
            // 사용자 상호작용 시작
            startCameraPreview()
            requestLocationUpdates()
        }
        
        private fun startCameraPreview() {
            // 카메라 미리보기 시작 코드
        }
        
        private fun requestLocationUpdates() {
            // GPS 위치 업데이트 코드
        }
        
        ```
        
    
    **onPause()**
    
    - **예시**: 미디어 재생 중지, 변경사항 임시 저장.
        
        ```jsx
        override fun onPause() {
            super.onPause()
            // 일시 중지 작업
            pauseMediaPlayback()
            saveDraftChanges()
        }
        
        private fun pauseMediaPlayback() {
            // 미디어 재생 중지 코드
        }
        
        private fun saveDraftChanges() {
            // 변경사항 임시 저장 코드
        }
        
        ```
        
    
    **onStop()**
    
    - **예시**: 네트워크 연결 해제, 데이터베이스 커밋, 백업 작업 수행.
        
        ```jsx
        override fun onStop() {
            super.onStop()
            // 중지 작업
            disconnectNetwork()
            commitDatabase()
            performBackup()
        }
        
        private fun disconnectNetwork() {
            // 네트워크 연결 해제 코드
        }
        
        private fun commitDatabase() {
            // 데이터베이스 커밋 코드
        }
        
        private fun performBackup() {
            // 백업 작업 수행 코드
        }
        
        ```
        
    
    **onDestroy()**
    
    - **예시**: 리소스 해제, 스레드 중단.
        
        ```jsx
        override fun onDestroy() {
            super.onDestroy()
            // 리소스 해제
            releaseResources()
            stopBackgroundThreads()
        }
        
        private fun releaseResources() {
            // 리소스 해제 코드
        }
        
        private fun stopBackgroundThreads() {
            // 백그라운드 스레드 중단 코드
        }
        
        ```
        
    
    **onRestart()**
    
    - **예시**: UI 업데이트, 필요한 데이터 재로드.
        
        ```jsx
        override fun onRestart() {
            super.onRestart()
            // 재시작 준비
            refreshUI()
            reloadData()
        }
        
        private fun refreshUI() {
            // UI 갱신 코드
        }
        
        private fun reloadData() {
            // 데이터 재로드 코드
        }
        
        ```
        
- MediaPlayer
    - MediaPlayer는 언제 사용할까요?
    오디오와 비디오를 재생할 때 사용한다. 이 클래스는 미디어 파일이나 스트리밍 콘텐츠를 재생하기 위한 기능을 제공한다.
    - MediaPlayer에서 사용할 수 있는 함수들은 무엇이 있으며, 어떤 기능을 할까요? (ex create, pause, …)
    -onCreate() : 최초 실행 시에만 해주어야하는 작업들이다. Data Binding, View 생성, setContentView와 같은 레이아웃을 정의
    -onStart() : 화면에 진입할 때마다 실행되어야하는 작업들, UI를 관리하는 코드를 초기화, onStop()에서 해제된 리소스 초기화
    -onResume() : 액티비티가 사용자와 상호작용하기 전에 호출된다. 사용자에게 보이는 동안만 실행해야하는 기능을 제공, onPause()에서 해제된 리소스 초기화, 화면이 재개된 상태로 전환될 때마다 필요한 다른 작업 초기화
    -onPause() : 액티비티가 정상적으로 실행이 되다가 어떠한 이벤트를 마주하여 사용자가 첫번째로 실행하게 되는 것, 잠시 후 다시 시작할 작업을 일시중지 하거나 조정, 배터리 수명에 영향을 미칠 수 있는 리소스 해제, Thread 중지
    -onStop() : 사용자에게 보이지 않는 동안 필요하지 않은 리소스를 해제하거나 조정, 비교적 부하가 큰 저장 작업, 정보를 데이터베이스에 저장
    -onDestroy() : 액티비티가 소멸되기 전에 정리하는 작업, 해제되지 않은 모든 리소스 해제
- SharedPreferences
    - SharedPreference란 무엇일까요?
    애플리케이션의 간단한 데이터를 저장하고 조회하는 데 사용되는 키-값 쌍을 위한 영구 저장소이다. 주로 작은 설정 값이나 상태 정보를 저장할 때 사용한다.
    - SharedPreference는 어떤 방식으로 값을 저장할까요?
    데이터를 저장하는 방법은 다음과 같다.
        
        ```jsx
        val editor = sharedPref.edit()
        editor.putString("key_name", "value") // 문자열 저장
        editor.putInt("key_age", 25) // 정수 저장
        editor.putBoolean("key_isLoggedIn", true) // 부울 저장
        editor.apply() // 비동기 저장 (commit()도 가능하지만 동기 저장)
        ```
        
    - JSON과 GSON이란 무엇일까요?
        
        > JSON
        > 
        
        JSON은 Javascript Object Notation으로, 네트워크를 통해 데이터를 주고받는데 사용되는 경량의 데이터 교환 형식이다. JSON은 데이터 포맷, 데이터를 표시하는 표현 방법이다.
        JSON은 name : value 쌍으로 이루여져 있다. 
        JSON의 객체는 name - value 쌍의 집합이고, 집합의 쌍들은 서로 쉼표로 구분한다. 
        name은 무조건 String 타입으로, 쌍따옴표를 이용해서 표기한다.
        객체는 중괄호({,})를 이용해서 만들 수 있고, 여러 개의 객체가 들어있는 배열을 넣고 싶으면 대괄호([,])를 사용한다. 
        
        > GSON
        > 
        
        GSON은 JSON 문자열을 객체로 변환해주는 라이브러리인데 구글에서 제공을 해주기 때문에 GSON으로 불린다. 
        Volley를 통해서 웹서버로부터 JSON 응답을 받았다면 GSON을 이용해 자바 객체로 바꾸고 그 객체 안에 들어있는 데이터를 사용하게 된다.
        GSON을 사용하기 위해서는 일단 GSON 객체를 만들어야한다. GSONBuiler를 사용하여 다양한 설정을 할 수 있고, GSON으로 바로 생성할 수도 있다.
        아래는 GSON의 사용 예시 코드이다.
        
        ```jsx
        val gson: Gson = GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT)
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()
            
        val gson = Gson()
        ```

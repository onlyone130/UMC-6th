[2️⃣**Chapter 2. Activity와 Fragment**](https://www.notion.so/Chapter-2-Activity-Fragment-14597d3e2f9448a88259754249b10127?pvs=21)

- Activity
    - Activity란 무엇인가요?
        
        안드로이드 앱의 중요한 구성요소로, 동작이 실행되고 결합되는 방식은 애플리케이션 모델의 기본 요소이다.
        
    - 새로운 Activity를 만들기 위해선 어떻게 해야할까요?
        
        안드로이드에서는 생명 주기의 특정 단계에 해당하는 특정 콜백 메서드를 호출하여 activity 인스턴스의 코드를 시작한다.
        
    - AppcompatActivity란 무엇일까요?
        
        AppcompatActivity는 Activity가 가지고 있는 상속 구조 중 가장 하위클래스이다. 특정 버전부터 지원되는 ActionBar을 해당 버전 이하에서도 호환될 수 있도록 지원해준다.
        
- Activity-Layout 결합
    - findViewById
        - findViewById 사용법
        
        ```kotlin
        @Nullable
        public final <T extends View> T findViewById(@IdRes int id) {
            if (id == NO_ID) {
                return null;
            }
            return findViewTraversal(id);
        }
        ```
        
        findViewById 메서드가 호출되면 View Type에 해당되는 findByViewById 메서드를 호출한다. id가 없다면 null을 반환하고, 그렇지 않다면 findViewTraversal 메소드를 호출한다.
        
        ```kotlin
        protected <T extends View> T findViewTraversal(@IdRes int id) {
            if (id == mID) {
                return (T) this;
            }
            return null;
        }
        ```
        
    - ViewBinding
        - ViewBinding 사용법
        
        ```kotlin
        android {
                ...
                viewBinding {
                    enabled = true
                }
            }
        ```
        
        Activity에서의 ViewBinding을 하는 방법은 아래와 같다. 
        많은 양의 view를 처리할 때는 ViewBinding을 사용하는 것이 효과적이다.
        
        ```kotlin
        
         private lateinit var binding: ResultProfileBinding
        
            override fun onCreate(savedInstanceState: Bundle) {
                super.onCreate(savedInstanceState)
                binding = ResultProfileBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
            }
        ```
        
        Fragment에서의 ViewBinding을 하는 방법은 아래와 같다.
        
        ```kotlin
          private var _binding: MainFragmentBinding? = null
        
            private val binding get() = _binding!!
        
            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                _binding = MainFragmentBinding.inflate(inflater, container, false)
                val view = binding.root
                return view
            }
        
            override fun onDestroyView() {
                super.onDestroyView()
                _binding = null
            }
        ```
        
    - findViewById 보다 ViewBinding이 권장되는 이유
        - findViewById의 단점
        - ViewBinding의 장점
- 새로운 Activity를 띄우는 방법
    - Intent란 무엇일까요?
        
        안드로이드 4대 컴포넌트 중 하나로, 컴포넌트간의 통신을 맡고 있다.
        
    - Intent를 사용하여 Activity 간 데이터를 전달하려면 어떻게 해야할까요?
        
        manifest.xml 파일에 intent를 하기 위한 사전 작업을 해주어야한다.
        1. 메인 엑티비티에서 intent의 putExtra로 데이터를 전달한다.
        2. 두번째 엑티비티에서 타입에 맞게 getIntExtra, getStringExtra, getDoubleExtra 등의 형태로 데이터를 전달받는다.
        3. startActivityForResult 혹은 ActivityResultLauncher 두 가지 중 하나의 방법을 택하여 양방향 데이터 통신을 진행할 수 있다. 
        
- 명시적 Intent와 암시적 Intent
    - 명시적 Intent란 무엇일까요?
        
        의도가 명확할 때 사용한다.
        호출할 대상이 확실하여, 액티비티가 명확하게 실행되어야할 경우에 사용한다.
        Package와 Class명을 정확하게 명시한다.
        
    
    ```kotlin
    
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    ```
    
    - 암시적 Intent란 무엇일까요?
        
        호출할 대상이 명확하지 않을 때 사용한다.
        intent의 의도에 맞는 Activity를 찾아서 실행한다.
        Action, Category, Type 등이 저장된다.
        
- Fragment
    - Fragment의 정의는 무엇일까요?
        
        Fragment는 앱 UI의 재사용 가능한 부분을 나타낸다. 프래그먼트는 자체 레이아웃을 정의 및 관리하고 자체 수명 주기를 보유하여 자체 입력 이벤트를 처리할 수 있다. 프래그먼트는 단독으로 실행될 수 없다. 활동 또는 다른 프래그먼트에서 호스팅을 해야한다.
        
    - Fragment를 사용하는 이유는 무엇일까요?
        
        Fragment를 사용하면 태블릿과 같이 화면이 넓은 기기에서 동작하는 앱을 개발할 수 있다.
        
        하나의 화면은 하나의 activity class에 작성해야하는데, 화면이 크면 activity class에 너무 많은 코드를 작성해야하는 불편함이 있다. 
        
        한 화면에 여러 가지 구성을 포함하고 싶다면 두 개의 클래스가 하나의 activity 화면에 출력되어야 하기 때문에 class를 view class로 만들어야한다. 그런데 여기서, view class는 activity가 아니기 때문에 fragment를 사용해서 activity에 작성된 내용을 담는 것이다.
        
    - 새 Fragment는 어떻게 만들 수 있을까요?
        
        androidx.fragment 라이브러리에서 새로운 Fragment를 제공한다.
        
    - Fragment는 어떻게 화면에 보이게 할 수 있을까요?
        
        액티비티의 레이아웃 xml 파일에 fragment가 출력될 뷰를 작성한다.
        
- Bundle
    - Bundle은 무엇일까요?
        
        Map 형태로 구현된 데이터의 묶음이다.  Map 형태이기 때문에 key 값은 String이고, value 값에는 int, string과 타입부터 다양하게 올 수 있다.
        
        Bundle은 데이터 저장 객체로 상태 저장 및 복구에 사용된다. onSavedInstanceState, onRestoreInstanceState에서 데이터 저장 및 복구를 진행할 수 있다.
        
    - Intent와 Bundle을 결합하는 방법은 무엇일까요?
        
        ```kotlin
        val intent = Intent()
        
        val bundle=Bundle()
        bundle.putString("key","value")
        intent.putExtra("bundle",bundle)
        ```
        
        Bundle은 Map 형식이기 때문에 key 값과 value를 지정해주어야한다.
        
- FragmentManager
    - FragmentManager란 무엇일까요?
        
        프래그먼트를 더하고, 삭제하고, 교체하고, 백스택에 더하는 활동을 책임지는 class를 말한다.
        
    - FragmentManager는 언제 사용해야 될까요?
        
        Jetpack Navigation이라는 라이브러리를 사용하면 FragmentManager와 직접적으로 상호작용 할 필요가 없다. 다만 Navigation 은 FragmentManager를 내부적으로 사용하여 구현되어 있습니다.

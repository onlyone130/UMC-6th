- ListView
    - ListView란 무엇일까요?
     ListView는 사용자가 정의한 데이터 목록을 세로 방향으로 나열하여 화면에 표시하는 뷰 그룹의 한 종류이다. ListView와 같은 뷰 그룹(ViewGroup)은 스크롤 기능을 지원하고 사용자가 배치된 각 항목(Item)을 선택하는 것도 가능하다.
    - ListView에 들어갈 아이템들은 어떻게 저장해야 할까요?
        
        ArrayList를 사용하거나 배열, 객체 리스트, 데이터베이스를 사용하여 아이템들을 저장한다.
        
    - ListView는 어떤 구성요소로 되어있을까요?
    data,  adapter, item_layout으로 구성되어있다.
- Adapter
    - Android에서 사용되는 Adapter란 무엇일까요?
    데이터와 View를 연결해주는 다리 역할을 하는 객체를 말한다.
    - Adapter는 주로 어떤 역할을 할까요?
    데이터 대응하는 아이템 레이아웃을 생성하고 데이터를 아이템 레이아웃에 담아서 뷰에 나타낸다.
    - ListView의 Adapter는 어떤 구성 요소를 가지고 있을까요?
        1. **데이터 소스**:
            
            **`private val dataSource: List<String>`**: Adapter가 관리하는 데이터 소스이다.
            
        2. **getView() 메서드**:
            
            **`getView(position: Int, convertView: View?, parent: ViewGroup): View`**: 주어진 위치의 데이터를 가져와 해당 위치에 표시할 뷰를 반환한다. 이 메서드에서 뷰를 생성하거나 재사용한다.
            
        3. **Context**:
            
            **`context: Context`**: Adapter가 Context를 사용하여 시스템 자원에 접근한다.
            
        4. **레이아웃 인플레이터**:
            
            **`private val inflater: LayoutInflater`**: XML 레이아웃 파일을 뷰 객체로 변환하는 데 사용된다. **`getSystemService(Context.LAYOUT_INFLATER_SERVICE)`**를 통해 인플레이터를 초기화한다.
            
        5. **뷰 홀더 패턴**:
            
            **`ViewHolder`** 클래스는 뷰의 참조를 저장하여 뷰를 재사용하는 데 사용된다. 이를 통해 **`findViewById()`** 호출을 줄이고 성능을 최적화한다.
            
- RecyclerView
    - RecyclerView란 무엇일까요?
    이미지나 텍스트를 리스트화해서 스크롤하며 볼 수 있게 해주는 컨테이너이다.
    - RecyclerView와 ListView는 어떤 차이점이 있을까요?
        - 아이템 재사용 방식: ListView는 모든 아이템을 불러오기 때문에, 스크롤 시에도 모든 아이템을 유지하며 화면에 보여주는 반면 RecyclerView는 ViewHolder 패턴을 사용하여 화면에 보여지는 아이템만 재사용하기 때문에 성능 개선을 할 수 있다.
        - 레이아웃 관리: ListView는 레이아웃을 수동으로 설정해야 하지만, RecyclerView는 레이아웃 관리자(Layout Manager)를 사용하여 레이아웃을 쉽게 설정 가능하다. 레이아웃 관리자는 리스트를 가로로 배치하거나, 그리드 형태로 배치하는 등 다양한 레이아웃을 지원한다.
        - 어댑터(Adapter): 두 뷰 모두 어댑터를 사용하여 데이터를 화면에 표시한다.  RecyclerView는 어댑터에 추가로 ViewHolder를 사용하여 아이템을 재사용한다.
        - 애니메이션: RecyclerView나 ListView에서는 아이템이 추가, 삭제, 이동할 때 애니메이션을 쉽게 지정할 수 있다. ListView에서는 애니메이션을 직접 지정해야 한다. 예를 들어서 아이템이 추가될 때는 화면에서 위에서 아래로 떨어지는 애니메이션을 구현할 수 있다. 반면 RecyclerView에서는 ItemAnimator를 사용하여 애니메이션을 지정할 수 있다. 예를 들어, 아이템이 추가될 때는 기본적으로 화면에서 오른쪽에서 왼쪽으로 나타나는 애니메이션을 사용할 수 있다. 또한, ItemDecorator를 사용하여 아이템 사이에 여백을 주거나, 아이템에 그림자 효과를 추가하는 등의 레이아웃 처리를 할 수 있다.
    - RecyclerView Adapter는 어떤 구성 요소를 가지고 있을까요?
        1. **ViewHolder 패턴**:
            
            RecyclerView는 ViewHolder 패턴을 사용하여 성능을 최적화한다.  ViewHolder는 RecyclerView의 각 아이템 뷰를 보유하고, 이를 재사용하여 뷰를 반복적으로 생성하는 비용을 줄인다. 
            
        2. **아이템 뷰 타입 지원**:
            
            Adapter는 다양한 유형의 뷰를 처리할 수 있도록 여러 아이템 뷰 타입을 지원한다. 이를 통해 같은 RecyclerView에서 서로 다른 레이아웃을 가진 아이템을 표시할 수 있다.
            
        3. **onCreateViewHolder() 메서드**:
            
            이 메서드는 새로운 ViewHolder 객체를 생성하는 데 사용된다. 레이아웃을 인플레이트하고 ViewHolder에 뷰를 바인딩하는 역할을 한다.
            
        4. **onBindViewHolder() 메서드**:
            
            이 메서드는 특정 위치의 데이터를 가져와 ViewHolder의 뷰에 바인딩하는 역할을 한다. 데이터와 뷰를 연결하는 부분이다.
            
        5. **getItemCount() 메서드**:
            
            이 메서드는 Adapter가 관리하는 데이터 세트의 크기를 반환한다. RecyclerView는 이 정보를 바탕으로 아이템을 렌더링한다.
            
        6. **데이터 변경 알림**:
            
            Adapter는 데이터 변경을 RecyclerView에 알릴 수 있다. 이를 통해 RecyclerView는 변경된 데이터를 반영하도록 갱신할 수 있다. 주로 **`notifyDataSetChanged()`**, **`notifyItemInserted()`**, **`notifyItemRemoved()`** 등의 메서드를 사용한다.
            
        7. **RecyclerView.Adapter 클래스 상속**:
            
            모든 커스텀 Adapter는 **`RecyclerView.Adapter`** 클래스를 상속받아 구현된다. 제네릭 타입으로 ViewHolder를 지정해야 한다.
            
        8. **리스트의 성능 최적화**:
            
            RecyclerView는 리스트의 성능을 최적화하기 위해 다양한 기능을 제공한다. 예를 들어, **`DiffUtil`**을 사용하여 데이터 세트의 변경 사항을 효율적으로 계산하고, 애니메이션을 적용할 수 있다.
            
    - RecyclerView를 설정할 때 주의해야 하는 점은 무엇이 있을까요?
        1. **ViewHolder 패턴의 적절한 사용**:
            
            ViewHolder는 뷰를 재사용하여 성능을 최적화합니다. ViewHolder를 적절하게 구현하여 각 아이템 뷰의 초기화 비용을 최소화해야 합니다.
            
        2. **아이템 뷰의 레이아웃 최적화**:
            
            각 아이템 뷰의 레이아웃을 단순하게 유지하여 측정 및 그리기 시간을 줄입니다. 복잡한 레이아웃은 성능 저하를 일으킬 수 있습니다.
            
        3. **데이터 변경 알림 최적화**:
            
            데이터 세트가 변경될 때, **`notifyDataSetChanged()`**를 남용하지 않고, **`notifyItemInserted()`**, **`notifyItemRemoved()`**, **`notifyItemChanged()`** 등을 사용하여 정확한 위치에 변경을 알리도록 합니다. 이렇게 하면 RecyclerView가 최소한의 작업으로 업데이트를 처리할 수 있습니다.
            
        4. **RecyclerView의 스크롤 성능 최적화**:
            
            RecyclerView의 스크롤 성능을 최적화하려면 **`setHasFixedSize(true)`**를 사용하여 아이템의 크기가 고정된 경우 성능을 향상시킬 수 있습니다.
            
            **`RecyclerView.RecycledViewPool`**을 사용하여 여러 RecyclerView가 동일한 뷰 타입을 공유하도록 할 수 있습니다.
            
        5. **DiffUtil 사용**:
            
            데이터 세트가 자주 변경될 경우, **`DiffUtil`**을 사용하여 새 데이터와 기존 데이터를 효율적으로 비교하고 변경 사항을 계산하여 성능을 최적화할 수 있습니다.
            
        6. **레이아웃 매니저 선택**:
            
            레이아웃 매니저는 RecyclerView의 스크롤 동작과 레이아웃을 관리합니다. **`LinearLayoutManager`**, **`GridLayoutManager`**, **`StaggeredGridLayoutManager`** 등 사용 시 상황에 맞는 레이아웃 매니저를 선택합니다. 커스텀 레이아웃 매니저를 구현할 때는 성능에 주의해야 합니다.
            
        7. **아이템 애니메이션 관리**:
            
            기본적으로 RecyclerView는 아이템 변경 시 애니메이션을 제공합니다. 복잡한 애니메이션은 성능 저하를 일으킬 수 있으므로 필요한 경우 사용자 정의 애니메이션을 비활성화하거나 최적화해야 합니다.
            
        8. **데이터 로딩 최적화**:
            
            많은 데이터를 한꺼번에 로드하지 않고, 필요한 시점에 데이터를 동적으로 로드하도록 합니다. 예를 들어, 페이징 라이브러리를 사용하여 대량의 데이터를 페이지 단위로 로드할 수 있습니다.
            
        9. **메모리 관리**:
            
            RecyclerView는 많은 뷰를 재사용하기 때문에 메모리 관리가 중요합니다. 메모리 누수가 발생하지 않도록 주의하고, 컨텍스트를 잘못 참조하지 않도록 합니다.
            
        10. **뷰 타입 관리**:
            
            다양한 뷰 타입을 사용해야 할 때는 **`getItemViewType()`** 메서드를 적절히 구현하여 각 뷰 타입에 맞는 ViewHolder를 생성하고 바인딩해야 합니다.
            
    - ViewPager2 에서 사용했던 FragmentStateAdapter와 RecyclerView.Adapter는 어떤 차이가 있을까요?
        - **FragmentStateAdapter**는 ViewPager2에서 각 페이지를 Fragment로 관리하기 위해 사용되고, Fragment의 생명주기를 관리하고 페이지 전환 시 상태를 유지한다.
        - **RecyclerView.Adapter**는 RecyclerView에서 아이템 리스트를 관리하고 ViewHolder를 사용하여 성능을 최적화한다.
    
    FragmentStateAdapter 예제 코드
    
    ```jsx
    class MyPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return NUM_PAGES
        }
    
        override fun createFragment(position: Int): Fragment {
            return MyFragment.newInstance(position)
        }
    }
    
    ```
    
    RecyclerView.Adapter 예제 코드
    
    ```jsx
    class MyAdapter(private val dataSet: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.textView)
        }
    
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_text_view, parent, false)
            return MyViewHolder(view)
        }
    
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = dataSet[position]
        }
    
        override fun getItemCount() = dataSet.size
    }
    
    ```
    
- foreground service
    - foreground service란 무엇일까요?
    사용자가 인식할 수 있도록 상시 알림을 통해 실행되는 서비스이다. 일반적인 백그라운드 서비스와 달리, Foreground Service는 사용자에게 명확하게 표시되며 시스템 리소스를 지속적으로 사용할 수 있다. 이러한 서비스는 중요한 작업을 수행할 때 주로 사용된다.
    - foreground service를 사용하는 이유는 무엇일까요?
        1. **중요한 작업 수행**:
            - 음악 재생, 위치 추적, 파일 다운로드 등 사용자가 인지하고 지속적으로 실행되어야 하는 작업을 수행한다.
        2. **시스템 자원 보호**:
            - Foreground Service는 시스템에 의해 쉽게 중단되지 않기 때문에 중요한 작업이 백그라운드에서 중단되지 않고 계속 실행될 수 있다.
        3. **사용자 알림**:
            - Foreground Service는 항상 알림을 표시하여 사용자에게 서비스가 실행 중임을 알린다. 이는 사용자에게 서비스의 존재를 명확히 하여 사용자가 서비스의 실행 여부를 쉽게 파악할 수 있게 한다.
    - foreground service 사용 시 주의사항은 무엇이 있을까요?
        1. **적절한 사용 목적**:
            
            Foreground Service는 시스템 자원을 많이 사용할 수 있기 때문에 꼭 필요한 경우에만 사용해야 한다. 불필요하게 사용하면 배터리 소모와 시스템 성능 저하를 초래할 수 있다.
            
        2. **적절한 알림 제공**:
            
            Foreground Service는 항상 알림을 통해 사용자에게 서비스가 실행 중임을 알려야 한다. 알림에는 서비스의 상태와 관련 정보를 포함해야 한다.
            
        3. **권한 처리**:
            
            위치 추적이나 네트워크 사용과 같이 특정 권한이 필요한 경우, 사용자가 권한을 명시적으로 허용하도록 해야 한다. 권한이 없으면 서비스가 정상적으로 작동하지 않을 수 있다.
            
        4. **서비스 종료 처리**:
            
            서비스가 더 이상 필요하지 않을 때는 반드시 서비스를 종료해야 한다. 이를 통해 시스템 자원을 효율적으로 관리하고 불필요한 배터리 소모를 방지할 수 있다.
            
        5. **안드로이드 정책 준수**:
            
            Foreground Service는 Android의 최신 정책과 가이드라인을 준수해야 한다. 특히 Android 8.0 (Oreo) 이후 버전에서는 백그라운드 서비스에 대한 제한이 강화되었으므로, Foreground Service를 사용하는 경우 이를 잘 이해하고 적용해야 한다.
            
        
        Foreground Service 설정 예시 코드
        
        ```jsx
        class MyForegroundService : Service() {
        
            override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
                val notification = createNotification()
                startForeground(NOTIFICATION_ID, notification)
        
                // 서비스 작업 수행
                // ...
        
                return START_NOT_STICKY
            }
        
            override fun onBind(intent: Intent): IBinder? {
                return null
            }
        
            private fun createNotification(): Notification {
                val channelId = "my_channel_id"
                val channelName = "My Foreground Service Channel"
                
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
                    val manager = getSystemService(NotificationManager::class.java)
                    manager.createNotificationChannel(channel)
                }
        
                val notificationBuilder = NotificationCompat.Builder(this, channelId)
                    .setContentTitle("Foreground Service")
                    .setContentText("Service is running...")
                    .setSmallIcon(R.drawable.ic_service_icon)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        
                return notificationBuilder.build()
            }
        
            override fun onDestroy() {
                super.onDestroy()
                // 서비스 종료 시 처리할 작업
                // ...
            }
        
            companion object {
                private const val NOTIFICATION_ID = 1
            }
        }
        
        ```
        
- background service
    - background service란 무엇일까요?
    사용자가 직접적으로 상호작용하지 않는 동안 백그라운드에서 실행되는 Android 서비스이다. 이러한 서비스는 사용자 인터페이스가 없으며, 백그라운드에서 작업을 수행하는 데 사용된다. 예를 들어, 데이터 동기화, 파일 다운로드, 알림 수신 등이 이에 해당한다.
    - background service를 사용하는 이유는 무엇일까요?
        1. **지속적인 작업 수행**:
            
            사용자가 앱을 사용하지 않는 동안에도 중요한 작업을 계속 수행해야 할 때 사용한다. 예를 들어, 데이터 동기화, 파일 업로드/다운로드, 위치 추적 등의 작업이 필요하다.
            
        2. **리소스 효율성**:
            
            특정 작업이 완료될 때까지 기다리지 않고, 백그라운드에서 작업을 처리함으로써 리소스를 효율적으로 사용할 수 있다. 이를 통해 사용자 경험을 향상시킬 수 있다.
            
        3. **알림 처리**:
            
            백그라운드에서 푸시 알림을 수신하고 처리하여 사용자에게 중요한 정보를 제공할 수 있다.
            
        4. **타이머 및 예약 작업**:
            
            일정 시간마다 작업을 수행해야 하는 경우에 사용한다. 예를 들어, 주기적으로 데이터를 서버와 동기화하는 작업 등이 있다.
            
    - background service 사용 시 주의사항은 무엇이 있을까요?
        1. **배터리 소모**:
            
            백그라운드에서 실행되는 서비스는 배터리 소모를 유발할 수 있으므로, 필요한 최소한의 작업만 수행하고, 작업이 완료되면 즉시 서비스를 중지해야 한다.
            
        2. **리소스 관리**:
            
            시스템 리소스를 효율적으로 사용해야 한다. 메모리, 네트워크, CPU 사용량을 최소화하여 다른 애플리케이션의 성능에 영향을 미치지 않도록 해야 한다.
            
        3. **작업 스케줄링**:
            - Android 8.0 (Oreo) 이상에서는 백그라운드 서비스에 대한 제한이 강화되었다. 그렇기 때문에 **`JobScheduler`**, **`WorkManager`** 등을 사용하여 작업을 스케줄링하는 것이 권장된다.
        4. **권한 관리**:
            
            네트워크 접근, 위치 정보 등 민감한 데이터에 접근할 경우 사용자가 명시적으로 권한을 부여해야 한다. 권한이 없으면 서비스가 정상적으로 작동하지 않을 수 있다.
            
        5. **서비스 중지**:
            
            작업이 완료되면 서비스를 반드시 중지해야 한다. 그렇지 않으면 불필요한 리소스 소모와 배터리 소모가 발생할 수 있다. **`stopSelf()`** 또는 **`stopService()`** 메서드를 사용하여 서비스를 중지한다.
            
        6. **Foreground Service로 전환**:
            
            사용자가 인지해야 할 중요한 작업을 수행하는 경우에는 백그라운드 서비스 대신 Foreground Service로 전환하여 알림을 통해 사용자에게 작업이 진행 중임을 알릴 수 있다.
            
    
    Background Service 설정 예제 코드
    
    ```jsx
    class MyBackgroundService : Service() {
    
        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            // 백그라운드 작업 수행
            Thread {
                // 예: 데이터 동기화 작업
                performBackgroundTask()
    
                // 작업 완료 후 서비스 중지
                stopSelf()
            }.start()
    
            return START_STICKY
        }
    
        override fun onBind(intent: Intent): IBinder? {
            return null
        }
    
        private fun performBackgroundTask() {
            // 백그라운드에서 수행할 작업 구현
            // 예: 서버와 데이터 동기화
        }
    }
    
    ```

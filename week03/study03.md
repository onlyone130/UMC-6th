[Chapter 3. Useful Widget](https://www.notion.so/Chapter-3-Useful-Widget-d033c7b84f404f0a8eb902e13e193cda?pvs=21)
- BottomNavigationView란?
    - BottomNavigationView란 무엇이고, 어떤 기능을 할까요?
        
        애플리케이션을 실행하였을 때 화면 하단에 있는 네비게이션 역할을 하는 버튼의 모음이다.
        
        BottomNavigationView를 사용하게 되면 사용자가 탭 한 번으로 최상위 보기를 쉽게 탐색하고 전환할 수 있다. BottomNavigationView는 애플리케이션 내에 최상위 대상이 3~5개 있을 때 사용해야한다.
        layout resource file을 아래와 같이 설정하여 BottomNavigationView를 사용한다.
        
        ```jsx
         
         <com.google.android.material.bottomnavigation.BottomNavigationView
             xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:app="http://schema.android.com/apk/res/res-auto"
             android:id="@+id/navigation"
             android:layout_width="match_parent"
             android:layout_height="56dp"
             android:layout_gravity="start"
             app:menu="@menu/my_navigation_items" />
        
         res/menu/my_navigation_items.xml:
         <menu xmlns:android="http://schemas.android.com/apk/res/android">
             <item android:id="@+id/action_search"
                  android:title="@string/menu_search"
                  android:icon="@drawable/ic_search" />
             <item android:id="@+id/action_settings"
                  android:title="@string/menu_settings"
                  android:icon="@drawable/ic_add" />
             <item android:id="@+id/action_navigation"
                  android:title="@string/menu_navigation"
                  android:icon="@drawable/ic_action_navigation_menu" />
         </menu>
        ```
        
    - BottomNavigationView가 사용된 예시에는 무엇이 있을까요?
        
        당근마켓의 메뉴바, 카카오톡의 메뉴바 등에 BottomNavigationView가 사용된다.
        
- BottomNavigationView의 구성 요소
    - BottomNavigationView를 사용하려면 레이아웃에 추가를 해야합니다. 이 때 어떤 값들이 필수적으로 지정되어야 할까요?
        
        menu resource 파일을 만들어 주고, menu 안에 item을 설정해주어야 한다.
        
    - Menu 리소스 XML
        - <menu> 태그는 무엇일까요? : BottomNavigationView에 나타나는 아이템들을 설정하는 역할을 한다.
        - <item> 태그는 무엇일까요? : menu의 개별 항목을 정의한다.
        - <item> 태그에 설정할 수 있는 항목에는 무엇이 있을까요? : id, title, icon 등을 사용할 수 있다.
    - 확인하기
        - 화면 구성
            
            ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/5e7d7daf-2be7-4c50-9b93-216549b3e561/3cf80661-4cea-48b2-b1b8-a432b34028db/Untitled.png)
            
            1. 왼쪽의 예시 화면에서 (A)와 (B)에 해당하는 각각의 알맞은 **화면 구성 요소**를 선택해주세요!
                - (A) = Activity
                - (B) = Fragment
            2. 왼쪽 화면을 구성하기 위해서 일반적으로 몇 개의 Fragment가 필요한가요??
                - 정답 ) _____4____ 개
- BottomNavigationView 설정하기
    - 각 Item을 클릭했을 때 나타나는 이벤트 설정하기
        1. 리소스 파일에서 메뉴 아이템 정의하기 : 먼저, res/menu/ 디렉토리에 XML 파일을 생성하고,
        여기에 BottomNavigationView에 사용될 메뉴 아이템을 정의한다.
        
        ```jsx
        
        <menu xmlns:android="http://schemas.android.com/apk/res/android">
            <item
                android:id="@+id/navigation_home"
                android:icon="@drawable/ic_home"
                android:title="@string/title_home" />
            <item
                android:id="@+id/navigation_dashboard"
                android:icon="@drawable/ic_dashboard"
                android:title="@string/title_dashboard" />
            <item
                android:id="@+id/navigation_notifications"
                android:icon="@drawable/ic_notifications"
                android:title="@string/title_notifications" />
        </menu>
        
        ```
        
        1. XML 레이아웃 파일에 BottomNavigationView 추가하기 : 레이아웃 XML 파일에 BottomNavigationView를 추가한다.
        
        ```jsx
        
        <com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/navigation"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            app:menu="@menu/navigation_menu" />
        
        ```
        
        1. 액티비티에서 리스너 구현하기 : BottomNavigationView를 찾아서 OnNavigationItemSelectedListener를 설정한다.
        
        ```jsx
        
        val navView: BottomNavigationView = findViewById(R.id.navigation)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // 홈 아이템 클릭 시 로직
                    true
                }
                R.id.navigation_dashboard -> {
                    // 대시보드 아이템 클릭 시 로직
                    true
                }
                R.id.navigation_notifications -> {
                    // 알림 아이템 클릭 시 로직
                    true
                }
                else -> false
            }
        }
        
        ```
        
    - BottomNavigationView의 주요 속성들을 정리해 주세요!
        1. **`app:menu`**:  BottomNavigationView에 사용될 메뉴를 정의하는 XML 파일을 지정한다. 이 메뉴 파일은 하단 네비게이션에 표시될 아이템들을 포함한다.
        2. **`android:background`**: 네비게이션 바의 배경 색상을 설정한다.
        3. **`app:itemIconTint`**: 아이템 아이콘의 색상을 조절하는데 사용된다. 색상 상태 리스트를 사용하여 선택되었을 때와 그렇지 않을 때의 색상을 다르게 설정할 수 있다.
        4. **`app:itemTextColor`**: 아이템 텍스트의 색상을 설정한다. 이 역시 선택된 상태와 그렇지 않은 상태의 색상을 구분할 수 있다.
        5. **`app:itemBackground`**: 각 탭 아이템의 배경을 설정할 수 있다.
        6. **`app:labelVisibilityMode`**: 탭의 레이블 표시 모드를 설정한다. 예를 들어, labeled는 모든 탭에 레이블을 표시하고, unlabled는 아이콘만 표시한다.
        7. **`app:selectedItemId`**: 초기에 선택될 아이템의 ID를 지정할 수 있다.
        
        
- TabLayout
    - TabLayout이란 무엇이고, 어떤 기능을 할까요?
        
        HorizontalScrollView를 상속받아서, 수평으로 Tab을 보여주는 Layout이다.
        주로 ViewPager2와 연결하여 사용하며, 현재페이지를 나타내는 역할을 한다. 
        
    - TabLayout이 사용된 예시에는 무엇이 있을까요?
        
        카카오톡에서 사진을 여러장 묶어서 보내고, 그 사진을 확인할 때 ViewPager와 TabLayout이 결합된 형태를 확인할 수 있다.
        
    - TabLayout에서 사용할 수 있는 속성들은 무엇이 있을까요?
        - app:tabIndicatorColor="색상”
        ⇒ 밑줄 색상을 나타낸다.
        - app:tabIndicatorHeight="3dp”
        ⇒ 밑줄 두께를 나타낸다.
        - app:tabIndicatorGravity="top | center | bottom | stretch”
        ⇒ 밑줄 위치를 나타낸다.
        - app:tabGravity="fill”
        ⇒ Tab 전체 너비를 설정한다.
        - app:tabRippleColor="@android:color/transparent”
        ⇒ Tab 클릭 시 색 변화를 설정한다.
        - android:icon="@drawable/아이콘”
        ⇒ TabItem의 아이콘을 설정한다.
        
        ```jsx
        <com.google.android.material.tabs.TabLayout
            android:id="@+id/tabLayout"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
        		app:tabIndicatorColor="색상"
        		app:tabIndicatorHeight="3dp"
        		app:tabIndicatorGravity="top | center | bottom | stretch"
        		app:tabGravity="fill"
        		app:tabRippleColor="@android:color/transparent"
        		>
        
            <com.google.android.material.tabs.TabItem
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Monday" 
        				android:icon="@drawable/아이콘"/>
        
            <com.google.android.material.tabs.TabItem
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Tuesday" />
        
            <com.google.android.material.tabs.TabItem
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Wednesday" />
        
        </com.google.android.material.tabs.TabLayout>
        ```
        

[]()

[]()

[]()

[]()

[]()

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/5e7d7daf-2be7-4c50-9b93-216549b3e561/383ada82-c279-4629-9ecf-3c2847140932/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/5e7d7daf-2be7-4c50-9b93-216549b3e561/00180da7-c15c-4d3e-a71d-103d34c44ace/Untitled.png)

- ViewPager2
    - ViewPager란 무엇이고, 어떤 기능을 할까요?
        - ViewPager는 좌우 스크롤을 통해서 화면을 넘겨볼 수 있는 기능을 제공한다.
        부분 화면 여러 개를 변환하여 보여주기 때문에 Fragment를 이용하여 구현해야한다.
        - ViewPager는 콘텐츠가 있는 다양한 View를 스와이프하는 것을 제어할 수 있다.
        - ViewPager는 PagerAdapter를 상속해서 구현하도록 하는 Adapter 패턴으로 이루어져있다.
        - PagerAdapter는 추상 Class이기 때문에 PagerAdapter를 상속해서 사용해야 한다.
    - ViewPager가 사용된 예시에는 무엇이 있을까요?
        
        KREAM, Melon 앱 등에서 페이지 간 이동 시 확인할 수 있다.
        
    - ViewPager와 ViewPager2의 차이는 무엇일까요?
        
        ViewPager는 좌우 스크롤, FragmentStatePagerAdapter, PagerAdapter, addPageChangeListener()를 사용한다.
        ViewPager2는 상하 좌우 스크롤, FragmentStateAdapter, RecyclerView.Adapter, registerOnpageCallback()을 사용한다.
        ViewPager2는 수정이 가능한 fragment collection의 페이징을 지원하고 collection이 변경될 때 UI를 업데이트하도록 notifyDatasetChanged를 호출한다.
        
    - ViewPager2에서 사용할 수 있는 속성들은 무엇이 있을까요?
        
        ```jsx
        <androidx.viewpager2.widget.ViewPager2
            xmlns:android="http://schemas.android.com/apk/res/android"
            android:id="@+id/pager"
            android:layout_width="match_parent"
            android:layout_height="match_parent" 
        		**android:orientation="vertical"
        		android:layoutDirection="rtl"**/>
        ```
        
        - android:orientation ⇒ 페이징 방향 설정 (상하, 좌우)
        - android:layoutDirection ⇒ RTL 페이징 수동 설정 가능
- ViewPager2 설정하기
    - ViewPager2를 이용하기 위해 어떤 라이브러리를 사용해야 할까요?
        - XML에 들어가야 하는 속성도 작성
    - ViewPager2에서 FragmentStateAdapter는 무엇이고 어떤 기능을 할까요?
        
        FragmentStateAdapter는 페이지 간 네비게이션을 관리하는 중요한 컴포넌트 중 하나이다.
        
        1. 프래그먼트 관리: FragmentStateAdapter는 각 페이지와 연결된 프래그먼트의 인스턴스를 생성하고 관리한다. 사용자가 페이지를 넘길 때, 어댑터는 필요한 프래그먼트를 제공하고, 더 이상 필요하지 않은 프래그먼트의 상태를 저장하거나 복원한다.
        2. 효율적인 메모리 관리: FragmentStateAdapter는 이름에서 알 수 있듯이 상태를 저장하는 방식으로 작동한다. 이는 스크롤하는 동안 사용하지 않는 프래그먼트를 메모리에서 제거하고, 필요할 때 다시 생성할 수 있게 한다. 이 방식은 메모리 사용을 최적화하고, 특히 많은 수의 페이지를 다룰 때 유용하다.
        3. 수명주기 존중: 어댑터는 프래그먼트의 수명 주기를 보장한다. 이는 ViewPager2 페이지 내의 프래그먼트가 활성화되거나 비활성화될 때 적절한 수명 주기 이벤트가 트리거되도록 보장한다.
- ViewPager2를 이용하기 위해 어떤 라이브러리를 사용해야 할까요?
    - Indicator란 무엇이고, 어떤 역할을 할까요?
        
        ViewPager2 의 페이지 상태를 나타낸다. 현재 페이지 및 페이지의 위치 파악 등에 사용된다.
        
    - ViewPager2에서 Indicator를 설정하려면 어떻게 해야할까요?
        - TabLayout을 통해 TabLayoutMediator로 ViewPager와 연결한다.
        - Custom Indicator를 통해 registerOnPageChangeCallback으로 ViewPager와 연결한다.

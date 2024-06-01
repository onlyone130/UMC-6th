- Database (DB)
    - Database의 정의는 무엇일까요?
    데이터를 어딘가에 쌓아 두고 보관하며 필요할 때마다 추가하거나 조회, 수정, 삭제할 수 있는 장소이다.
    - Database는 어디서 주로 사용될까요?
    은행시스템, 비행기 티켓 예매 시스템, CRM, EMR, e-커머스 등에 사용된다.
- Database Management System (DBMS)
    - DBMS란 무엇일까요?
    데이터의 저장, 관리, 검색, 업데이트 및 삭제할 수 있는 소프트웨어 시스템이다. DBMS는 데이터베이스의 일관성, 무결성, 보안 및 복구 기능을 제공하며, 여러 사용자와 응용 프로그램이 데이터를 효율적으로 사용할 수 있도록 한다.
    - 대표적인 DBMS는 무엇이 있을까요?
    MySQL, PostgreSQL, Oracle Database, Microsoft SQL Server, SQLite, MongoDB 등이 있다.
    - 관계형 저장 방식은 무엇일까요?
    데이터를 테이블 형식으로 저장하는 방식을 말한다. 각 테이블은 행(row)과 열(column)로 구성되며, 데이터는 행에 저장된다. 테이블 간의 관계를 설정하여 데이터를 효율적으로 관리할 수 있다.
    - 관계형이 아닌 저장 방식에는 무엇이 있을까요?
        - 키-값 저장소 (Key-Value Store) : 데이터가 키-값 쌍으로 저장된다.
        Redis, DynamoDB
        - 문서 지향 저장소 (Document Store) : 데이터가 JSON, BSON과 같은 문서 형태로 저장된다.
        MongoDB, CouchDB
        - 칼럼 지향 저장소 (Column-Family Store) : 데이터가 열 단위로 저장된다.
        Cassandra, HBase
        - 그래프 데이터베이스 (Graph Database) : 데이터가 노드와 간선으로 표현되는 구조로 저장된다.
        Neo4j, ArangoDB
    - SQL이란 무엇일까요?
        1. DDL(Data Definition Language)
        데이터베이스의 구조를 정의하는 언어이다. (CREATE, ALTER, DROP 등)
        2. DML(Data Manipulation Language)
        데이터베이스 내의 데이터를 조작하는 언어이다. (SELECT, INSERT, UPDATE, DELETE)
        3. ~~DCL(Data Control Language)~~
- Key-Value 구조
    - Java나 Kotlin에서 Key-Value를 사용하는 대표적인 자료 구조는 무엇인가요?
    맵 (Map)이다. 맵은 키(key)와 값(value)의 쌍으로 데이터를 저장하며, 각 키는 고유해야 한다. java와 kotlin에서 자주 사용하는 맵 자료 구조는 아래와 같다.
    
    Java에서의 Map
    HashMap, TreeMap, LinkedHashMap 등이 Map 인터페이스를 구현하는 클래스이다.
    
    HashMap 사용 예시
        
        ```jsx
        import java.util.HashMap;
        import java.util.Map;
        
        public class Main {
            public static void main(String[] args) {
                Map<String, String> map = new HashMap<>();
                map.put("key1", "value1");
                map.put("key2", "value2");
                map.put("key3", "value3");
        
                // 값 접근
                String value1 = map.get("key1");
                System.out.println("key1의 값: " + value1);
        
                // 키-값 쌍 출력
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
        
        ```
        
        Kotlin에서의 Map
        기본적으로 불변형(immutable)으로 제공되며, HashMap, mutableMapOf 등을 사용하여 가변형(mutable) 맵을 생성 가능하다.
        
        불변형 Map 사용
        
        ```jsx
        fun main() {
            val map = mapOf("key1" to "value1", "key2" to "value2", "key3" to "value3")
        
            // 값 접근
            val value1 = map["key1"]
            println("key1의 값: $value1")
        
            // 키-값 쌍 출력
            for ((key, value) in map) {
                println("$key: $value")
            }
        }
        
        ```
        
        가변형 Map 사용
        
        ```jsx
        fun main() {
            val mutableMap = mutableMapOf("key1" to "value1", "key2" to "value2", "key3" to "value3")
        
            // 값 추가
            mutableMap["key4"] = "value4"
        
            // 값 접근
            val value1 = mutableMap["key1"]
            println("key1의 값: $value1")
        
            // 키-값 쌍 출력
            for ((key, value) in mutableMap) {
                println("$key: $value")
            }
        }
        
        ```
        
    - 해당 구조의 특징에는 무엇이 있을까요?
    
    ### **HashMap**
    
    - **구현**: 해시 테이블을 기반으로 한 **`Map`** 구현체이다.
    - **특징**:
        - **빠른 검색 속도**: 키를 기반으로 한 O(1) 시간 복잡도로 상수 시간에 값을 검색, 삽입, 삭제할 수 있다.
        - **순서 보장 없음**: 입력 순서가 보장되지 않는다. 데이터가 입력된 순서와 상관없이 해시 값을 기준으로 저장된다.
        - **null 허용**: 하나의 **`null`** 키와 다수의 **`null`** 값을 허용한다.
        - **비동기적**: 동기화되지 않으며, 여러 스레드에서 안전하게 사용할 수 없다. 멀티스레드 환경에서는 **`Collections.synchronizedMap`**으로 동기화하거나 **`ConcurrentHashMap`**을 사용하는 것이 좋다.
    
    ### **TreeMap**
    
    - **구현**: 레드-블랙 트리(Red-Black Tree)를 기반으로 한 **`Map`** 구현체이다.
    - **특징**:
        - **정렬된 순서**: 키의 자연 순서 또는 생성 시 제공된 비교기(Comparator)에 따라 정렬된 순서로 키-값 쌍을 저장한다.
        - **시간 복잡도**: 검색, 삽입, 삭제의 시간 복잡도는 O(log n)이다.
        - **범위 조회**: **`subMap`**, **`headMap`**, **`tailMap`** 같은 범위 검색을 위한 메서드를 제공한다.
        - **null 키 허용 안됨**: 키는 null을 허용하지 않는다. 값은 null을 허용한다.
    
    ### **LinkedHashMap**
    
    - **구현**: 이중 연결 리스트와 해시 테이블을 조합한 **`Map`** 구현체이다.
    - **특징**:
        - **입력 순서 유지**: 입력된 순서대로 요소를 저장하고 반복할 때도 그 순서를 유지한다.
        - **시간 복잡도**: **`HashMap`**과 동일하게 O(1)의 시간 복잡도로 검색, 삽입, 삭제가 가능하다.
        - **예측 가능한 반복 순서**: 반복 시 입력 순서나 액세스 순서에 따라 예측 가능한 순서를 제공한다.
        - **null 허용**: 하나의 **`null`** 키와 다수의 **`null`** 값을 허용한다.
    
    ### **공통 특징**
    
    - **키와 값**: 모든 **`Map`** 구현체는 고유한 키와 키에 매핑된 값을 저장한다.
    - **무결성**: 키는 고유해야 하며, 동일한 키가 다시 추가되면 기존 키-값 쌍을 덮어쓴다.
    - **Generic 지원**: 제네릭을 지원하여 타입 안전성을 보장한다.
    
    Java 예시: HashMap, TreeMap, LinkedHashMap
    
    ```jsx
    import java.util.HashMap;
    import java.util.TreeMap;
    import java.util.LinkedHashMap;
    import java.util.Map;
    
    public class Main {
        public static void main(String[] args) {
            Map<String, String> hashMap = new HashMap<>();
            Map<String, String> treeMap = new TreeMap<>();
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
    
            // 데이터 추가
            hashMap.put("a", "apple");
            treeMap.put("a", "apple");
            linkedHashMap.put("a", "apple");
    
            hashMap.put("b", "banana");
            treeMap.put("b", "banana");
            linkedHashMap.put("b", "banana");
    
            // 데이터 출력
            System.out.println("HashMap: " + hashMap);
            System.out.println("TreeMap: " + treeMap);
            System.out.println("LinkedHashMap: " + linkedHashMap);
        }
    }
    
    ```
    
    Kotlin 예시: mutableMapOf
    
    ```jsx
    fun main() {
        val hashMap: MutableMap<String, String> = hashMapOf("a" to "apple", "b" to "banana")
        val treeMap: MutableMap<String, String> = sortedMapOf("a" to "apple", "b" to "banana")
        val linkedHashMap: MutableMap<String, String> = linkedMapOf("a" to "apple", "b" to "banana")
    
        // 데이터 추가
        hashMap["c"] = "cherry"
        treeMap["c"] = "cherry"
        linkedHashMap["c"] = "cherry"
    
        // 데이터 출력
        println("HashMap: $hashMap")
        println("TreeMap: $treeMap")
        println("LinkedHashMap: $linkedHashMap")
    }
    
    ```
    
    - 배열이나 리스트가 아닌 경우 하나의 Key에 여러 값을 넣을 수 있을까요?
    1. Set을 사용 : HashSet, TreeSet, LinkedHashSet 등을 사용하여 중복되지 않은 값을 저장할 수 있다.
    2. Map을 사용하여 Map이나 Set을 값으로 사용 : 복합 자료 구조를 사용하여 키에 여러 값을 저장할 수 있다.
- SharedPreferences
    - 하나의 Key에 여러 값을 넣는 방법이 있을까요? (Hint: JSON)
    SharedPreferences는 기본적으로 문자열, 정수, 부울 값 등 단순한 데이터를 저장하는데에 사용된다. 하나의 key에 여러 값을 저장하려면 JSON 형식을 사용하여 데이터를 문자열로 직렬화하여 저장할 수 있다. 저장된 JSON 문자열은 나중에 다시 복원하여 여러 값으로 사용할 수 있다.
    
    여러 문자열을 하나의 key에 저장하는 방법
    
    ```jsx
    import android.content.Context
    import android.content.SharedPreferences
    import org.json.JSONArray
    
    fun saveValues(context: Context, key: String, values: List<String>) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
    
        // JSON 배열로 변환
        val jsonArray = JSONArray()
        for (value in values) {
            jsonArray.put(value)
        }
        // JSON 배열을 문자열로 변환하여 저장
        editor.putString(key, jsonArray.toString())
        editor.apply()
    }
    
    ```
    
- RoomDB
    - RoomDB는 무엇일까요?
    안드로이드에서 앱의 데이터를 저장하는 방법은 파일, 데이터베이스, 프리퍼런스로 나뉜다. 그 중 데이터 베이스 프로그래밍을 이용항 안드로이드 폰에서 DB를 관리하는 오픈소스 SQLite 가 있다.
    Room은 SQLite를 완벽히 활용하면서 원활한 데이터베이스 액세스가 가능하도록 SQLite에 추상화 계층을 제공한다.
    - RoomDB 개발 이전에 사용하였고, 현재 RoomDB의 기반인 DBMS는 무엇일까요?
    SQLite이다.
        - **SQLite**는 C 언어로 작성된 경량의 관계형 데이터베이스 관리 시스템이다.
        - **내장형 데이터베이스**: 안드로이드 플랫폼에 기본적으로 포함되어 있으며, 별도의 서버 설정 없이 앱 내부에 데이터베이스를 포함할 수 있다.
        - **SQL 쿼리 사용**: 데이터를 조작하기 위해 SQL(Structured Query Language)을 사용한다.
        - **간편한 사용**: 작은 메모리 사용량과 디스크 공간 사용량으로 모바일 환경에 적합하다.
        - **단일 파일 기반**: 모든 데이터베이스 객체(테이블, 인덱스, 트리거 등)를 단일 파일에 저장한다.
    - RoomDB는 어떤 방식으로 값을 저장할까요?
        1. 엔티티(Entity):
        -Room에서는 데이터베이스 테이블을 나타내는 클래스이다. 각 엔티티 클래스는 테이블의 구조를 정의하며, 클래스의 각 필드는 테이블의 열을 나타낸다.
        -**`@Entity`** 어노테이션을 사용하여 클래스를 엔티티로 정의한다.
        2. DAO (Data Access Object):
        -데이터베이스 작업(쿼리, 삽입, 업데이트, 삭제)을 정의하는 인터페이스 또는 추상 클래스이다.
        -**`@Dao`** 어노테이션을 사용하여 DAO를 정의하고, 각 메서드에 **`@Insert`**, **`@Update`**, **`@Delete`**, **`@Query`** 등의 어노테이션을 사용하여 데이터베이스 작업을 정의한다.
        3. 데이터베이스 클래스:
        -Room 데이터베이스의 메인 접근 지점을 제공하는 추상 클래스이다.
        -**`@Database`** 어노테이션을 사용하여 데이터베이스를 정의하고, 엔티티와 DAO를 연결한다.
- Firebase
    - Firebase는 무엇이고 왜 사용할까요?
    Firebase는 Google에서 제공하는 모바일 및 웹 애플리케이션 개발 플랫폼이다. 개발자가 애플리케이션을 더 빠르고 쉽게 구축하고, 확장 가능하며, 높은 품질의 앱을 개발할 수 있도록 다양한 도구와 서비스를 제공한다. Firebase는 서버리스 환경을 제공하며 백엔드 인프라를 관리할 필요없이 애플리케이션 로직에 집중할 수 있게 한다.
        
        **Firebase를 사용하는 이유**:
        
        1. **빠른 개발 속도**: Firebase는 다양한 백엔드 서비스 (인증, 데이터베이스, 저장소 등)를 제공하여 서버 설정과 관리를 줄여주고, 개발 속도를 높여준다.
        2. **실시간 데이터베이스**: Firebase Realtime Database와 Firestore를 통해 클라이언트 간의 데이터 동기화와 실시간 업데이트가 가능하다.
        3. **확장성**: Firebase의 인프라는 구글 클라우드 플랫폼을 기반으로 하며, 애플리케이션이 성장함에 따라 확장할 수 있는 유연성을 제공한다.
        4. **통합 서비스**: 분석, 광고, 푸시 알림 등 다양한 서비스를 통합하여 하나의 플랫폼에서 관리할 수 있다.
        5. **크로스 플랫폼**: iOS, Android, 웹 애플리케이션 모두에서 Firebase를 사용할 수 있다.
    - Firebase에서 제공해주는 기능은 어떤 것이 있나요?
        1. **인증(Authentication)**:
            - 이메일 및 비밀번호, 전화번호, 소셜 로그인을 통한 사용자 인증을 지원한다.
            - OAuth 제공자 (Google, Facebook, Twitter 등)와 통합할 수 있다.
        2. **실시간 데이터베이스(Realtime Database)**:
            - JSON 형식으로 데이터를 실시간으로 저장하고 동기화할 수 있는 NoSQL 데이터베이스이다.
            - 클라이언트 간의 데이터 동기화를 자동으로 관리한다.
        3. **Cloud Firestore**:
            - 확장 가능한 유연한 NoSQL 데이터베이스로, 실시간 동기화와 오프라인 데이터 액세스를 제공한다.
            - 더 풍부한 쿼리 기능과 데이터 구조를 지원한다.
        4. **Cloud Storage**:
            - 이미지, 동영상 등 대용량 파일을 저장할 수 있는 클라우드 스토리지 서비스이다.
            - Firebase SDK를 통해 파일 업로드와 다운로드를 쉽게 구현할 수 있다.
        5. **Firebase 호스팅(Hosting)**:
            - 정적 웹 콘텐츠 및 동적 콘텐츠를 위한 고성능 호스팅을 제공한다.
            - 간단한 명령어로 배포하고, SSL 인증서를 자동으로 관리한다.
        6. **Cloud Functions**:
            - 서버 없이 백엔드 코드를 실행할 수 있는 함수이다.
            - Firebase 이벤트 또는 HTTP 요청에 응답하여 코드를 실행할 수 있다.
        7. **Firebase 애널리틱스(Analytics)**:
            - 사용자 행동을 추적하고 분석할 수 있는 무료 애널리틱스 솔루션이다.
            - 맞춤 이벤트를 설정하여 다양한 사용자 데이터를 수집하고 분석할 수 있다.
        8. **Cloud Messaging**:
            - 푸시 알림을 전송할 수 있는 서비스이다.
            - 사용자에게 맞춤형 메시지를 실시간으로 보낼 수 있다.
        9. **Remote Config**:
            - 애플리케이션을 업데이트하지 않고도 앱의 동작과 모양을 변경할 수 있는 기능이다.
            - A/B 테스트를 통해 최적의 사용자 경험을 제공한다.
        10. **Firebase Test Lab**:
            - 다양한 실제 기기에서 앱을 테스트할 수 있는 클라우드 기반 테스트 환경을 제공한다.
        11. **Firebase Crashlytics**:
            - 실시간 충돌 보고서를 제공하여 앱의 안정성을 높이고 문제를 신속하게 해결할 수 있도록 도와준다.

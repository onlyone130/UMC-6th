- Thread
    - Thread란 무엇일까요?
    프로세스 내부에서 일을 하는 주체이다. 프로세스의 실행 흐름을 읽는 것들이 Thread이다.
    - Thread를 사용하는 예시는 무엇이 있을까요?
    네트워크에서 데이터를 다운로드하는 예시 코드이다.
    
    ```jsx
    
    import android.os.Bundle
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    
    class MainActivity : AppCompatActivity() {
        private lateinit var textView: TextView
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            textView = findViewById(R.id.text_view)
    
            val downloadThread = Thread {
                val data = downloadData()
                runOnUiThread {
                    textView.text = data
                }
            }
            downloadThread.start()
        }
    
        private fun downloadData(): String {
            // 여기에서 데이터 다운로드 로직을 구현하세요.
            return "Downloaded data"
        }
    }
    
    ```
    
- Main Thread와 Worker Thread
    - View Control을 담당하는 Thread는 무엇일까요?
    Main Thread이고 이는 안드로이드 os에서 자동으로 만들어주는 스레드이다.
    - Worker Thread는 어떤 작업을 담당할까요?
    백그라운드에서 처리하는 작업들이 많아 백그라운드 Thread라고도 불린다.
    애플리케이션의 성능을 향상시키기 위해 Thread를 생성하여 Network 작업, DB 쿼리와 같은 시간이 오래 걸리는 작업들을 주로 처리한다.
- Single Thread와 Multi Thread
    - Single-Thread란 무엇일까요?
    안드로이드는 기본적으로 하나의 main thread를 가지고 있는데, 이를 single-Thread라고 부른다.
    동작의 무결성을 보장하기 위해서 싱글 스레드를 사용한다.
    단일 스레드 환경에서 작업을 실행하는 것은 작업의 복잡성을 줄이고, 데이터 경쟁이나 데드락과 같은 문제를 방지할 수도 있다. 안드로이드와 같이 리소스가 제한된 환경에서는 너무 많은 스레드를 사용하면 오베허드가 발생하여 성능이 저하될 수 있기 때문에 단일 스레드가 멀티스레드보다 더 좋은 경우도 있다.
    - Multi-Thread란 무엇일까요?
    여러 흐름을 동시에 사용하는 것을 말한다.
    실제로 여러 일을 동시에 하는 것이 아니라 하는 작업을 계속 바꾸면서 진행한다. 그렇지만 실제로 작업이 바뀌면서 지연되는 것은 아니다.
- 동기와 비동기
    - 동기란 무엇일까요?
    요청이 들어오면 순차적으로 작업을 수행하고, 해당 작업이 수행중이면 다른 작업은 대기한다.
    우리가 일반적으로 작성하는 코드들을 말한다. 
    작업이 들어온 순서대로 결과가 도출된다.
    요청을 하면 그 즉시 작업을 수행해서 결과를 보여주어야 한다.
    - 비동기란 무엇일까요?
    요청이 들어오면 해당 요청에 의한 작업이 끝나지 않았다 하더라도 계속 요청을 받는다. 작업이 끝났다는 이벤트가 오면 해당 요청을 처리한다는 특징이 있다.
    통신과 같이 시간이 오래 걸리는 작업에서 주로 사용한다.
    작업이 들어온 순서와 상관없이 결과가 도출된다.
    도출된 결과는 callback 함수로 보내고, 요청을 해도 그 작업이 바로 실행된다는 보장은 없다.
    - 동기와 비동기 각각의 장단점은 무엇이 있을까요?
    동기) 장점 : 원하는 일을 순차적으로 진행할 수 있다.
             단점 : 하던 일을 끝내고 결과가 나올 때까지 다른 일을 하지 못한다.
    비동기) 장점 : 여러가지 작업을 동시에 진행해야 할 때 사용 가능하다.
                단점 : 동기에 비해서 작업들을 관리하는데에 복잡함이 있다.
    - 동기와 비동기를 사용하는 예시에는 무엇이 있을까요?
    동기 : 안드로이드 앱에서 파일 시스템으로부터 텍스트 데이터를 동기적으로 읽어오는 과정 예시
    
    ```jsx
    
    import android.os.Bundle
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import java.io.File
    
    class MainActivity : AppCompatActivity() {
        private lateinit var textView: TextView
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            textView = findViewById(R.id.text_view)
    
            try {
                val data = readDataFromFile("data.txt")
                textView.text = data
            } catch (e: Exception) {
                textView.text = "Error reading data"
            }
        }
    
        private fun readDataFromFile(filename: String): String {
            val file = File(filesDir, filename)
            return file.readText()
        }
    }
    
    ```
    
          비동기 : 데이터를 비동기적으로 다운로드하고 UI를 업데이트하는 예시
    
    ```jsx
    
    import android.os.AsyncTask
    import android.os.Bundle
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    
    class MainActivity : AppCompatActivity() {
        private lateinit var textView: TextView
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            textView = findViewById(R.id.text_view)
            DownloadTask().execute("http://example.com/data")
        }
    
        private inner class DownloadTask : AsyncTask<String, Void, String>() {
            override fun doInBackground(vararg urls: String?): String {
                return downloadDataFromNetwork(urls[0])
            }
    
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                textView.text = result
            }
    
            private fun downloadDataFromNetwork(url: String?): String {
                // 실제 데이터 다운로드 로직을 구현하세요.
                return "Downloaded content from $url"
            }
        }
    }
    
    ```
    
- Handler
    - Android에서 Handler란 무엇일까요?
    Thread의 작업을 관리하고, Thread 간 작업을 전달하는 역할을 하는 클래스이다.
    - Handler를 사용하는 이유는 무엇일까요?
    Android에서 화면 UI에 접근하려면 main thread에서 실행되어야하기 때문에 new thread의 작업 진행 상황을 main thread로 전달하여 UI에 표시하기 위해서 handler를 통해 통신을 수행하여 해결한다.
    - Handler의 Message란 무엇일까요?
    MessageQueue는 안드로이드에서 메시지를 보관하는 큐 구조체이다. FIFO 방식으로 동작하고, looper가 loop을 돌면서 메시지 큐에서 메시지를 가져와 출력한다.
    MessageQueue는 handler에 의해 사용되고, handler는 sendMessage(), post(), postDelayed()와 같은 메소드를 사용하여 메시지를 보내고, 해당 메시지는 메시지 큐에 보관된다.
    메시지큐에서 메시지를 가져와서 처리하면 해당 메시지는 메시지큐에서 제거된다.
    - Handler를 사용하는 예시에는 무엇이 있을까요?
    타이머실행, 일정 간격으로 반복적으로 실행되어야하는 작업을 스케줄링할 때 Handler를 사용한다.
    
    일정 시간 후에 UI를 업데이트하는 예시
    Handler를 사용하여 Runnable을 5초 후에 실행하도록 예약한다. Runnable 내부에서는 TextView의 텍스트를 업데이트하는데, 이러한 작업은 메인 스레드에서 수행해야하기 때문에 Looper.getMainLooper()를 통해서 메인 스레드의 Looper를 사용하여 Handler를 생성한다.
    
    ```jsx
    
    import android.os.Bundle
    import android.os.Handler
    import android.os.Looper
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    
    class MainActivity : AppCompatActivity() {
        private lateinit var textView: TextView
        private lateinit var handler: Handler
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            textView = findViewById(R.id.text_view)
    
            // 메인 스레드의 Looper를 사용하여 Handler 인스턴스를 생성합니다.
            handler = Handler(Looper.getMainLooper())
    
            // Runnable 객체를 생성하고, Handler를 통해 5초(5000ms) 후에 실행하도록 합니다.
            val updateTextRunnable = Runnable {
                textView.text = "Updated after 5 seconds"
            }
            handler.postDelayed(updateTextRunnable, 5000)
        }
    }
    
    ```
    
- Looper
    - Android에서 Looper란 무엇일까요?
    Message Queue를 생성하고 관리하는 역할로 Message나 Runnable 객체를 하나씩 꺼내서 Handler에 전달한다. Looper 클래스와 Message Queue로 인해 UI 경쟁상태를 방지할 수 있다. Looper.loop() 매소드 내부에서 무한루프를 돌면서 Message Queue를 확인하여 하나씩 처리하게 된다.
    - Looper를 활용하는 예시는 무엇이 있을까요?
    Handler와 마찬가지로 타이머 똔느 주기적인 작업을 수행할 할 때에도 Looper를 사용한다.
    
    ```jsx
    
      public static void loop() {
              final Looper me = myLooper();
              if (me == null) {
                  throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
              }
              final MessageQueue queue = me.mQueue;
    
              // Make sure the identity of this thread is that of the local process,
              // and keep track of what that identity token actually is.
              Binder.clearCallingIdentity();
              final long ident = Binder.clearCallingIdentity();
    
              // Allow overriding a threshold with a system prop. e.g.
              // adb shell 'setprop log.looper.1000.main.slow 1 && stop && start'
              final int thresholdOverride =
                      SystemProperties.getInt("log.looper."
                              + Process.myUid() + "."
                              + Thread.currentThread().getName()
                              + ".slow", 0);
    
              boolean slowDeliveryDetected = false;
    
              for (;;) {
                  Message msg = queue.next(); // might block
                  if (msg == null) {
                      // No message indicates that the message queue is quitting.
                      return;
                  }
    
                  ...
    
                  try {
                      msg.target.dispatchMessage(msg);
                      if (observer != null) {
                          observer.messageDispatched(token, msg);
                      }
                      dispatchEnd = needEndTime ? SystemClock.uptimeMillis() : 0;
                  }
              }
              ...
       }
    ```
    
- Coroutine
    - Coroutine이란 무엇일까요?
     비동기 경량 스레드이다.
    ”co : 함께” + “routine : 작업 처리단위” = “Coroutine : 어떤 작업을 함께 처리한다.”
    비동기 처리 방식과 같고, 일반적인 스레드는 자유롭게 제어가 힘들고 구현도 복잡하다. 그렇지만 코루틴은 가볍고 많은 기능을 제공한다.
    코루틴은 스레드풀을 생성하지만 직접 제어하지는 않고 오직 Dispatcher를 통해서만 제어가 가능하다.
    - Coroutine은 언제 사용할까요?
    안드로이드 앱에서는 네트워크 호출, 파일 다운로드, 데이터베이스 쿼리 등과 같은 비동기적인 작업을 수행해야 하는 경우가 많다. 위와 같은 작업은 UI 스레드에서 수행할 경우에 앱의 성능에 영향을 미칠 수 있기 때문에 백그라운드 스레드에서 실행해야한다. Coroutine은 이러한 작업을 보다 쉽고 간결하게 처리할 수 있도록 도와준다.
    - Coroutine의 Dispatcher란 무엇일까요?
    코루틴 처리를 어떻게 할 것인지에 대한 요소들의 집합인 CoroutineContext의 두가지 요소 중 하나이다. CoroutineContext에는 Dispatcher와 Job(생성된 코루틴을 컨트롤하고, 생명 주기나 부모자식 관게 정리 및 관리하는 역할을 담당)이 있다.
    코루틴을 시작하거나 재개할 스레드를 결정하기 위한 도구이다.
    코루틴을 스레드에 배분하고, 스레드를 풀어서 스레드 하나에 할당해서 코루틴을 배당한다.
    모든 Dispatcher는 CoroutineDispatcher 인터페이스를 구현해야 한다.
    - Dispatcher의 종류에는 무엇이 있을까요?
    -Dispatchers.Main
     : Android Main(UI) Thread에서 Coroutine을 실행하는 Dispatcher로,
      반드시 UI와 상호작용을 하기 위해서만 사용한다.
    -Dispatchers.IO
     : File Input/Output, Network IO, Parser 작업에 최적화된 Dispatcher이다.
    -Dispatchers.Default
     : CPU 사용량이 많은 작업에 사용한다.
    -Dispatchers.Unconfined : 특수한 상황에서 코루틴을 실행하지만 사용을 권장하지는 않는다.

# ThreadBasic
[전체코드보기](https://github.com/Youngho-Kim/ThreadBasic/blob/master/app/src/main/java/com/android/kwave/threadbasic/ThreadBasicActivity.java)  

// Thread 생성  
    Thread thread = new Thread();    
// Thread 실행  
    thread.start();  
    
// Thread 생성2  
Runnable thread2 = new Runnable(){}    
// Thread 실행2  
        new Thread(thread2).start();  
        
// 3.1 Thread 생성
class CustomThread extends Thread{
   @Override
    public void run() {
         Log.i("Thread Test","Hello Custom Thread");
    }
}  

// 4.1 Thread 생성
class CustomRunnable implements Runnable{
    @Override
    public void run() {
        Log.i("Thread Test","Hello Custom Runnable");
    }
}

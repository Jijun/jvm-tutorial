package tutorial.jvm.thread;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		
		final Thread t1 = new Thread(){
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T1 running");
			};
		};
		
		Thread t2 = new Thread(t1) {
			
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T2 running");
			}
		};
		t1.start();
		t2.start();

			t2.join();
		System.out.println("main Thread running");
		
	}
}

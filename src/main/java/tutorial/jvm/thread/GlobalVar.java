package tutorial.jvm.thread;

public class GlobalVar {
	public final static Object locker = new Object();
	public static boolean flag = false;

	public static void main(String[] args) {

		Noticer n = new Noticer();
		Waiter w = new Waiter();

		n.start();
		w.start();
	}
}

class Waiter extends Thread {

	public void run() {

		while (true) {

			synchronized (GlobalVar.locker) {

				while (!GlobalVar.flag) {

					try {
						GlobalVar.locker.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				GlobalVar.flag = false;
			}// synchronized end

			// do something here
			System.out.println("Waiter:完成一个新分配的任务");
		}
	}
}

class Noticer extends Thread {

	public void run() {

		synchronized (GlobalVar.locker) {
			GlobalVar.flag = true;
			GlobalVar.locker.notify();
			System.out.println("Noticer:分配一个新任务通知");
		}
	}
}

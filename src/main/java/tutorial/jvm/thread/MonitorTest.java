package tutorial.jvm.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MonitorTest {
	private Object monitor = new Object();
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");

	private String getTime() {
		return format.format(Calendar.getInstance().getTime());
	}

	public void waitOnce(String thread, final long ms) {
		Thread waitThread = new Thread() {
			public void run() {
				synchronized (monitor) {// 获得对象监视器
					try {
						System.out.println("Thread "
								+ Thread.currentThread().getName()
								+ " Wait at " + getTime());
						monitor.wait(ms);
						System.out.println("Thread "
								+ Thread.currentThread().getName()
								+ " Waked at " + getTime());
					} catch (InterruptedException e) {
					}
				}
			};
		};
		waitThread.setName(thread);
		waitThread.start();
	}

	public void awakeAndWait(String thread, final long ms) {
		Thread notifyThread = new Thread() {
			public void run() {
				synchronized (monitor) {
//					monitor.notify(); //喚醒一個
					monitor.notifyAll();//通知所有
					System.out.println("Thread "
							+ Thread.currentThread().getName() + " Notify at "
							+ getTime());
					// 保持了对象锁的等待
					try {
						Thread.sleep(ms);
					} catch (InterruptedException e) {
					}
				}
				// 释放了对象锁之后的等待
				try {
					Thread.sleep(ms);
				} catch (InterruptedException e) {
				}
			};
		};
		notifyThread.setName(thread);
		notifyThread.start();
	}

	public static void main(String[] args) {
		MonitorTest test = new MonitorTest();
		test.waitOnce("1", Integer.MAX_VALUE);
		test.waitOnce("2", Integer.MAX_VALUE);
		try {// 延迟2s
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		// 在唤醒一个在对象上等待的线程，本身执行时间4s，2s是在对象锁内
		// ，2s是在释放了对象锁以后
		test.awakeAndWait("3", 2000);
	}
}

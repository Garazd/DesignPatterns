package testPatterns.testSingleton;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class MultithreadingTest {

    protected abstract Object getSingleton();

    private ConsoleMock consoleMock = new ConsoleMock();

    @Test
    public void testThreadSafe() throws InterruptedException {
        final List<Object> instances = new CopyOnWriteArrayList();

        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    instances.add(getSingleton());
                }
            }
        };

        runInThreads(runnable, 100);

        for (int i = 0; i < instances.size() - 1; i++) {
            assertSame(instances.get(i), instances.get(i + 1));
        }

        assertEquals("Инстанциировали Singleton!\r\n", consoleMock.getOut());
    }

    private void runInThreads(Runnable runnable, int threadCount) throws InterruptedException {
        List<Thread> threads = new LinkedList<Thread>();

        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(runnable));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
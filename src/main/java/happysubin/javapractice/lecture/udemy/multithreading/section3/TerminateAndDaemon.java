package happysubin.javapractice.lecture.udemy.multithreading.section3;

import com.fasterxml.jackson.databind.node.BigIntegerNode;

import java.math.BigInteger;

public class TerminateAndDaemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();

        thread.interrupt();


        Thread thread2 = new Thread(new LongComputationTask(new BigInteger("2222222222"), new BigInteger("11231230")));

        //스레드 인터럽트를 정상적으로 처리할 필요가 없다면 데몬 스레드로 둔다. JVM이 바로 데몬 스레드를 셧다운 시켜버린다.
        //데몬 스레드는 부수적인 일을 맡아야함. 그냥 꺼져도 상관 없어야하므로.
        thread2.setDaemon(true);

        thread2.start();

        thread2.interrupt();


    }

    static class LongComputationTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0 ; i = i.add(BigInteger.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }

    static class BlockingTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("Exiting ablocking thread");
            }
        }
    }
}

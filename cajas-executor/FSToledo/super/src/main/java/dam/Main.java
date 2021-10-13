package dam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        try {
            int numThreads = Integer.parseInt(args[0]);
            int numClients = Integer.parseInt(args[1]);
            if((numThreads>0)&&(numClients>0)) {
                int sequentialFinishTime = processingSequential(numThreads,numClients);
                int concurrentFinishTime = processingConcurrent(numThreads,numClients);
                System.out.println("Sequential processing ends in "+sequentialFinishTime+" seconds.");
                System.out.println("Concurrent processing ends in "+concurrentFinishTime+" seconds.");
            }
        } catch(ArrayIndexOutOfBoundsException ae){
            System.out.println("Error: Two positive integer arguments has been expected");
        } catch(NumberFormatException e){
            System.out.println(e.getMessage() + "\n Wrong Arguments has been passed");}
    }
    private static int processingSequential(int numThreads, int numClients){
        System.out.println("Sequential Processing with Pool of "+ numThreads + " Checkouts:");
        Clients clients = new Clients(numClients);
        CheckOut[] checkOuts = new CheckOut[numThreads];
        long initialTime = System.currentTimeMillis();
        while (!clients.getClientQueue().isEmpty()){
            for (int i=0;i<numThreads;i++) {
                checkOuts[i] = new CheckOut(""+(i+1));
                checkOuts[i].processPurchase(clients.getClientQueue().pop(), initialTime);
            }
        }
        System.out.println("All CheckOuts has been finished");
        return (int)((System.currentTimeMillis()-initialTime)/1000);
    }
    private static int processingConcurrent(int numThreads, int numClients){
        System.out.println("Current Processing with a Pool of "+ numThreads + " CheckOuts:");
        Clients clients = new Clients(numClients);
        long initialTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        CheckOutThread[] checkOutThreads = new CheckOutThread[numThreads];
        while (!clients.getClientQueue().isEmpty()) {
            for (int i = 0; i< numThreads ;i++) {
                checkOutThreads[i] = new CheckOutThread(""+(i+1),clients.getClientQueue().pop(), initialTime);
                executor.execute(checkOutThreads[i]);
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()){}

        System.out.println("All CheckOuts has been finished");
        return (int)((System.currentTimeMillis()-initialTime)/1000);
    }
}
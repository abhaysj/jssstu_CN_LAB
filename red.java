import java.util.Random;


class red {
    private double minThreshold;
    private double maxThreshold;
    private double maxProbability;
    private Random random;

    public red(double minThreshold, double maxThreshold, double maxProbability) {
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.maxProbability = maxProbability;
        this.random = new Random();
    }

    public boolean isCongested(double currentQueueSize) {
        
        double probability = 0.0;

        if (currentQueueSize <= minThreshold) {
            probability = 0.0;
            
        } else if (currentQueueSize >= maxThreshold) {
            probability = maxProbability;
            
        } 
        else {
            probability = maxProbability * (currentQueueSize - minThreshold) / (maxThreshold - minThreshold);
            
        }
        double r = random.nextDouble();
        System.out.println("the value of current queue size:"+currentQueueSize);
        System.out.println("the value of  random probability value:"+r);
        
        System.out.println("the value of probability:"+probability);
        return  r < probability;
    }
}

 class Main {
    public static void main(String[] args) {
        double minThreshold ;    // Minimum threshold
        double maxThreshold ;   // Maximum threshold
        double maxProbability ;  // Maximum drop probability

        
        Random random = new Random();
        minThreshold = (double)random.nextInt(10);
        System.out.println("the value of minimum threshold:"+minThreshold);
        maxThreshold= 10.0;
        System.out.println("the value of maximum threshold:"+maxThreshold);
        maxProbability=random.nextDouble();
        System.out.println("the value of maximum probability:"+maxProbability);
        System.out.println();
        red red = new red(minThreshold, maxThreshold, maxProbability);
        for (int i = 1; i <= 5; i++) {
            double currentQueueSize = i * 2.0; // Simulated queue size

            if (red.isCongested(currentQueueSize)) {
                System.out.println("Packet " + i + " dropped due to congestion.");
                System.out.println();
            } else {
                System.out.println("Packet " + i + " successfully forwarded.");
                System.out.println();
            }
        }
    }
}
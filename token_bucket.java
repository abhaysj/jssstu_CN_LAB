class TokenBucket {
    private int capacity; // Maximum tokens the bucket can hold
    private int tokens;   // Current number of tokens in the bucket
    //private long lastRefillTime; // Last time the bucket was refilled
    private int refillRate; // Tokens added per second

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.tokens = 0;
        this.refillRate = refillRate;
        //this.lastRefillTime = System.nanoTime();
    }

    public boolean allowRequest(int tokensRequested) {
        refill(); // Refill the bucket before checking

        if (tokens >= tokensRequested) {
            tokens -= tokensRequested;
            return true; // Request allowed
        }

        return false; // Request denied
    }

    private void refill() {
        //long now = System.nanoTime();
        //long timeElapsed = now - lastRefillTime;
        //int tokensToAdd = (int) (timeElapsed * refillRate / TimeUnit.SECONDS.toNanos(1));
        if((tokens+refillRate)<=capacity)
            tokens=tokens+refillRate;
        else
            System.out.println("cannot refill, tokens cannot exceed capacity ");
        //tokens = Math.min(capacity, tokens + tokensToAdd);
        //lastRefillTime = now;
    }
}

 public class token_bucket {
    public static void main(String[] args) {
        int capacity = 10; // Bucket capacity
        int refillRate = 2; // Tokens added per second
        TokenBucket tokenBucket = new TokenBucket(capacity, refillRate);

        for (int i = 1; i <= 6; i++) {
            if (tokenBucket.allowRequest(i)) {
                System.out.println("Request " + i + ": Allowed");//packet of size i and it is equal to tokens requested
            } else {
                System.out.println("Request " + i + ": Denied");
            }
        }
    }
}


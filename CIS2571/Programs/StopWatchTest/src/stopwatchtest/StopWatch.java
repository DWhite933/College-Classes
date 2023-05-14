package stopwatchtest;

class StopWatch{
    // time at which stopwatch started
    private long startTime = System.currentTimeMillis();
    
    // time at which stopwatch stopped
    private long endTime;
    
    // default construtor
    public StopWatch(){
        
    }
    
    // returns startTime
    public long getStartTime(){
        return startTime;
    }
    
    // returns endTime
    public long getEndTime(){
        return endTime;
    }
    
    // sets startTime to current time
    public void start(){
        startTime = System.currentTimeMillis();
    }
    
    // sets endTime to current time
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    
    // calculates elapsed time
    public long getElapsedTime(){
        long elapsedTime = endTime - startTime;
        return elapsedTime;
    }
}
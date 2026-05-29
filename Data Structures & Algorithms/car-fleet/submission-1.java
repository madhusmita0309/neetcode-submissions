class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(speed.length == 1)
            return 1;
        List<int[]> speedPositionPair = new ArrayList();
        for(int i=0; i<speed.length; i++){
            int [] temp = new int[2];
            temp[0] = position[i];
            temp[1] = speed[i];
            speedPositionPair.add(temp);
        }

        speedPositionPair.sort((a,b) -> b[0] - a[0]);
        int fleet = 1;
        

        double prevTime = (double)(target-speedPositionPair.get(0)[0])/(double)speedPositionPair.get(0)[1];
        double currTime = 0.0;
        for(int i=1; i<speed.length; i++){
            currTime = (double)(target-speedPositionPair.get(i)[0])/(double)speedPositionPair.get(i)[1];
            if(prevTime < currTime){
                fleet++;
                prevTime = currTime;
            }
        }

        return fleet;
    }
}

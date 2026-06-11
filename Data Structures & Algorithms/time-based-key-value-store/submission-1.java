class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> store; // key - key , value - pair of [timestamp, value]
    public TimeMap() {
        this.store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(this.store.containsKey(key)){
            List<Pair<Integer, String>> temp = this.store.get(key);
            temp.add(new Pair(timestamp, value));
        }else{
            List<Pair<Integer, String>> temp = new ArrayList();
            Pair p = new Pair(timestamp, value);
            temp.add(p);
            this.store.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!this.store.containsKey(key))
            return "";
        List<Pair<Integer, String>> list = this.store.get(key);
        int left = 0; int right = list.size()-1;
        String result = "";
        while(left <= right){
            int mid = (left + right)/2;
            if(list.get(mid).getKey() <= timestamp){
                result = list.get(mid).getValue();
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}

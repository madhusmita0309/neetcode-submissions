class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] tempArr = strs[i].toCharArray();
            Arrays.sort(tempArr);
            List<String> tempList;
            if(anagramMap.containsKey(String.valueOf(tempArr))){
                tempList = anagramMap.get(String.valueOf(tempArr));
                tempList.add(strs[i]);
            }else{
                tempList = new ArrayList();
                tempList.add(strs[i]);
            }
            anagramMap.put(String.valueOf(tempArr), tempList);
        }

        for(List<String> anagramLists : anagramMap.values()){
            result.add(anagramLists);
        }

        return result;
    }
}

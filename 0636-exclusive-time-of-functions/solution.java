class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Deque <Integer> id= new ArrayDeque<>();
        int res[]=new int [n];
        int pretime=0;
        for(String log :logs){
            String[] str=log.split(":");
            int curtime=Integer.valueOf(str[2]);
            if (str[1].equals("start")){
                if (!id.isEmpty()) {
                    res[id.peek()] += curtime - pretime;
                }
            id.push(Integer.valueOf(str[0]));
            pretime = curtime;

            }else{
                res[id.pop()] += curtime - pretime + 1;
                pretime = curtime+1;
            }              
           
        }
        return res;
    }
}

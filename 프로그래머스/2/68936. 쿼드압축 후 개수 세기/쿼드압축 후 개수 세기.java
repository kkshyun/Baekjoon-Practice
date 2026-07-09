class Solution {
    static int count0 = 0;
    static int count1 = 0;
    public int[] solution(int[][] arr) {
        check(0, 0, arr.length, arr);
        
        int[] answer = {count0, count1};
        return answer;
    }
    
    public void check(int y, int x, int size, int[][] a) {
        int basis = a[y][x];
        boolean same = true;
        for(int i = y ; i < y+size; i++) {
            for(int j = x; j < x+size; j++) {
                if(a[i][j] != basis) {
                    same = false;
                    break;
                }
            }
            if(!same)
                break;
        }
        if(same) {
            if(basis == 0)
                count0++;
            else
                count1++;
            return;
        }
        size = size/2;
        check(y, x, size, a);
        check(y+size, x, size, a);
        check(y, x+size, size, a);
        check(y+size, x+size, size, a);
    }
}
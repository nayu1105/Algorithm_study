class Solution {
    public int solution(int m, int n, int[][] puddles) {        
        long[][] map = new long[m+1][n+1];
        
        map[1][1]=1;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i==1&&j==1)continue;
                
                if(isPool(i, j, puddles)){
                // System.out.print(map[i][j] + " ");
                    continue;
                }
                
                map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                
                // System.out.print(map[i][j] + " ");
            }
            // System.out.println();
        }
        
        int answer = (int) map[m][n] % 1000000007;
        
        // System.out.println("answer" + answer);
        return answer;
    }
    
    static public boolean isPool(int m, int n, int[][] puddles){
        for(int i=0; i<puddles.length; i++){
            if(puddles[i][0] == m && puddles[i][1] == n)return true;
        }
        return false;
    }
}
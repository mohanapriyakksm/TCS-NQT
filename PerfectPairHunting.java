import java.util.Scanner;

public class PerfectPairHunting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.close();
        int[] perfectMatch = qualityCount(matrix, m, n);
        int lastIndex = perfectMatch.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(perfectMatch[i] + ":");
        }
        if (lastIndex >= 0) {
           System.out.print(perfectMatch[lastIndex]);
        }
    }

    public static int[] qualityCount(int[][] matrix,int m, int n){
        int highestCount = 0;
        int hrow = -1;
        int hcol = -1;
            for(int i=0;i<m;i++){
                for(int j=0; j<n;j++){
                    if(i==0 && j==0) continue;
                    if(matrix[i][j]==0) continue;
                    int currentCount = checkCount(i,j, matrix);
                    if(currentCount > highestCount){
                        highestCount = currentCount;
                        hrow=i;
                        hcol=j;
                    }
                }

            }
            return new int[] {hrow,hcol,highestCount};


    }

    public static int checkCount(int row, int col, int[][] matrix){
        
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int startRow = Math.max(0,row-1);
        int endRow = Math.min(row+1,numRows-1);
        int startCol = Math.max(0,col-1);
        int endCol = Math.min(col+1,numCols-1);
        int count = 0;

        for(int r = startRow; r<=endRow; r++){
            for(int c = startCol; c <= endCol; c++){
                if(!(r==row && c==col)){
                    if(matrix[r][c] == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

/*Sam is an eligible bachelor. He decides to settle down in life and start a family. He goes bride hunting.
He wants to marry a girl who has at least one of the 8 qualities mentioned below:-
1) The girl should be rich.
2) The girl should be an Engineer/Doctor.
3) The girl should be beautiful.
4) The girl should be of height 5.3".
5) The girl should be working in an MNC.
6) The girl should be an extrovert.
7) The girl should not have spectacles.
8) The girl should be kind and honest.
He is in search of a bride who has some or all of the 8 qualities mentioned above. On bride hunting, he may find more than one contender to be his wife.
In that case, he wants to choose a girl whose house is closest to his house. Find a bride for Sam who has maximum qualities. If in case, there are more than one contenders who are at equal distance from Sam’s house; then
print "“Polygamy not allowed”".
In case there is no suitable girl who fits the criteria then print “"No suitable girl found"”
Given a Matrix N*M, Sam's house is at (1, 1). It is denoted by 1. In the same matrix, the location of a marriageable Girl is also denoted by 1. Hence 1 at location (1, 1) should not be considered as the location of a marriageable Girl’s location.
The qualities of that girl, as per Sam’s criteria, have to be decoded from the number of non-zero neighbors (max 8-way) she has. Similar to the condition above, 1 at location (1, 1) should not be considered as the quality of a Girl. See Example section to get a better understanding.
Find Sam, a suitable Bride and print the row and column of the bride, and find out the number of qualities that the Bride possesses.
NOTE: - Distance is calculated in number of hops in any direction i.e. (Left, Right, Up, Down and Diagonal)
 
Constraints
•	2 <= N,M <= 10^2
Input Format
•	First Line contains the row (N) and column (M) of the houses.
•	Next N lines contain the data about girls and their qualities.
 
Output
•	It will contain the row and column of the bride, and the number of qualities that Bride possess separated by a colon (i.e. :).
 
Explanation
Example 1
Input:
2 9
1 0 1 1 0 1 1 1 1
0 0 0 1 0 1 0 0 1
Output:
1:7:3
Explanation:
The girl and qualities are present at (1,3),(1,4),(1,6),(1,7),(1,8),(1,9),(2,4),(2,6),(2,9).
The girl present at (1,3) has 2 qualities (i.e. (1,4)and (2,4)).
The girl present at (1,4) has 2 qualities.
The Bride present at (1,6) has 2 qualities.
The Bride present at (1,7) has 3 qualities.
The Bride present at (1,8) has 3 qualities.
The Bride present at (1,9) has 2 qualities.
The Bride present at (2,4) has 2 qualities.
The Bride present at (2,6) has 2 qualities.
The Bride present at (2,9) has 2 qualities.
As we see, there are two contenders who have maximum qualities, one is at (1,7) and another at (1,8).
The girl who is closest to Sam's house is at (1,7). Hence, she is the bride.
Hence, the output will be 1:7:3.
Example 2
Input:
6 6
1 0 0 0 0 0
0 0 0 0 0 0
0 0 1 1 1 0
0 0 1 1 1 0
0 0 1 1 1 0
0 0 0 0 0 0
Output:
4:4:8
Explanation:
The bride and qualities are present at (3,3),(3,4),(3,5),(4,3),(4,4),(4,5),(5,3),(5,4),(5,5)
The Bride present at (3,3) has 3 qualities (i.e. (3,4),(4,3) and (4,4)).
The Bride present at (3,4) has 5 qualities.
The Bride present at (3,5) has 3 qualities. */
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        char[][] mat = new char[numRows][s.length()];

        for(int i = 0;i<mat.length ; i++){
            for(int j = 0; j<mat[0].length; j++){
                mat[i][j] = '$';
            }
        }

        int row = 0;
        int col = 0;
        boolean goingDown = true;

        for(int i=0; i<s.length(); i++){
            mat[row][col] = s.charAt(i);

            if(goingDown){
                row++;

                if(row == numRows){
                    goingDown = false;
                    row -= 2;
                    col++;
                }
            }
            else{
                row--;
                col++;

                if(row < 0){
                    goingDown = true;
                    row = 1;
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<numRows; i++){
            for(int j=0; j<s.length(); j++){
                if(mat[i][j] != '$'){
                    ans.append(mat[i][j]);
                }
            }
        }

        return ans.toString();
    }
}

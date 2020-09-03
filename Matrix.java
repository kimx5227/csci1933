public class Matrix{

    private int nrows;
    private int ncols;
    private int[][] matrix;

    public int[][] Matrix(int nrows, int ncols){
        this.nrows = nrows;
        this.ncols = ncols;
        int[][] newMat = new int[nrows][ncols];
        return newMat;
    }

    public Matrix(int[][] arr){
        nrows = arr.length;
        ncols = arr[0].length;
        int[][] newMat = new int[nrows][ncols];
        for (int i = 0; i < nrows; i++){
            for (int j = 0; j < ncols; j++){
                newMat[i][j] = arr[i][j];
            }
        }
        matrix = newMat;
    }

    public Matrix transpose(){
      int temp = 0;
      for (int i = 0; i < matrix.length; i++){
          for (int j = matrix[0].length-1; j > i; j--){
              temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
      }

      Matrix mat = new Matrix(matrix);
      return mat;
    }

    public String toString(){
      String newString = "";
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              newString = newString + matrix[i][j] + " ";
          }
          newString = newString + "\n";
      }
      return newString;
    }

    public static void main(String[] args){
        int[][] arr = { {2,7,9},{3,6,1},{7,4,2} };
        Matrix mat = new Matrix(arr);
        System.out.println(mat);
        Matrix matTran = mat.transpose();
        System.out.println(matTran);
    }

}

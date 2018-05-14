import java.util.ArrayList;

public class printMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return res;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start=0;
        while (cols>start*2&&rows>start*2)
        {
            PrintMatrix(matrix,start,res);
            start++;
        }
        return res;

    }

    private static void PrintMatrix(int[][] matrix, int start, ArrayList<Integer> res) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end_rows = rows-start-1;
        int end_cols = cols-start-1;
        for (int i=start;i<=end_cols;i++)//top
            res.add(matrix[start][i]);
        if (end_rows>start)
            for (int i=start+1;i<=end_rows;i++)//right
                res.add(matrix[i][end_cols]);
        if (end_cols>start&&end_rows>start)
            for (int i=end_cols-1;i>=start;i--)//bottom
                res.add(matrix[end_rows][i]);
        if (end_cols>start&&end_rows>start+1)
            for (int i=end_rows-1;i>=start+1;i--)//left
                res.add(matrix[i][start]);

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        System.out.println(printMatrix(matrix));
    }
}

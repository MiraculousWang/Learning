package LeetCode;

///
///832. 翻转图像
//给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
//
//水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
//
//反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
//
//
//
//示例 1：
//
//输入：[[1,1,0],[1,0,1],[0,0,0]]
//输出：[[1,0,0],[0,1,0],[1,1,1]]
//解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
//示例 2：
//
//输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
//     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//
//
//提示：
//
//1 <= A.length = A[0].length <= 20
//0 <= A[i][j] <= 1
//
// https://leetcode-cn.com/problems/flipping-an-image/

public class flippingAnImage {

  public static void main(String[] args){
    int[][] A = {
        {1,1,0,0},
        {1,0,0,1},
        {0,1,1,1},
        {1,0,1,0}
    };

    A = new flippingAnImage().flipAndInvertImage1(A);

    for (int[] a : A){
      System.out.print("[");
      for (int i : a){
        System.out.print(i + ",");
      }
      System.out.println("]");
    }
  }

  public int[][] flipAndInvertImage1(int[][] A) {
    int length = A[0].length - 1;
    for (int i = 0; i < A.length; i++){
      int count = 0;
      while (count <= length - count){
        int tmp = A[i][count] ^ 1;
        A[i][count] = A[i][length - count] ^ 1;
        A[i][length - count] = tmp;
        count++;
      }
    }
    return A;
  }

}

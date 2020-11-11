package LeetCode;

//57. 插入区间
//
//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
//在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
// 
//
//示例 1：
//
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
//示例 2：
//
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/insert-interval
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//


import java.util.Arrays;

public class insertQujian {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null){ return new int[][]{newInterval}; }
    if (newInterval == null|| newInterval.length == 0){return intervals;}

    int new1 = newInterval[0];
    int new2 = newInterval[1];
    int insertIndex1 = 0;
    int insertIndex2 = 0;

    int[][] arrays = new int[intervals.length][2];
    for (int i = 0;i < intervals.length;i++){
      if (insertIndex1 == 0 && new1 <= intervals[i][0]){
        insertIndex1 = i;
      }
      if (new2 <= intervals[i][1]){
        insertIndex2 = i;
        break;
      }
    }

    for (int i = 0;i < intervals.length;i++){
      if (new1 <= intervals[i][0]){

      }else {
        arrays[i][0] = intervals[i][0];
        arrays[i][1] = intervals[i][1];
      }
    }

    return null;
  }
}

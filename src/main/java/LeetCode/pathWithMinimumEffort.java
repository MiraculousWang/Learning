package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//1631. 最小体力消耗路径
//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
//
//一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
//
//请你返回从左上角走到右下角的最小 体力消耗值 。
//
//
//
//示例 1：
//
//
//
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
//示例 2：
//
//
//
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
//示例 3：
//
//
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
//
//
//提示：
//
//rows == heights.length
//columns == heights[i].length
//1 <= rows, columns <= 100
//1 <= heights[i][j] <= 106
//
//https://leetcode-cn.com/problems/path-with-minimum-effort/
//
public class pathWithMinimumEffort {

  public static void main(String args[]){
    int heights[][] = new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
    System.out.println(new pathWithMinimumEffort().minimumEffortPath(heights));
  }

  public int minimumEffortPath(int[][] heights) {
    int n=heights.length*heights[0].length;
    U u=new U(n);
    int left_up=0;
    int right_down=n-1;
    //构造边集
    List<Edge> edges=new ArrayList<>();
    for(int i=0;i<heights.length;i++){
      for(int j=0;j<heights[0].length;j++){
        //[i-1,j]和[i,j]构造的边
        //边的构造要麻烦一些 有两个方向
        int cur=i*heights[0].length+j;
        //往左或者往上看 这样好些 不然都没遍历到
        if(j-1>=0){
          int left=cur-1;
          //还要构造边
          Edge e=new Edge(cur,left,Math.abs(heights[i][j]-heights[i][j-1]));
          edges.add(e);
        }
        if(i-1>=0){
          int up=(i-1)*heights[0].length+j;
          Edge e=new Edge(cur,up,Math.abs(heights[i][j]-heights[i-1][j]));
          edges.add(e);
        }
      }
    }

    Collections.sort(edges,(a,b)->{
      return a.v-b.v;
    });

    //按顺序遍历
    for(Edge e:edges){
      System.out.println(e.i+" "+e.j+" "+e.v);
    }
    int res=0;
    //不能用for
    int c=0;
    while(u.find(left_up)!=u.find(right_down)){
      Edge e=edges.get(c++);
      int i=e.i;
      int j=e.j;
      u.union(e.i,e.j);
      res=e.v;

    }
    return res;

  }


  class Edge{
    int i;
    int j;
    int v;
    public Edge(int i,int j,int v){
      this.i=i;
      this.j=j;
      this.v=v;
    }
  }


  class U{
    int n;
    int cal;
    int[] ancinents;
    int[] bros;
    public U(U u){
      this.n=u.n;
      this.cal=u.cal;
      this.ancinents=new int[n];
      this.bros=new int[n];
      for(int i=0;i<n;i++){
        this.ancinents[i]=u.ancinents[i];
        this.bros[i]=u.bros[i];
      }
    }
    public U(int n){
      this.n=n;
      this.cal=n;
      this.ancinents=new int[n];
      this.bros=new int[n];
      for(int i=0;i<n;i++){
        ancinents[i]=i;
      }
      Arrays.fill(bros,1);
    }
    public int find(int i){
      while(i!=ancinents[i]){

        //ancinents[i]=ancinents[ancinents[i]];
        i=ancinents[i];
        //i=ancinents[ancinents[i]];
      }
      return i;
    }
    public void union(int i,int j){
      int a=find(i);
      int b=find(j);
      if(a!=b){
        bros[a]+=bros[b];
        ancinents[b]=a;
        cal--;
      }
    }
  }


}

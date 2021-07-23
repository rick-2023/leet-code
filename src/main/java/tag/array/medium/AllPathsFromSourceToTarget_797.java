package tag.array.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zrfan
 * @date 2021/07/23.
 */
public class AllPathsFromSourceToTarget_797 {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    // 二维比一维会多一些入参比如 val....
    help(0, graph, new LinkedList<>());
    return result;
  }

  private void help(int val, int[][] graph, LinkedList<Integer> temp) {

    // 这里要灵活变通，是node val的值 到达临界跳出，而不是 temp.size()

    if (val == graph.length - 1) {
      temp.add(val);
      result.add(new ArrayList<>(temp));
      return;
    }

    temp.add(val);


    for (int i = 0; i < graph[val].length; i++) {

      help(graph[val][i], graph, temp);
      temp.removeLast();

    }


  }


  public static void main(String[] args) {
    AllPathsFromSourceToTarget_797 allPathsFromSourceToTarget_797 = new AllPathsFromSourceToTarget_797();
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    List<List<Integer>> lists = allPathsFromSourceToTarget_797.allPathsSourceTarget(graph);
    System.out.println(lists);
  }
}

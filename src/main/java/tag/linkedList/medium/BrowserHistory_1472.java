package tag.linkedList.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrfan
 * @date 2022/02/19.
 */
public class BrowserHistory_1472 {

  List<String> visitList;
  int cur, total;

  public BrowserHistory_1472(String homepage) {

    visitList = new ArrayList<>();
    visitList.add(homepage);

    cur++;
    total++;

  }

  public void visit(String url) {

    if (visitList.size() > cur) {
      visitList.set(cur, url);
    } else {
      visitList.add(url);
    }

    cur++;
    total = cur;

  }

  public String back(int steps) {

    cur = Math.max(1, cur - steps);
    return visitList.get(cur - 1);

  }

  public String forward(int steps) {

    cur = Math.min(total, cur + steps);
    return visitList.get(cur - 1);

  }
}

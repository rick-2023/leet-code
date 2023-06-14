package tag.string.easy;

/**
 * 返回最后一个单词的长度
 *
 * 去掉前后空格
 * 找到最后一个 ' ', 用len-index-1
 *
 * @author zrfan
 * @date 2023/06/14.
 */
public class LengthOfLastWord_58 {

  public int lengthOfLastWord(String s) {
    return s.trim().length() - s.trim().lastIndexOf(' ') -1;
  }
}

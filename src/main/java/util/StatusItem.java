package util;

import java.util.LinkedHashMap;
import java.util.Map;

public class StatusItem {

  /**
   * ステータスリストを取得する.
   * @return
   */
  public static Map<String, String> getStatusItem() {
    Map<String, String> statusItem = new LinkedHashMap<String, String>();
    statusItem.put("0", "未着手");
    statusItem.put("1", "対応中");
    statusItem.put("2", "保留");
    statusItem.put("3", "取消");
    statusItem.put("4", "完了");
    return statusItem;
  }
}

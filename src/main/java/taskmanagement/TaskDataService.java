package taskmanagement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class TaskDataService {
  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  public List<TaskData> getAll() {
    return (List<TaskData>) entityManager.createQuery("from TaskData").getResultList();
  }

  // @SuppressWarnings("unchecked")
  public TaskData findByTaskNo(long taskNo) {
    return (TaskData) entityManager.createQuery("from TaskData where taskNo = " + taskNo)
        .getSingleResult();
  }

  /**
   * タスク情報を検索する.
   * @param searchDate  検索日
   * @param searchText  検索テキスト
   * @param inStatus  検索ステータス
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<TaskData> searchTask(String searchDate, String searchText, String inStatus) {
    String strSql = "";
    strSql += "from TaskData where ";
    strSql += "statusCd in (" + inStatus + ")";

    if (!searchText.equals("")) {
      strSql += " AND (task like '%" + searchText + "%' or taskDetails like '%" + searchText
          + "%')";
    }else {

    }

    strSql += " AND planFrom <= '" + searchDate + "' AND planTo >= '" + searchDate + "'";

    return (List<TaskData>) entityManager.createQuery(strSql).getResultList();
  }

}

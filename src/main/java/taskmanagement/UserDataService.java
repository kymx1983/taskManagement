package taskmanagement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class UserDataService {
  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  public List<UserData> getAll() {
    return (List<UserData>) entityManager.createQuery("from UserData").getResultList();
  }

  /**
   * ログイン処理.
   * @param loginId ログインID
   * @param password  パスワード
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<UserData> login(String loginId, String password) {
    return (List<UserData>) entityManager
        .createQuery(
            "from UserData where loginId = '" + loginId + "' and password = '" + password + "'")
        .getResultList();
  }

  public UserData findByUserNo(long userNo) {
    return (UserData) entityManager.createQuery("from UserData where userNo = " + userNo)
        .getSingleResult();
  }

}

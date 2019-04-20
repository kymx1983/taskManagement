package taskmanagement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class UserDataService{
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<UserData> getAll() {
		return (List<UserData>) entityManager.createQuery("from UserData").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<UserData> login(String loginID, String password) {
		return (List<UserData>) entityManager.createQuery("from UserData where loginID = '" + loginID + "' and password = '" + password + "'").getResultList();
	}

	public UserData findByUserNo(long userNo) {
		return (UserData) entityManager.createQuery("from UserData where userNo = " + userNo).getSingleResult();
	}

}

package taskmanagement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class TaskDataService{
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<TaskData> getAll() {
		return (List<TaskData>) entityManager.createQuery("from TaskData").getResultList();
	}

//	@SuppressWarnings("unchecked")
	public TaskData findByTaskNo(long taskNo ) {
		return (TaskData) entityManager.createQuery("from TaskData where taskNo = " + taskNo).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<TaskData> searchTask(String searchDate, String  searchText, String inStatus){
		String strSQL = "";
		strSQL += "from TaskData where ";
		strSQL += "statusCD in (" + inStatus + ")";

		if(!searchText.equals("")) {
			strSQL += " AND (task like '%" + searchText + "%' or taskDetails like '%" + searchText + "%')";
		}

		strSQL += " AND planFrom <= '" + searchDate + "' AND planTo >= '" + searchDate + "'";

		return (List<TaskData>) entityManager.createQuery(strSQL).getResultList();
	}

}

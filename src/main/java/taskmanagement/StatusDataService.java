package taskmanagement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class StatusDataService {
  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  public List<StatusData> getAll() {
    return (List<StatusData>) entityManager.createQuery("from StatusData order by statuscd").getResultList();
  }
}

package taskmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "statusdata")
public class StatusData {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "statuscd")
  @NotNull
  private int statusCd;

  @Column(name = "statusname",nullable = false)
  @NotEmpty()
  private String statusName;

  public int getStatusCd() {
    return statusCd;
  }

  public void setStatusCd(int statusCd) {
    this.statusCd = statusCd;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

}

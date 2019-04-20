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
@Table(name = "taskData")
public class TaskData {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  @NotNull
  private long taskNo;

  @Column(nullable = false)
  @NotEmpty(message = "プロジェクトを入力してください")
  private String projectCd;

  @Column(nullable = false)
  @NotEmpty(message = "タスクを入力してください")
  private String task;

  @Column(nullable = false)
  private String taskDetails;

  @Column(nullable = false)
  // @NotEmpty
  private long userNo;

  @Column(nullable = false)
  @NotEmpty(message = "開始日を指定してください")
  private String planFrom;

  @Column
  @NotEmpty(message = "終了日を指定してください")
  private String planTo;

  @Column
  private int statusCd;

  @Column
  private String due;

  public long getTaskNo() {
    return taskNo;
  }

  public void setTaskNo(long taskNo) {
    this.taskNo = taskNo;
  }

  public String getProjectCd() {
    return projectCd;
  }

  public void setProjectCd(String projectCd) {
    this.projectCd = projectCd;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getTaskDetails() {
    return taskDetails;
  }

  public void setTaskDetails(String taskDetails) {
    this.taskDetails = taskDetails;
  }

  public long getUserNo() {
    return this.userNo;
  }

  public void setUserNo(long userNo) {
    this.userNo = userNo;
  }

  public String getPlanFrom() {
    return planFrom;
  }

  public void setPlanFrom(String planFrom) {
    this.planFrom = planFrom;
  }

  public String getPlanTo() {
    return planTo;
  }

  public void setPlanTo(String planTo) {
    this.planTo = planTo;
  }

  public int getStatusCd() {
    return statusCd;
  }

  public void setStatusCd(int statusCd) {
    this.statusCd = statusCd;
  }

  public String getDue() {
    return due;
  }

  public void setDue(String due) {
    this.due = due;
  }
}

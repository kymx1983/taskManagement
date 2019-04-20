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
@Table(name = "UserData")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @NotNull
    private long userNo;

    @Column(nullable = false)
    @NotEmpty(message="ログインIDを入力してください")
    private String loginID;

    @Column(nullable = false)
    @NotEmpty(message="パスワードを入力してください")
    private String password;

    @Column(nullable = false)
    @NotEmpty(message="ユーザ名を入力してください")
    private String userName;

    public long getUserNo() {
        return userNo;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

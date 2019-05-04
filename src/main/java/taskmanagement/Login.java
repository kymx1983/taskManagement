package taskmanagement;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import util.TaskUtil;

@RestController
public class Login {

  @Autowired
  UserDataRepository userRepository;

  @Autowired
  private UserDataService userService;

  @Autowired
  private TaskDataService taskService;

  /**
   * ログイン画面に遷移する.
   * @param mav ModelAndViewインスタンス
   * @return
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("login.html");

    return mav;
  }

  /**
   * ログイン機能.
   * @param loginId 画面から入力されたログインID
   * @param password 画面から入力されたパスワード
   * @param mav 画面入力内容
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(@RequestParam String loginId, @RequestParam String password,
      ModelAndView mav) {

    if (userService.login(loginId, password).size() > 0) {

      // ログイン成功
      mav.setViewName("SelectTask.html");
      mav.addObject("searchDate", TaskUtil.getToday());
      List<TaskData> list = taskService.getAll();
      mav.addObject("datalist", list);

      List<UserData> user = userService.getAll();
      mav.addObject("userList", user);

    } else {
      // ログイン失敗
      mav.setViewName("login.html");
      mav.addObject("message", "ログインIDまたはパスワードが誤っています");
    }

    return mav;
  }

  /**
   * 初期処理を実装する.
   */
  @PostConstruct
  public void init() {

  }
}

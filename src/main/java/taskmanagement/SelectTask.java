package taskmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import util.StatusItem;
import util.TaskUtil;

@RestController
public class SelectTask {

  @Autowired
  TaskDataRepository repository;

  @Autowired
  private TaskDataService service;

  @Autowired
  private UserDataService userService;

  @Autowired
  private TaskDataService taskService;

  @RequestMapping(value = "/select", method = RequestMethod.POST)
  public ModelAndView select(
      @RequestParam String searchDate,
      @RequestParam String searchText,
      @RequestParam(value = "statusConditions", required = false) String[] statusConditions,
      ModelAndView mav) {

    mav.setViewName("selectTask.html");

    mav.addObject("searchDate", TaskUtil.getToday());

    System.out.println("searchDate" + searchDate);

    String status = "";
    if (statusConditions != null) {
      for (String value : statusConditions) {
        if (status.length() > 0) {
          status += ",";
        }
        status += value;
      }

    }

    System.out.println("ステータス:" + status);

    List<TaskData> list = service.searchTask(searchDate, searchText, status);
    mav.addObject("datalist", list);

    return mav;
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public ModelAndView editTask(@RequestParam long taskNo, ModelAndView mav) {

    mav = getInsertTaskView(taskNo);
    mav.addObject("obj", getTaskData(taskNo));

    return mav;

  }

  @RequestMapping(value = "/flush", method = RequestMethod.POST)
  @Transactional(readOnly = false)
  public ModelAndView flush(
      @ModelAttribute("obj") @Validated TaskData taskData,
      BindingResult result,
      @RequestParam String mode) {

    if (result.hasErrors()) {
      ModelAndView mav = getInsertTaskView(taskData.getTaskNo());
      mav.addObject("message", "入力内容に誤りがあります");
      mav.addObject("obj", taskData);
      return mav;

    }
    switch (mode) {
    case "insert":
    case "update":
      repository.saveAndFlush(taskData);
      break;
    case "copy":
      taskData.setTaskNo(0);
      repository.saveAndFlush(taskData);
      break;
    case "delete":
      repository.delete(taskData);
      break;
    }

    // ログイン成功
    ModelAndView mav = new ModelAndView();
    mav.setViewName("SelectTask.html");
    mav.addObject("searchDate", TaskUtil.getToday());
    List<TaskData> list = taskService.getAll();
    mav.addObject("datalist", list);

    List<UserData> user = userService.getAll();
    mav.addObject("userList", user);

    return mav;
  }

  public ModelAndView getInsertTaskView(long taskNo) {

    ModelAndView mav = new ModelAndView();

    mav.setViewName("InsertTask.html");

    // ステータスのラジオボタンに表示する内容を設定する
    mav.addObject("statusItem", StatusItem.getStatusItem());

    boolean modeVisible = false;
    if (taskNo != 0) {
      modeVisible = true;
    }
    mav.addObject("modeVisible", modeVisible);

    return mav;

  }

  private TaskData getTaskData(long taskNo) {
    TaskData data = new TaskData();
    if (taskNo != 0) {
      data = service.findByTaskNo(taskNo);
    } else {
      // 新規作成の場合
      // 日付項目に今日日付を設定する
      String today = TaskUtil.getToday();
      data.setPlanFrom(today);
      data.setPlanTo(today);
      data.setDue(today);

      // ステータスを未着手にする
      data.setStatusCd(1);
    }
    return data;
  }

}

package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TaskUtil {
	public static String getToday() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return  sdf.format(calendar.getTime());

	}
}

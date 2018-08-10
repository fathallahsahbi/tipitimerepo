package helpers;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import renderers.FixedHoliday;
import renderers.HolidayList;

/**
 * Helper to manage time related actions
 * 
 * @category Helpers
 * @since upcoming version
 *
 */
public class TimeHelper {
	private int currentMonth;
	private int currentYear;
	private String currentMonthText;
	private int totalDays;
	private int workingDays;

	/**
	 * Helper Constructor
	 */
	public TimeHelper() {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		currentYear = calendar.get(Calendar.YEAR);
		currentMonth = calendar.get(Calendar.MONTH);
	}

	/**
	 * Method to calculate total days of current month
	 * 
	 * @author safubi
	 * @since upcoming version
	 * @return total days in current month
	 */
	public int calculateTotalDays() {
		YearMonth yearMonth = YearMonth.of(currentYear, currentMonth + 1);
		return yearMonth.lengthOfMonth();
	}

	/**
	 * Method to calculate working days of current month
	 * 
	 * @author safubi
	 * @since upcoming version
	 * @return working days in current month
	 */
	public int calculateWorkingDays() {
		int totalDays = calculateTotalDays();
		int workingDays = totalDays;
		for (int i = 1; i <= totalDays; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(currentYear, currentMonth, i);
			if (calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
				System.out.println(calendar.getTime());
				workingDays--;
			}
			FixedHoliday day = new FixedHoliday(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH));
			if (day.equals(HolidayList.NEW_YEAR_DAY) || day.equals(HolidayList.REVOLUTION_DAY)
					|| day.equals(HolidayList.INDEPENDANCE_DAY) || day.equals(HolidayList.MARTYRS_DAY)
					|| day.equals(HolidayList.WORKERS_DAY) || day.equals(HolidayList.REPUBLIC_DAY)) {
				System.out.println(calendar.getTime());
				workingDays--;
			}
		}

		return workingDays;
	}

	/**
	 * Method to calculate required work hours of current month
	 * 
	 * @author safubi
	 * @since upcoming version
	 * @return required work hours of current month
	 */
	public int calculateRequiredHours() {
		return calculateWorkingDays() * 8;
	}

	/**
	 * Method to calculate current month salary
	 * 
	 * @author safubi
	 * @since upcoming version
	 * @param baseSalary
	 *            base salary of staff
	 * @param workedHours
	 *            number of worked hours by staff
	 * @return salary of current
	 */
	public float calculateSalary(int baseSalary, float workedHours) {
		float salary = (workedHours / calculateRequiredHours()) * baseSalary;
		return salary;
	}

	/**
	 * @author safubi
	 * @since upcoming version
	 * @param numberOfHours
	 *            list of number of hours worked by each staff for a project
	 * @param hourlyWages
	 *            list of staffs hourly wages
	 * @return total generated salary by project
	 */
	public double sumProduct(List<Double> numberOfHours, List<Double> hourlyWages) {
		double sumProduct = 0f;
		for (int i = 0; i < numberOfHours.size(); i++) {
			sumProduct += numberOfHours.get(i) * hourlyWages.get(i);
		}
		return sumProduct;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public String getCurrentMonthText() {
		return currentMonthText;
	}

	public void setCurrentMonthText(String currentMonthText) {
		this.currentMonthText = currentMonthText;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

}

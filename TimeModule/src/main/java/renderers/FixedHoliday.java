package renderers;

public class FixedHoliday {
	private int day;
	private int month;

	public FixedHoliday(int day, int month) {
		this.day = day;
		this.month = month;
	}

	public boolean equals(FixedHoliday fixedHoliday) {
		if (fixedHoliday.getDay() == this.day && fixedHoliday.getMonth() == this.month) {
			return true;
		} else {
			return false;
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

}

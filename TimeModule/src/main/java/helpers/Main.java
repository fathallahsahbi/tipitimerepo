package helpers;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		TimeHelper helper = new TimeHelper();
		List<Double> hours = new ArrayList<>();
		List<Double> wages = new ArrayList<>();
		wages.add(10.52631579);
		wages.add(9.210526316);
		wages.add(9.210526316);
		wages.add(9.210526316);
		wages.add(10.52631579);
		wages.add(9.210526316);
		wages.add(10.52631579);
		wages.add(9.210526316);
		wages.add(6.907894737);
		wages.add(7.894736842);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(3.947368421);
		wages.add(7.236842105);
		hours.add(150.0);
		hours.add(105.5);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(119.5);
		hours.add(20.5);
		hours.add(94.0);
		hours.add(0.0);
		hours.add(43.0);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(0.0);
		hours.add(106.5);
		hours.add(94.0);
		hours.add(0.0);
		double joboty = helper.sumProduct(hours, wages);
		System.out.println("joboty : " + joboty);
	}
}

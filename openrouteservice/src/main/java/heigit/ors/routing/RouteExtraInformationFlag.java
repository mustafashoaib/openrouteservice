package heigit.ors.routing;

import com.graphhopper.util.Helper;

public class RouteExtraInformationFlag {
	public static final int Steepness = 1;
	public static final int Surface = 2;
	public static final int WayTypes = 4;
	public static final int Suitability = 8;

	public static boolean isSet(int extraInfo, int value)
   {
		return (extraInfo & value) == value;
   }

	public static int getFromString(String value) {
		if (Helper.isEmpty(value))
			return 0;

		int res = 0;

		String[] values = value.split("\\|");
		for (int i = 0; i < values.length; ++i) {
			switch (values[i].toLowerCase()) {
			case "steepness":
				res |= Steepness;
				break;
			case "surface":
				res |= Surface;
				break;
			case "waytypes":
				res |= WayTypes;
				break;
			case "suitability":
				res |= Suitability;
				break;
			}
		}

		return res;
	}
}

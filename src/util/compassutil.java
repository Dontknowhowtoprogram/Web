package util;

import org.compass.core.Compass;
import org.compass.core.CompassSession;
import org.compass.core.config.CompassConfiguration;

public class compassutil {
	public static CompassSession getSession() {
		CompassConfiguration cfg = new CompassConfiguration();
		cfg.configure();
		Compass compass = cfg.buildCompass();
		return compass.openSession();
	}
}

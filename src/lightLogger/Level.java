package lightLogger;

/**
 * A log level is used for message selection which should be logged and the
 * output format.
 * 
 * @author executor
 * 
 */
public class Level {

	/**
	 * A set of default log levels.
	 * 
	 * @author executor
	 * 
	 */
	public enum DEFAULT {
		ERROR(new Level(1, "ERROR")), WARN(new Level(2, "WARN")), INFO(
				new Level(4, "INFO")), TRACE(new Level(8, "TRACE")), DEBUG(
				new Level(16, "DEBUG")), ALL(
				new Level(Integer.MAX_VALUE, "all"));

		private Level level;

		private DEFAULT(Level level) {
			this.level = level;
		}

		public Level getLevel() {
			return this.level;
		}

	}

	private int value;
	private String label;

	public Level(int level, String label) {
		this.value = level;
		this.label = label;
	}

	/**
	 * 
	 * @return Value for level selection and log mask.
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * 
	 * @return Label or level name.
	 */
	public String getLabel() {
		return this.label;
	}

}

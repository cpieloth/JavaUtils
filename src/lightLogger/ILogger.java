package lightLogger;

import java.util.Set;

/**
 * Interface for log object. An implementation can specify the output format and more.
 * 
 * @author executor
 *
 */
public interface ILogger {

	/**
	 * Logs a message for a class by using the specified log level.
	 * 
	 * @param level
	 * @param clazz
	 * @param message
	 */
	public void log(Level level, Class<?> clazz, String message);

	/**
	 * Logs a message by using the error log level.
	 * 
	 * @param clazz
	 * @param message
	 */
	public void logError(Class<?> clazz, String message);

	/**
	 * Logs a message by using the warn log level.
	 * 
	 * @param clazz
	 * @param message
	 */
	public void logWarn(Class<?> clazz, String message);

	/**
	 * Logs a message by using the info log level.
	 * 
	 * @param clazz
	 * @param message
	 */
	public void logInfo(Class<?> clazz, String message);

	/**
	 * Logs a message by using the trace log level.
	 * 
	 * @param clazz
	 * @param message
	 */
	public void logTrace(Class<?> clazz, String message);

	/**
	 * Logs a message by using the debug log level.
	 * 
	 * @param clazz
	 * @param message
	 */
	public void logDebug(Class<?> clazz, String message);

	/**
	 * 
	 * @return The log mask for log level selection.
	 */
	public int getLogMask();

	/**
	 * Sets the log mask for log level selection by summation of each level's
	 * value.
	 * 
	 * @param level
	 *            Set of levels to log
	 */
	public void setLogMask(Set<Level> level);

	/**
	 * Sets the log mask for log level selection.
	 * 
	 * @param value
	 *            Log mask as value.
	 */
	public void setLogMask(int value);

}

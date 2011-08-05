package stopwatch;

public class StopWatch {

	public static enum State {
		STARTED, PAUSED, STOPPED, READY;
	}

	private State state;

	public static final String PREFIX = "time=";
	public static final String SUFFIX = "time=";

	private long begin = 0, end = 0, time = 0;

	public StopWatch() {
		this.state = State.READY;
	}

	public boolean start() {
		if (this.state == State.READY) {
			this.begin = System.currentTimeMillis();
			this.state = State.STARTED;
			return true;
		} else
			return false;
	}

	public boolean stop() {
		if (this.state == State.STARTED) {
			this.end = System.currentTimeMillis();
			this.state = State.STOPPED;
			return true;
		} else if (this.state == State.PAUSED) {
			this.end = 0;
			this.begin = 0;
			this.state = State.STOPPED;
			return true;
		} else {
			return false;
		}
	}

	public boolean pause() {
		if (this.state == State.STARTED) {
			this.time += System.currentTimeMillis() - this.begin;
			this.state = State.PAUSED;
			return true;
		} else
			return false;
	}

	public boolean resume() {
		if (this.state == State.PAUSED) {
			this.begin = System.currentTimeMillis();
			this.state = State.STARTED;
			return true;
		} else
			return false;
	}

	public void reset() {
		this.state = State.READY;
		this.begin = 0;
		this.end = 0;
		this.time = 0;
	}

	public State getState() {
		return this.state;
	}

	public double getTime() {
		if (this.state == State.STARTED)
			return this.time + (System.currentTimeMillis() - this.begin);
		else if (this.state == State.PAUSED)
			return this.time;
		else {
			this.time += this.end - this.begin;
			this.end = 0;
			this.begin = 0;
			return this.time;
		}
	}

	public String getTimeString() {
		return Double.toString(this.getTime());
	}

	public String getTimeString(String prefix, String suffix) {
		return prefix + this.getTimeString() + suffix;
	}

}

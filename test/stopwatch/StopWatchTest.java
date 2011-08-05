package stopwatch;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StopWatchTest {
	
	private StopWatch stopWatch;

	@Before
	public void reset() {
		this.stopWatch = new StopWatch();
	}
	
	@Test
	public void testStart() {
		if(!stopWatch.start())
			fail("Wrong return value!");
		if(stopWatch.getState() != StopWatch.State.STARTED)
			fail("Wrong state!");
		
		if(stopWatch.start())
			fail("Wrong return value!");
		
	}

	@Test
	public void testStop() {
		stopWatch.start();
		if(!stopWatch.stop())
			fail("Wrong return value!");
		if(stopWatch.getState() != StopWatch.State.STOPPED)
			fail("Wrong state!");
		
		stopWatch.reset();
		if(stopWatch.stop())
			fail("Wrong return value!");
	}

	@Test
	public void testPause() {
		stopWatch.start();
		if(!stopWatch.pause())
			fail("Wrong return value!");
		if(stopWatch.getState() != StopWatch.State.PAUSED)
			fail("Wrong state!");
		
		stopWatch.reset();
		if(stopWatch.pause())
			fail("Wrong return value!");
	}

	@Test
	public void testResume() {
		stopWatch.start();
		stopWatch.pause();
		if(!stopWatch.resume())
			fail("Wrong return value!");
		if(stopWatch.getState() != StopWatch.State.STARTED)
			fail("Wrong state!");
		
		stopWatch.reset();
		if(stopWatch.resume())
			fail("Wrong return value!");
	}

	
	@Test
	public void testReset() {
		stopWatch.start();
		stopWatch.reset();
		if(stopWatch.getState() != StopWatch.State.READY)
			fail("Wrong state!");
		
		if(stopWatch.getTime() != 0)
			fail("Wrong return value!");
	}

	@Test
	public void testGetState() {
		if(stopWatch.getState() != StopWatch.State.READY)
			fail("Wrong state!");
		
		stopWatch.start();
		if(stopWatch.getState() != StopWatch.State.STARTED)
			fail("Wrong state!");
		
		stopWatch.pause();
		if(stopWatch.getState() != StopWatch.State.PAUSED)
			fail("Wrong state!");
		
		stopWatch.resume();
		if(stopWatch.getState() != StopWatch.State.STARTED)
			fail("Wrong state!");
		
		stopWatch.stop();
		if(stopWatch.getState() != StopWatch.State.STOPPED)
			fail("Wrong state!");
		
		stopWatch.reset();
		if(stopWatch.getState() != StopWatch.State.READY)
			fail("Wrong state!");
	}

	@Test
	public void testGetTime() throws InterruptedException {
		long time = 10;
		long DELTA = 1;
		
		/* --- */
		stopWatch.start();
		Thread.sleep(time);
		stopWatch.stop();
		Assert.assertEquals("Start stop", time, stopWatch.getTime(), DELTA);
		
		stopWatch.start();
		Assert.assertEquals("Start stop start", time, stopWatch.getTime(), DELTA);
		
		/* --- */
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(time);
		
		if(stopWatch.getTime() < time)
			fail("StopWatch is not running!");
		
		/* --- */
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(time);
		stopWatch.pause();
		Assert.assertEquals("Start pause", time, stopWatch.getTime(), DELTA);
		Assert.assertEquals("Start pause", time, stopWatch.getTime(), DELTA);
		
		stopWatch.start();
		Assert.assertEquals("Start pause start", time, stopWatch.getTime(), DELTA);
		
		/* --- */
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(time);
		stopWatch.pause();
		Thread.sleep(time);
		stopWatch.resume();
		Thread.sleep(time);
		stopWatch.stop();
		Assert.assertEquals("Start pause resume stop", 2*time, stopWatch.getTime(), DELTA);
		
		/* --- */
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(time);
		stopWatch.pause();
		Thread.sleep(time);
		stopWatch.resume();
		Thread.sleep(time);
		stopWatch.pause();
		Thread.sleep(time);
		stopWatch.resume();
		Thread.sleep(time);
		stopWatch.stop();
		Assert.assertEquals("Start pause resume pause resume stop", 3*time, stopWatch.getTime(), DELTA);
		
		/* --- */
		stopWatch.reset();
		stopWatch.start();
		Thread.sleep(time);
		stopWatch.pause();
		Thread.sleep(time);
		stopWatch.resume();
		Thread.sleep(time);
		stopWatch.pause();
		stopWatch.stop();
		Assert.assertEquals("Start pause resume pause stop", 2*time, stopWatch.getTime(), DELTA);
		Assert.assertEquals("Start pause resume pause stop", 2*time, stopWatch.getTime(), DELTA);
	}

	@Test
	public void testGetTimeString() {
		double time = stopWatch.getTime();
		Assert.assertEquals("time as string", Double.toString(time), stopWatch.getTimeString());
	}

	@Test
	public void testGetTimeStringStringString() {
		double time = stopWatch.getTime();
		String prefix = "foo", suffix = "bar";
		Assert.assertEquals("time as string", prefix + Double.toString(time) + suffix, stopWatch.getTimeString(prefix, suffix));
	}

}

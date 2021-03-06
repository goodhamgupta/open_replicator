package com.google.code.or;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.or.binlog.BinlogEventListener;
import com.google.code.or.binlog.BinlogEventV4;
import com.google.code.or.logging.Log4jInitializer;

public class OpenParserTest
{
	//
	private static final Logger LOGGER = LoggerFactory.getLogger(OpenParserTest.class);

	/**
	 * 
	 */
	public static void main(String args[]) throws Exception
	{
		//
		Log4jInitializer.initialize();

		//
		final OpenParser op = new OpenParser();
		op.setStartPosition(4);
		op.setBinlogFileName("mysql-bin.000002");
		op.setBinlogFilePath("/Users/yogesh.dahiya/Downloads");
		op.setBinlogEventListener(new BinlogEventListener()
		{
			public void onEvents(BinlogEventV4 event)
			{
				// if (event instanceof XidEvent)
				// {
				LOGGER.info("{}", event);
				// }
			}

			@Override
			public void onException() {
				LOGGER.info("Error occured in binlog parser.");
				
			}
		});
		op.start();

		//
		LOGGER.info("press 'q' to stop");
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (String line = br.readLine(); line != null; line = br.readLine())
		{
			if (line.equals("q"))
			{
				op.stop(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
				break;
			}
		}
	}
}

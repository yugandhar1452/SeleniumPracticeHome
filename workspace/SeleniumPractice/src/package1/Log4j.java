package package1;

import org.apache.log4j.Logger;

public class Log4j {

	public static void main(String[] args) {
	Logger log = Logger.getLogger(Log4j.class.getName());
	String nme=Log4j.class.getName();	
	log.info(nme);

	}

}

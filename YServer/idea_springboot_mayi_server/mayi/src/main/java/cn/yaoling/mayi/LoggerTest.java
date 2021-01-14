package cn.yaoling.mayi;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    //private final Logger logger =  LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void  test1()
    {
/*        logger.debug("debug");
        logger.info("info");
        logger.error("error");
        logger.trace("trace");*/
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
        log.trace("trace...");

    }
}

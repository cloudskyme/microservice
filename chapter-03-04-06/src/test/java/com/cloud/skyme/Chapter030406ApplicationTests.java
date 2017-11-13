package com.cloud.skyme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.skyme.queue.HelloSender;

@SpringBootTest(classes=Chapter030406Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Chapter030406ApplicationTests {

	@Autowired
    private HelloSender helloSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }

}

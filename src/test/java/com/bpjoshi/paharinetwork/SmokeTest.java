package com.bpjoshi.paharinetwork;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bpjoshi.paharinetwork.controllers.PageController;
/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	@Autowired
    private PageController pageController;
	/*
	 * To get convinced that the context is creating your controller, add an assertion:
	 */
    @Test
    public void contexLoads() throws Exception {
        assertThat(pageController).isNotNull();
    }
}

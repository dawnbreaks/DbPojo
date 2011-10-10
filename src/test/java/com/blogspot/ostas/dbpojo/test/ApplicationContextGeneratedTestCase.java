package com.blogspot.ostas.dbpojo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-generated.xml"})
public class ApplicationContextGeneratedTestCase {
    @Test public void loadDaos(){
        assertTrue(true);
    }
}

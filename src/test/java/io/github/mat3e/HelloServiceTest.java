package io.github.mat3e;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {

    private HelloService SUT = new HelloService();

    @Test
    public void testShouldPrepareGreetingNullReturnsGreetingsWithFallBackValue() throws Exception {
        //given
        String name = null;

        //when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void testShouldPrepareGreetingNameReturnsGreetingsWithName() throws Exception {
        //given
        var name = "test";

        //when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + name + "!", result);
    }
}

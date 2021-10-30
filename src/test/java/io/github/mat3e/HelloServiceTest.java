package io.github.mat3e;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {

    private static final String WELCOME = "Hello ";

    @Test
    public void testShouldPrepareGreetingNullNameReturnsGreetingsWithFallBackValue() throws Exception {
        //given

        LangRepository mockRepository = getMockLangRepository();
        var SUT = new HelloService(mockRepository);
        String name = null;

        //when
        var result = SUT.prepareGreeting(null, "");

        //then
        assertEquals(WELCOME + HelloService.FALLBACK_NAME + "!", result);
    }



    @Test
    public void testShouldPrepareGreetingNameReturnsGreetingsWithName() throws Exception {
        //given
        var SUT = new HelloService();
        var name = "test";

        //when
        var result = SUT.prepareGreeting(name);

        //then
        assertEquals("Hello " + name + "!", result);
    }

    private LangRepository getMockLangRepository() {
        var mockRepository = new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.of(new Lang(null,WELCOME,null));
            }
        };
        return mockRepository;
    }
}

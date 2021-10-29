package io.github.mat3e;

import java.util.Optional;

class HelloService {

    static final String FALLBACK_NAME = "world";
    static final Lang FALL_BACK_LANG = new Lang(1L,"Hello ","pl");

    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }

    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name){
      return  prepareGreeting(name, FALL_BACK_LANG.getId());
    }

    String prepareGreeting(String name, Long langId){
        var welcomeMessage = repository.findById(langId).orElse(FALL_BACK_LANG).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return  welcomeMessage + nameToWelcome + "!";
    }
}

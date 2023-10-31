package com.example.Todo.App.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="feature")
public class FeatureFile {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class FeatureClass {
        private boolean isEnabled;

    }

   private final Map<String,FeatureClass> dict=new ConcurrentHashMap<>();
    public FeatureFile() {
        dict.put("TodoClass", new FeatureClass(true));
        dict.put("User",new FeatureClass(
                false
        ));
        dict.put("Authtentication",new FeatureClass(false));

    }

    @ReadOperation
    public Map<String,FeatureClass> feature(){
        return dict;

    }

@ReadOperation
    public FeatureClass feature( @Selector String key){
        return dict.get(key);


}



}

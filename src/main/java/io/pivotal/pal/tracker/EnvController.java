package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memoryLimit;
    String cfInstanceIndex;
    String cfInstanceAddress;

    Map<String,String> envMap;
    public EnvController(
        @Value("${PORT:NOT SET}") String port,
        @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
        @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
        @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddress)
    {
        envMap = new HashMap<>();
        envMap.put("PORT",port);
        envMap.put("MEMORY_LIMIT",memoryLimit);
        envMap.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        envMap.put("CF_INSTANCE_ADDR",cfInstanceAddress);

        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }


    @GetMapping("/env")
    public Map<String,String> getEnv() {

        return envMap;
    }
}

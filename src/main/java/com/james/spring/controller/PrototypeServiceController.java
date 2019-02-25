package com.james.spring.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.james.spring.service.IPrototypeService;

@RestController
public class PrototypeServiceController {
    private Set<IPrototypeService> services = new HashSet<IPrototypeService>();

    @Autowired
    @Qualifier("singleServiceImpl")
    IPrototypeService singleService;

    @RequestMapping("/prototype")
    public String prototype(@RequestParam(value = "id") String id) {
        IPrototypeService prototypeService = createService(id);

        services.add(singleService);
        services.add(prototypeService);

        StringBuilder sb = new StringBuilder();
        for (IPrototypeService service : services) {
            sb.append(service.call() + "<br>");
        }

        return sb.toString();
    }

    @Lookup("prototypeServiceImpl")
    public IPrototypeService createService(String id) {
        return null;
    }
}

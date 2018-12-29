package com.james.spring.service;

import java.util.concurrent.Future;

public interface TaskThreadPoolService {
    Future<String> getTasks(int i);
}

package com.pratice.backend.service.impl;

import com.pratice.backend.repository.TodoRepository;
import com.pratice.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;
}

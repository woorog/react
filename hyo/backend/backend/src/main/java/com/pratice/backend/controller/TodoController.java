package com.pratice.backend.controller;

import com.pratice.backend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Todo")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

}

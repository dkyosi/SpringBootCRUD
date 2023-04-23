package com.springbootcrud.controller;

import com.springbootcrud.request.CreateBookRequest;
import com.springbootcrud.response.BaseResponse;
import com.springbootcrud.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public BaseResponse CreateBook(@RequestBody CreateBookRequest request){
        try {
            return bookService.createBook(request);
        }catch (Exception e){
            return new BaseResponse(400,"Failed "+e.getMessage());
        }
    }
}

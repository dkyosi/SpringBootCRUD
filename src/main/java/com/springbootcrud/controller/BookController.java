package com.springbootcrud.controller;

import com.springbootcrud.request.CreateBookRequest;
import com.springbootcrud.response.BaseResponse;
import com.springbootcrud.service.BookService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public BaseResponse getSingleBook(@PathParam("bookId") long bookId){
        try {
            return bookService.getSingleBook(bookId);
        }catch (Exception e){
            return new BaseResponse(400,"Failed "+e.getMessage());
        }
    }

    @GetMapping("/all")
    public BaseResponse getBooks(){
        try {
            return bookService.getAllBooks();
        }catch (Exception e){
            return new BaseResponse(400,"Failed "+e.getMessage());
        }
    }
}

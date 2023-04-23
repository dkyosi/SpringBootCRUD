package com.springbootcrud.service;

import com.springbootcrud.datalayer.Book;
import com.springbootcrud.repository.BookRepository;
import com.springbootcrud.request.CreateBookRequest;
import com.springbootcrud.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BaseResponse createBook(CreateBookRequest request) {
        try {
            return  new BaseResponse(201,
                    bookRepository.save(new Book(request.getBookTitle(),request.getAuthor())),
                    "Created Successfully");
        }catch (Exception e){
            throw e;
        }
    }

    public BaseResponse getSingleBook(long bookId) {
        try {
            return  new BaseResponse(201,
                    bookRepository.findById(bookId),
                    "Current Book");
        }catch (Exception e){
            throw e;
        }
    }
}

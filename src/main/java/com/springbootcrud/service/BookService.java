package com.springbootcrud.service;

import com.springbootcrud.datalayer.Book;
import com.springbootcrud.repository.BookRepository;
import com.springbootcrud.request.CreateBookRequest;
import com.springbootcrud.request.EditBookRequest;
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

    public BaseResponse getAllBooks() {
        try {
            return  new BaseResponse(201,
                    bookRepository.findAll(),
                    "All Books");
        }catch (Exception e){
            throw e;
        }
    }

    public BaseResponse editBook(EditBookRequest request) {
        try {
            Book book = bookRepository.findById(request.getBookId()).orElseThrow();
            if (request.getTitle().isBlank() || request.getTitle().isEmpty()){
                throw new IllegalArgumentException("Book title cannot be empty");
            }
            if (request.getAuthor().isBlank() || request.getAuthor().isEmpty()){
                throw new IllegalArgumentException("Book author cannot be empty");
            }
            book.setBookTitle(request.getTitle());
            book.setAuthor(request.getAuthor());

            return  new BaseResponse(201,
                    bookRepository.save(book),
                    "Book updated");
        }catch (Exception e){
            throw e;
        }
    }
}

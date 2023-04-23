package com.springbootcrud.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditBookRequest {
    private long bookId;
    private String title;
    private String author;
}

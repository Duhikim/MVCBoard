package com.example.mywebservice.Post.controller.model;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long id;

    private String title;
    private String content;
    private String author;


}

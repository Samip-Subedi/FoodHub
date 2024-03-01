package com.online.test_trail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;


    private Integer userId;

    private Long contentId;

    private String description;
}

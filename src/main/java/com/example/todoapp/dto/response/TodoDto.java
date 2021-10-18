package com.example.todoapp.dto.response;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    private UUID id;
    private String title;
    private String description;
    private String username;
    private Date updatedAt;
    private Date createdAt;

}

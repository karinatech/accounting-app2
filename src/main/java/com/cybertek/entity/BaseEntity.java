package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String createdBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdTime;
    private String updatedBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedTime;

    private boolean isDeleted=false;





}

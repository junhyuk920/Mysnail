package com.junhyuk.mysnail.dto;

import lombok.*;

import java.time.LocalDateTime;

import com.junhyuk.mysnail.domain.entity.MysnailEntity;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MysnailDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MysnailEntity toEntity(){
        return MysnailEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }

    @Builder
    public MysnailDto(Long id, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}

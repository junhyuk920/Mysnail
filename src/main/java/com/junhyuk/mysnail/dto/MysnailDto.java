package com.junhyuk.mysnail.dto;

import lombok.*;

import java.time.LocalDateTime;

import com.junhyuk.mysnail.domain.entity.MysnailEntity;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
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

}

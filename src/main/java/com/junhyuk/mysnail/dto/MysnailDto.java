package com.junhyuk.mysnail.dto;

import lombok.*;

import com.junhyuk.mysnail.domain.entity.MysnailEntity;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MysnailDto {
    private Long id;
    private String title;
    private String content;

    public MysnailEntity toEntity(){
        MysnailEntity mysnailEntity = MysnailEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
        return mysnailEntity;
    }

    @Builder
    public MysnailDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

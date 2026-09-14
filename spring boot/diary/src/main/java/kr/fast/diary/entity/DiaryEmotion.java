package kr.fast.diary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diary_emotion")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryEmotion {

    @Id
    private Long diary_id;

    private Long emotion_tag_id;
}
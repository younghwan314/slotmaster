package com.slotmaster.slotmaster.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * 엔티티의 생성 시각과 마지막 수정 시각을 자동으로 관리하는 공통 추상 클래스입니다.
 * Spring Data JPA의 Auditing 기능을 사용합니다.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

	// 생성 시각 (엔티티가 처음 저장될 때 자동으로 설정)
	@CreatedDate
	@Column(updatable = false, nullable = false)
	private LocalDateTime createdAt;

	// 수정 시각 (엔티티가 수정될 때마다 자동 갱신)
	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime updatedAt;
}

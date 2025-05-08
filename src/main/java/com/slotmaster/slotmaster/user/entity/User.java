package com.slotmaster.slotmaster.user.entity;

import com.slotmaster.slotmaster.common.entity.BaseTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 예약 시스템 사용자 정보를 담는 엔티티입니다.
 * 이름, 이메일, 비밀번호 등의 정보를 포함합니다.
 */
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseTime {

	// 사용자 ID (기본 키)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 사용자 이름
	@Column(nullable = false)
	private String name;

	// 사용자 이메일
	@Column(nullable = false)
	private String email;

	// 사용자 비밀번호
	@Column(nullable = false)
	private String password;

}

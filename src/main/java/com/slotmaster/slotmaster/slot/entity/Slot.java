package com.slotmaster.slotmaster.slot.entity;

import java.time.LocalDateTime;

import com.slotmaster.slotmaster.common.entity.BaseTime;
import com.slotmaster.slotmaster.slot.enums.SlotStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 예약 가능한 시간 슬롯을 나타내는 엔티티입니다.
 * 이름, 시작/종료 시간, 최대 예약 가능 인원, 현재 예약된 인원, 상태 등을 포함합니다.
 */
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "slots")
public class Slot extends BaseTime {

	// 슬롯 ID (기본 키)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 슬롯 이름
	@Column(nullable = false)
	private String name;

	// 시작 시간
	@Column(nullable = false)
	private LocalDateTime startTime;

	// 종료 시간
	@Column(nullable = false)
	private LocalDateTime endTime;

	// 예약 가능한 최대 인원 수
	@Column(nullable = false)
	private int maxParticipants;

	// 현재 예약된 인원 수
	@Column(nullable = false)
	private int currentParticipants;

	// 슬롯 상태 (AVAILABLE, RESERVED, EXPIRED)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private SlotStatus status;
}

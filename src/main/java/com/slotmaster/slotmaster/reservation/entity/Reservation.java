package com.slotmaster.slotmaster.reservation.entity;

import java.time.LocalDateTime;

import com.slotmaster.slotmaster.common.entity.BaseTime;
import com.slotmaster.slotmaster.reservation.enums.ReservationStatus;
import com.slotmaster.slotmaster.slot.entity.Slot;
import com.slotmaster.slotmaster.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자와 슬롯 간의 예약 내역을 저장하는 엔티티입니다.
 */
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reservations")
public class Reservation extends BaseTime {

	// 예약 ID (기본 키)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 예약한 사용자
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// 예약된 슬롯
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "slot_id", nullable = false)
	private Slot slot;

	// 예약 상태 (RESERVED, CANCELLED 등)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ReservationStatus status;

	// 예약 시각
	@Column(nullable = false)
	private LocalDateTime reservedAt;

	// 예약 취소 시각
	private LocalDateTime cancelledAt;
}

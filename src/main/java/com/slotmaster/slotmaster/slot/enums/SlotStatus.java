package com.slotmaster.slotmaster.slot.enums;

/**
 * 슬롯의 현재 상태를 나타냅니다.
 */
public enum SlotStatus {

	AVAILABLE, // 예약 가능한 상태
	RESERVED,  // 예약이 꽉 찬 상태
	EXPIRED    // 시간이 지나 만료된 상태
}

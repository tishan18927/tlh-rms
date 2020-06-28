package com.tlh.rms.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ROOM_CATEGORY")
public class RoomCategory extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "FLOOR_SIZE", nullable = false)
    private int floorSize;

    @Column(name = "GUEST_COUNT", nullable = false)
    private int guestCount;
}

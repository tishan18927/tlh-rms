package com.tlh.rms.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ROOM_ENTITY")
public class RoomEntity extends BaseEntity {

    @JsonIgnore
    @JoinColumn(name = "HOTEL")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HotelEntity hotel;

    @JoinColumn(name = "CATEGORY")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RoomCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "room", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ReservationEntity> reservations;

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(2000)", nullable = false)
    private String description;
}

package com.tlh.rms.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RESERVATION_ENTITY")
public class ReservationEntity extends BaseEntity{

    @Column(name = "RESERVED_BY", columnDefinition = "VARCHAR(36)", nullable = false)
    private String reservedBy;

    @Column(name = "RESERVED_AT", nullable = false)
    private Long reservedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM", nullable = false)
    private RoomEntity room;

    @Temporal(TemporalType.DATE)
    @Column(name = "STARTING_DATE", nullable = false)
    private Date firstDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_DATE", nullable = false)
    private Date lastDate;
}

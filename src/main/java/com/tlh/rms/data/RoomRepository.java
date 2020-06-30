package com.tlh.rms.data;

import com.tlh.rms.data.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("SELECT DISTINCT room FROM RoomEntity room " +
            "JOIN FETCH room.category category " +
            "INNER JOIN room.hotel hotel " +
            "LEFT JOIN room.reservations res " +
                "ON " +
                    "res.room = room and " +
                    "((res.firstDate between :firstDate AND :lastDate) OR (res.lastDate between :firstDate and :lastDate)) " +
            "WHERE " +
                "hotel.id = :hotel AND res IS NULL AND category.guestCount >= :guestCount"
    )
    Set<RoomEntity> findAllAvailable(@Param("hotel") Long hotelId, @Param("lastDate")Date lastDate, @Param("firstDate") Date firstDate, @Param("guestCount") int guestCount);

    @Query("SELECT DISTINCT room FROM RoomEntity room " +
            "JOIN FETCH room.hotel hotel " +
            "JOIN FETCH room.category category " +
            "LEFT JOIN room.reservations res " +
            "ON " +
                "res.room = room and " +
                "((res.firstDate between :firstDate AND :lastDate) OR (res.lastDate between :firstDate and :lastDate)) " +
            "WHERE " +
                "room.id = :id AND res IS NULL"
    )
    //@Query("SELECT DISTINCT room FROM RoomEntity room JOIN FETCH room.hotel hotel JOIN FETCH room.category category LEFT JOIN room.reservations res WHERE room.id = :id AND (res.firstDate > :lastDate OR res.lastDate < :firstDate OR res IS NULL)")
    RoomEntity getAvailabilityForRoom(@Param("id") Long id, @Param("lastDate")Date lastDate, @Param("firstDate") Date firstDate);
}

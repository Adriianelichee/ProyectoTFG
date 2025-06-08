package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorJpaRepository extends JpaRepository<Floor, Integer> {
    @Query("SELECT DISTINCT f FROM Floor f " +
            "LEFT JOIN f.rooms r " +
            "LEFT JOIN f.workstations w " +
            "LEFT JOIN DetailReservationRoom drr ON drr.room.roomId = r.roomId " +
            "LEFT JOIN DetailReservationWorkstation drw ON drw.workstation.workstationId = w.workstationId " +
            "LEFT JOIN Reservation res1 ON res1.reservationId = drr.reservation.reservationId " +
            "LEFT JOIN Reservation res2 ON res2.reservationId = drw.reservation.reservationId " +
            "LEFT JOIN User u1 ON u1.userId = res1.user.userId " +
            "LEFT JOIN User u2 ON u2.userId = res2.user.userId " +
            "WHERE u1.company.companyId = :companyId OR u2.company.companyId = :companyId")
    List<Floor> findByCompanyId(@Param("companyId") Integer companyId);
}

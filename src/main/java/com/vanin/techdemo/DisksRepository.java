package com.vanin.techdemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface DisksRepository extends Repository<Disk, Long> {

    Disk findByName(String name);

    @Query("select d.name from Disk d where d.currentHolder = NULL")
    Page<Disk> listOfFreeDisks(Pageable pageable);

    @Query("select d.name from Disk d where d.currentHolder = ?1 order by d.name")
    Page<Disk> listOfDisksHoldingByUser(String user, Pageable pageable);

    @Query("select d.name, d.currentHolder from Disk d where d.owner = ?1 order by d.currentHolder")
    Page<Disk> listOfDisksByUserWhoHolds(String user, Pageable pageable);
}

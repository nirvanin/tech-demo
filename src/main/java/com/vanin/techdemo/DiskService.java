package com.vanin.techdemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiskService {

    Disk getDisk(String name);

    Page<Disk> getFreeDisks();

    Page<Disk> disksByHolder(String user);

    Page<Disk> disksByOwnerWhoHolds(String user);

}

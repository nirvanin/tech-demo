package com.vanin.techdemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component("disksService")
@Transactional
public class DiskServiceImpl implements DiskService {

    private final DisksRepository disksRepository;

    private final UsersRepository userRepository;

    public DiskServiceImpl(DisksRepository disksRepository,
                           UsersRepository userRepository) {
        this.disksRepository = disksRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Disk getDisk(String name) {
        Assert.notNull(name, "Name must not be null");
        return this.disksRepository.findByName(name);
    }

    @Override
    public Page<Disk> getFreeDisks() {
        return disksRepository.listOfFreeDisks(new PageRequest(1,20));
    }

    @Override
    public Page<Disk> disksByHolder(String user) {
        Assert.notNull(user, "Name must not be null");
        return disksRepository.listOfDisksHoldingByUser(user, new PageRequest(1,20));
    }

    @Override
    public Page<Disk> disksByOwnerWhoHolds(String user) {
        Assert.notNull(user, "Name must not be null");
        return disksRepository.listOfDisksByUserWhoHolds(user, new PageRequest(1,20));
    }

}

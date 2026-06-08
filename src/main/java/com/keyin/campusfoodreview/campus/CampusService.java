package com.keyin.campusfoodreview.campus;

import org.hibernate.CacheMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CampusService {
    // Why is this not recommended??
    @Autowired
    CampusRepository campusRepository;

    public Campus saveCampus(Campus campus){
        return campusRepository.save(campus);
    }




}

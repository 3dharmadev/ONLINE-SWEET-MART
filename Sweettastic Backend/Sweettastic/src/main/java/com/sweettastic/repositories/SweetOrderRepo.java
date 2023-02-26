package com.sweettastic.repositories;
 

import com.sweettastic.models.SweetOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 
@Repository
public interface SweetOrderRepo extends JpaRepository<SweetOrder, Integer>{

}

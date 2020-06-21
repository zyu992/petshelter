package ca.mcgill.ecse321.petshelter.mapper;

import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.petshelter.entity.PaymentHistory;
import ca.mcgill.ecse321.petshelter.entity.User;

@Repository
public interface PaymentHistoryMapper {
    
    PaymentHistory findById(Integer id);
    Iterable<PaymentHistory> findByPayer(User payer);

}
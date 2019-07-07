package tutorial.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import tutorial.hotel.model.Contract;

public interface ContractRepository extends CrudRepository<Contract, Integer>{
}

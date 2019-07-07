package tutorial.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.hotel.model.Form;
import tutorial.hotel.model.Contract;
import tutorial.hotel.model.RoomTypeFormModel;
import tutorial.hotel.model.RoomTypes;
import tutorial.hotel.repository.ContractRepository;
import tutorial.hotel.repository.HotelierRepository;
import tutorial.hotel.repository.RoomTypesRepository;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FormController {

    @Autowired
    private HotelierRepository hotelierrepository;

    @Autowired
    private ContractRepository contractrepository;

    @Autowired
    private RoomTypesRepository roomtypesrepository;

    @PostMapping("/addcontracts")
    public void createContract(@Valid @RequestBody Form form) {
        System.out.println("Hey, i m here");
        Contract contract = new Contract();

        System.out.println(form.getHotel_id());
        contract.setHotelId(form.getHotel_id());
        contract.setStartDate(form.getStart_date());
        contract.setEndDate(form.getEnd_date());
        contract.setMarkup(form.getMarkup());
        System.out.println(contract.getEndDate());
        contractrepository.save(contract);
        System.out.println(form.getRoom_types());

        for (RoomTypeFormModel roomtype: form.getRoom_types()){

            RoomTypes roomtypes = new RoomTypes();

            roomtypes.setType_name(roomtype.getType_name());
            roomtypes.setPrice(roomtype.getPrice());
            roomtypes.setMax_adults(roomtype.getMax_adults());
            roomtypes.setNo_of_rooms(roomtype.getNo_of_rooms());

            roomtypesrepository.save(roomtypes);

        }

    }

}

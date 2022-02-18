package Models.PersonsModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

import static Utils.TypeOperation.emptyStringTransform;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonsRequestModel {

    String personName;
    String phoneNumber;

    public static PersonsRequestModel createPersonsRequestModel(Map<String,String> TableItems){

        PersonsRequestModel personsRequestModel = new PersonsRequestModel();

        personsRequestModel.setPersonName(emptyStringTransform(TableItems.get("PersonName")));
        personsRequestModel.setPhoneNumber(emptyStringTransform(TableItems.get("PhoneNumber")));

        return personsRequestModel;

    }


}

package Models.PersonsModel;

import lombok.*;

import java.util.Map;

import static Utils.TypeOperation.emptyStringTransform;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonsResponseModel {

    int id;
    String personName;
    String phoneNumber;

    public void setId(String val){

        try {

            this.id = Integer.parseInt(val);

        }catch (NumberFormatException e){
            this.id = 0 ;
        }

    }

    public static PersonsResponseModel createPersonsResponseModel(Map<String,String> TableItems){

        PersonsResponseModel personsResponseModel = new PersonsResponseModel();

        personsResponseModel.setId(TableItems.get("id"));
        personsResponseModel.setPersonName(emptyStringTransform(TableItems.get("PersonName")));
        personsResponseModel.setPhoneNumber(emptyStringTransform(TableItems.get("PhoneNumber")));

        return personsResponseModel;

    }

}

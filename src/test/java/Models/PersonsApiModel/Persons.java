package Models.PersonsApiModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Persons {

    int id;
    String personName;
    String phoneNumber;

    public static Persons createPersons(Map<String,String> TableItems){

        return new Persons(Integer.getInteger(TableItems.get("id")),
                TableItems.get("personName"),
                TableItems.get("phoneNumber"));

    }

}

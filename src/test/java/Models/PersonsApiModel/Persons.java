package Models.PersonsApiModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persons {

    int id;
    String personName;
    String phoneNumber;

    public static Persons createPersons(Map<String,String> TableItems){

        return new Persons(Integer.parseInt(TableItems.get("id")),
                TableItems.get("personName"),
                TableItems.get("phoneNumber"));

    }

}

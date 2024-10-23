package pojoConcepts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Employee1 {

    public static void main(String[] args) throws JsonProcessingException {
        Employee employee1 = new Employee();
        employee1.setFirstName("Kalai");
        employee1.setLastName("R");
        employee1.setEmail("kalai@gmail.com");
        employee1.setSkills(Arrays.asList("java","selenium"));

        System.out.println(employee1.getFirstName());
        System.out.println(employee1.getLastName());
        System.out.println(employee1.getEmail());
        System.out.println(employee1.getSkills());

        ObjectMapper mapper = new ObjectMapper();
        String employeeJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);
        System.out.println(employeeJSON);

    }
}

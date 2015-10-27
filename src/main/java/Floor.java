import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by user on 10/26/15.
 */
public class Floor {
    final Logger logger = LoggerFactory.getLogger(Office.class);

    private List<Employee> employees;
    private List<RecycleBin> recycleBins;
    private Map<RecycleBin, Employee> mapBinsEmployees = new HashMap<>();

    @PostConstruct
    public void initialize() {
        if (employees == null) {
            logger.info("No employees on the floor");
            return;
        }
        if (recycleBins == null) {
            logger.info("No recycleBins on the floor");
            return;
        }
        int idxEmployee = 0;

        for (RecycleBin bin:recycleBins) {
            Employee employee;
            while (employees.get(idxEmployee).getRecycleBin() != null) {
                ++idxEmployee;
            }
            employee = employees.get(idxEmployee++);
            employee.setRecycleBin(bin);
            mapBinsEmployees.put(bin,  employee);
            logger.debug("recycleBins {} mapped to employee {}", bin.getCoordinate(), employee.getName());

        }

    }

    public List<RecycleBin> getRecycleBins() {
        return recycleBins;
    }

    public void setRecycleBins(List<RecycleBin> recycleBins) {
        this.recycleBins = recycleBins;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

import java.util.*;

public class MyHashTable {
    
    public static final int EMPLOYEE_NUMBER_INDEX = 0;
    public static final int FIRST_NAME_INDEX = 1;
    public static final int LAST_NAME_INDEX = 2;

    public ArrayList<EmployeeInfo>[] buckets;
    public int size;

    public MyHashTable(int numOfBuckets) {
        buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList();
        }
    }

    public int calcBucket(int employeeNumber) {
        return (employeeNumber % buckets.length);
    }

    public void add(EmployeeInfo addedEmployee) {
        if (addedEmployee != null) {
            buckets[calcBucket(addedEmployee.employeeNumber)].add(addedEmployee);
            size++;
        }
    }

    public EmployeeInfo remove(int employeeNumber) {
        EmployeeInfo currentItem = retrieve(employeeNumber);
        if (buckets[calcBucket(employeeNumber)].remove(currentItem)) {
            size--;
            return currentItem;
        } else {
            return null;
        }
    }

    public EmployeeInfo retrieve(int employeeNumber) {
        for (EmployeeInfo currentItem : buckets[calcBucket(employeeNumber)]) {
            if (currentItem.employeeNumber == employeeNumber) {
                return currentItem;
            }
        }
        return null;
    }

    public ArrayList<EmployeeInfo> retrieveAll(int type, String query){
        Boolean condition;
        ArrayList<EmployeeInfo> list = new ArrayList();
        for (ArrayList<EmployeeInfo> bucket : this.buckets) {
            for (EmployeeInfo item : bucket) {
                switch (type){
                    case EMPLOYEE_NUMBER_INDEX:
                        condition = String.valueOf(item.employeeNumber).contains(query);
                        break;
                    case FIRST_NAME_INDEX:
                        condition = item.firstName.contains(query);
                        break;  
                    case LAST_NAME_INDEX:
                        condition = item.lastName.contains(query);
                        break;
                    default:
                        condition = false;
                }
                if (condition){
                    list.add(item);
                }
            }
        }
        return list;
    }
}

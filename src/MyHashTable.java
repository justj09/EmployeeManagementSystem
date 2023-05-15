import java.util.*;

public class MyHashTable {
    
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
 
}

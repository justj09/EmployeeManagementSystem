import java.util.*;

public class MyHashTable {
    
    private Main_jFrame main;
    public ArrayList<EmployeeInfo>[] buckets;
    public int size;

    public MyHashTable(Main_jFrame main, int numOfBuckets) {
        this.main = main;
        this.buckets = new ArrayList[numOfBuckets];
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
            main.updateTable();
            size++;
        }
    }

    public EmployeeInfo remove(int employeeNumber) {
        EmployeeInfo currentItem = retrieve(employeeNumber);
        if (buckets[calcBucket(employeeNumber)].remove(currentItem)) {
            main.updateTable();
            size--;
            return currentItem;
        } 
        else {
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
                try {
                    switch (type){
                        case 0:
                            condition = String.valueOf(item.employeeNumber).contains(query);
                            break;
                        case 1:
                            condition = item.firstName.contains(query);
                            break;  
                        case 2:
                            condition = item.lastName.contains(query);
                            break;
                        case 3:
                            if (query.endsWith("%")){
                                query = query.substring(0, query.length() - 1);
                            }
                            condition = String.valueOf(item.deductRate).contains(query);
                            break;
                        default:
                            condition = false;
                    }
                }
                catch (Exception e) {
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

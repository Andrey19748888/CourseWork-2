import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Service {

    private Map<Integer, Task> taskMap;
    private ArrayList<Task> archive;

    private Map<LocalDate, ArrayList> tasksByDate;



    public void printByDate() {

        Collection<Task> tasks = taskMap.values();
        for (Task task : tasks) {
            LocalDate date = task.getDateTime().toLocalDate();

            if (!taskMap.containsKey(date)) {
                tasksByDate.put(date, new ArrayList<Task>());
            }
            tasksByDate.get(date).add(task);


        }

        for (Map.Entry<LocalDate, ArrayList> entry : tasksByDate.entrySet()) {
            System.out.println(entry.getKey());

            ArrayList<Task> list = entry.getValue();
            for (Task task : list) {
                System.out.println(task);
            }

            System.out.println();


        }



    }


    public Service() {
        taskMap = new HashMap<>();
        archive = new ArrayList<>();

        tasksByDate = new HashMap<>();


        taskMap.put(1, new MonthlyTask("Name 1",
                "Description 1",
                Type.WORK,
                LocalDateTime.of(2022, 01, 1, 0, 0, 0)));
        taskMap.put(2, new DailyTask("Name 2",
                "Description 2",
                Type.WORK,
                LocalDateTime.of(2022, 01, 1, 0, 0, 0)));
        taskMap.put(3, new WeeklyTask("Name 3",
                "Description 3",
                Type.WORK,
                LocalDateTime.of(2022, 01, 3, 0, 0, 0)));
        taskMap.put(4, new DailyTask("Name 4",
                "Description 4",
                Type.WORK,
                LocalDateTime.of(2022, 01, 3, 0, 0, 0)));
        System.out.println(taskMap);
        System.out.println(tasksByDate);
    }

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task getTaskById(int number) {


        return taskMap.get(number);
    }

    public int getMapSize() {
        return taskMap.size();
    }


    Task task;

    public Task delete(int id) {
        task = taskMap.get(id);
        archive.add(task);
        task.setDeleted(true);

        return task;
    }

    public void printMap() {
        System.out.println(taskMap);


    }

    public ArrayList<Task> getDeletedTasks() {
        return archive;
    }

}


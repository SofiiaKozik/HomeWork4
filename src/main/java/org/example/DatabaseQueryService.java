package org.example;

import org.example.AdditionalServices.Filereader;
import org.example.AdditionalServices.QweryService;
import org.example.ListTypesСlasses.LongestProject;
import org.example.ListTypesСlasses.MaxProjectCountClient;
import org.example.ListTypesСlasses.MaxSalaryWorker;
import org.example.ListTypesСlasses.ProjectPrices;
import org.example.ListTypesСlasses.WorkerType;
import org.example.ListTypesСlasses.YoungestEldestWorkers;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DatabaseQueryService {
    QweryService qweryService = new QweryService();
    Filereader filereader = new Filereader();

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws FileNotFoundException, SQLException {
        List<MaxSalaryWorker> maxSalaryWorkers = new LinkedList<>();
        String findMaxSalaryWorkerScript = "C:\\Users\\skozi\\DataGripProjects\\Test1\\find_max_salary_worker.sql";
        String query = filereader.readQwery(findMaxSalaryWorkerScript);
        ResultSet rs = qweryService.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("name");
            int salary = rs.getInt("salary");
            maxSalaryWorkers.add(new MaxSalaryWorker(name,salary));
        }
        return maxSalaryWorkers;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws FileNotFoundException, SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = new LinkedList<>();
        String findMaxProjectsClientScript = "C:\\Users\\skozi\\DataGripProjects\\Test1\\find_max_projects_client.sql";
        String query = filereader.readQwery(findMaxProjectsClientScript);
        ResultSet rs = qweryService.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("name");
            int projectCount = rs.getInt("project_count");
            maxProjectCountClients.add(new MaxProjectCountClient(name,projectCount));
        }
        return maxProjectCountClients;
    }

    public List<LongestProject> findLongestProjects() throws FileNotFoundException, SQLException {
        List<LongestProject> longestProjects = new LinkedList<>();
        String findLongestProjectsScript = "C:\\Users\\skozi\\DataGripProjects\\Test1\\find_longest_project.sql";
        String query = filereader.readQwery(findLongestProjectsScript);
        ResultSet rs = qweryService.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("name");
            int projectDuration = rs.getInt("month_data");
            longestProjects.add(new LongestProject(name,projectDuration));
        }
        return longestProjects;
    }

    public List<ProjectPrices> printProjectPrices() throws FileNotFoundException, SQLException {
        List<ProjectPrices> projectPrices = new LinkedList<>();
        String printProjectPricesScript = "C:\\Users\\skozi\\DataGripProjects\\Test1\\print_project_prices.sql";
        String query = filereader.readQwery(printProjectPricesScript);
        ResultSet rs = qweryService.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            projectPrices.add(new ProjectPrices(name,price));
        }
        return projectPrices;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws FileNotFoundException, SQLException {
        List<YoungestEldestWorkers> youngestEldestWorkers = new LinkedList<>();
        String findYoungestEldestWorkersScript = "C:\\Users\\skozi\\DataGripProjects\\Test1\\find_youngest_eldest_workers.sql";
        String query = filereader.readQwery(findYoungestEldestWorkersScript);
        ResultSet rs = qweryService.executeQuery(query);
        while (rs.next()) {
            WorkerType type = WorkerType.valueOf(rs.getString("type"));
            String name = rs.getString("name");
            LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
            youngestEldestWorkers.add(new YoungestEldestWorkers(type, name, birthday));
        }
        return youngestEldestWorkers;
    }


    public static void main(String[] args) throws SQLException, FileNotFoundException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        List<MaxSalaryWorker> maxSalaryWorkers =  databaseQueryService.findMaxSalaryWorker();
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProjects();
        List<ProjectPrices> projectPrices = new DatabaseQueryService().printProjectPrices();
        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        System.out.println(youngestEldestWorkers);

    }
}

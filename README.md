### [Spring Batch — Implementation of processing CSV file into a database](https://medium.com/@avinash28196/spring-batch-implementation-of-processing-csv-file-into-a-database-a7d997753020)

 In this example we leverage spring-batch features to load data from a csv file into Spring-boot In-memory h2 database.

![batch processs](https://i.imgur.com/WyxCQFF.png)

 ## 1. Lets start with configuring the maven project (pom.xml)  


 ```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-batch</artifactId>
</dependency>

<dependency>
 <groupId>com.h2database</groupId>
 <artifactId>h2</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

1. **spring-boot-starter-batch** Enables us to create and schedule jobs and various other batch operations can be achieved.

2. **h2** H2 Database is In memory light weight, which provides Web based application console to perform CRUD operations. In our example we will allow batch jobs read data from a csv file and to write into the database.

3. **spring-boot-started-web** Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.

#### The Hotel Review CSV file.

![](https://cdn-images-1.medium.com/max/1600/1*mUupS3H4cPU6h2zgZBPkTA.png)

## 2. configuring application.properties for h2 database and batch ops.


```application.properties

#Disable batch job's auto start
spring.batch.job.enabled=false
spring.main.banner-mode=off

#H2 Database properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create
spring.h2.console.enabled=true

```

h2 is a light weight, In memory database. Provides browser based console will be available at url http://localhost:8080/h2-console/

![](https://cdn-images-1.medium.com/max/1600/1*H7EqkYGIoM9esxBr4uLcoQ.png)

Project is generated with the help of http://start.spring.io

A Look at Completed Project.

![](https://cdn-images-1.medium.com/max/1600/1*SPvpdEjI6z8kUxbE-ZH5EQ.png)

### Creating the pojo class.

Variables of the pojo class will be the entities of the table.

```java
public class Hotels {

	private Long id;
	private String name;
	private String description;
	private String city;
	private int rating;
}

//Getters and Setters
```

## Springboot App

  A. This main class enables the job launcher to execute.

  ```java
  @PostConstruct
    public void perform() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }
  ```

  B. Provides a port, This will enable other apps to interact with h2 database with tcp port 8090.

  ```java
  @Bean(initMethod = "start", destroyMethod = "stop")
   public Server h2Server() throws SQLException {
       return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8090");
   }
}

  ```


## Batch Jobs.

This operation is spilt into 2:

1. batchconfig.java

  We are creating a job to perform a step by step reading a line in csv file and preparing insert statement and executing into the data base.

2. DBlogProcessor.java

  This is a log operation of the steps executed.
  ```java
  public class DBLogProcessor implements ItemProcessor<Hotels, Hotels>
  {
    public Hotels process(Hotels Hotel) throws Exception
    {
        System.out.println("Inserting Hotels : " + Hotel);
        return Hotel;
    }
  }
  ```



## Spring Batch Configuration.

![batch processs](https://i.imgur.com/Ghp19uO.png)


We are creating a job to perform a step by step reading a line in csv file and preparing insert statement and executing into the database.

1. JobBuilderFactory(JobRepository jobRepository) Convenient factory for a JobBuilder which sets the JobRepository automatically.

JobBuilder get(java.lang.String name) Creates a job builder and initialises its job repository. name — the name of the job.
Increment the run.id parameter (starting with 1).
start(Step step) Create a new job builder that will execute a step or sequence of steps. step — a step to execute.

2. StepBuilder which sets the JobRepository.

A Step is a domain object that contains an independent, sequential phase of a batch job and contains all of the information needed to define and control the actual batch processing. Now that we’ve created the reader and processor for data we need to write it. For the reading, we’ve been using chunk-oriented processing, meaning we’ve been reading the data one at a time.



3. FlatFileItemReader<T> ItemReader that reads lines from input setResource(Resource) In our example we are using CSV file.

FlatFileItemReader is parameterized with a model.
setLineMapper method converts Strings to objects representing the item.
setResource. Public setter for the input resource.
setLinesToSkip the number of lines to skip at the start of a file.

4. Defining the Datasource DataSource dataSource().

Here we can define the type of datasource i.e (MySql, Oracle etc) and scripts specific to the datasource are defined, also script for defining our table is provided (Hotel.sql)

5. The JdbcBatchItemWriter.

Integrating the datasource and The itemWriter object will set JDBC connection and sql statement is prepared for the batch action we want to perform in the database.

6. The LineMapper

The lineMapper for mapping lines (strings) to domain objects typically used to map lines read from a file to domain objects on a per line basis.
The lineTokenizer to split string obtained typically from a file into tokens. In our example we are using DelimitedLineTokenizer that is because we are using csv file.
fieldSetMapper to map data obtained from a FieldSet into an object.

### Demo:

When the Batch Process is complete this is what is printed to the console.

Batch Process Complete:

![](https://cdn-images-1.medium.com/max/1600/1*-OtfAcbsKk2ogF8j0L-LZA.png)

Verify it in the H2 Database.

![](https://cdn-images-1.medium.com/max/1600/1*W6_fcmn25rWotdpzNn3tBg.png)

### Thanks For Reading. Happy Coding.

Check out the post for more details.

### [Spring Batch — Implementation of processing CSV file into a database](https://medium.com/@avinash28196/spring-batch-implementation-of-processing-csv-file-into-a-database-a7d997753020)

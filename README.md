# Importing data from a .csv into a H2 Database using spring-batch.

 In this example we leverage spring-batch features to load data from a csv file into Spring-boot In-memory h2 database.


 ### 1. Lets start with configuring the maven project (pom.xml)  


 ```
  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-batch</artifactId></dependency>
      </dependency>
      <dependency>
  	<groupId>com.h2database</groupId>
  	<artifactId>h2</artifactId>
  </dependency>
```

1. **spring-boot-starter-batch** Enables us to create and schedule jobs and various other batch opertaions can be achieved.

2. **h2** H2 Database is In memory light weight, which provides application console to perform CRUD operations. In our example we will allow batch jobs to write into the database.

### 2. configuring application.properties for h2 database and batch ops.


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

// Screenshot //

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

### Springboot App

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


### Batch Jobs.

This operation is spilt into 3:

1. batchconfig.java

  We are creating a job to perform a step by step reading a line in csv file and preparing insert statement and executing into the data base.

2. DBlogProcessor.java

  This is a log operation of the steps executed.

  public class DBLogProcessor implements ItemProcessor<Hotels, Hotels>
  {
    public Hotels process(Hotels Hotel) throws Exception
    {
        System.out.println("Inserting Hotels : " + Hotel);
        return Hotel;
    }
  }


3. webconfig.java

  Registering the url /h2-console/ to servlet.

# Spring Batch

 JobBuilderFactory(JobRepository jobRepository)  Convenient factory for a JobBuilder which sets the JobRepository automatically
	1.  JobBuilder get(java.lang.String name) Creates a job builder and initialises its job repository. name - the name of the job
	2.  Increment the run.id parameter (starting with 1).
	3.  start(Step step) Create a new job builder that will execute a step or sequence of steps. step - a step to execute

  StepBuilder which sets the JobRepository and PlatformTransactionManager automatically
	1. get(java.lang.String name) Creates a job builder and initializes its job repository. name - the name of the job
	2. .reader(reader())
           .processor(processor())
           .writer(writer())
           .build();


 FlatFileItemReader<T> Restartable ItemReader that reads lines from input setResource(Resource).
	1. Setter for line mapper. This property is required to be set.
	2. setResource. Public setter for the input resource.
	3. setLinesToSkip the number of lines to skip at the start of a file.



http://malsolo.com/blog4java/wp-content/uploads/2014/08/spring-batch-reference-model.png

https://howtodoinjava.com/spring-batch/multiresourceitemreader-read-multiple-csv-files-example/

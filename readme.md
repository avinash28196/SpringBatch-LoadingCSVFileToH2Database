# Spring Batch 

 JobBuilderFactory(JobRepository jobRepository)  Convenient factory for a JobBuilder which sets the JobRepository automatically
	1.  JobBuilder get(java.lang.String name) Creates a job builder and initializes its job repository. name - the name of the job
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

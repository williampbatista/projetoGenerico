package projetoGenerico.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import projetoGenerico.entity.Customer;
import projetoGenerico.step.CustomerProcess;
import projetoGenerico.step.CustomerReader;
import projetoGenerico.step.CustomerWriter;

@Configuration
public class JobConfig {
	
	@Autowired
    JobRepository jobRepository;
    
	@Autowired
    JobRegistry jobRegistry;
    
    @Autowired
    JobLauncher jobLauncher;
    
    @Autowired
    JobExplorer jobExplorer;
 
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	CustomerReader customerReader;
	@Autowired
	CustomerWriter customerWriter;
	@Autowired
	CustomerProcess customerProcess;
	
	
	/**
	 * 
	 * @return
	 */
	@Bean
    public JobOperator jobOperator() {
        SimpleJobOperator jobOperator = new SimpleJobOperator();
        jobOperator.setJobExplorer(jobExplorer);
        jobOperator.setJobLauncher(jobLauncher);
        jobOperator.setJobRegistry(jobRegistry);
        jobOperator.setJobRepository(jobRepository);
        return jobOperator;
    }
	
	/**
	 * 
	 * @param jobRegistry
	 * @return
	 */
	@Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
        return jobRegistryBeanPostProcessor;
    }
	
	@Bean
	@Qualifier("exportarCustomer")
	public Job exportCustomerJob(JobBuilderFactory jobs, @Qualifier("exportarCustomerStep") Step exportarCustomerStep) {
		return jobs.get("exportarCustomer")
				.incrementer(new RunIdIncrementer())
				.flow(exportarCustomerStep)
				.end()
				.build();
	}
	
	/**
	 * 
	 * @param stepBuilderFactory
	 * @return
	 */
	@Bean("exportarCustomerStep")
	protected Step exportarCustomer(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("exportarCustomerStep")
				.<Iterable<Customer>, Iterable<Customer>> chunk(10)
				.reader(customerReader)
				.processor(customerProcess)
				.writer(customerWriter)
				.build();
	}
	
	
}
